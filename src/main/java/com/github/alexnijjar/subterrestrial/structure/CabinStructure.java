package com.github.alexnijjar.subterrestrial.structure;

import com.github.alexnijjar.subterrestrial.config.CabinConfig;
import com.mojang.serialization.Codec;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.PostPlacementProcessor;
import net.minecraft.structure.StructureGeneratorFactory;
import net.minecraft.structure.StructurePiecesGenerator;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

import java.util.Optional;
import java.util.Random;

public class CabinStructure extends StructureFeature<StructurePoolFeatureConfig> {

    public CabinStructure(Codec<StructurePoolFeatureConfig> codec, CabinConfig config) {
        super(codec, (context) -> CabinStructure.generate(context, config), PostPlacementProcessor.EMPTY);
    }

    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> generate(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context, CabinConfig config) {

        int minHeight = config.minHeight;
        int maxHeight = config.maxHeight;

        ChunkPos chunkPos = context.chunkPos();
        Random random = new Random();

        // Random x and z coordinates within the chunk.
        int x = random.nextInt(chunkPos.getEndX() - chunkPos.getStartX()) + chunkPos.getStartX();
        int z = random.nextInt(chunkPos.getEndZ() - chunkPos.getStartZ()) + chunkPos.getStartZ();

        // Random y coordinate based on the min and max height value in the config.
        int y = minHeight == maxHeight ? minHeight : random.nextInt(maxHeight - minHeight) + minHeight;

        return StructurePoolBasedGenerator.generate(context, PoolStructurePiece::new, new BlockPos(x, y, z), false, false);
    }
}
