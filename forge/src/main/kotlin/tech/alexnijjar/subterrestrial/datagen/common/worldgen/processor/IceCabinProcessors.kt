package tech.alexnijjar.subterrestrial.datagen.common.worldgen.processor

import com.google.common.collect.ImmutableList
import net.minecraft.core.Direction
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.FenceBlock
import net.minecraft.world.level.block.RotatedPillarBlock
import net.minecraft.world.level.levelgen.structure.templatesystem.*
import tech.alexnijjar.subterrestrial.datagen.provider.server.registry.ModProcessorListProvider

object IceCabinProcessors {

    val REPLACE: ResourceKey<StructureProcessorList> = ModProcessorListProvider.createKey("cabin/ice/replace")
    val DEGRADATION_REPLACE: ResourceKey<StructureProcessorList> = ModProcessorListProvider.createKey("cabin/ice/degradation_replace")

    fun bootstrap(context: BootstapContext<StructureProcessorList>) {
        val replace = ImmutableList.builder<ProcessorRule>()
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.LIME_WOOL, Blocks.PACKED_ICE))

        replace.addAll(ImmutableList.of(
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_LOG, 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.POWDER_SNOW.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_LOG, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SNOW_BLOCK.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_LOG, 0.25f),
                AlwaysTrueTest.INSTANCE,
                Blocks.BLUE_ICE.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_LOG, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.PACKED_ICE.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_LOG, 0.05f),
                AlwaysTrueTest.INSTANCE,
                Blocks.ICE.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.STRIPPED_SPRUCE_LOG, 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.POWDER_SNOW.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.STRIPPED_SPRUCE_LOG, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SNOW_BLOCK.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.STRIPPED_SPRUCE_LOG, 0.25f),
                AlwaysTrueTest.INSTANCE,
                Blocks.BLUE_ICE.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.STRIPPED_SPRUCE_LOG, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.PACKED_ICE.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.STRIPPED_SPRUCE_LOG, 0.05f),
                AlwaysTrueTest.INSTANCE,
                Blocks.ICE.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_PLANKS, 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.POWDER_SNOW.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_PLANKS, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SNOW_BLOCK.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_PLANKS, 0.25f),
                AlwaysTrueTest.INSTANCE,
                Blocks.BLUE_ICE.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_PLANKS, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.PACKED_ICE.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_PLANKS, 0.05f),
                AlwaysTrueTest.INSTANCE,
                Blocks.ICE.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_SLAB, 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.POWDER_SNOW.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_SLAB, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SNOW_BLOCK.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_SLAB, 0.25f),
                AlwaysTrueTest.INSTANCE,
                Blocks.BLUE_ICE.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_SLAB, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.PACKED_ICE.defaultBlockState()
            ),
            ProcessorRule(
                RandomBlockMatchTest(Blocks.SPRUCE_SLAB, 0.05f),
                AlwaysTrueTest.INSTANCE,
                Blocks.ICE.defaultBlockState()
            )
        ))

        context.register(REPLACE, StructureProcessorList(ImmutableList.of<StructureProcessor>(
            RuleProcessor(
                replace.build()
            )
        )))

        val degradationReplace = ImmutableList.builder<ProcessorRule>()
        degradationReplace.addAll(ModProcessorListProvider.convertAll(Blocks.ANVIL, Blocks.DAMAGED_ANVIL))
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_STAIRS, 0.025f))
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_SLAB, 0.025f))

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
                    RandomBlockStateMatchTest(Blocks.SPRUCE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.SPRUCE_FENCE.defaultBlockState().setValue(FenceBlock.NORTH, true).setValue(FenceBlock.SOUTH, true)
                ),
                ProcessorRule(
                    RandomBlockStateMatchTest(Blocks.SPRUCE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.SPRUCE_FENCE.defaultBlockState().setValue(FenceBlock.EAST, true).setValue(FenceBlock.WEST, true)
                ),
                ProcessorRule(
                    RandomBlockStateMatchTest(Blocks.STRIPPED_SPRUCE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.SPRUCE_FENCE.defaultBlockState().setValue(FenceBlock.NORTH, true).setValue(FenceBlock.SOUTH, true)
                ),
                ProcessorRule(
                    RandomBlockStateMatchTest(Blocks.STRIPPED_SPRUCE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.SPRUCE_FENCE.defaultBlockState().setValue(FenceBlock.EAST, true).setValue(FenceBlock.WEST, true)
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.BOOKSHELF, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.SPRUCE_LOG, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.STRIPPED_SPRUCE_LOG, 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.SPRUCE_FENCE, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.SPRUCE_STAIRS, 0.05f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.SPRUCE_SLAB, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.SPRUCE_PLANKS, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.PACKED_ICE, 0.15f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                ProcessorRule(
                    RandomBlockMatchTest(Blocks.SNOW_BLOCK, 0.15f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                )
            )).build())
        )))
    }
}
