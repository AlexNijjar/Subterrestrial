package com.github.alexnijjar.subterrestrial.config;

import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "cabin_config")
public class CabinConfig {

    public String name;
    public boolean generate;
    @ConfigEntry.Gui.Tooltip(count = 2)
    public int spacing;
    @ConfigEntry.Gui.Tooltip(count = 2)
    public int separation;
    public int minHeight;
    public int maxHeight;
    @ConfigEntry.Gui.Tooltip
    public int intactWeight;
    @ConfigEntry.Gui.Tooltip
    public int brokenWeight;

    // Don't delete, will crash the config.
    public CabinConfig() {
        this("minecraft:empty", true, 9, 5, -64, 64, 10, 20);
    }

    public CabinConfig(String name, boolean generate, int spacing, int separation, int minHeight, int maxHeight, int intactWeight, int brokenWeight) {
        this.name = name;
        this.generate = generate;
        this.spacing = spacing;
        this.separation = separation;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.intactWeight = intactWeight;
        this.brokenWeight = brokenWeight;
    }
}
