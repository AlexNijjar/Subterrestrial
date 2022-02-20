package com.github.alexnijjar.subterrestrial.config;

import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "Cabins")
public class CabinConfig {

    @ConfigEntry.Gui.RequiresRestart
    public boolean enabled;
    public int spacing;
    public int separation;
    public int minHeight;
    public int maxHeight;

    public CabinConfig(boolean enabled, int spacing, int separation, int minHeight, int maxHeight) {
        this.enabled = enabled;
        this.spacing = spacing;
        this.separation = separation;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }
}
