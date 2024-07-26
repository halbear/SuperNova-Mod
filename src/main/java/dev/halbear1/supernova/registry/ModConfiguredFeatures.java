package dev.halbear1.supernova.registry;

import dev.halbear1.supernova.SuperNova;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

public class ModConfiguredFeatures { //hal & pal
    //pal: 'bauxite' not 'baxuite'
    public static final ConfiguredFeature<?,?> BAUXITE_ORE_GEN = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.BAUXITE_ORE.get().getDefaultState(), 8)).range(40).square().count(12);
    public static final ConfiguredFeature<?,?> RUTILE_ORE_GEN = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.RUTILE_ORE.get().getDefaultState(), 6)).range(25).square().count(7);
    public static final ConfiguredFeature<?,?> COPPER_ORE_GEN = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.COPPER_ORE.get().getDefaultState(), 12)).range(225).square().count(24);
    public static final ConfiguredFeature<?,?> ANATASE_ORE_GEN = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.ANATASE_ORE.get().getDefaultState(), 5)).range(25).square().count(5);

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC,?> register(String name, ConfiguredFeature<FC,?> feature){ //hal
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(SuperNova.MOD_ID, name), feature);
    }

    public static void registerConfiguredFeatures() { //hal & pal
        register("bauxite_ore_gen",BAUXITE_ORE_GEN);
        register("rutile_ore_gen",RUTILE_ORE_GEN);
        register("copper_ore_gen",COPPER_ORE_GEN);
        register("anatase_ore_gen",ANATASE_ORE_GEN);
    }
}
