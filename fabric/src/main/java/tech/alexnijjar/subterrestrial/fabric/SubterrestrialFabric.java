package tech.alexnijjar.subterrestrial.fabric;

import net.fabricmc.api.ModInitializer;
import tech.alexnijjar.subterrestrial.Subterrestrial;

public class SubterrestrialFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Subterrestrial.init();
    }
}