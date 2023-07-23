package tech.alexnijjar.subterrestrial.datagen.provider.base;

import tech.alexnijjar.subterrestrial.Subterrestrial;
import tech.alexnijjar.subterrestrial.common.data.worldgen.ModProcessorListProvider;
import tech.alexnijjar.subterrestrial.common.data.worldgen.ModStructureProvider;
import tech.alexnijjar.subterrestrial.common.data.worldgen.ModStructureSetProvider;
import tech.alexnijjar.subterrestrial.common.data.worldgen.ModTemplatePoolProvider;
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
