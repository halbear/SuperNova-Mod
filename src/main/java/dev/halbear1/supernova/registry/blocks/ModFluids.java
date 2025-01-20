package dev.halbear1.supernova.registry.blocks;

import dev.halbear1.supernova.SuperNova;
import dev.halbear1.supernova.custom.fluid.FlammableFluid;
import dev.halbear1.supernova.custom.fluid.SupernovaFlowingFluid;
import dev.halbear1.supernova.custom.fluid.SupernovaFluidAttributes;
import dev.halbear1.supernova.registry.items.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {
    public static  final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static  final ResourceLocation WATER_FLOW_RL = new ResourceLocation("block/water_flow");
    public static  final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");
    public static  final ResourceLocation CRUDE_OIL_STILL_RL = new ResourceLocation("supernova:block/crude_oil_still");
    public static  final ResourceLocation CRUDE_OIL_FLOW_RL = new ResourceLocation("supernova:block/crude_oil_flowing");
    public static  final ResourceLocation CRUDE_OIL_OVERLAY_RL = new ResourceLocation("supernova:block/crude_oil_overlay");
    public static  final ResourceLocation REFINED_OIL_STILL_RL = new ResourceLocation("supernova:block/refined_oil_still");
    public static  final ResourceLocation REFINED_OIL_FLOW_RL = new ResourceLocation("supernova:block/refined_oil_flowing");
    public static  final ResourceLocation REFINED_OIL_OVERLAY_RL = new ResourceLocation("supernova:block/refined_oil_overlay");

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, SuperNova.MOD_ID);

    //salt water
    public static final RegistryObject<FlowingFluid> SALT_WATER_FLUID = FLUIDS.register("salt_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.SALT_WATER_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SALT_WATER_FLOWING = FLUIDS.register("salt_water_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.SALT_WATER_PROPERTIES));

    public static final ForgeFlowingFluid.Properties SALT_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> SALT_WATER_FLUID.get(), () -> SALT_WATER_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOW_RL)
            .density(15).viscosity(5).sound(SoundEvents.BLOCK_WATER_AMBIENT).overlay(WATER_OVERLAY_RL).color(0xff45ADF2)).slopeFindDistance(5).levelDecreasePerBlock(1).canMultiply()
            .block(() -> ModFluids.SALT_WATER_BLOCK.get()).bucket(() -> ModItems.SALT_WATER_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> SALT_WATER_BLOCK = ModBlocks.BLOCKS.register("salt_water",
            () -> new FlowingFluidBlock(() -> ModFluids.SALT_WATER_FLUID.get(), AbstractBlock.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100f).noDrops()));

    //Oil
    public static final RegistryObject<SupernovaFlowingFluid> CRUDE_OIL_FLUID = FLUIDS.register("crude_oil_fluid",
            () -> new SupernovaFlowingFluid.Source(ModFluids.CRUDE_OIL_PROPERTIES));
    public static final RegistryObject<SupernovaFlowingFluid> CRUDE_OIL_FLOWING = FLUIDS.register("crude_oil_flowing",
            () -> new SupernovaFlowingFluid.Flowing(ModFluids.CRUDE_OIL_PROPERTIES));

    public static final SupernovaFlowingFluid.Properties CRUDE_OIL_PROPERTIES = new SupernovaFlowingFluid.Properties(
            () -> CRUDE_OIL_FLUID.get(), () -> CRUDE_OIL_FLOWING.get(), SupernovaFluidAttributes.builder(CRUDE_OIL_STILL_RL, CRUDE_OIL_FLOW_RL)
            .density(30).viscosity(30).sound(SoundEvents.BLOCK_HONEY_BLOCK_SLIDE).overlay(CRUDE_OIL_OVERLAY_RL).color(0x00FFFFFF)).tickRate(20).slopeFindDistance(4).levelDecreasePerBlock(2)
            .block(() -> ModFluids.CRUDE_OIL_BLOCK.get()).bucket(() -> ModItems.CRUDE_OIL_BUCKET.get());

    public static final RegistryObject<FlammableFluid> CRUDE_OIL_BLOCK = ModBlocks.BLOCKS.register("crude_oil",
            () -> new FlammableFluid(() -> ModFluids.CRUDE_OIL_FLUID.get(), AbstractBlock.Properties.create(Material.WATER).tickRandomly()
                    .doesNotBlockMovement().hardnessAndResistance(100f).noDrops()));


    public static final RegistryObject<SupernovaFlowingFluid> REFINED_OIL_FLUID = FLUIDS.register("refined_oil_fluid",
            () -> new SupernovaFlowingFluid.Source(ModFluids.REFINED_OIL_PROPERTIES));
    public static final RegistryObject<SupernovaFlowingFluid> REFINED_OIL_FLOWING = FLUIDS.register("refined_oil_flowing",
            () -> new SupernovaFlowingFluid.Flowing(ModFluids.REFINED_OIL_PROPERTIES));

    public static final SupernovaFlowingFluid.Properties REFINED_OIL_PROPERTIES = new SupernovaFlowingFluid.Properties(
            () -> REFINED_OIL_FLUID.get(), () -> REFINED_OIL_FLOWING.get(), SupernovaFluidAttributes.builder(REFINED_OIL_STILL_RL, REFINED_OIL_FLOW_RL)
            .density(30).viscosity(30).sound(SoundEvents.BLOCK_HONEY_BLOCK_PLACE, SoundEvents.ITEM_BOTTLE_FILL).overlay(REFINED_OIL_OVERLAY_RL).color(0x00FFFFFF)).tickRate(25).slopeFindDistance(4).levelDecreasePerBlock(2)
            .block(() -> ModFluids.REFINED_OIL_BLOCK.get()).bucket(() -> ModItems.REFINED_OIL_BUCKET.get());

    public static final RegistryObject<FlammableFluid> REFINED_OIL_BLOCK = ModBlocks.BLOCKS.register("refined_oil",
            () -> new FlammableFluid(() -> ModFluids.REFINED_OIL_FLUID.get(), AbstractBlock.Properties.create(Material.WATER).tickRandomly()
                    .doesNotBlockMovement().hardnessAndResistance(100f).noDrops()));

}
