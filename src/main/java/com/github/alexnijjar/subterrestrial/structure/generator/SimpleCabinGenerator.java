package com.github.alexnijjar.subterrestrial.structure.generator;

import com.github.alexnijjar.subterrestrial.Subterrestrial;
import com.github.alexnijjar.subterrestrial.config.CabinConfig;
import com.github.alexnijjar.subterrestrial.util.SubterrestrialIdentifier;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;

public class SimpleCabinGenerator {

    public static StructurePool createSimpleCabin(String name) {
        int intactWeight = 100;
        int brokenWeight = 200;

        for (CabinConfig config : Subterrestrial.CONFIG.cabinConfig_v1) {
            if (config.name.equals(name + "_cabin")) {
                intactWeight = config.intactWeight;
                brokenWeight = config.brokenWeight;
                break;
            }
        }

        registerIntactPool(name, "top");
        registerIntactPool(name, "bottom");
        registerPool(name, "top");
        registerPool(name, "bottom");

        return StructurePools.register(
                new StructurePool(
                        new SubterrestrialIdentifier(name + "_cabin_base"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_base_1"), intactWeight),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_upper_base_1"), intactWeight),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_lower_base_1"), intactWeight),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_base_2"), brokenWeight),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_upper_base_2"), brokenWeight),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_lower_base_2"), brokenWeight),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_base_3"), brokenWeight),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_upper_base_3"), brokenWeight),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_lower_base_3"), brokenWeight),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_base_4"), brokenWeight),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_upper_base_4"), brokenWeight),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_lower_base_4"), brokenWeight)
                        ),
                        StructurePool.Projection.RIGID
                )
        );
    }

    public static void registerPool(String name, String location) {
        StructurePools.register(
                new StructurePool(
                        new SubterrestrialIdentifier(name + "_cabin_" + location),
                        new Identifier("empty"),
                        ImmutableList.of(
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_" + location + "_2"), 1),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_" + location + "_3"), 1),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_" + location + "_4"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );
    }

    public static void registerIntactPool(String name, String location) {
        StructurePools.register(
                new StructurePool(
                        new SubterrestrialIdentifier(name + "_intact_cabin_" + location),
                        new Identifier("empty"),
                        ImmutableList.of(
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/" + name + "/cabin_" + location + "_1"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );
    }
}
