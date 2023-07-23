package tech.alexnijjar.subterrestrial.datagen.common.tags

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.level.biome.Biome
import tech.alexnijjar.subterrestrial.Subterrestrial

object ModTags {
    val HAS_DEEPSLATE_CABIN = createTag("has_structure/deepslate_cabin")
    val HAS_DEFAULT_CABIN = createTag("has_structure/default_cabin")
    val HAS_DESERT_CABIN = createTag("has_structure/desert_cabin")
    val HAS_ICE_CABIN = createTag("has_structure/ice_cabin")
    val HAS_JUNGLE_CABIN = createTag("has_structure/jungle_cabin")
    val HAS_MESA_CABIN = createTag("has_structure/mesa_cabin")
    val HAS_OCEAN_CABIN = createTag("has_structure/ocean_cabin")
    val HAS_TAIGA_CABIN = createTag("has_structure/taiga_cabin")

    private fun createTag(string: String): TagKey<Biome> {
        return TagKey.create(Registries.BIOME, ResourceLocation(Subterrestrial.MOD_ID, string))
    }
}
