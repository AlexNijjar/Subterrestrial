package dev.alexnijjar.subterrestrial;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Decoder;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.Lifecycle;
import net.minecraft.core.Registry;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.*;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.Locale;
import java.util.Map;

public class Subterrestrial {
    public static final String MOD_ID = "subterrestrial";

    public static void init() {
    }

    public static <E> void loadRegistryContents(RegistryOps.RegistryInfoLookup registryInfoLookup, ResourceManager resourceManager, ResourceKey<? extends Registry<E>> resourceKey, WritableRegistry<E> writableRegistry, Decoder<E> decoder, Map<ResourceKey<?>, Exception> map, CallbackInfo ci, String string2, FileToIdConverter fileToIdConverter, RegistryOps<JsonElement> registryOps, Map.Entry<ResourceLocation, Resource> entry, ResourceLocation resourceLocation) {
        System.out.println("Subterrestrial: loadRegistryContents");
    }
}