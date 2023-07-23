package dev.alexnijjar.subterrestrial.common.data.worldgen.pool;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import dev.alexnijjar.subterrestrial.Subterrestrial;
import dev.alexnijjar.subterrestrial.common.data.worldgen.ModTemplatePoolProvider;
import dev.alexnijjar.subterrestrial.common.data.worldgen.processor.OceanCabinProcessors;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.function.Function;

public class OceanCabinPools {

    public static final ResourceKey<StructureTemplatePool> BASE = ModTemplatePoolProvider.createKey("cabin/ocean/base");
    public static final ResourceKey<StructureTemplatePool> BOTTOM = ModTemplatePoolProvider.createKey("cabin/ocean/bottom");

    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        HolderGetter<StructureProcessorList> holderGetter = context.lookup(Registries.PROCESSOR_LIST);
        HolderGetter<StructureTemplatePool> holderGetter2 = context.lookup(Registries.TEMPLATE_POOL);
        Holder.Reference<StructureTemplatePool> empty = holderGetter2.getOrThrow(Pools.EMPTY);

        Holder.Reference<StructureProcessorList> replace = holderGetter.getOrThrow(OceanCabinProcessors.REPLACE);
        Holder.Reference<StructureProcessorList> degradationReplace = holderGetter.getOrThrow(OceanCabinProcessors.DEGRADATION_REPLACE);


        ImmutableList.Builder<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> builder = ImmutableList.builder();
        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/base_lower_0", degradationReplace), 100));
        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/base_lower_0", replace), 5));

        context.register(BASE, new StructureTemplatePool(
            empty,
            builder.build(),
            StructureTemplatePool.Projection.RIGID));

        ImmutableList.Builder<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> builder1 = ImmutableList.builder();
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_0", degradationReplace), 100));
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_0", replace), 5));
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_1", degradationReplace), 100));
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_1", replace), 5));
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_2", degradationReplace), 100));
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_2", replace), 5));
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_3", degradationReplace), 100));
        builder1.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/ocean/bottom_3", replace), 5));

        context.register(BOTTOM, new StructureTemplatePool(
            empty,
            builder1.build(),
            StructureTemplatePool.Projection.RIGID));
    }
}
