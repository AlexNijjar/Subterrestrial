package tech.alexnijjar.subterrestrial.datagen.provider.server.registry

import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.levelgen.GenerationStep
import net.minecraft.world.level.levelgen.VerticalAnchor
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight
import net.minecraft.world.level.levelgen.structure.Structure
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure
import tech.alexnijjar.subterrestrial.Subterrestrial
import tech.alexnijjar.subterrestrial.datagen.common.tags.ModTags
import tech.alexnijjar.subterrestrial.datagen.common.worldgen.pool.*
import java.util.*

object ModStructureProvider {

    val DEEPSLATE_CABIN = createKey("deepslate_cabin")
    val DEFAULT_CABIN = createKey("default_cabin")
    val DESERT_CABIN = createKey("desert_cabin")
    val ICE_CABIN = createKey("ice_cabin")
    val JUNGLE_CABIN = createKey("jungle_cabin")
    val MESA_CABIN = createKey("mesa_cabin")
    val OCEAN_CABIN = createKey("ocean_cabin")
    val TAIGA_CABIN = createKey("taiga_cabin")

    fun createKey(name: String): ResourceKey<Structure> {
        return ResourceKey.create(Registries.STRUCTURE, ResourceLocation(Subterrestrial.MOD_ID, name))
    }

    private fun structure(biomes: HolderSet<Biome>, spawnOverrides: Map<MobCategory, StructureSpawnOverride>): Structure.StructureSettings {
        return Structure.StructureSettings(biomes, spawnOverrides, GenerationStep.Decoration.UNDERGROUND_STRUCTURES, TerrainAdjustment.BEARD_THIN)
    }

    private fun structure(biomes: HolderSet<Biome>): Structure.StructureSettings {
        return structure(biomes, java.util.Map.of())
    }

    fun bootstrap(context: BootstapContext<Structure>) {
        val holderGetter = context.lookup(Registries.BIOME)
        val holderGetter2 = context.lookup(Registries.TEMPLATE_POOL)
        context.register(
            DEEPSLATE_CABIN,
            JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_DEEPSLATE_CABIN)),
                holderGetter2.getOrThrow(DeepslateCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(-56), VerticalAnchor.absolute(-6)),
                false,
                Optional.empty(),
                80))
        context.register(
            DEFAULT_CABIN,
            JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_DEFAULT_CABIN)),
                holderGetter2.getOrThrow(DefaultCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(6), VerticalAnchor.absolute(42)),
                false,
                Optional.empty(),
                80))
        context.register(
            DESERT_CABIN,
            JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_DESERT_CABIN)),
                holderGetter2.getOrThrow(DesertCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(6), VerticalAnchor.absolute(44)),
                false,
                Optional.empty(),
                80))
        context.register(
            ICE_CABIN,
            JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_ICE_CABIN)),
                holderGetter2.getOrThrow(IceCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(6), VerticalAnchor.absolute(42)),
                false,
                Optional.empty(),
                80))
        context.register(
            JUNGLE_CABIN,
            JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_JUNGLE_CABIN)),
                holderGetter2.getOrThrow(JungleCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(6), VerticalAnchor.absolute(44)),
                false,
                Optional.empty(),
                80))
        context.register(
            MESA_CABIN,
            JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_MESA_CABIN)),
                holderGetter2.getOrThrow(MesaCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(6), VerticalAnchor.absolute(48)),
                false,
                Optional.empty(),
                80))
        context.register(
            OCEAN_CABIN,
            JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_OCEAN_CABIN)),
                holderGetter2.getOrThrow(OceanCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(24), VerticalAnchor.absolute(44)),
                false,
                Optional.empty(),
                80))
        context.register(
            TAIGA_CABIN,
            JigsawStructure(structure(
                holderGetter.getOrThrow(ModTags.HAS_TAIGA_CABIN)),
                holderGetter2.getOrThrow(TaigaCabinPools.BASE),
                Optional.empty(),
                7,
                UniformHeight.of(VerticalAnchor.absolute(6), VerticalAnchor.absolute(48)),
                false,
                Optional.empty(),
                80))
    }
}