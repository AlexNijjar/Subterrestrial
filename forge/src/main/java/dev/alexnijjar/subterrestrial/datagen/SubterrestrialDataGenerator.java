package dev.alexnijjar.subterrestrial.datagen;

import dev.alexnijjar.subterrestrial.Subterrestrial;
import dev.alexnijjar.subterrestrial.datagen.provider.base.ModWorldgenProvider;
import dev.alexnijjar.subterrestrial.datagen.provider.server.ModBiomeTagProvider;
import dev.alexnijjar.subterrestrial.common.data.ModLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Subterrestrial.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class SubterrestrialDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();

        generator.addProvider(event.includeServer(), new ModWorldgenProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeClient(), new ModBiomeTagProvider(packOutput, lookupProvider, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModLootTableProvider(packOutput));
    }
}
