package tech.alexnijjar.subterrestrial.datagen

import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import tech.alexnijjar.subterrestrial.Subterrestrial
import tech.alexnijjar.subterrestrial.datagen.provider.base.ModWorldgenProvider
import tech.alexnijjar.subterrestrial.datagen.provider.server.ModBiomeTagProvider
import tech.alexnijjar.subterrestrial.datagen.provider.server.ModLootTableProvider

@Suppress("unused")
@Mod.EventBusSubscriber(modid = Subterrestrial.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
object SubterrestrialDataGenerator {

    @SubscribeEvent
    fun gatherData(event: GatherDataEvent) {
        val generator = event.generator
        val lookupProvider = event.lookupProvider
        val packOutput = generator.packOutput
        generator.addProvider(event.includeServer(), ModWorldgenProvider(packOutput, lookupProvider))
        generator.addProvider(event.includeClient(), ModBiomeTagProvider(packOutput, lookupProvider, event.existingFileHelper))
        generator.addProvider(event.includeClient(), ModLootTableProvider(packOutput))
    }
}