package tech.alexnijjar.subterrestrial.datagen.common.worldgen.processor

import com.google.common.collect.ImmutableList
import net.minecraft.core.Direction
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.state.properties.BambooLeaves
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf
import net.minecraft.world.level.levelgen.structure.templatesystem.*
import tech.alexnijjar.subterrestrial.datagen.provider.server.registry.ModProcessorListProvider

object JungleCabinProcessors {

    val REPLACE: ResourceKey<StructureProcessorList> = ModProcessorListProvider.createKey("cabin/jungle/replace")
    val DEGRADATION_REPLACE: ResourceKey<StructureProcessorList> = ModProcessorListProvider.createKey("cabin/jungle/degradation_replace")

    fun bootstrap(context: BootstapContext<StructureProcessorList>) {
        val replace = ImmutableList.builder<ProcessorRule>()
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.LIME_WOOL, Blocks.JUNGLE_PLANKS))

        replace.addAll(ImmutableList.of(
            ProcessorRule(
                BlockMatchTest(Blocks.GLOW_LICHEN),
                AlwaysTrueTest.INSTANCE,
                Blocks.AIR.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.GRASS_BLOCK, 0.1f),
                AlwaysTrueTest.INSTANCE,
                Blocks.MOSS_BLOCK.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.JUNGLE_LOG, 0.2f),
                AlwaysTrueTest.INSTANCE,
                Blocks.MOSS_BLOCK.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.STRIPPED_JUNGLE_LOG, 0.2f),
                AlwaysTrueTest.INSTANCE,
                Blocks.MOSS_BLOCK.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.JUNGLE_SLAB, 0.2f),
                AlwaysTrueTest.INSTANCE,
                Blocks.MOSS_BLOCK.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.1f),
                AlwaysTrueTest.INSTANCE,
                Blocks.GRASS.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.25f),
                AlwaysTrueTest.INSTANCE,
                Blocks.BAMBOO.defaultBlockState().setValue(BambooStalkBlock.LEAVES, BambooLeaves.LARGE)
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.1f),
                AlwaysTrueTest.INSTANCE,
                Blocks.BIG_DRIPLEAF.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.08f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.HALF, DoubleBlockHalf.UPPER).setValue(SmallDripleafBlock.FACING, Direction.NORTH)
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.8f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.HALF, DoubleBlockHalf.UPPER).setValue(SmallDripleafBlock.FACING, Direction.EAST)
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.08f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.HALF, DoubleBlockHalf.UPPER).setValue(SmallDripleafBlock.FACING, Direction.SOUTH)
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.08f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.HALF, DoubleBlockHalf.UPPER).setValue(SmallDripleafBlock.FACING, Direction.WEST)
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.075f),
                AlwaysTrueTest.INSTANCE,
                Blocks.AZALEA.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.075f),
                AlwaysTrueTest.INSTANCE,
                Blocks.FLOWERING_AZALEA.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.NORTH, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.AGE, 2).setValue(CocoaBlock.FACING, Direction.NORTH)
            ),
            ProcessorRule(
                RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.EAST, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.AGE, 2).setValue(CocoaBlock.FACING, Direction.EAST)
            ),
            ProcessorRule(
                RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.SOUTH, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.AGE, 2).setValue(CocoaBlock.FACING, Direction.SOUTH)
            ),
            ProcessorRule(
                RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.WEST, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.AGE, 2).setValue(CocoaBlock.FACING, Direction.WEST)
            ),
            ProcessorRule(
                RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.NORTH, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.FACING, Direction.NORTH)
            ),
            ProcessorRule(
                RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.EAST, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.FACING, Direction.EAST)
            ),
            ProcessorRule(
                RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.SOUTH, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.FACING, Direction.SOUTH)
            ),
            ProcessorRule(
                RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.WEST, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.FACING, Direction.WEST)
            )
        ))

        context.register(REPLACE, StructureProcessorList(ImmutableList.of<StructureProcessor>(
            RuleProcessor(
                replace.build())
        )))

        val degradationReplace = ImmutableList.builder<ProcessorRule>()
        degradationReplace.addAll(ModProcessorListProvider.convertAll(Blocks.ANVIL, Blocks.DAMAGED_ANVIL))
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_STAIRS, 0.025f))
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_SLAB, 0.025f))

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
                    RandomBlockStateMatchTest(Blocks.JUNGLE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.JUNGLE_FENCE.defaultBlockState().setValue(FenceBlock.NORTH, true).setValue(FenceBlock.SOUTH, true)
                ),
                ProcessorRule(
                    RandomBlockStateMatchTest(Blocks.JUNGLE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.JUNGLE_FENCE.defaultBlockState().setValue(FenceBlock.EAST, true).setValue(FenceBlock.WEST, true)
                ),
                ProcessorRule(
                    RandomBlockStateMatchTest(Blocks.STRIPPED_JUNGLE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.JUNGLE_FENCE.defaultBlockState().setValue(FenceBlock.NORTH, true).setValue(FenceBlock.SOUTH, true)
                ),
                ProcessorRule(
                    RandomBlockStateMatchTest(Blocks.STRIPPED_JUNGLE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.JUNGLE_FENCE.defaultBlockState().setValue(FenceBlock.EAST, true).setValue(FenceBlock.WEST, true)
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.BOOKSHELF, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.JUNGLE_LOG, 0.05f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.STRIPPED_JUNGLE_LOG, 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.JUNGLE_FENCE, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.JUNGLE_STAIRS, 0.05f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.JUNGLE_SLAB, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.JUNGLE_PLANKS, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                )
            )).build())
        )))
    }
}
