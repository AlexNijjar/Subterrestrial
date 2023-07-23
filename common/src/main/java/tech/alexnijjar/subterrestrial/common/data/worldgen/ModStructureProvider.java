package tech.alexnijjar.subterrestrial.common.data.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import tech.alexnijjar.subterrestrial.Subterrestrial;
import tech.alexnijjar.subterrestrial.common.data.worldgen.pool.*;
import tech.alexnijjar.subterrestrial.common.tag.ModTags;

import java.util.Map;
import java.util.Optional;

public class ModStructureProvider {

    private static final int OFFSET = 0; // for debugging
    public static final ResourceKey<Structure> DEEPSLATE_CABIN = createKey("deepslate_cabin");
    public static final ResourceKey<Structure> DEFAULT_CABIN = createKey("default_cabin");
    public static final ResourceKey<Structure> DESERT_CABIN = createKey("desert_cabin");
    public static final ResourceKey<Structure> ICE_CABIN = createKey("ice_cabin");
    public static final ResourceKey<Structure> JUNGLE_CABIN = createKey("jungle_cabin");
    public static final ResourceKey<Structure> MESA_CABIN = createKey("mesa_cabin");
    public static final ResourceKey<Structure> OCEAN_CABIN = createKey("ocean_cabin");
    public static final ResourceKey<Structure> TAIGA_CABIN = createKey("taiga_cabin");

    public static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(Subterrestrial.MOD_ID, name));
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> biomes, Map<MobCategory, StructureSpawnOverride> spawnOverrides, GenerationStep.Decoration step, TerrainAdjustment terrainAdaptation) {
        return new Structure.StructureSettings(biomes, spawnOverrides, step, terrainAdaptation);
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> biomes, GenerationStep.Decoration step, TerrainAdjustment terrainAdaptation) {
        return structure(biomes, Map.of(), step, terrainAdaptation);
    }

    public static void bootstrap(BootstapContext<Structure> context) {
        HolderGetter<Biome> holderGetter = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> holderGetter2 = context.lookup(Registries.TEMPLATE_POOL);
        context.register(
            DEEPSLATE_CABIN,
            new JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_DEEPSLATE_CABIN),
                GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
                TerrainAdjustment.BEARD_THIN),
                holderGetter2.getOrThrow(DeepslateCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(-56 + OFFSET), VerticalAnchor.absolute(-6 + OFFSET)),
                false,
                Optional.empty(),
                80));

        context.register(
            DEFAULT_CABIN,
            new JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_DEFAULT_CABIN),
                GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
                TerrainAdjustment.BEARD_THIN),
                holderGetter2.getOrThrow(DefaultCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(6 + OFFSET), VerticalAnchor.absolute(42 + OFFSET)),
                false,
                Optional.empty(),
                80));

        context.register(
            DESERT_CABIN,
            new JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_DESERT_CABIN),
                GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
                TerrainAdjustment.BEARD_THIN),
                holderGetter2.getOrThrow(DesertCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(6 + OFFSET), VerticalAnchor.absolute(44 + OFFSET)),
                false,
                Optional.empty(),
                80));

        context.register(
            ICE_CABIN,
            new JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_ICE_CABIN),
                GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
                TerrainAdjustment.BEARD_THIN),
                holderGetter2.getOrThrow(IceCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(6 + OFFSET), VerticalAnchor.absolute(42 + OFFSET)),
                false,
                Optional.empty(),
                80));

        context.register(
            JUNGLE_CABIN,
            new JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_JUNGLE_CABIN),
                GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
                TerrainAdjustment.BEARD_THIN),
                holderGetter2.getOrThrow(JungleCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(6 + OFFSET), VerticalAnchor.absolute(44 + OFFSET)),
                false,
                Optional.empty(),
                80));

        context.register(
            MESA_CABIN,
            new JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_MESA_CABIN),
                GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
                TerrainAdjustment.BEARD_THIN),
                holderGetter2.getOrThrow(MesaCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(6 + OFFSET), VerticalAnchor.absolute(48 + OFFSET)),
                false,
                Optional.empty(),
                80));

        context.register(
            OCEAN_CABIN,
            new JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_OCEAN_CABIN),
                GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
                TerrainAdjustment.BEARD_THIN),
                holderGetter2.getOrThrow(OceanCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(24 + OFFSET), VerticalAnchor.absolute(44 + OFFSET)),
                false,
                Optional.empty(),
                80));

        context.register(
            TAIGA_CABIN,
            new JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_TAIGA_CABIN),
                GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
                TerrainAdjustment.BEARD_THIN),
                holderGetter2.getOrThrow(TaigaCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(6 + OFFSET), VerticalAnchor.absolute(48 + OFFSET)),
                false,
                Optional.empty(),
                80));
    }
}
