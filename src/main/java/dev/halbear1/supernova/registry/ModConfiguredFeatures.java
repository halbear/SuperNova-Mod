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

    public static final ConfiguredFeature<?,?> BAXUITE_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.BAUXITE_ORE.get().getDefaultState(), 8)).range(16).square().count(8);

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC,?> register(String name, ConfiguredFeature<FC,?> feature){
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(SuperNova.MOD_ID, name), feature);
    }

    public static void registerConfiguredFeatures() {
        register("bauxite_ore",BAXUITE_ORE);
    }
}
