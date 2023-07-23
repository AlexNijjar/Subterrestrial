package tech.alexnijjar.subterrestrial.datagen.provider.base

import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider
import tech.alexnijjar.subterrestrial.Subterrestrial
import tech.alexnijjar.subterrestrial.datagen.provider.server.registry.ModProcessorListProvider
import tech.alexnijjar.subterrestrial.datagen.provider.server.registry.ModStructureProvider
import tech.alexnijjar.subterrestrial.datagen.provider.server.registry.ModStructureSetProvider
import tech.alexnijjar.subterrestrial.datagen.provider.server.registry.ModTemplatePoolProvider
import java.util.concurrent.CompletableFuture

class ModWorldgenProvider(output: PackOutput, registries: CompletableFuture<HolderLookup.Provider>) :
    DatapackBuiltinEntriesProvider(output, registries, BUILDER, setOf(Subterrestrial.MOD_ID)) {

    companion object {
        private val BUILDER = RegistrySetBuilder()
            .add(Registries.PROCESSOR_LIST, ModProcessorListProvider::bootstrap)
            .add(Registries.STRUCTURE, ModStructureProvider::bootstrap)
            .add(Registries.STRUCTURE_SET, ModStructureSetProvider::bootstrap)
            .add(Registries.TEMPLATE_POOL, ModTemplatePoolProvider::bootstrap)
    }
}
