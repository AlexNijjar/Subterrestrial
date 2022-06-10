package com.github.alexnijjar.subterrestrial.data;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Range;

import com.github.alexnijjar.subterrestrial.Subterrestrial;
import com.github.alexnijjar.subterrestrial.config.TechLoot;
import com.github.alexnijjar.subterrestrial.util.ModIdentifier;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.registry.Registry;

public class ResourceData {

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static void register() {

        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new SimpleSynchronousResourceReloadListener() {

            @Override
            public Identifier getFabricId() {
                return new ModIdentifier("cabins");
            }

            @Override
            public void reload(ResourceManager manager) {

                if (!Subterrestrial.CONFIG.moddedLootInChests) {
                    return;
                }

                List<LootData> lootData = new ArrayList<>();
                // Get the mod loot data.
                for (Identifier id : manager.findResources("cabins/mod_loot", path -> path.getPath().endsWith(".json")).keySet()) {
                    try {
                        for (Resource resource : manager.getAllResources(id)) {
                            InputStreamReader reader = new InputStreamReader(resource.getInputStream());
                            JsonObject jsonObject = JsonHelper.deserialize(GSON, reader, JsonObject.class);

                            if (jsonObject != null) {
                                for (JsonElement chests : jsonObject.getAsJsonArray("chests")) {
                                    JsonObject chestObject = chests.getAsJsonObject();
                                    String chest = chestObject.get("chest").getAsString();
                                    for (JsonElement loot : chestObject.getAsJsonArray("loot")) {
                                        JsonObject lootObject = loot.getAsJsonObject();
                                        Identifier name = new Identifier(lootObject.get("name").getAsString());
                                        int minRolls = lootObject.has("min_rolls") ? lootObject.get("min_rolls").getAsInt() : 1;
                                        int maxRolls = lootObject.has("max_rolls") ? lootObject.get("max_rolls").getAsInt() : 1;
                                        int minCount = lootObject.has("min_count") ? lootObject.get("min_count").getAsInt() : 1;
                                        int maxCount = lootObject.has("max_count") ? lootObject.get("max_count").getAsInt() : 1;
                                        float chance = lootObject.has("chance") ? lootObject.get("chance").getAsFloat() : 1.0f;
                                        lootData.add(new LootData(chest, name, Range.between(minRolls, maxRolls), Range.between(minCount, maxCount), chance));
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        Subterrestrial.LOGGER.error("Failed to load Subterrestrial mod loot from \"" + id + "\"", e);
                        e.printStackTrace();
                    }
                }

                if (!Subterrestrial.registeredLoot && lootData.size() > 0) {
                    LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                        if (id.getNamespace().equals(Subterrestrial.MOD_ID)) {
                            for (LootData data : lootData) {

                                // Don't add tech loot if the config does not allow it.
                                if (id.getNamespace().equals("modern_industrialization") && !Subterrestrial.CONFIG.techLoot.equals(TechLoot.MODERN_INDUSTRIALIZATION)) {
                                    continue;
                                }
                                if (id.getNamespace().equals("tech_reborn") && !Subterrestrial.CONFIG.techLoot.equals(TechLoot.TECH_REBORN)) {
                                    continue;
                                }

                                if (id.equals(new ModIdentifier(data.chest()))) {
                                    if (Registry.ITEM.containsId(data.id())) {
                                        LootPool.Builder pool = LootPool.builder().rolls(UniformLootNumberProvider.create(data.rolls().getMinimum(), data.rolls().getMaximum()))
                                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(data.count().getMinimum(), data.count().getMaximum())).build()).conditionally(RandomChanceLootCondition.builder(data.chance()).build())
                                                .with(ItemEntry.builder(Registry.ITEM.get(data.id())));
                                        tableBuilder.pool(pool);
                                    }
                                }
                            }
                        }
                    });
                    Subterrestrial.registeredLoot = true;
                }
            }
        });
    }
}
