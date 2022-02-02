package com.github.alexnijjar.subterrestrial.structure;

import com.github.alexnijjar.subterrestrial.Subterrestrial;
import com.github.alexnijjar.subterrestrial.config.CabinConfig;
import com.mojang.serialization.Codec;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.PostPlacementProcessor;
import net.minecraft.structure.StructureGeneratorFactory;
import net.minecraft.structure.StructurePiecesGenerator;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

import java.util.Optional;
import java.util.Random;

public class CabinStructure extends StructureFeature<StructurePoolFeatureConfig> {

    public CabinStructure(Codec<StructurePoolFeatureConfig> codec, String name) {
        super(codec, (context) -> CabinStructure.generate(context, name), PostPlacementProcessor.EMPTY);
    }

    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> generate(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context, String name) {

        int min = 4;
        int max = 45;

        for (CabinConfig config : Subterrestrial.CONFIG.cabinConfig_v1) {
            if (config.name.equals(name)) {
                min = config.minHeight;
                max = config.maxHeight;
                break;
            }
        }

        int y = min == max ? min : new Random().nextInt(max - min) + min;

        BlockPos pos = context.chunkPos().getCenterAtY(y);

        return StructurePoolBasedGenerator.generate(context, PoolStructurePiece::new, pos, false, false);
    }
}
