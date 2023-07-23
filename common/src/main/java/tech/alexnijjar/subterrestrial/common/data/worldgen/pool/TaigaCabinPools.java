package tech.alexnijjar.subterrestrial.common.data.worldgen.pool;

import tech.alexnijjar.subterrestrial.common.data.worldgen.ModTemplatePoolProvider;
import tech.alexnijjar.subterrestrial.common.data.worldgen.processor.TaigaCabinProcessors;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class TaigaCabinPools {

    public static final ResourceKey<StructureTemplatePool> BASE = ModTemplatePoolProvider.createKey("cabin/taiga/base");
    public static final ResourceKey<StructureTemplatePool> BOTTOM = ModTemplatePoolProvider.createKey("cabin/taiga/bottom");
    public static final ResourceKey<StructureTemplatePool> TOP = ModTemplatePoolProvider.createKey("cabin/taiga/top");

    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        HolderGetter<StructureProcessorList> holderGetter = context.lookup(Registries.PROCESSOR_LIST);
        HolderGetter<StructureTemplatePool> holderGetter2 = context.lookup(Registries.TEMPLATE_POOL);
        Holder.Reference<StructureTemplatePool> empty = holderGetter2.getOrThrow(Pools.EMPTY);

        Holder.Reference<StructureProcessorList> replace = holderGetter.getOrThrow(TaigaCabinProcessors.REPLACE);
        Holder.Reference<StructureProcessorList> degradationReplace = holderGetter.getOrThrow(TaigaCabinProcessors.DEGRADATION_REPLACE);

        context.register(BASE, ModTemplatePoolProvider.createBasePools("taiga", empty, replace, degradationReplace, false));
        context.register(BOTTOM, ModTemplatePoolProvider.createBottomPools("taiga", empty, replace, degradationReplace));
        context.register(TOP, ModTemplatePoolProvider.createTopPools("taiga", empty, replace, degradationReplace));
    }
}
