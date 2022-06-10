package com.github.alexnijjar.subterrestrial.config;

import java.util.Locale;

import org.jetbrains.annotations.NotNull;

import me.shedaniel.clothconfig2.gui.entries.SelectionListEntry;
import net.minecraft.client.resource.language.I18n;

public enum TechLoot implements SelectionListEntry.Translatable {
    MODERN_INDUSTRIALIZATION, TECH_REBORN;

    @Override
    public @NotNull String getKey() {
        return I18n.translate("text.autoconfig.subterrestrial.tech_loot." + name().toLowerCase(Locale.ROOT));
    }
}
