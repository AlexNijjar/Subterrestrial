package dev.alexnijjar.subterrestrial.datagen.provider.server;

import dev.alexnijjar.subterrestrial.Subterrestrial;
import dev.alexnijjar.subterrestrial.common.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends TagsProvider<Biome> {
    public ModBiomeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, ExistingFileHelper existingFileHelper) {
        super(output, ForgeRegistries.BIOMES.getRegistryKey(), completableFuture, Subterrestrial.MOD_ID, existingFileHelper);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModTags.HAS_DEEPSLATE_CABIN).addTags(
            BiomeTags.HAS_MINESHAFT
        );

        tag(ModTags.HAS_DEFAULT_CABIN).addTags(
            BiomeTags.HAS_VILLAGE_PLAINS,
            BiomeTags.IS_HILL,
            BiomeTags.IS_FOREST
        ).add(
            Biomes.MEADOW,
            Biomes.JAGGED_PEAKS,
            Biomes.STONY_PEAKS,
            Biomes.STONY_SHORE,
            Biomes.MUSHROOM_FIELDS,
            Biomes.PLAINS,
            Biomes.SWAMP,
            Biomes.DRIPSTONE_CAVES
        ).addOptionalTag(
            Tags.Biomes.IS_PLAINS.location()
        );

        tag(ModTags.HAS_DESERT_CABIN).addTags(
            BiomeTags.HAS_DESERT_PYRAMID,
            BiomeTags.HAS_VILLAGE_SAVANNA
        ).add(
            Biomes.WINDSWEPT_SAVANNA,
            Biomes.SAVANNA,
            Biomes.SAVANNA_PLATEAU
        ).addOptionalTag(
            Tags.Biomes.IS_DESERT.location()
        );

        tag(ModTags.HAS_ICE_CABIN).addTags(
            BiomeTags.HAS_IGLOO,
            BiomeTags.HAS_VILLAGE_SNOWY
        ).add(
            Biomes.ICE_SPIKES,
            Biomes.SNOWY_PLAINS,
            Biomes.SNOWY_BEACH,
            Biomes.SNOWY_TAIGA,
            Biomes.SNOWY_SLOPES,
            Biomes.FROZEN_RIVER,
            Biomes.FROZEN_PEAKS
        ).addOptionalTag(
            Tags.Biomes.IS_SNOWY.location()
        );

        tag(ModTags.HAS_JUNGLE_CABIN).addTags(
            BiomeTags.IS_JUNGLE,
            BiomeTags.HAS_JUNGLE_TEMPLE
        ).add(
            Biomes.LUSH_CAVES
        ).addOptionalTag(
            Tags.Biomes.IS_LUSH.location()
        );

        tag(ModTags.HAS_MESA_CABIN).addTags(
            BiomeTags.IS_BADLANDS
        );

        tag(ModTags.HAS_OCEAN_CABIN).addTags(
            BiomeTags.IS_OCEAN,
            BiomeTags.HAS_OCEAN_RUIN_WARM
        ).add(
            Biomes.RIVER
        ).addOptionalTag(
            Tags.Biomes.IS_WATER.location()
        );

        tag(ModTags.HAS_TAIGA_CABIN).addTags(
            BiomeTags.HAS_VILLAGE_TAIGA,
            BiomeTags.IS_TAIGA
        ).add(
            Biomes.TAIGA,
            Biomes.OLD_GROWTH_PINE_TAIGA,
            Biomes.OLD_GROWTH_SPRUCE_TAIGA
        );
    }
}
