package com.github.alexnijjar.subterrestrial.structure;

import com.github.alexnijjar.subterrestrial.config.CabinConfig;
import com.github.alexnijjar.subterrestrial.mixin.StructureFeatureAccessor;
import com.github.alexnijjar.subterrestrial.util.SubterrestrialIdentifier;
import com.github.alexnijjar.subterrestrial.util.SubterrestrialUtils;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

import java.util.Map;

public class SubterrestrialStructures {

    public static void register() {

        for (Map.Entry<String, CabinConfig> entry : SubterrestrialUtils.getCabins().entrySet()) {
            CabinConfig value = entry.getValue();

            StructureFeature<StructurePoolFeatureConfig> structure = new CabinStructure(StructurePoolFeatureConfig.CODEC, value);

            // Custom structure feature with a custom height.
            Registry.register(Registry.STRUCTURE_FEATURE, new SubterrestrialIdentifier(entry.getKey()), structure).getGenerationStep();
            // Add the generation step to the custom structure feature.
            StructureFeatureAccessor.getStep().put(structure, GenerationStep.Feature.UNDERGROUND_STRUCTURES);
        }

        // Registers either the main chest or an extractinator if the mod is installed.
        SubterrestrialUtils.registerMainChest();
    }
}
