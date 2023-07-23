package tech.alexnijjar.subterrestrial.common.data.worldgen.processor;

import com.google.common.collect.ImmutableList;
import tech.alexnijjar.subterrestrial.common.data.worldgen.ModProcessorListProvider;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

public class IceCabinProcessors {

    public static final ResourceKey<StructureProcessorList> REPLACE = ModProcessorListProvider.createKey("cabin/ice/replace");
    public static final ResourceKey<StructureProcessorList> DEGRADATION_REPLACE = ModProcessorListProvider.createKey("cabin/ice/degradation_replace");

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        ImmutableList.Builder<ProcessorRule> replace = ImmutableList.builder();
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.LIME_WOOL, Blocks.PACKED_ICE));
        replace.addAll(ImmutableList.of(
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_LOG, 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.POWDER_SNOW.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_LOG, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SNOW_BLOCK.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_LOG, 0.25f),
                AlwaysTrueTest.INSTANCE,
                Blocks.BLUE_ICE.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_LOG, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.PACKED_ICE.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_LOG, 0.05f),
                AlwaysTrueTest.INSTANCE,
                Blocks.ICE.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.STRIPPED_SPRUCE_LOG, 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.POWDER_SNOW.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.STRIPPED_SPRUCE_LOG, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SNOW_BLOCK.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.STRIPPED_SPRUCE_LOG, 0.25f),
                AlwaysTrueTest.INSTANCE,
                Blocks.BLUE_ICE.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.STRIPPED_SPRUCE_LOG, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.PACKED_ICE.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.STRIPPED_SPRUCE_LOG, 0.05f),
                AlwaysTrueTest.INSTANCE,
                Blocks.ICE.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_PLANKS, 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.POWDER_SNOW.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_PLANKS, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SNOW_BLOCK.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_PLANKS, 0.25f),
                AlwaysTrueTest.INSTANCE,
                Blocks.BLUE_ICE.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_PLANKS, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.PACKED_ICE.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_PLANKS, 0.05f),
                AlwaysTrueTest.INSTANCE,
                Blocks.ICE.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_SLAB, 0.025f),
                AlwaysTrueTest.INSTANCE,
                Blocks.POWDER_SNOW.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_SLAB, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.SNOW_BLOCK.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_SLAB, 0.25f),
                AlwaysTrueTest.INSTANCE,
                Blocks.BLUE_ICE.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_SLAB, 0.35f),
                AlwaysTrueTest.INSTANCE,
                Blocks.PACKED_ICE.defaultBlockState()
            ),
            new ProcessorRule(
                new RandomBlockMatchTest(Blocks.SPRUCE_SLAB, 0.05f),
                AlwaysTrueTest.INSTANCE,
                Blocks.ICE.defaultBlockState()
            )
        ));

        context.register(REPLACE, new StructureProcessorList(ImmutableList.of(
            new RuleProcessor(
                replace.build()
            )
        )));

        ImmutableList.Builder<ProcessorRule> degradationReplace = ImmutableList.builder();
        degradationReplace.addAll(ModProcessorListProvider.convertAll(Blocks.ANVIL, Blocks.DAMAGED_ANVIL));
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_STAIRS, 0.025f));
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_SLAB, 0.025f));

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
                    new RandomBlockStateMatchTest(Blocks.SPRUCE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.SPRUCE_FENCE.defaultBlockState().setValue(FenceBlock.NORTH, true).setValue(FenceBlock.SOUTH, true)
                ),
                new ProcessorRule(
                    new RandomBlockStateMatchTest(Blocks.SPRUCE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.SPRUCE_FENCE.defaultBlockState().setValue(FenceBlock.EAST, true).setValue(FenceBlock.WEST, true)
                ),
                new ProcessorRule(
                    new RandomBlockStateMatchTest(Blocks.STRIPPED_SPRUCE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.SPRUCE_FENCE.defaultBlockState().setValue(FenceBlock.NORTH, true).setValue(FenceBlock.SOUTH, true)
                ),
                new ProcessorRule(
                    new RandomBlockStateMatchTest(Blocks.STRIPPED_SPRUCE_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.SPRUCE_FENCE.defaultBlockState().setValue(FenceBlock.EAST, true).setValue(FenceBlock.WEST, true)
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.BOOKSHELF, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.SPRUCE_LOG, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.STRIPPED_SPRUCE_LOG, 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.SPRUCE_FENCE, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.SPRUCE_STAIRS, 0.05f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.SPRUCE_SLAB, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.SPRUCE_PLANKS, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.PACKED_ICE, 0.15f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.SNOW_BLOCK, 0.15f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                )
            )).build())
        )));
    }
}
