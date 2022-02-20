package com.github.alexnijjar.subterrestrial;

import com.github.alexnijjar.subterrestrial.config.SubterrestrialConfig;
import com.github.alexnijjar.subterrestrial.loot.LootTableModifier;
import com.github.alexnijjar.subterrestrial.structure.SubterrestrialStructures;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Subterrestrial implements ModInitializer {

    public static final String MOD_ID = "subterrestrial";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static SubterrestrialConfig CONFIG;

    @Override
    public void onInitialize() {

        // Register config.
        AutoConfig.register(SubterrestrialConfig.class, Toml4jConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(SubterrestrialConfig.class).getConfig();

        // Register structures.
        LootTableModifier.modifyCabinLoot();
        SubterrestrialStructures.register();

        LOGGER.info("Subterrestrial initialized!");
    }
}