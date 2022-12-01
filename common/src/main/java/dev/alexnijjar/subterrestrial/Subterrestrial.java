package dev.alexnijjar.subterrestrial;

import dev.alexnijjar.subterrestrial.registry.ModStructures;

public class Subterrestrial {
    public static final String MOD_ID = "subterrestrial";

    public static void init() {
        ModStructures.init();
        ModStructures.registerMainChest();
    }
}