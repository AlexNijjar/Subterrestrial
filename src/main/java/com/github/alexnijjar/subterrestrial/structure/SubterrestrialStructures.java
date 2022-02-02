package com.github.alexnijjar.subterrestrial.structure;

import com.github.alexnijjar.subterrestrial.Subterrestrial;
import com.github.alexnijjar.subterrestrial.config.CabinConfig;
import com.github.alexnijjar.subterrestrial.structure.generator.SimpleCabinGenerator;
import com.github.alexnijjar.subterrestrial.util.SubterrestrialIdentifier;
import com.github.alexnijjar.subterrestrial.util.SubterrestrialUtils;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

import java.util.function.Predicate;

public class SubterrestrialStructures {

    public static void register() {

        if (Subterrestrial.CONFIG.generateCabins_v1) {

            int salt = 951481806;
            for (CabinConfig config : Subterrestrial.CONFIG.cabinConfig_v1) {

                String name = config.name.replace("_cabin", "");
                StructureFeature<StructurePoolFeatureConfig> structure = new CabinStructure(StructurePoolFeatureConfig.CODEC, config.name);
                ConfiguredStructureFeature<?, ?> configured;

                FabricStructureBuilder.create(new SubterrestrialIdentifier(name + "_underground_cabin"), structure)
                        .step(GenerationStep.Feature.UNDERGROUND_STRUCTURES)
                        .defaultConfig(new StructureConfig(
                                config.spacing,
                                config.separation,
                                salt))
                        .adjustsSurface()
                        .register();

                StructurePool pool = SimpleCabinGenerator.createSimpleCabin(name);
                configured = structure.configure(new StructurePoolFeatureConfig(() -> pool, 1));
                Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, new SubterrestrialIdentifier("configured_" + name + "_cabin"), configured);

                // Add structure spawning to biomes.
                BiomeModifications.addStructure(
                        getBiomes(name),
                        RegistryKey.of(
                                Registry.CONFIGURED_STRUCTURE_FEATURE_KEY,
                                BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getId(configured))
                );

                salt++;
            }

            // Used in all cabins.
            StructurePools.register(
                    new StructurePool(
                            new SubterrestrialIdentifier("cabin_main_loot"),
                            new Identifier("empty"),
                            SubterrestrialUtils.getMainChest(),
                            StructurePool.Projection.RIGID
                    )
            );
        }
    }

    public static Predicate<BiomeSelectionContext> getBiomes(String name) {
        switch (name) {
            case "default" -> {
                return BiomeSelectors.categories(
                        Biome.Category.EXTREME_HILLS,
                        Biome.Category.PLAINS,
                        Biome.Category.BEACH,
                        Biome.Category.FOREST,
                        Biome.Category.SWAMP,
                        Biome.Category.MUSHROOM,
                        Biome.Category.UNDERGROUND,
                        Biome.Category.MOUNTAIN
                );
            }
            case "deepslate" -> {
                return BiomeSelectors.foundInOverworld();
            }
            case "desert" -> {
                return BiomeSelectors.categories(
                        Biome.Category.DESERT,
                        Biome.Category.SAVANNA,
                        Biome.Category.MESA
                );
            }
            case "ice" -> {
                return BiomeSelectors.categories(
                        Biome.Category.ICY,
                        Biome.Category.TAIGA
                );
            }
            case "jungle" -> {
                return BiomeSelectors.categories(
                        Biome.Category.JUNGLE
                );
            }
            case "ocean" -> {
                return BiomeSelectors.categories(
                        Biome.Category.OCEAN,
                        Biome.Category.RIVER
                );
            }
        }
        return BiomeSelectors.foundInOverworld();
    }
}
