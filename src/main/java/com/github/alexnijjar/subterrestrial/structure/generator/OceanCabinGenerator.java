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

public class OceanCabinGenerator {

    public static final StructurePool STARTING_POOL;

    static {

        int intactWeight = 10;
        int brokenWeight = 20;

        for (CabinConfig config : Subterrestrial.CONFIG.cabinConfig_v1) {
            if (config.name.equals("ocean_cabin")) {
                intactWeight = config.intactWeight;
                brokenWeight = config.brokenWeight;
                break;
            }
        }

        STARTING_POOL = StructurePools.register(
                new StructurePool(
                        new SubterrestrialIdentifier("ocean_cabin_base"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/ocean/cabin_lower_base_1"), intactWeight),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/ocean/cabin_lower_base_2"), brokenWeight),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/ocean/cabin_lower_base_3"), brokenWeight)
                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePools.register(
                new StructurePool(
                        new SubterrestrialIdentifier("ocean_intact_cabin_bottom"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/ocean/cabin_bottom_1"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePools.register(
                new StructurePool(
                        new SubterrestrialIdentifier("ocean_cabin_bottom"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/ocean/cabin_bottom_2"), 1),
                                new Pair<>(StructurePoolElement.ofSingle(Subterrestrial.MOD_ID + ":cabin/ocean/cabin_bottom_3"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );
    }
}
