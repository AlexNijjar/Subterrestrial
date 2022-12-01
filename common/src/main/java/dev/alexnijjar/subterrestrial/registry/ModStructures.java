package dev.alexnijjar.subterrestrial.registry;

import com.mojang.datafixers.util.Pair;
import dev.alexnijjar.subterrestrial.Subterrestrial;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.List;

public class ModStructures {

    // Registers an extractinator jigsaw structure if the Extractinator mod is installed, or the default main chest if it is not.
    public static void registerMainChest() {
        Pools.register(
                new StructureTemplatePool(
                        new ResourceLocation(Subterrestrial.MOD_ID, "main"),
                        new ResourceLocation("empty"),
                        List.of(new Pair<>(StructurePoolElement.single(Subterrestrial.MOD_ID + ":cabin/loot/" + (ModRegistryHelpers.isModLoaded("extractinator") ? "extractinator" : "main")), 1)),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }

    public static void init() {
    }
}