package tech.alexnijjar.subterrestrial.common.tag;

import tech.alexnijjar.subterrestrial.Subterrestrial;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModTags {
    public static final TagKey<Biome> HAS_DEEPSLATE_CABIN = ModTags.create("has_structure/deepslate_cabin");
    public static final TagKey<Biome> HAS_DEFAULT_CABIN = ModTags.create("has_structure/default_cabin");
    public static final TagKey<Biome> HAS_DESERT_CABIN = ModTags.create("has_structure/desert_cabin");
    public static final TagKey<Biome> HAS_ICE_CABIN = ModTags.create("has_structure/ice_cabin");
    public static final TagKey<Biome> HAS_JUNGLE_CABIN = ModTags.create("has_structure/jungle_cabin");
    public static final TagKey<Biome> HAS_MESA_CABIN = ModTags.create("has_structure/mesa_cabin");
    public static final TagKey<Biome> HAS_OCEAN_CABIN = ModTags.create("has_structure/ocean_cabin");
    public static final TagKey<Biome> HAS_TAIGA_CABIN = ModTags.create("has_structure/taiga_cabin");

    private static TagKey<Biome> create(String string) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(Subterrestrial.MOD_ID, string));
    }
}
