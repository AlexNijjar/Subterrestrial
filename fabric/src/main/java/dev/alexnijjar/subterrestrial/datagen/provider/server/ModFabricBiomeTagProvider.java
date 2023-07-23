package dev.alexnijjar.subterrestrial.datagen.provider.server;

import dev.alexnijjar.subterrestrial.common.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class ModFabricBiomeTagProvider extends FabricTagProvider<Biome> {
    public ModFabricBiomeTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.BIOME, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getOrCreateTagBuilder(ModTags.HAS_DEEPSLATE_CABIN).addOptionalTag(
            ConventionalBiomeTags.IN_OVERWORLD
        );

        getOrCreateTagBuilder(ModTags.HAS_DEFAULT_CABIN).forceAddTag(
            ConventionalBiomeTags.PLAINS
        );

        getOrCreateTagBuilder(ModTags.HAS_DESERT_CABIN).forceAddTag(
            ConventionalBiomeTags.DESERT
        );

        getOrCreateTagBuilder(ModTags.HAS_ICE_CABIN).forceAddTag(
            ConventionalBiomeTags.SNOWY
        );

        getOrCreateTagBuilder(ModTags.HAS_JUNGLE_CABIN).forceAddTag(
            ConventionalBiomeTags.JUNGLE
        );

        getOrCreateTagBuilder(ModTags.HAS_MESA_CABIN).forceAddTag(
            ConventionalBiomeTags.BADLANDS
        );
        getOrCreateTagBuilder(ModTags.HAS_MESA_CABIN).forceAddTag(
            ConventionalBiomeTags.MESA
        );

        getOrCreateTagBuilder(ModTags.HAS_OCEAN_CABIN).forceAddTag(
            ConventionalBiomeTags.OCEAN
        );

        getOrCreateTagBuilder(ModTags.HAS_TAIGA_CABIN).forceAddTag(
            ConventionalBiomeTags.TAIGA
        );
    }
}
