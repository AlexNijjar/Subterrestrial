package com.github.alexnijjar.subterrestrial.config;

import com.github.alexnijjar.subterrestrial.util.SubterrestrialUtils;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "Subterrestrial")
public class SubterrestrialConfig implements ConfigData {

    public boolean generateCabins = true;
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

    // TODO: If possible, unify the CabinConfig lang so that it's not copy-paste for each cabin.
    @ConfigEntry.Gui.CollapsibleObject
    public CabinConfig defaultCabin = new CabinConfig(true, 6, 4, 3, 42);
    @ConfigEntry.Gui.CollapsibleObject
    public CabinConfig deepslateCabin = new CabinConfig(true, 6, 4, -56, -3);
    @ConfigEntry.Gui.CollapsibleObject
    public CabinConfig desertCabin = new CabinConfig(true, 5, 4, 3, 44);
    @ConfigEntry.Gui.CollapsibleObject
    public CabinConfig mesaCabin = new CabinConfig(true, 4, 3, 3, 48);
    @ConfigEntry.Gui.CollapsibleObject
    public CabinConfig taigaCabin = new CabinConfig(true, 5, 4, 3, 48);
    @ConfigEntry.Gui.CollapsibleObject
    public CabinConfig iceCabin = new CabinConfig(true, 4, 3, 3, 42);
    @ConfigEntry.Gui.CollapsibleObject
    public CabinConfig jungleCabin = new CabinConfig(true, 4, 3, 3, 44);
    @ConfigEntry.Gui.CollapsibleObject
    public CabinConfig oceanCabin = new CabinConfig(true, 8, 6, 24, 44);

    SubterrestrialConfig() {
        if (SubterrestrialUtils.modLoaded("modern_industrialization")) techLoot = TechLoot.MODERN_INDUSTRIALIZATION;
        else if ((SubterrestrialUtils.modLoaded("techreborn"))) techLoot = TechLoot.TECH_REBORN;
    }
}
