package dev.alexnijjar.subterrestrial.forge;

import dev.alexnijjar.subterrestrial.Subterrestrial;
import dev.alexnijjar.subterrestrial.registry.forge.ModRegistryHelpersImpl;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Subterrestrial.MOD_ID)
public class SubterrestrialForge {
    public SubterrestrialForge() {
        Subterrestrial.init();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModRegistryHelpersImpl.REGISTRIES.values().forEach(deferredRegister -> deferredRegister.register(bus));
    }
}