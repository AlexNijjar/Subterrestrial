package dev.alexnijjar.subterrestrial.common.data.worldgen.processor;

import com.google.common.collect.ImmutableList;
import dev.alexnijjar.subterrestrial.common.data.worldgen.ModProcessorListProvider;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

public class DeepslateCabinProcessors {

    public static final ResourceKey<StructureProcessorList> REPLACE = ModProcessorListProvider.createKey("cabin/deepslate/replace");
    public static final ResourceKey<StructureProcessorList> DEGRADATION_REPLACE = ModProcessorListProvider.createKey("cabin/deepslate/degradation_replace");

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        ImmutableList.Builder<ProcessorRule> replace = ImmutableList.builder();
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.LIME_WOOL, Blocks.DARK_OAK_PLANKS));
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.COBBLESTONE, Blocks.COBBLED_DEEPSLATE));
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.STONE_BRICKS, Blocks.DEEPSLATE_BRICKS));
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.OAK_PLANKS, Blocks.DARK_OAK_PLANKS));
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.OAK_LOG, Blocks.DARK_OAK_LOG));
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG));
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.OAK_SLAB, Blocks.DARK_OAK_SLAB));
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.OAK_STAIRS, Blocks.DARK_OAK_STAIRS));
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.OAK_DOOR, Blocks.DARK_OAK_DOOR));
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.OAK_FENCE, Blocks.DARK_OAK_FENCE));
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.COBBLESTONE_WALL, Blocks.COBBLED_DEEPSLATE_WALL));

        context.register(REPLACE, new StructureProcessorList(ImmutableList.of(
            new RuleProcessor(
                replace.build())
        )));

        ImmutableList.Builder<ProcessorRule> degradationReplace = ImmutableList.builder();
        degradationReplace.addAll(ModProcessorListProvider.convertAll(Blocks.ANVIL, Blocks.DAMAGED_ANVIL));
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_STAIRS, 0.025f));
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_SLAB, 0.025f));

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
                    new RandomBlockStateMatchTest(Blocks.DARK_OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.DARK_OAK_FENCE.defaultBlockState().setValue(FenceBlock.NORTH, true).setValue(FenceBlock.SOUTH, true)
                ),
                new ProcessorRule(
                    new RandomBlockStateMatchTest(Blocks.DARK_OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.DARK_OAK_FENCE.defaultBlockState().setValue(FenceBlock.EAST, true).setValue(FenceBlock.WEST, true)
                ),
                new ProcessorRule(
                    new RandomBlockStateMatchTest(Blocks.STRIPPED_DARK_OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.DARK_OAK_FENCE.defaultBlockState().setValue(FenceBlock.NORTH, true).setValue(FenceBlock.SOUTH, true)
                ),
                new ProcessorRule(
                    new RandomBlockStateMatchTest(Blocks.STRIPPED_DARK_OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.DARK_OAK_FENCE.defaultBlockState().setValue(FenceBlock.EAST, true).setValue(FenceBlock.WEST, true)
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.BOOKSHELF, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.DEEPSLATE_BRICKS, 0.5f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.CRACKED_DEEPSLATE_BRICKS.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.DARK_OAK_LOG, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.STRIPPED_DARK_OAK_LOG, 0.1f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.DARK_OAK_FENCE, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.DARK_OAK_STAIRS, 0.05f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.DARK_OAK_SLAB, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.DARK_OAK_PLANKS, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.COBBLED_DEEPSLATE_WALL, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.COBBLED_DEEPSLATE, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                )
            )).build())
        )));
    }
}
