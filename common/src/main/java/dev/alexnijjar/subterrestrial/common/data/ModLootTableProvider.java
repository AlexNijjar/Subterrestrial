package dev.alexnijjar.subterrestrial.common.data;

import dev.alexnijjar.subterrestrial.Subterrestrial;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

public class ModLootTableProvider extends LootTableProvider {

    public static final ResourceLocation BEDROOM = new ResourceLocation(Subterrestrial.MOD_ID, "chests/cabin/bedroom");
    public static final ResourceLocation BEEKEEPING = new ResourceLocation(Subterrestrial.MOD_ID, "chests/cabin/beekeeping");
    public static final ResourceLocation BLOCKS = new ResourceLocation(Subterrestrial.MOD_ID, "chests/cabin/blocks");
    public static final ResourceLocation BREWING = new ResourceLocation(Subterrestrial.MOD_ID, "chests/cabin/brewing");
    public static final ResourceLocation ENCHANTING = new ResourceLocation(Subterrestrial.MOD_ID, "chests/cabin/enchanting");
    public static final ResourceLocation ENHANCED_ENCHANTING = new ResourceLocation(Subterrestrial.MOD_ID, "chests/cabin/enhanced_enchanting");
    public static final ResourceLocation ENHANCED_METALWORKS = new ResourceLocation(Subterrestrial.MOD_ID, "chests/cabin/enhanced_metalworks");
    public static final ResourceLocation FLETCHING = new ResourceLocation(Subterrestrial.MOD_ID, "chests/cabin/fletching");
    public static final ResourceLocation KITCHEN = new ResourceLocation(Subterrestrial.MOD_ID, "chests/cabin/kitchen");
    public static final ResourceLocation MAIN = new ResourceLocation(Subterrestrial.MOD_ID, "chests/cabin/main");
    public static final ResourceLocation METALWORKS = new ResourceLocation(Subterrestrial.MOD_ID, "chests/cabin/metalworks");
    public static final ResourceLocation MUSIC = new ResourceLocation(Subterrestrial.MOD_ID, "chests/cabin/music");
    public static final ResourceLocation WEAVING = new ResourceLocation(Subterrestrial.MOD_ID, "chests/cabin/weaving");

    public ModLootTableProvider(PackOutput output) {
        super(output, Set.of(), List.of(new SubProviderEntry(ChestLootTables::new, LootContextParamSets.CHEST)));
    }

