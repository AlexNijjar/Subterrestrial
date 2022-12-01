package dev.alexnijjar.subterrestrial.registry.fabric;

import com.mojang.datafixers.util.Pair;
import dev.alexnijjar.subterrestrial.Subterrestrial;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class ModRegistryHelpersImpl {
    public static <V, T extends V> Pair<Supplier<T>, ResourceLocation> registerFull(Registry<V> registry, String id, Supplier<T> object) {
        var register = Registry.register(registry, new ResourceLocation(Subterrestrial.MOD_ID, id), object.get());
        return Pair.of(() -> register, new ResourceLocation(Subterrestrial.MOD_ID, id));
    }

    public static boolean isModLoaded(String modid) {
        return FabricLoader.getInstance().isModLoaded(modid);
    }
}
