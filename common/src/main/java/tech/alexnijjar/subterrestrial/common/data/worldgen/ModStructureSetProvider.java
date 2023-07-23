package tech.alexnijjar.subterrestrial.common.data.worldgen;

import tech.alexnijjar.subterrestrial.Subterrestrial;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class ModStructureSetProvider {
    public static final ResourceKey<StructureSet> DEEPSLATE_CABIN = createKey("deepslate_cabin");
    public static final ResourceKey<StructureSet> DEFAULT_CABIN = createKey("default_cabin");
    public static final ResourceKey<StructureSet> DESERT_CABIN = createKey("desert_cabin");
    public static final ResourceKey<StructureSet> ICE_CABIN = createKey("ice_cabin");
    public static final ResourceKey<StructureSet> JUNGLE_CABIN = createKey("jungle_cabin");
    public static final ResourceKey<StructureSet> MESA_CABIN = createKey("mesa_cabin");
    public static final ResourceKey<StructureSet> OCEAN_CABIN = createKey("ocean_cabin");
    public static final ResourceKey<StructureSet> TAIGA_CABIN = createKey("taiga_cabin");

    public static ResourceKey<StructureSet> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, new ResourceLocation(Subterrestrial.MOD_ID, name));
    }

    public static void bootstrap(BootstapContext<StructureSet> context) {
        HolderGetter<Structure> holderGetter = context.lookup(Registries.STRUCTURE);

        context.register(DEEPSLATE_CABIN,
            new StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.DEEPSLATE_CABIN),
                new RandomSpreadStructurePlacement(
                    8,
                    6,
                    RandomSpreadType.LINEAR,
                    930216435)));

        context.register(DEFAULT_CABIN,
            new StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.DEFAULT_CABIN),
                new RandomSpreadStructurePlacement(
                    8,
                    7,
                    RandomSpreadType.LINEAR,
                    620305146)));

        context.register(DESERT_CABIN,
            new StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.DESERT_CABIN),
                new RandomSpreadStructurePlacement(
                    7,
                    6,
                    RandomSpreadType.LINEAR,
                    850269402)));
//
        context.register(ICE_CABIN,
            new StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.ICE_CABIN),
                new RandomSpreadStructurePlacement(
                    6,
                    5,
                    RandomSpreadType.LINEAR,
                    398191767)));

        context.register(JUNGLE_CABIN,
            new StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.JUNGLE_CABIN),
                new RandomSpreadStructurePlacement(
                    7,
                    6,
                    RandomSpreadType.LINEAR,
                    991795390)));

        context.register(MESA_CABIN,
            new StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.MESA_CABIN),
                new RandomSpreadStructurePlacement(
                    6,
                    5,
                    RandomSpreadType.LINEAR,
                    367681074)));

        context.register(OCEAN_CABIN,
            new StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.OCEAN_CABIN),
                new RandomSpreadStructurePlacement(
                    10,
                    8,
                    RandomSpreadType.LINEAR,
                    259410023)));

        context.register(TAIGA_CABIN,
            new StructureSet(
                holderGetter.getOrThrow(ModStructureProvider.TAIGA_CABIN),
                new RandomSpreadStructurePlacement(
                    7,
                    6,
                    RandomSpreadType.LINEAR,
                    764700120)));
    }
}
