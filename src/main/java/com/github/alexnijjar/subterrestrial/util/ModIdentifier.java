package com.github.alexnijjar.subterrestrial.util;

import com.github.alexnijjar.subterrestrial.Subterrestrial;

import net.minecraft.util.Identifier;

public final class ModIdentifier extends Identifier {

    public ModIdentifier(String path) {
        super(Subterrestrial.MOD_ID, path);
    }
}
