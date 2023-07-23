package dev.alexnijjar.subterrestrial.common.data.worldgen.processor;

import com.google.common.collect.ImmutableList;
import dev.alexnijjar.subterrestrial.common.data.worldgen.ModProcessorListProvider;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

public class DesertCabinProcessors {

    public static final ResourceKey<StructureProcessorList> REPLACE = ModProcessorListProvider.createKey("cabin/desert/replace");
    public static final ResourceKey<StructureProcessorList> DEGRADATION_REPLACE = ModProcessorListProvider.createKey("cabin/desert/degradation_replace");

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        ImmutableList.Builder<ProcessorRule> replace = ImmutableList.builder();
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.LIME_WOOL, Blocks.SANDSTONE));

        context.register(REPLACE, new StructureProcessorList(ImmutableList.of(
            new RuleProcessor(
                replace.build())
        )));

        ImmutableList.Builder<ProcessorRule> degradationReplace = ImmutableList.builder();
        degradationReplace.addAll(ModProcessorListProvider.convertAll(Blocks.ANVIL, Blocks.DAMAGED_ANVIL));
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.SANDSTONE, Blocks.SANDSTONE_STAIRS, 0.025f));
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.SANDSTONE, Blocks.SANDSTONE_SLAB, 0.025f));

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
                    new RandomBlockMatchTest(Blocks.BOOKSHELF, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.SANDSTONE_WALL, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.SANDSTONE, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.ACACIA_STAIRS, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.ACACIA_FENCE, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.SANDSTONE_SLAB, 0.4f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.SANDSTONE_STAIRS, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                )
            )).build())
        )));
    }
}
