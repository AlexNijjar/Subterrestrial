package tech.alexnijjar.subterrestrial.fabric;

import tech.alexnijjar.subterrestrial.Subterrestrial;
import net.fabricmc.api.ModInitializer;

public class SubterrestrialFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Subterrestrial.init();
    }
}