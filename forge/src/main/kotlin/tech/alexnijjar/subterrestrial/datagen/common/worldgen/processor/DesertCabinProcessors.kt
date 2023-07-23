package tech.alexnijjar.subterrestrial.datagen.common.worldgen.processor

import com.google.common.collect.ImmutableList
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.structure.templatesystem.*
import tech.alexnijjar.subterrestrial.datagen.provider.server.registry.ModProcessorListProvider

object DesertCabinProcessors {

    val REPLACE: ResourceKey<StructureProcessorList> = ModProcessorListProvider.createKey("cabin/desert/replace")
    val DEGRADATION_REPLACE: ResourceKey<StructureProcessorList> = ModProcessorListProvider.createKey("cabin/desert/degradation_replace")

    fun bootstrap(context: BootstapContext<StructureProcessorList>) {
        val replace = ImmutableList.builder<ProcessorRule>()

        replace.addAll(ModProcessorListProvider.convertAll(Blocks.LIME_WOOL, Blocks.SANDSTONE))
        context.register(REPLACE, StructureProcessorList(ImmutableList.of<StructureProcessor>(
            RuleProcessor(
                replace.build())
        )))

        val degradationReplace = ImmutableList.builder<ProcessorRule>()
        degradationReplace.addAll(ModProcessorListProvider.convertAll(Blocks.ANVIL, Blocks.DAMAGED_ANVIL))
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.SANDSTONE, Blocks.SANDSTONE_STAIRS, 0.025f))
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.SANDSTONE, Blocks.SANDSTONE_SLAB, 0.025f))

        context.register(DEGRADATION_REPLACE, StructureProcessorList(ImmutableList.of<StructureProcessor>(
            RuleProcessor(
                replace.build()
            ),
            RuleProcessor(degradationReplace.addAll(ImmutableList.of(
                ProcessorRule(
                    TagMatchTest(BlockTags.WOOL_CARPETS),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    BlockMatchTest(Blocks.IRON_BLOCK),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    BlockMatchTest(Blocks.TORCH),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                ProcessorRule(
                    BlockMatchTest(Blocks.WALL_TORCH),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                ProcessorRule(
                    BlockMatchTest(Blocks.LANTERN),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.BOOKSHELF, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.SANDSTONE_WALL, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.SANDSTONE, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.ACACIA_STAIRS, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.ACACIA_FENCE, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.SANDSTONE_SLAB, 0.4f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.SANDSTONE_STAIRS, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                )
            )).build())
        )))
    }
}
