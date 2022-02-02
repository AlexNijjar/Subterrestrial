package com.github.alexnijjar.subterrestrial.util;

import com.github.alexnijjar.subterrestrial.Subterrestrial;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;

import java.util.List;
import java.util.function.Function;

public class SubterrestrialUtils {

    public static boolean modLoaded(String string) {
        return FabricLoader.getInstance().isModLoaded(string);
    }

    public static List<Pair<Function<StructurePool.Projection, ? extends StructurePoolElement>, Integer>> getMainChest() {
        if (Subterrestrial.CONFIG.extractinatorSupport_v1 && modLoaded("the_extractinator")) {
            return ImmutableList.of(
                    new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/main/main_loot_extractinator"), 1)
            );
        } else {
            return ImmutableList.of(
                    new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/main/main_loot_chest"), 1)
            );
        }
    }
}
