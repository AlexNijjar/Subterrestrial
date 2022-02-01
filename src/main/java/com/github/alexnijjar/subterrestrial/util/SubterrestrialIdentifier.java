package com.github.alexnijjar.subterrestrial.util;

import com.github.alexnijjar.subterrestrial.Subterrestrial;
import net.minecraft.util.Identifier;

public final class SubterrestrialIdentifier extends Identifier {

    public SubterrestrialIdentifier(String path) {
        super(Subterrestrial.MOD_ID, path);
    }
}
