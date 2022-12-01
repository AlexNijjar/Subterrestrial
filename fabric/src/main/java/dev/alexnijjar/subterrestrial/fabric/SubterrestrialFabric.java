package dev.alexnijjar.subterrestrial.fabric;

import dev.alexnijjar.subterrestrial.Subterrestrial;
import net.fabricmc.api.ModInitializer;

public class SubterrestrialFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Subterrestrial.init();
    }
}