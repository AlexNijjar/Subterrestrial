package com.github.alexnijjar.subterrestrial.util;

import java.util.List;
import java.util.function.Function;

import com.github.alexnijjar.subterrestrial.Subterrestrial;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;

public class ModUtils {

    public static boolean modLoaded(String string) {
        return FabricLoader.getInstance().isModLoaded(string);
    }

    // Returns an extractinator jigsaw structure if The Extractinator is installed, or the default main chest if it is not.
    public static List<Pair<Function<StructurePool.Projection, ? extends StructurePoolElement>, Integer>> getMainChest() {
        if (Subterrestrial.CONFIG.extractinatorSupport && modLoaded("the_extractinator")) {
            return ImmutableList.of(new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/loot/extractinator"), 1));
        } else {
            return ImmutableList.of(new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/loot/main"), 1));
        }
    }

    public static void registerMainChest() {
        StructurePools.register(new StructurePool(new ModIdentifier("main"), new Identifier("empty"), getMainChest(), StructurePool.Projection.RIGID));
    }
}