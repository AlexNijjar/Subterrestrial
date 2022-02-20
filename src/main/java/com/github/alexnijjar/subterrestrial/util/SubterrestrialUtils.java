package com.github.alexnijjar.subterrestrial.util;

import com.github.alexnijjar.subterrestrial.Subterrestrial;
import com.github.alexnijjar.subterrestrial.config.CabinConfig;
import com.github.alexnijjar.subterrestrial.config.SubterrestrialConfig;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class SubterrestrialUtils {

    public static boolean modLoaded(String string) {
        return FabricLoader.getInstance().isModLoaded(string);
    }

    // Returns an extractinator jigsaw structure if The Extractinator is installed, or the default main chest if it is not.
    public static List<Pair<Function<StructurePool.Projection, ? extends StructurePoolElement>, Integer>> getMainChest() {
        if (Subterrestrial.CONFIG.extractinatorSupport && modLoaded("the_extractinator")) {
            return ImmutableList.of(
                    new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/loot/extractinator"), 1)
            );
        } else {
            return ImmutableList.of(
                    new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/loot/main"), 1)
            );
        }
    }

    public static void registerPool(List<Pair<Function<StructurePool.Projection, ? extends StructurePoolElement>, Integer>> items, String id) {
        StructurePools.register(
                new StructurePool(
                        new SubterrestrialIdentifier(id),
                        new Identifier("empty"),
                        items,
                        StructurePool.Projection.RIGID
                )
        );
    }

    public static Map<String, CabinConfig> getCabinList() {
        SubterrestrialConfig config = Subterrestrial.CONFIG;
        return ImmutableMap.of(
                "default_cabin", config.defaultCabin,
                "deepslate_cabin", config.deepslateCabin,
                "desert_cabin", config.desertCabin,
                "mesa_cabin", config.mesaCabin,
                "taiga_cabin", config.taigaCabin,
                "ice_cabin", config.iceCabin,
                "jungle_cabin", config.jungleCabin,
                "ocean_cabin", config.oceanCabin
        );
    }
}
