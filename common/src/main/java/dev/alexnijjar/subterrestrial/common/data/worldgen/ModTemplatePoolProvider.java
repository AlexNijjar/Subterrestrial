package dev.alexnijjar.subterrestrial.common.data.worldgen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import dev.alexnijjar.subterrestrial.Subterrestrial;
import dev.alexnijjar.subterrestrial.common.data.worldgen.pool.*;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.function.Function;

public class ModTemplatePoolProvider {

    public static ResourceKey<StructureTemplatePool> createKey(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(Subterrestrial.MOD_ID, name));
    }

    public static StructureTemplatePool createBasePools(String name, Holder.Reference<StructureTemplatePool> empty, Holder.Reference<StructureProcessorList> replace, Holder.Reference<StructureProcessorList> degradation, boolean hasVariant) {
        ImmutableList.Builder<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> builder = ImmutableList.builder();

        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/base_lower_0", degradation), 100));
        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/base_0", degradation), 100));
        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/base_upper_0", degradation), 100));
        if (hasVariant) {
            builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/base_lower_1", degradation), 100));
            builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/base_1", degradation), 100));
            builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/base_upper_1", degradation), 100));
        }

        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/base_lower_0", replace), 5));
        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/base_0", replace), 5));
        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/base_upper_0", replace), 5));
        if (hasVariant) {
            builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/base_lower_1", replace), 5));
            builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/base_1", replace), 5));
            builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/base_upper_1", replace), 5));
        }

        return new StructureTemplatePool(
                empty,
                builder.build(),
                StructureTemplatePool.Projection.RIGID);
    }

    public static StructureTemplatePool createBottomTopPools(String name, Holder.Reference<StructureTemplatePool> empty, Holder.Reference<StructureProcessorList> replace, Holder.Reference<StructureProcessorList> degradation, String append) {
        ImmutableList.Builder<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> builder = ImmutableList.builder();

        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/" + append + "_0", degradation), 100));
        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/" + append + "_1", degradation), 100));
        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/" + append + "_2", degradation), 100));
        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/" + append + "_3", degradation), 100));

        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/" + append + "_0", replace), 5));
        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/" + append + "_1", replace), 5));
        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/" + append + "_2", replace), 5));
        builder.add(Pair.of(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/" + name + "/" + append + "_3", replace), 5));

        return new StructureTemplatePool(
                empty,
                builder.build(),
                StructureTemplatePool.Projection.RIGID);
    }

    public static StructureTemplatePool createBottomPools(String name, Holder.Reference<StructureTemplatePool> empty, Holder.Reference<StructureProcessorList> replace, Holder.Reference<StructureProcessorList> degradation) {
        return createBottomTopPools(name, empty, replace, degradation, "bottom");
    }

    public static StructureTemplatePool createTopPools(String name, Holder.Reference<StructureTemplatePool> empty, Holder.Reference<StructureProcessorList> replace, Holder.Reference<StructureProcessorList> degradation) {
        return createBottomTopPools(name, empty, replace, degradation, "top");
    }

    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        DeepslateCabinPools.bootstrap(context);
        DefaultCabinPools.bootstrap(context);
        DesertCabinPools.bootstrap(context);
        IceCabinPools.bootstrap(context);
        JungleCabinPools.bootstrap(context);
        MesaCabinPools.bootstrap(context);
        OceanCabinPools.bootstrap(context);
        TaigaCabinPools.bootstrap(context);
    }
}
