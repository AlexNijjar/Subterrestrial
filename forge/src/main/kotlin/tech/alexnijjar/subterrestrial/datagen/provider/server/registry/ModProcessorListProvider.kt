package tech.alexnijjar.subterrestrial.datagen.provider.server.registry

import com.google.common.collect.ImmutableList
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.block.state.properties.Property
import net.minecraft.world.level.levelgen.structure.templatesystem.*
import tech.alexnijjar.subterrestrial.Subterrestrial
import tech.alexnijjar.subterrestrial.datagen.common.worldgen.processor.*

object ModProcessorListProvider {

    fun createKey(name: String): ResourceKey<StructureProcessorList> {
        return ResourceKey.create(Registries.PROCESSOR_LIST, ResourceLocation(Subterrestrial.MOD_ID, name))
    }

    fun convertAll(input: Block, output: Block): ImmutableList<ProcessorRule> {
        val builder = ImmutableList.builder<ProcessorRule>()
        for (state in input.stateDefinition.possibleStates) {
            if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getValue(BlockStateProperties.WATERLOGGED)) continue
            if (state.hasProperty(BlockStateProperties.POWERED) && state.getValue(BlockStateProperties.POWERED)) continue
            if (state.hasProperty(BlockStateProperties.OPEN) && state.getValue(BlockStateProperties.OPEN)) continue

            var modified = output.defaultBlockState()
            for (entry in state.values.entries) {
                @Suppress("UNCHECKED_CAST")
                val key = entry.key as Property<Comparable<Any>>
                modified = modified.setValue(key, state.getValue(key))
            }
            builder.add(ProcessorRule(
                BlockStateMatchTest(state),
                AlwaysTrueTest.INSTANCE,
                modified))
        }
        return builder.build()
    }

    fun convertOneToAll(input: Block, output: Block, probability: Float): ImmutableList<ProcessorRule> {
        val builder = ImmutableList.builder<ProcessorRule>()
        for (state in output.stateDefinition.possibleStates) {
            if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getValue(BlockStateProperties.WATERLOGGED)) continue

            for (entry in state.values.entries) {
                @Suppress("UNCHECKED_CAST")
                val key = entry.key as Property<Comparable<Any>>
                state.setValue(key, state.getValue(key))
            }

            builder.add(ProcessorRule(
                RandomBlockMatchTest(input, probability),
                AlwaysTrueTest.INSTANCE,
                state))
        }
        return builder.build()
    }

    fun bootstrap(context: BootstapContext<StructureProcessorList>) {
        DeepslateCabinProcessors.bootstrap(context)
        DefaultCabinProcessors.bootstrap(context)
        DesertCabinProcessors.bootstrap(context)
        IceCabinProcessors.bootstrap(context)
        JungleCabinProcessors.bootstrap(context)
        MesaCabinProcessors.bootstrap(context)
        OceanCabinProcessors.bootstrap(context)
        TaigaCabinProcessors.bootstrap(context)
    }
}