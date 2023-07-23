package dev.alexnijjar.subterrestrial.datagen.provider.base;

import dev.alexnijjar.subterrestrial.Subterrestrial;
import dev.alexnijjar.subterrestrial.common.data.worldgen.ModProcessorListProvider;
import dev.alexnijjar.subterrestrial.common.data.worldgen.ModStructureProvider;
import dev.alexnijjar.subterrestrial.common.data.worldgen.ModStructureSetProvider;
import dev.alexnijjar.subterrestrial.common.data.worldgen.ModTemplatePoolProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldgenProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        .add(Registries.PROCESSOR_LIST, ModProcessorListProvider::bootstrap)
        .add(Registries.STRUCTURE, ModStructureProvider::bootstrap)
        .add(Registries.STRUCTURE_SET, ModStructureSetProvider::bootstrap)
        .add(Registries.TEMPLATE_POOL, ModTemplatePoolProvider::bootstrap);

    public ModWorldgenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Subterrestrial.MOD_ID));
    }
}
