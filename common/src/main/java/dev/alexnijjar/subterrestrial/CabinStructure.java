package dev.alexnijjar.subterrestrial;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.PostPlacementProcessor;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;

import java.util.Optional;
import java.util.Random;

public class CabinStructure extends StructureFeature<JigsawConfiguration> {
    public CabinStructure(Codec<JigsawConfiguration> codec, int minHeight, int maxHeight) {
        super(codec, context -> CabinStructure.generate(context, minHeight, maxHeight), PostPlacementProcessor.NONE);
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.UNDERGROUND_STRUCTURES;
    }

    public static Optional<PieceGenerator<JigsawConfiguration>> generate(PieceGeneratorSupplier.Context<JigsawConfiguration> context, int minHeight, int maxHeight) {
        ChunkPos chunkPos = context.chunkPos();
        Random random = new Random();

        // Random x and z coordinates within the chunk.
        int x = random.nextInt(chunkPos.getMaxBlockX() - chunkPos.getMinBlockX()) + chunkPos.getMinBlockX();
        int y = minHeight == maxHeight ? minHeight : random.nextInt(maxHeight - minHeight) + minHeight;
        int z = random.nextInt(chunkPos.getMaxBlockZ() - chunkPos.getMinBlockZ()) + chunkPos.getMinBlockZ();

        return JigsawPlacement.addPieces(context, PoolElementStructurePiece::new, new BlockPos(x, y, z), false, false);
    }
}
