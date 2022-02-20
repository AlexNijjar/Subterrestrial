package com.github.alexnijjar.subterrestrial.structure;

import com.github.alexnijjar.subterrestrial.config.CabinConfig;
import com.github.alexnijjar.subterrestrial.util.SubterrestrialIdentifier;
import com.github.alexnijjar.subterrestrial.util.SubterrestrialUtils;
import com.mojang.serialization.Codec;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.PostPlacementProcessor;
import net.minecraft.structure.StructureGeneratorFactory;
import net.minecraft.structure.StructurePiecesGenerator;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class CabinStructure extends StructureFeature<StructurePoolFeatureConfig> {

    public CabinStructure(Codec<StructurePoolFeatureConfig> codec, String name) {
        super(codec, (context) -> CabinStructure.generate(context, name), PostPlacementProcessor.EMPTY);
    }

    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> generate(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context, String name) {

        int min = 4;
        int max = 45;

        for (Map.Entry<String, CabinConfig> entry : SubterrestrialUtils.getCabinList().entrySet()) {
            String key = entry.getKey();
            CabinConfig value = entry.getValue();

            if (key.equals(name + "_cabin")) {
                if (!value.enabled) return Optional.empty();
                min = value.minHeight;
                max = value.maxHeight;
                break;
            }
        }

        int y = min == max ? min : new Random().nextInt(max - min) + min;

        BlockPos pos = context.chunkPos().getCenterAtY(y);

        StructurePoolFeatureConfig newConfig = new StructurePoolFeatureConfig(
                () -> context.registryManager().get(Registry.STRUCTURE_POOL_KEY)
                        .get(new SubterrestrialIdentifier("cabin/" + name + "/base")),
                10
        );

        StructureGeneratorFactory.Context<StructurePoolFeatureConfig> newContext = new StructureGeneratorFactory.Context<>(
                context.chunkGenerator(),
                context.biomeSource(),
                context.seed(),
                context.chunkPos(),
                newConfig,
                context.world(),
                context.validBiome(),
                context.structureManager(),
                context.registryManager()
        );

        return StructurePoolBasedGenerator.generate(newContext, PoolStructurePiece::new, pos, false, false);
    }
}
