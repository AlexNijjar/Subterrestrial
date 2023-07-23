package tech.alexnijjar.subterrestrial.datagen.common.worldgen.pool

import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.data.worldgen.Pools
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool
import tech.alexnijjar.subterrestrial.datagen.common.worldgen.processor.DesertCabinProcessors
import tech.alexnijjar.subterrestrial.datagen.provider.server.registry.ModTemplatePoolProvider

object DesertCabinPools {
    val BASE = ModTemplatePoolProvider.createKey("cabin/desert/base")
    private val BOTTOM = ModTemplatePoolProvider.createKey("cabin/desert/bottom")
    private val TOP = ModTemplatePoolProvider.createKey("cabin/desert/top")

    fun bootstrap(context: BootstapContext<StructureTemplatePool>) {
        val processorListGetter = context.lookup(Registries.PROCESSOR_LIST)
        val templatePoolGetter = context.lookup(Registries.TEMPLATE_POOL)
        val empty = templatePoolGetter.getOrThrow(Pools.EMPTY)

        val replace = processorListGetter.getOrThrow(DesertCabinProcessors.REPLACE)
        val degradationReplace = processorListGetter.getOrThrow(DesertCabinProcessors.DEGRADATION_REPLACE)

        context.register(BASE, ModTemplatePoolProvider.createBasePools("desert", empty, replace, degradationReplace, false))
        context.register(BOTTOM, ModTemplatePoolProvider.createBottomPools("desert", empty, replace, degradationReplace))
        context.register(TOP, ModTemplatePoolProvider.createTopPools("desert", empty, replace, degradationReplace))
    }
}