package tech.alexnijjar.subterrestrial.datagen.common.worldgen.pool

import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.data.worldgen.Pools
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool
import tech.alexnijjar.subterrestrial.datagen.common.worldgen.processor.DeepslateCabinProcessors
import tech.alexnijjar.subterrestrial.datagen.provider.server.registry.ModTemplatePoolProvider

object DeepslateCabinPools {
    val BASE = ModTemplatePoolProvider.createKey("cabin/deepslate/base")
    private val BOTTOM = ModTemplatePoolProvider.createKey("cabin/deepslate/bottom")
    private val TOP = ModTemplatePoolProvider.createKey("cabin/deepslate/top")

    fun bootstrap(context: BootstapContext<StructureTemplatePool>) {
        val processorListGetter = context.lookup(Registries.PROCESSOR_LIST)
        val templatePoolGetter = context.lookup(Registries.TEMPLATE_POOL)
        val empty = templatePoolGetter.getOrThrow(Pools.EMPTY)

        val replace = processorListGetter.getOrThrow(DeepslateCabinProcessors.REPLACE)
        val degradationReplace = processorListGetter.getOrThrow(DeepslateCabinProcessors.DEGRADATION_REPLACE)

        context.register(BASE, ModTemplatePoolProvider.createBasePools("deepslate", empty, replace, degradationReplace, true))
        context.register(BOTTOM, ModTemplatePoolProvider.createBottomPools("default", empty, replace, degradationReplace))
        context.register(TOP, ModTemplatePoolProvider.createTopPools("default", empty, replace, degradationReplace))
    }
}