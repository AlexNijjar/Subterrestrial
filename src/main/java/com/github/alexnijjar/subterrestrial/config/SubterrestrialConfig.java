package com.github.alexnijjar.subterrestrial.config;

import com.github.alexnijjar.subterrestrial.util.ModUtils;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "Subterrestrial")
public class SubterrestrialConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip(count = 3)
    @ConfigEntry.Gui.RequiresRestart
    public boolean moddedLootInChests = true;
    @ConfigEntry.Gui.Tooltip(count = 2)
    @ConfigEntry.Gui.RequiresRestart
    public boolean extractinatorSupport = true;
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    @ConfigEntry.Gui.Tooltip(count = 2)
    @ConfigEntry.Gui.RequiresRestart
    public TechLoot techLoot = TechLoot.MODERN_INDUSTRIALIZATION;

    SubterrestrialConfig() {
        if (ModUtils.modLoaded("modern_industrialization")) {
            techLoot = TechLoot.MODERN_INDUSTRIALIZATION;
        }
        else if ((ModUtils.modLoaded("techreborn"))) {
            techLoot = TechLoot.TECH_REBORN;
        }
    }
}
