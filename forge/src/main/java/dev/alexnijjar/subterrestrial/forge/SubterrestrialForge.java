package dev.alexnijjar.subterrestrial.forge;

import dev.alexnijjar.subterrestrial.Subterrestrial;
import net.minecraftforge.fml.common.Mod;

@Mod(Subterrestrial.MOD_ID)
public class SubterrestrialForge {
    public SubterrestrialForge() {
        Subterrestrial.init();
    }
}