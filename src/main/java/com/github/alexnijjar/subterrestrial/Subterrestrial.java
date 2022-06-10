package com.github.alexnijjar.subterrestrial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.alexnijjar.subterrestrial.config.SubterrestrialConfig;
import com.github.alexnijjar.subterrestrial.data.ResourceData;
import com.github.alexnijjar.subterrestrial.util.ModUtils;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class Subterrestrial implements ModInitializer {

    public static final String MOD_ID = "subterrestrial";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static SubterrestrialConfig CONFIG;
    public static boolean registeredLoot;

    @Override
    public void onInitialize() {

        // Register config.
        AutoConfig.register(SubterrestrialConfig.class, Toml4jConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(SubterrestrialConfig.class).getConfig();

        ModUtils.registerMainChest();
        
        // Data-driven stuff.
        ResourceData.register();

        LOGGER.info("Subterrestrial initialized!");
    }
}