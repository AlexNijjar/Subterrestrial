package tech.alexnijjar.subterrestrial.datagen.common.worldgen.pool

import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.data.worldgen.Pools
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool
import tech.alexnijjar.subterrestrial.datagen.common.worldgen.processor.TaigaCabinProcessors
import tech.alexnijjar.subterrestrial.datagen.provider.server.registry.ModTemplatePoolProvider

object TaigaCabinPools {
    val BASE = ModTemplatePoolProvider.createKey("cabin/taiga/base")
    private val BOTTOM = ModTemplatePoolProvider.createKey("cabin/taiga/bottom")
    private val TOP = ModTemplatePoolProvider.createKey("cabin/taiga/top")

    fun bootstrap(context: BootstapContext<StructureTemplatePool>) {
        val processorListGetter = context.lookup(Registries.PROCESSOR_LIST)
        val templatePoolGetter = context.lookup(Registries.TEMPLATE_POOL)
        val empty = templatePoolGetter.getOrThrow(Pools.EMPTY)

        val replace = processorListGetter.getOrThrow(TaigaCabinProcessors.REPLACE)
        val degradationReplace = processorListGetter.getOrThrow(TaigaCabinProcessors.DEGRADATION_REPLACE)

        context.register(BASE, ModTemplatePoolProvider.createBasePools("taiga", empty, replace, degradationReplace, false))
        context.register(BOTTOM, ModTemplatePoolProvider.createBottomPools("taiga", empty, replace, degradationReplace))
        context.register(TOP, ModTemplatePoolProvider.createTopPools("taiga", empty, replace, degradationReplace))
    }
}