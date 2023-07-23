package tech.alexnijjar.subterrestrial.datagen.provider.server.registry

import com.google.common.collect.ImmutableList
import com.mojang.datafixers.util.Pair
import net.minecraft.core.Holder
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList
import tech.alexnijjar.subterrestrial.Subterrestrial
import tech.alexnijjar.subterrestrial.datagen.common.worldgen.pool.*
import java.util.function.Function

object ModTemplatePoolProvider {

    fun createKey(name: String): ResourceKey<StructureTemplatePool> {
        return ResourceKey.create(Registries.TEMPLATE_POOL, ResourceLocation(Subterrestrial.MOD_ID, name))
    }

    fun createBasePools(name: String, empty: Holder.Reference<StructureTemplatePool>, replace: Holder.Reference<StructureProcessorList>, degradation: Holder.Reference<StructureProcessorList>, hasVariant: Boolean): StructureTemplatePool {
        val builder = ImmutableList.Builder<Pair<Function<StructureTemplatePool.Projection, out StructurePoolElement>, Int>>()

        builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/base_lower_0", degradation), 100))
        builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/base_0", degradation), 100))
        builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/base_upper_0", degradation), 100))

        if (hasVariant) {
            builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/base_lower_1", degradation), 100))
            builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/base_1", degradation), 100))
            builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/base_upper_1", degradation), 100))
        }

        builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/base_lower_0", replace), 5))
        builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/base_0", replace), 5))
        builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/base_upper_0", replace), 5))

        if (hasVariant) {
            builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/base_lower_1", replace), 5))
            builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/base_1", replace), 5))
            builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/base_upper_1", replace), 5))
        }

        return StructureTemplatePool(empty, builder.build(), StructureTemplatePool.Projection.RIGID)
    }

    private fun createBottomTopPools(name: String, empty: Holder.Reference<StructureTemplatePool>, replace: Holder.Reference<StructureProcessorList>, degradation: Holder.Reference<StructureProcessorList>, append: String): StructureTemplatePool {
        val builder = ImmutableList.Builder<Pair<Function<StructureTemplatePool.Projection, out StructurePoolElement>, Int>>()

        builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/${append}_0", degradation), 100))
        builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/${append}_1", degradation), 100))
        builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/${append}_2", degradation), 100))
        builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/${append}_3", degradation), 100))

        builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/${append}_0", replace), 5))
        builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/${append}_1", replace), 5))
        builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/${append}_2", replace), 5))
        builder.add(Pair.of(StructurePoolElement.single("${Subterrestrial.MOD_ID}:cabin/$name/${append}_3", replace), 5))

        return StructureTemplatePool(
            empty,
            builder.build(),
            StructureTemplatePool.Projection.RIGID)
    }

    fun createBottomPools(name: String, empty: Holder.Reference<StructureTemplatePool>, replace: Holder.Reference<StructureProcessorList>, degradation: Holder.Reference<StructureProcessorList>): StructureTemplatePool {
        return createBottomTopPools(name, empty, replace, degradation, "bottom")
    }

    fun createTopPools(name: String, empty: Holder.Reference<StructureTemplatePool>, replace: Holder.Reference<StructureProcessorList>, degradation: Holder.Reference<StructureProcessorList>): StructureTemplatePool {
        return createBottomTopPools(name, empty, replace, degradation, "top")
    }

    fun bootstrap(context: BootstapContext<StructureTemplatePool>) {
        DeepslateCabinPools.bootstrap(context)
        DefaultCabinPools.bootstrap(context)
        DesertCabinPools.bootstrap(context)
        IceCabinPools.bootstrap(context)
        JungleCabinPools.bootstrap(context)
        MesaCabinPools.bootstrap(context)
        OceanCabinPools.bootstrap(context)
        TaigaCabinPools.bootstrap(context)
    }
}