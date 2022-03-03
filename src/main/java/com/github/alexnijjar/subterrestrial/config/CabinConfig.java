package com.github.alexnijjar.subterrestrial.config;

import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "Cabins")
public class CabinConfig {
    public int minHeight;
    public int maxHeight;

    public CabinConfig(int minHeight, int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }
}
