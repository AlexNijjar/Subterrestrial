package tech.alexnijjar.subterrestrial.datagen.common.worldgen.pool

import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.data.worldgen.Pools
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool
import tech.alexnijjar.subterrestrial.datagen.common.worldgen.processor.JungleCabinProcessors
import tech.alexnijjar.subterrestrial.datagen.provider.server.registry.ModTemplatePoolProvider

object JungleCabinPools {
    val BASE = ModTemplatePoolProvider.createKey("cabin/jungle/base")
    private val BOTTOM = ModTemplatePoolProvider.createKey("cabin/jungle/bottom")
    private val TOP = ModTemplatePoolProvider.createKey("cabin/jungle/top")

    fun bootstrap(context: BootstapContext<StructureTemplatePool>) {
        val processorListGetter = context.lookup(Registries.PROCESSOR_LIST)
        val templatePoolGetter = context.lookup(Registries.TEMPLATE_POOL)
        val empty = templatePoolGetter.getOrThrow(Pools.EMPTY)

        val replace = processorListGetter.getOrThrow(JungleCabinProcessors.REPLACE)
        val degradationReplace = processorListGetter.getOrThrow(JungleCabinProcessors.DEGRADATION_REPLACE)

        context.register(BASE, ModTemplatePoolProvider.createBasePools("jungle", empty, replace, degradationReplace, false))
        context.register(BOTTOM, ModTemplatePoolProvider.createBottomPools("jungle", empty, replace, degradationReplace))
        context.register(TOP, ModTemplatePoolProvider.createTopPools("jungle", empty, replace, degradationReplace))
    }
}