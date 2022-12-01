package dev.alexnijjar.subterrestrial.registry;

import com.mojang.datafixers.util.Pair;
import dev.alexnijjar.subterrestrial.CabinStructure;
import dev.alexnijjar.subterrestrial.Subterrestrial;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.List;
import java.util.function.Supplier;

public class ModStructures {
    public static final Supplier<StructureFeature<JigsawConfiguration>> DEEPSLATE_CABIN = register("deepslate_cabin", () -> new CabinStructure(JigsawConfiguration.CODEC, -56, -6));
    public static final Supplier<StructureFeature<JigsawConfiguration>> DEFAULT_CABIN = register("default_cabin", () -> new CabinStructure(JigsawConfiguration.CODEC, 6, 42));
    public static final Supplier<StructureFeature<JigsawConfiguration>> DESERT_CABIN = register("desert_cabin", () -> new CabinStructure(JigsawConfiguration.CODEC, 6, 44));
    public static final Supplier<StructureFeature<JigsawConfiguration>> ICE_CABIN = register("ice_cabin", () -> new CabinStructure(JigsawConfiguration.CODEC, 6, 42));
    public static final Supplier<StructureFeature<JigsawConfiguration>> JUNGLE_CABIN = register("jungle_cabin", () -> new CabinStructure(JigsawConfiguration.CODEC, 6, 44));
    public static final Supplier<StructureFeature<JigsawConfiguration>> MESA_CABIN = register("mesa_cabin", () -> new CabinStructure(JigsawConfiguration.CODEC, 6, 48));
    public static final Supplier<StructureFeature<JigsawConfiguration>> OCEAN_CABIN = register("ocean_cabin", () -> new CabinStructure(JigsawConfiguration.CODEC, 24, 44));
    public static final Supplier<StructureFeature<JigsawConfiguration>> TAIGA_CABIN = register("taiga_cabin", () -> new CabinStructure(JigsawConfiguration.CODEC, 6, 48));

    private static <T extends StructureFeature<C>, C extends FeatureConfiguration> Supplier<T> register(String id, Supplier<T> object) {
        return ModRegistryHelpers.register(Registry.STRUCTURE_FEATURE, id, object);
    }

    // Registers an extractinator jigsaw structure if the Extractinator mod is installed, or the default main chest if it is not.
    public static void registerMainChest() {
        Pools.register(
                new StructureTemplatePool(
                        new ResourceLocation(Subterrestrial.MOD_ID, "main"),
                        new ResourceLocation("empty"),
                        List.of(new Pair<>(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/loot/" + (ModRegistryHelpers.isModLoaded("extractinator") ? "extractinator" : "main")), 1)),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }

    public static void init() {
    }
}