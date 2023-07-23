package tech.alexnijjar.subterrestrial.forge;

import tech.alexnijjar.subterrestrial.Subterrestrial;
import net.minecraftforge.fml.common.Mod;

@Mod(Subterrestrial.MOD_ID)
public class SubterrestrialForge {
    public SubterrestrialForge() {
        Subterrestrial.init();
    }
}