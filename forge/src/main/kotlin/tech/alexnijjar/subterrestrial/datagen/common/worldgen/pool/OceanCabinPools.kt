package tech.alexnijjar.subterrestrial.datagen.common.worldgen.pool

import com.google.common.collect.ImmutableList
import com.mojang.datafixers.util.Pair
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.data.worldgen.Pools
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool
import tech.alexnijjar.subterrestrial.Subterrestrial
import tech.alexnijjar.subterrestrial.datagen.common.worldgen.processor.OceanCabinProcessors
import tech.alexnijjar.subterrestrial.datagen.provider.server.registry.ModTemplatePoolProvider
import java.util.function.Function

object OceanCabinPools {
    val BASE = ModTemplatePoolProvider.createKey("cabin/ocean/base")
    private val BOTTOM = ModTemplatePoolProvider.createKey("cabin/ocean/bottom")

    fun bootstrap(context: BootstapContext<StructureTemplatePool>) {
        val processorListGetter = context.lookup(Registries.PROCESSOR_LIST)
        val templatePoolGetter = context.lookup(Registries.TEMPLATE_POOL)
        val empty = templatePoolGetter.getOrThrow(Pools.EMPTY)

        val replace = processorListGetter.getOrThrow(OceanCabinProcessors.REPLACE)
        val degradationReplace = processorListGetter.getOrThrow(OceanCabinProcessors.DEGRADATION_REPLACE)

        val builder = ImmutableList.builder<Pair<Function<StructureTemplatePool.Projection, out StructurePoolElement>, Int>>()
        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/base_lower_0", degradationReplace), 100))
        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/base_lower_0", replace), 5))

        context.register(BASE, StructureTemplatePool(
            empty,
            builder.build(),
            StructureTemplatePool.Projection.RIGID))

        val builder1 = ImmutableList.builder<Pair<Function<StructureTemplatePool.Projection, out StructurePoolElement>, Int>>()
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_0", degradationReplace), 100))
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_0", replace), 5))
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_1", degradationReplace), 100))
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_1", replace), 5))
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_2", degradationReplace), 100))
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_2", replace), 5))
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_3", degradationReplace), 100))
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_3", replace), 5))

        context.register(BOTTOM, StructureTemplatePool(
            empty,
            builder1.build(),
            StructureTemplatePool.Projection.RIGID))
    }
}