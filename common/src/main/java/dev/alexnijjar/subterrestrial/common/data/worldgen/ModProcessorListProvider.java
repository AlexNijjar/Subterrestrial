package dev.alexnijjar.subterrestrial.common.data.worldgen;

import com.google.common.collect.ImmutableList;
import dev.alexnijjar.subterrestrial.Subterrestrial;
import dev.alexnijjar.subterrestrial.common.data.worldgen.processor.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

public class ModProcessorListProvider {

    public static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(Subterrestrial.MOD_ID, name));
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static ImmutableList<ProcessorRule> convertAll(Block input, Block output) {
        ImmutableList.Builder<ProcessorRule> builder = ImmutableList.builder();
        for (BlockState state : input.getStateDefinition().getPossibleStates()) {
            if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getValue(BlockStateProperties.WATERLOGGED)) {
                continue;
            }
            if (state.hasProperty(BlockStateProperties.POWERED) && state.getValue(BlockStateProperties.POWERED)) {
                continue;
            }
            if (state.hasProperty(BlockStateProperties.OPEN) && state.getValue(BlockStateProperties.OPEN)) {
                continue;
            }
            BlockState modified = output.defaultBlockState();
            for (var entry : state.getValues().entrySet()) {
                modified = modified.setValue((Property) entry.getKey(), state.getValue((Property) entry.getKey()));
            }

            builder.add(new ProcessorRule(
                    new BlockStateMatchTest(state),
                    AlwaysTrueTest.INSTANCE,
                    modified));
        }
        return builder.build();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static ImmutableList<ProcessorRule> convertOneToAll(Block input, Block output, float probability) {
        ImmutableList.Builder<ProcessorRule> builder = ImmutableList.builder();

        for (BlockState state : output.getStateDefinition().getPossibleStates()) {
            if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getValue(BlockStateProperties.WATERLOGGED)) {
                continue;
            }
            for (var entry : state.getValues().entrySet()) {
                state.setValue((Property) entry.getKey(), state.getValue((Property) entry.getKey()));
            }

            builder.add(new ProcessorRule(
                    new RandomBlockMatchTest(input, probability),
                    AlwaysTrueTest.INSTANCE,
                    state));
        }
        return builder.build();
    }

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        DeepslateCabinProcessors.bootstrap(context);
        DefaultCabinProcessors.bootstrap(context);
        DesertCabinProcessors.bootstrap(context);
        IceCabinProcessors.bootstrap(context);
        JungleCabinProcessors.bootstrap(context);
        MesaCabinProcessors.bootstrap(context);
        OceanCabinProcessors.bootstrap(context);
        TaigaCabinProcessors.bootstrap(context);
    }
}
