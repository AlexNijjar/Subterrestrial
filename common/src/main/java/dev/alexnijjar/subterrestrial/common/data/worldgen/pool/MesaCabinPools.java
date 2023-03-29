package dev.alexnijjar.subterrestrial.common.data.worldgen.pool;

import dev.alexnijjar.subterrestrial.common.data.worldgen.ModTemplatePoolProvider;
import dev.alexnijjar.subterrestrial.common.data.worldgen.processor.MesaCabinProcessors;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class MesaCabinPools {

    public static final ResourceKey<StructureTemplatePool> BASE = ModTemplatePoolProvider.createKey("cabin/mesa/base");
    public static final ResourceKey<StructureTemplatePool> BOTTOM = ModTemplatePoolProvider.createKey("cabin/mesa/bottom");
    public static final ResourceKey<StructureTemplatePool> TOP = ModTemplatePoolProvider.createKey("cabin/mesa/top");

    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        HolderGetter<StructureProcessorList> holderGetter = context.lookup(Registries.PROCESSOR_LIST);
        HolderGetter<StructureTemplatePool> holderGetter2 = context.lookup(Registries.TEMPLATE_POOL);
        Holder.Reference<StructureTemplatePool> empty = holderGetter2.getOrThrow(Pools.EMPTY);

        Holder.Reference<StructureProcessorList> replace = holderGetter.getOrThrow(MesaCabinProcessors.REPLACE);
        Holder.Reference<StructureProcessorList> degradationReplace = holderGetter.getOrThrow(MesaCabinProcessors.DEGRADATION_REPLACE);

        context.register(BASE, ModTemplatePoolProvider.createBasePools("mesa", empty, replace, degradationReplace, false));
        context.register(BOTTOM, ModTemplatePoolProvider.createBottomPools("desert", empty, replace, degradationReplace));
        context.register(TOP, ModTemplatePoolProvider.createTopPools("desert", empty, replace, degradationReplace));
    }
}
