package com.github.alexnijjar.subterrestrial.structure;

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

    public CabinStructure(Codec<StructurePoolFeatureConfig> codec, int min, int max) {
        super(codec, (context) -> CabinStructure.generate(context, min, max), PostPlacementProcessor.EMPTY);
    }

    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> generate(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context, int min, int max) {

        int randomY =  new Random().nextInt(max - min) + min;
        BlockPos pos = context.chunkPos().getCenterAtY(randomY);

        return StructurePoolBasedGenerator.generate(context, PoolStructurePiece::new, pos, false, false);
    }
}
