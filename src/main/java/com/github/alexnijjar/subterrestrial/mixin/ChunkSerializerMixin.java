package com.github.alexnijjar.subterrestrial.mixin;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.structure.StructureContext;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ChunkSerializer;
import net.minecraft.world.gen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Warnings and errors will appear in the console for players updating from the old extractinator structures.
// This suppresses the warnings by deleting the references in each chunk.
// This will not do anything for new worlds; it will only affect worlds with < 1.0.3 versions of the extractinator.
@Mixin(ChunkSerializer.class)
public class ChunkSerializerMixin {

// suppresses the "Unknown structure start" error.
    @Inject(method = "readStructureStarts", at = @At("HEAD"))
    private static void readStructureStarts(StructureContext context, NbtCompound nbt, long worldSeed, CallbackInfoReturnable<Map<StructureFeature<?>, StructureStart<?>>> info) {

        NbtCompound nbtCompound = nbt.getCompound("starts");
        List<String> itemsToRemove = new ArrayList<>();

        for (String key : nbtCompound.getKeys()) {
            if (key.contains("the_extractinator:")) {
                itemsToRemove.add(key);
            }
        }

        for (String key : itemsToRemove)
            nbtCompound.remove(key);
    }

    // suppresses the "Found reference to unknown structure" warning.
    @Inject(method = "readStructureReferences", at = @At("HEAD"))
    private static void readStructureReferences(ChunkPos pos, NbtCompound nbt, CallbackInfoReturnable<Map<StructureFeature<?>, StructureStart<?>>> info) {

        NbtCompound nbtCompound = nbt.getCompound("References");
        List<String> itemsToRemove = new ArrayList<>();

        for (String key : nbtCompound.getKeys()) {
            if (key.contains("the_extractinator:")) {
                itemsToRemove.add(key);
            }
        }
        for (String key : itemsToRemove)
            nbtCompound.remove(key);
    }
}
