package com.github.alexnijjar.subterrestrial.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import java.util.Arrays;
import java.util.List;

@Config(name = "subterrestrial")
public class SubterrestrialConfig implements ConfigData {

    public boolean generateCabins_v1 = true;

    public List<CabinConfig> cabinConfig_v1 = Arrays.asList(
            new CabinConfig("default_cabin", true, 9, 5, 3, 42, 10, 20),
            new CabinConfig("deepslate_cabin", true, 8, 4, -64, -3, 10, 20),
            new CabinConfig("desert_cabin", true, 4, 3, 3, 48, 10, 20),
            new CabinConfig("ice_cabin", true, 4, 3, 3, 48, 10, 20),
            new CabinConfig("jungle_cabin", true, 4, 3, 3, 48, 10, 20),
            new CabinConfig("ocean_cabin", true, 18, 9, 32, 44, 10, 20)
    );

    @ConfigEntry.Gui.Tooltip(count = 3)
    @ConfigEntry.Gui.RequiresRestart
    public boolean moddedLootInChests_v1 = true;
}
