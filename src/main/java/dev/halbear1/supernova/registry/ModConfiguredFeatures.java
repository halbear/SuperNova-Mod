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

public class ModConfiguredFeatures {
    //pal: 'bauxite' not 'baxuite'
    public static final ConfiguredFeature<?,?> BAUXITE_ORE_GEN = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.BAUXITE_ORE.get().getDefaultState(), 12)).range(32).square().count(12);
    public static final ConfiguredFeature<?,?> RUTILE_ORE_GEN = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.RUTILE_ORE.get().getDefaultState(), 12)).range(32).square().count(12);

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC,?> register(String name, ConfiguredFeature<FC,?> feature){
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(SuperNova.MOD_ID, name), feature);
    }

    public static void registerConfiguredFeatures() {
       register("bauxite_ore_gen",BAUXITE_ORE_GEN);
       register("rutile_ore_gen",RUTILE_ORE_GEN);
    }
}