    public static class ChestLootTables implements LootTableSubProvider {
        @Override
        public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {

            consumer.accept(BuiltInLootTables.JUNGLE_TEMPLE_DISPENSER,
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(1.0F, 2.0F))
                                    .add(LootItem.lootTableItem(Items.ARROW).setWeight(30).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 7.0F))))));


            consumer.accept(BEDROOM,
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(4, 9))
                                    .add(LootItem.lootTableItem(Items.BREAD).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                    .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.BONE).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                                    .add(LootItem.lootTableItem(Items.STRING).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 8))))
                                    .add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 5))))
                                    .add(LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 10))))
                                    .add(LootItem.lootTableItem(Items.EMERALD).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                                    .add(LootItem.lootTableItem(Items.WHITE_WOOL).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                    .add(LootItem.lootTableItem(Items.TORCH).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(12, 36))))
                                    .add(LootItem.lootTableItem(Items.ENDER_PEARL).setWeight(3))
                            ));

            consumer.accept(BEEKEEPING,
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(2, 4))
                                    .add(LootItem.lootTableItem(Items.HONEYCOMB).setWeight(30).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6))))
                                    .add(LootItem.lootTableItem(Items.HONEY_BOTTLE).setWeight(30).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                    .add(LootItem.lootTableItem(Items.HONEY_BLOCK).setWeight(20).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                    .add(LootItem.lootTableItem(Items.HONEYCOMB_BLOCK).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                    .add(LootItem.lootTableItem(Items.DANDELION).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.POPPY).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.BLUE_ORCHID).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.ALLIUM).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.AZURE_BLUET).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.RED_TULIP).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.ORANGE_TULIP).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.WHITE_TULIP).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.PINK_TULIP).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.OXEYE_DAISY).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.CORNFLOWER).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.LILY_OF_THE_VALLEY).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.WITHER_ROSE).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.SUNFLOWER).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.LILAC).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.ROSE_BUSH).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.PEONY).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                            ));

            consumer.accept(BLOCKS,
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(5, 9))
                                    .add(LootItem.lootTableItem(Items.GRAVEL).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(12, 32))))
                                    .add(LootItem.lootTableItem(Items.SAND).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(12, 32))))
                                    .add(LootItem.lootTableItem(Items.DIRT).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(12, 32))))
                                    .add(LootItem.lootTableItem(Items.MUD).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(12, 32))))
                            ));

            consumer.accept(BREWING,
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(1, 2))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.MUNDANE))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.THICK))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.AWKWARD))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.NIGHT_VISION))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.LONG_NIGHT_VISION))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.INVISIBILITY))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.LONG_INVISIBILITY))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.LEAPING))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.LONG_LEAPING))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.STRONG_LEAPING))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.FIRE_RESISTANCE))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.LONG_FIRE_RESISTANCE))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.SWIFTNESS))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.LONG_SWIFTNESS))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.STRONG_SWIFTNESS))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.SLOWNESS))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.LONG_SLOWNESS))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.STRONG_SLOWNESS))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.TURTLE_MASTER))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.WATER_BREATHING))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.LONG_WATER_BREATHING))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.HEALING))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.STRONG_HEALING))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.HARMING))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.STRONG_HARMING))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.POISON))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.LONG_POISON))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.STRONG_POISON))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.REGENERATION))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.LONG_REGENERATION))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.STRONG_REGENERATION))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.STRENGTH))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.LONG_STRENGTH))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.STRONG_STRENGTH))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.WEAKNESS))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.LONG_WEAKNESS))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.SLOW_FALLING))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(5)).apply(SetPotionFunction.setPotion(Potions.LONG_SLOW_FALLING))
                            ).withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(3, 5))
                                    .add(LootItem.lootTableItem(Items.GLASS_BOTTLE).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6))))
                                    .add(LootItem.lootTableItem(Items.POTION).setWeight(10)).apply(SetPotionFunction.setPotion(Potions.WATER))
                                    .add(LootItem.lootTableItem(Items.REDSTONE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 8))))
                                    .add(LootItem.lootTableItem(Items.GUNPOWDER).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 8))))
                                    .add(LootItem.lootTableItem(Items.SUGAR).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                    .add(LootItem.lootTableItem(Items.RABBIT_FOOT).setWeight(10))
                                    .add(LootItem.lootTableItem(Items.GOLDEN_CARROT).setWeight(10))
                                    .add(LootItem.lootTableItem(Items.PHANTOM_MEMBRANE).setWeight(10))
                                    .add(LootItem.lootTableItem(Items.SPIDER_EYE).setWeight(10))
                                    .add(LootItem.lootTableItem(Items.FERMENTED_SPIDER_EYE).setWeight(10))
                                    .add(LootItem.lootTableItem(Items.SLIME_BALL).setWeight(10))
                                    .add(LootItem.lootTableItem(Items.GLISTERING_MELON_SLICE).setWeight(10))
                            ));

            consumer.accept(ENCHANTING,
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1))
                                    .add(LootItem.lootTableItem(Items.BOOK).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(30.0F)).allowTreasure()))
                            )
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(1, 2))
                                    .add(LootItem.lootTableItem(Items.BOOK).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                                    .add(LootItem.lootTableItem(Items.PAPER).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6))))
                                    .add(LootItem.lootTableItem(Items.LAPIS_LAZULI).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6))))
                                    .add(LootItem.lootTableItem(Items.EXPERIENCE_BOTTLE).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                            ));

            consumer.accept(ENHANCED_ENCHANTING,
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(1, 2))
                                    .add(LootItem.lootTableItem(Items.BOOK).apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(30.0F)).allowTreasure()))
                            )
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(1, 4))
                                    .add(LootItem.lootTableItem(Items.BOOK).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6))))
                                    .add(LootItem.lootTableItem(Items.PAPER).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                                    .add(LootItem.lootTableItem(Items.LAPIS_LAZULI).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 12))))
                                    .add(LootItem.lootTableItem(Items.EXPERIENCE_BOTTLE).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                            ));

            consumer.accept(ENHANCED_METALWORKS,
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(2, 4))
                                    .add(LootItem.lootTableItem(Items.CHAINMAIL_HELMET).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.7f))))
                                    .add(LootItem.lootTableItem(Items.CHAINMAIL_CHESTPLATE).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.7f))))
                                    .add(LootItem.lootTableItem(Items.CHAINMAIL_LEGGINGS).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.7f))))
                                    .add(LootItem.lootTableItem(Items.CHAINMAIL_BOOTS).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.7f))))
                                    .add(LootItem.lootTableItem(Items.IRON_PICKAXE).setWeight(5).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.7f))))
                                    .add(LootItem.lootTableItem(Items.IRON_AXE).setWeight(5).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.7f))))
                                    .add(LootItem.lootTableItem(Items.IRON_SHOVEL).setWeight(5).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.7f))))
                            )
                            .withPool(LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1))
                                    .add(LootItem.lootTableItem(Items.SHEARS).setWeight(15))
                                    .add(LootItem.lootTableItem(Items.SADDLE).setWeight(15))
                                    .add(LootItem.lootTableItem(Items.IRON_HORSE_ARMOR).setWeight(10))
                                    .add(LootItem.lootTableItem(Items.GOLDEN_HORSE_ARMOR).setWeight(10))
                                    .add(LootItem.lootTableItem(Items.DIAMOND_HORSE_ARMOR).setWeight(10))
                                    .add(LootItem.lootTableItem(Items.SPYGLASS).setWeight(5))
                            )
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(1, 4))
                                    .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(8, 32))))
                                    .add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(4, 16))))
                                    .add(LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(8, 32))))
                                    .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(5).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(1, 2))))
                                    .add(LootItem.lootTableItem(Items.EMERALD).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(6, 12))))
                                    .add(LootItem.lootTableItem(Items.CHAIN).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(6, 12))))
                                    .add(LootItem.lootTableItem(Items.BUCKET).setWeight(10))
                            ));

            consumer.accept(FLETCHING,
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(1, 4))
                                    .add(LootItem.lootTableItem(Items.ARROW).setWeight(150).apply(SetItemCountFunction.setCount(UniformGenerator.between(6, 12))))
                                    .add(LootItem.lootTableItem(Items.SPECTRAL_ARROW).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).apply(SetPotionFunction.setPotion(Potions.NIGHT_VISION)))
                                    .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).apply(SetPotionFunction.setPotion(Potions.LONG_NIGHT_VISION)))
                                    .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).apply(SetPotionFunction.setPotion(Potions.INVISIBILITY)))
                                    .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).apply(SetPotionFunction.setPotion(Potions.LONG_INVISIBILITY)))
                                    .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).apply(SetPotionFunction.setPotion(Potions.LEAPING)))
                                    .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).apply(SetPotionFunction.setPotion(Potions.LONG_LEAPING)))
                                    .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).apply(SetPotionFunction.setPotion(Potions.STRONG_LEAPING)))
                                    .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).apply(SetPotionFunction.setPotion(Potions.FIRE_RESISTANCE)))
                                    .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).apply(SetPotionFunction.setPotion(Potions.LONG_FIRE_RESISTANCE)))
                                    .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).apply(SetPotionFunction.setPotion(Potions.SWIFTNESS)))
                                    .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).apply(SetPotionFunction.setPotion(Potions.LONG_SWIFTNESS)))
                                    .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).apply(SetPotionFunction.setPotion(Potions.STRONG_SWIFTNESS)))
                                    .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).apply(SetPotionFunction.setPotion(Potions.SLOW_FALLING)))
                                    .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).apply(SetPotionFunction.setPotion(Potions.LONG_SLOW_FALLING)))
                            )
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(2, 6))
                                    .add(LootItem.lootTableItem(Items.FLINT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6))))
                                    .add(LootItem.lootTableItem(Items.FLINT).setWeight(12).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 9))))
                                    .add(LootItem.lootTableItem(Items.LEAD).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(6, 12))))
                                    .add(LootItem.lootTableItem(Items.FEATHER).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                            ));

            consumer.accept(KITCHEN,
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(5, 8))
                                    .add(LootItem.lootTableItem(Items.BREAD).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 16))))
                                    .add(LootItem.lootTableItem(Items.BONE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6))))
                                    .add(LootItem.lootTableItem(Items.POISONOUS_POTATO).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                    .add(LootItem.lootTableItem(Items.POTATO).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                                    .add(LootItem.lootTableItem(Items.BUCKET).setWeight(3))
                                    .add(LootItem.lootTableItem(Items.WHEAT_SEEDS).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                                    .add(LootItem.lootTableItem(Items.BEETROOT_SEEDS).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                    .add(LootItem.lootTableItem(Items.MELON_SEEDS).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                    .add(LootItem.lootTableItem(Items.WHEAT).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 9))))
                                    .add(LootItem.lootTableItem(Items.SUGAR).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                            ));

            consumer.accept(MAIN,
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(4, 8))
                                    .add(LootItem.lootTableItem(Items.GOLDEN_APPLE).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                    .add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE).setWeight(1))
                                    .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(25).apply(SetItemCountFunction.setCount(UniformGenerator.between(8, 16))))
                                    .add(LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(25).apply(SetItemCountFunction.setCount(UniformGenerator.between(10, 20))))
                                    .add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(20).apply(SetItemCountFunction.setCount(UniformGenerator.between(8, 16))))
                                    .add(LootItem.lootTableItem(Items.ENDER_PEARL).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                    .add(LootItem.lootTableItem(Items.APPLE).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                                    .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                                    .add(LootItem.lootTableItem(Items.EMERALD).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.DIAMOND_SWORD).setWeight(1).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2f, 0.6f))))
                                    .add(LootItem.lootTableItem(Items.DIAMOND_PICKAXE).setWeight(1).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2f, 0.6f))))
                                    .add(LootItem.lootTableItem(Items.DIAMOND_AXE).setWeight(1).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2f, 0.6f))))
                                    .add(LootItem.lootTableItem(Items.DIAMOND_SHOVEL).setWeight(1).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2f, 0.6f))))
                            ));

            consumer.accept(METALWORKS,
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(2, 4))
                                    .add(LootItem.lootTableItem(Items.CHAINMAIL_HELMET).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2f, 0.6f))))
                                    .add(LootItem.lootTableItem(Items.CHAINMAIL_CHESTPLATE).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2f, 0.6f))))
                                    .add(LootItem.lootTableItem(Items.CHAINMAIL_LEGGINGS).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2f, 0.6f))))
                                    .add(LootItem.lootTableItem(Items.CHAINMAIL_BOOTS).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2f, 0.6f))))
                                    .add(LootItem.lootTableItem(Items.IRON_PICKAXE).setWeight(5).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2f, 0.6f))))
                                    .add(LootItem.lootTableItem(Items.IRON_AXE).setWeight(5).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2f, 0.6f))))
                                    .add(LootItem.lootTableItem(Items.IRON_SHOVEL).setWeight(5).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2f, 0.6f))))
                            )
                            .withPool(LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1))
                                    .add(LootItem.lootTableItem(Items.SHEARS).setWeight(15))
                                    .add(LootItem.lootTableItem(Items.SADDLE).setWeight(15))
                                    .add(LootItem.lootTableItem(Items.IRON_HORSE_ARMOR).setWeight(15))
                                    .add(LootItem.lootTableItem(Items.GOLDEN_HORSE_ARMOR).setWeight(10))
                                    .add(LootItem.lootTableItem(Items.SPYGLASS).setWeight(3))
                            )
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(1, 4))
                                    .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(4, 16))))
                                    .add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(2, 8))))
                                    .add(LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(6, 24))))
                                    .add(LootItem.lootTableItem(Items.CHAIN).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(2, 10))))
                                    .add(LootItem.lootTableItem(Items.BUCKET).setWeight(10))
                            ));

            consumer.accept(MUSIC,
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(1, 2))
                                    .add(LootItem.lootTableItem(Items.MUSIC_DISC_13).setWeight(12))
                                    .add(LootItem.lootTableItem(Items.MUSIC_DISC_CAT).setWeight(12))
                                    .add(LootItem.lootTableItem(Items.MUSIC_DISC_BLOCKS).setWeight(2))
                                    .add(LootItem.lootTableItem(Items.MUSIC_DISC_CHIRP).setWeight(2))
                                    .add(LootItem.lootTableItem(Items.MUSIC_DISC_FAR).setWeight(2))
                                    .add(LootItem.lootTableItem(Items.MUSIC_DISC_MALL).setWeight(2))
                                    .add(LootItem.lootTableItem(Items.MUSIC_DISC_MELLOHI).setWeight(2))
                                    .add(LootItem.lootTableItem(Items.MUSIC_DISC_STAL).setWeight(2))
                                    .add(LootItem.lootTableItem(Items.MUSIC_DISC_STRAD).setWeight(2))
                                    .add(LootItem.lootTableItem(Items.MUSIC_DISC_WARD).setWeight(2))
                                    .add(LootItem.lootTableItem(Items.MUSIC_DISC_11).setWeight(2))
                                    .add(LootItem.lootTableItem(Items.MUSIC_DISC_WAIT).setWeight(2))
                            ));

            consumer.accept(WEAVING,
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(2, 6))
                                    .add(LootItem.lootTableItem(Items.BLACK_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.BLUE_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.BROWN_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.CYAN_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.GRAY_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.GREEN_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.LIGHT_BLUE_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.LIGHT_GRAY_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.LIME_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.MAGENTA_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.ORANGE_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.PINK_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.PURPLE_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.RED_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.WHITE_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.YELLOW_DYE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                            ).withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(2, 4))
                                    .add(LootItem.lootTableItem(Items.COBWEB).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                    .add(LootItem.lootTableItem(Items.STRING).setWeight(12).apply(SetItemCountFunction.setCount(UniformGenerator.between(6, 12))))
                                    .add(LootItem.lootTableItem(Items.LEATHER).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 9))))
                                    .add(LootItem.lootTableItem(Items.RABBIT_HIDE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 12))))
                            )
                            .withPool(LootPool.lootPool()
                                    .setRolls(UniformGenerator.between(1, 4))
                                    .add(LootItem.lootTableItem(Items.LEATHER_HORSE_ARMOR).setWeight(10))
                                    .add(LootItem.lootTableItem(Items.LEATHER_HELMET).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.7f))))
                                    .add(LootItem.lootTableItem(Items.LEATHER_CHESTPLATE).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.7f))))
                                    .add(LootItem.lootTableItem(Items.LEATHER_LEGGINGS).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.7f))))
                                    .add(LootItem.lootTableItem(Items.LEATHER_BOOTS).setWeight(10).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.7f))))
                            ));
        }
    }
}
