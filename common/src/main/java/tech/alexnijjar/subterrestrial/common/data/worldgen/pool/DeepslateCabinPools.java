package tech.alexnijjar.subterrestrial.common.data.worldgen.pool;

import tech.alexnijjar.subterrestrial.common.data.worldgen.ModTemplatePoolProvider;
import tech.alexnijjar.subterrestrial.common.data.worldgen.processor.DeepslateCabinProcessors;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class DeepslateCabinPools {

    public static final ResourceKey<StructureTemplatePool> BASE = ModTemplatePoolProvider.createKey("cabin/deepslate/base");
    public static final ResourceKey<StructureTemplatePool> BOTTOM = ModTemplatePoolProvider.createKey("cabin/deepslate/bottom");
    public static final ResourceKey<StructureTemplatePool> TOP = ModTemplatePoolProvider.createKey("cabin/deepslate/top");

    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        HolderGetter<StructureProcessorList> holderGetter = context.lookup(Registries.PROCESSOR_LIST);
        HolderGetter<StructureTemplatePool> holderGetter2 = context.lookup(Registries.TEMPLATE_POOL);
        Holder.Reference<StructureTemplatePool> empty = holderGetter2.getOrThrow(Pools.EMPTY);

        Holder.Reference<StructureProcessorList> replace = holderGetter.getOrThrow(DeepslateCabinProcessors.REPLACE);
        Holder.Reference<StructureProcessorList> degradationReplace = holderGetter.getOrThrow(DeepslateCabinProcessors.DEGRADATION_REPLACE);

        context.register(BASE, ModTemplatePoolProvider.createBasePools("deepslate", empty, replace, degradationReplace, true));
        context.register(BOTTOM, ModTemplatePoolProvider.createBottomPools("default", empty, replace, degradationReplace));
        context.register(TOP, ModTemplatePoolProvider.createTopPools("default", empty, replace, degradationReplace));
    }
}
