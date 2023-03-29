package dev.alexnijjar.subterrestrial.datagen;

import dev.alexnijjar.subterrestrial.datagen.provider.server.ModFabricBiomeTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SubterrestrialFabricDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModFabricBiomeTagProvider::new);
    }
}
