package tech.alexnijjar.subterrestrial.common.data.worldgen.processor;

import com.google.common.collect.ImmutableList;
import tech.alexnijjar.subterrestrial.common.data.worldgen.ModProcessorListProvider;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

public class JungleCabinProcessors {

    public static final ResourceKey<StructureProcessorList> REPLACE = ModProcessorListProvider.createKey("cabin/jungle/replace");
    public static final ResourceKey<StructureProcessorList> DEGRADATION_REPLACE = ModProcessorListProvider.createKey("cabin/jungle/degradation_replace");

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        ImmutableList.Builder<ProcessorRule> replace = ImmutableList.builder();
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.LIME_WOOL, Blocks.JUNGLE_PLANKS));
//        replace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.VINE, Blocks.GLOW_LICHEN, 0.05f));
        replace.addAll(ImmutableList.of(
            new ProcessorRule(
                new BlockMatchTest(Blocks.GLOW_LICHEN),
                AlwaysTrueTest.INSTANCE,
                Blocks.AIR.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.GRASS_BLOCK, 0.1f),
                AlwaysTrueTest.INSTANCE,
                Blocks.MOSS_BLOCK.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.JUNGLE_LOG, 0.2f),
                AlwaysTrueTest.INSTANCE,
                Blocks.MOSS_BLOCK.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.STRIPPED_JUNGLE_LOG, 0.2f),
                AlwaysTrueTest.INSTANCE,
                Blocks.MOSS_BLOCK.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.JUNGLE_SLAB, 0.2f),
                AlwaysTrueTest.INSTANCE,
                Blocks.MOSS_BLOCK.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.1f),
                AlwaysTrueTest.INSTANCE,
                Blocks.GRASS.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.25f),
                AlwaysTrueTest.INSTANCE,
                Blocks.BAMBOO.defaultBlockState().setValue(BambooStalkBlock.LEAVES, BambooLeaves.LARGE)
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.1f),
                AlwaysTrueTest.INSTANCE,
                Blocks.BIG_DRIPLEAF.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.08f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.HALF, DoubleBlockHalf.UPPER).setValue(SmallDripleafBlock.FACING, Direction.NORTH)
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.8f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.HALF, DoubleBlockHalf.UPPER).setValue(SmallDripleafBlock.FACING, Direction.EAST)
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.08f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.HALF, DoubleBlockHalf.UPPER).setValue(SmallDripleafBlock.FACING, Direction.SOUTH)
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.08f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.HALF, DoubleBlockHalf.UPPER).setValue(SmallDripleafBlock.FACING, Direction.WEST)
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.075f),
                AlwaysTrueTest.INSTANCE,
                Blocks.AZALEA.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.MOSS_CARPET, 0.075f),
                AlwaysTrueTest.INSTANCE,
                Blocks.FLOWERING_AZALEA.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.NORTH, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.AGE, 2).setValue(CocoaBlock.FACING, Direction.NORTH)
            ),
            new ProcessorRule(
                new RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.EAST, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.AGE, 2).setValue(CocoaBlock.FACING, Direction.EAST)
            ),
            new ProcessorRule(
                new RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.SOUTH, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.AGE, 2).setValue(CocoaBlock.FACING, Direction.SOUTH)
            ),
            new ProcessorRule(
                new RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.WEST, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.AGE, 2).setValue(CocoaBlock.FACING, Direction.WEST)
            ),
            new ProcessorRule(
                new RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.NORTH, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.FACING, Direction.NORTH)
            ),
            new ProcessorRule(
                new RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.EAST, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.FACING, Direction.EAST)
            ),
            new ProcessorRule(
                new RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.SOUTH, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.FACING, Direction.SOUTH)
            ),
            new ProcessorRule(
                new RandomBlockStateMatchTest(Blocks.VINE.defaultBlockState().setValue(VineBlock.WEST, true), 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.FACING, Direction.WEST)
            )
        ));

        context.register(REPLACE, new StructureProcessorList(ImmutableList.of(
            new RuleProcessor(
                replace.build())
        )));

        ImmutableList.Builder<ProcessorRule> degradationReplace = ImmutableList.builder();
        degradationReplace.addAll(ModProcessorListProvider.convertAll(Blocks.ANVIL, Blocks.DAMAGED_ANVIL));
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_STAIRS, 0.025f));
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_SLAB, 0.025f));

        context.register(DEGRADATION_REPLACE, new StructureProcessorList(ImmutableList.of(
            new RuleProcessor(
                replace.build()
            ),
            new RuleProcessor(degradationReplace.addAll(ImmutableList.of(
                new ProcessorRule(
                    new TagMatchTest(BlockTags.WOOL_CARPETS),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new BlockMatchTest(Blocks.IRON_BLOCK),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new BlockMatchTest(Blocks.TORCH),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                new ProcessorRule(
                    new BlockMatchTest(Blocks.WALL_TORCH),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                new ProcessorRule(
                    new BlockMatchTest(Blocks.LANTERN),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockStateMatchTest(Blocks.JUNGLE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.JUNGLE_FENCE.defaultBlockState().setValue(FenceBlock.NORTH, true).setValue(FenceBlock.SOUTH, true)
                ),
                new ProcessorRule(
                    new RandomBlockStateMatchTest(Blocks.JUNGLE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.JUNGLE_FENCE.defaultBlockState().setValue(FenceBlock.EAST, true).setValue(FenceBlock.WEST, true)
                ),
                new ProcessorRule(
                    new RandomBlockStateMatchTest(Blocks.STRIPPED_JUNGLE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.JUNGLE_FENCE.defaultBlockState().setValue(FenceBlock.NORTH, true).setValue(FenceBlock.SOUTH, true)
                ),
                new ProcessorRule(
                    new RandomBlockStateMatchTest(Blocks.STRIPPED_JUNGLE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.JUNGLE_FENCE.defaultBlockState().setValue(FenceBlock.EAST, true).setValue(FenceBlock.WEST, true)
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.BOOKSHELF, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.JUNGLE_LOG, 0.05f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.STRIPPED_JUNGLE_LOG, 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.JUNGLE_FENCE, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.JUNGLE_STAIRS, 0.05f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.JUNGLE_SLAB, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.JUNGLE_PLANKS, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                )
            )).build())
        )));
    }
}
