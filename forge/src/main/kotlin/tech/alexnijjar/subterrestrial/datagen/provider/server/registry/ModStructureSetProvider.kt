package tech.alexnijjar.subterrestrial.datagen.provider.server.registry

import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.structure.StructureSet
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType
import tech.alexnijjar.subterrestrial.Subterrestrial

object ModStructureSetProvider {
    private val DEEPSLATE_CABIN = createKey("deepslate_cabin")
    private val DEFAULT_CABIN = createKey("default_cabin")
    private val DESERT_CABIN = createKey("desert_cabin")
    private val ICE_CABIN = createKey("ice_cabin")
    private val JUNGLE_CABIN = createKey("jungle_cabin")
    private val MESA_CABIN = createKey("mesa_cabin")
    private val OCEAN_CABIN = createKey("ocean_cabin")
    private val TAIGA_CABIN = createKey("taiga_cabin")

    private fun createKey(name: String): ResourceKey<StructureSet> {
        return ResourceKey.create(Registries.STRUCTURE_SET, ResourceLocation(Subterrestrial.MOD_ID, name))
    }

    fun bootstrap(context: BootstapContext<StructureSet>) {
        val holderGetter = context.lookup(Registries.STRUCTURE)
        context.register(DEEPSLATE_CABIN,
            StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.DEEPSLATE_CABIN),
                RandomSpreadStructurePlacement(
                    8,
                    6,
                    RandomSpreadType.LINEAR,
                    930216435)))
        context.register(DEFAULT_CABIN,
            StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.DEFAULT_CABIN),
                RandomSpreadStructurePlacement(
                    8,
                    7,
                    RandomSpreadType.LINEAR,
                    620305146)))
        context.register(DESERT_CABIN,
            StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.DESERT_CABIN),
                RandomSpreadStructurePlacement(
                    7,
                    6,
                    RandomSpreadType.LINEAR,
                    850269402)))
        context.register(ICE_CABIN,
            StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.ICE_CABIN),
                RandomSpreadStructurePlacement(
                    6,
                    5,
                    RandomSpreadType.LINEAR,
                    398191767)))
        context.register(JUNGLE_CABIN,
            StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.JUNGLE_CABIN),
                RandomSpreadStructurePlacement(
                    7,
                    6,
                    RandomSpreadType.LINEAR,
                    991795390)))
        context.register(MESA_CABIN,
            StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.MESA_CABIN),
                RandomSpreadStructurePlacement(
                    6,
                    5,
                    RandomSpreadType.LINEAR,
                    367681074)))
        context.register(OCEAN_CABIN,
            StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.OCEAN_CABIN),
                RandomSpreadStructurePlacement(
                    10,
                    8,
                    RandomSpreadType.LINEAR,
                    259410023)))
        context.register(TAIGA_CABIN,
            StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.TAIGA_CABIN),
                RandomSpreadStructurePlacement(
                    7,
                    6,
                    RandomSpreadType.LINEAR,
                    764700120)))
    }
}
