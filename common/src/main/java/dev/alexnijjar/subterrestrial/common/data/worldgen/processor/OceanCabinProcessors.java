package dev.alexnijjar.subterrestrial.common.data.worldgen.processor;

import com.google.common.collect.ImmutableList;
import dev.alexnijjar.subterrestrial.common.data.worldgen.ModProcessorListProvider;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

public class OceanCabinProcessors {

    public static final ResourceKey<StructureProcessorList> REPLACE = ModProcessorListProvider.createKey("cabin/ocean/replace");
    public static final ResourceKey<StructureProcessorList> DEGRADATION_REPLACE = ModProcessorListProvider.createKey("cabin/ocean/degradation_replace");

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        ImmutableList.Builder<ProcessorRule> replace = ImmutableList.builder();
        replace.addAll(ModProcessorListProvider.convertAll(Blocks.LIME_WOOL, Blocks.PRISMARINE));

        context.register(REPLACE, new StructureProcessorList(ImmutableList.of(
            new RuleProcessor(
                replace.build())
        )));

        ImmutableList.Builder<ProcessorRule> degradationReplace = ImmutableList.builder();
        degradationReplace.addAll(ModProcessorListProvider.convertAll(Blocks.ANVIL, Blocks.DAMAGED_ANVIL));
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.PRISMARINE_BRICKS, Blocks.PRISMARINE_STAIRS, 0.025f));
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.PRISMARINE_BRICKS, Blocks.PRISMARINE_SLAB, 0.025f));
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.DARK_PRISMARINE, Blocks.PRISMARINE_STAIRS, 0.015f));
        degradationReplace.addAll(ModProcessorListProvider.convertOneToAll(Blocks.DARK_PRISMARINE, Blocks.PRISMARINE_SLAB, 0.015f));

        context.register(DEGRADATION_REPLACE, new StructureProcessorList(ImmutableList.of(
            new RuleProcessor(
                replace.build()
            ),
            new RuleProcessor(degradationReplace.addAll(ImmutableList.of(
                new ProcessorRule(
                    new BlockMatchTest(Blocks.IRON_BLOCK),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.BOOKSHELF, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.COBWEB.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.OXIDIZED_CUT_COPPER, 0.33f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.WEATHERED_CUT_COPPER.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.OXIDIZED_COPPER, 0.33f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.WEATHERED_COPPER.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.PRISMARINE_BRICKS, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.PRISMARINE_BRICKS, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.PRISMARINE.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.DARK_PRISMARINE, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.AIR.defaultBlockState()
                ),
                new ProcessorRule(
                    new RandomBlockMatchTest(Blocks.DARK_PRISMARINE, 0.2f),
                    AlwaysTrueTest.INSTANCE,
                    Blocks.PRISMARINE.defaultBlockState()
                )
            )).build())
        )));
    }
}
