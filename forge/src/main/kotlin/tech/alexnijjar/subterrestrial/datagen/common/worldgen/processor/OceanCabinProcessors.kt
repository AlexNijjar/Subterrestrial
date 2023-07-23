package tech.alexnijjar.subterrestrial.datagen.common.worldgen.processor

import com.google.common.collect.ImmutableList
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.structure.templatesystem.*
import tech.alexnijjar.subterrestrial.datagen.provider.server.registry.ModProcessorListProvider

object OceanCabinProcessors {

    val REPLACE: ResourceKey<StructureProcessorList> = ModProcessorListProvider.createKey("cabin/ocean/replace")
    val DEGRADATION_REPLACE: ResourceKey<StructureProcessorList> = ModProcessorListProvider.createKey("cabin/ocean/degradation_replace")

    fun bootstrap(context: BootstapContext<StructureProcessorList>) {
        val replace = ImmutableList.builder<ProcessorRule>()
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.LIME_WOOL, Blocks.PRISMARINE))
        context.register(REPLACE, StructureProcessorList(ImmutableList.of<StructureProcessor>(
            RuleProcessor(
                replace.build())
        )))
        val degradationReplace = ImmutableList.builder<ProcessorRule>()
        degradationReplace.addAll(ModProcessorListProvider.convertAll(Blocks.ANVIL, Blocks.DAMAGED_ANVIL))
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.PRISMARINE_BRICKS, Blocks.PRISMARINE_STAIRS, 0.025f))
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.PRISMARINE_BRICKS, Blocks.PRISMARINE_SLAB, 0.025f))
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.DARK_PRISMARINE, Blocks.PRISMARINE_STAIRS, 0.015f))
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.DARK_PRISMARINE, Blocks.PRISMARINE_SLAB, 0.015f))
        context.register(DEGRADATION_REPLACE, StructureProcessorList(ImmutableList.of<StructureProcessor>(
            RuleProcessor(
                replace.build()
            ),
            RuleProcessor(degradationReplace.addAll(ImmutableList.of(
                ProcessorRule(
                    BlockMatchTest(Blocks.IRON_BLOCK),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.BOOKSHELF, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.OXIDIZED_CUT_COPPER, 0.33f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.WEATHERED_CUT_COPPER.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.OXIDIZED_COPPER, 0.33f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.WEATHERED_COPPER.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.PRISMARINE_BRICKS, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.PRISMARINE_BRICKS, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.PRISMARINE.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.DARK_PRISMARINE, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.DARK_PRISMARINE, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.PRISMARINE.defaultBlockState()
                )
            )).build())
        )))
    }
}
