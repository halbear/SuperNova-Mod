package dev.halbear1.supernova.registry;

import dev.halbear1.supernova.SuperNova;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
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
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, SuperNova.MOD_ID);

    //salt water
    public static final RegistryObject<FlowingFluid> SALT_WATER_FLUID = FLUIDS.register("salt_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.SALT_WATER_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SALT_WATER_FLOWING = FLUIDS.register("salt_water_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.SALT_WATER_PROPERTIES));
    public static final ForgeFlowingFluid.Properties SALT_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> SALT_WATER_FLUID.get(), () -> SALT_WATER_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOW_RL)
            .density(15).viscosity(5).sound(SoundEvents.BLOCK_WATER_AMBIENT).overlay(WATER_OVERLAY_RL).color(0xff5abcd8)).slopeFindDistance(5).levelDecreasePerBlock(1).canMultiply()
            .block(() -> ModFluids.SALT_WATER_BLOCK.get()).bucket(() -> ModItems.SALT_WATER_BUCKET.get());
    public static final RegistryObject<FlowingFluidBlock> SALT_WATER_BLOCK = ModBlocks.BLOCKS.register("salt_water",
            () -> new FlowingFluidBlock(() -> ModFluids.SALT_WATER_FLUID.get(), AbstractBlock.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100f).noDrops()));
    //Oil
    public static final RegistryObject<FlowingFluid> CRUDE_OIL_FLUID = FLUIDS.register("crude_oil_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.CRUDE_OIL_PROPERTIES));
    public static final RegistryObject<FlowingFluid> CRUDE_OIL_FLOWING = FLUIDS.register("crude_oil_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.CRUDE_OIL_PROPERTIES));
    public static final ForgeFlowingFluid.Properties CRUDE_OIL_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> CRUDE_OIL_FLUID.get(), () -> CRUDE_OIL_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOW_RL)
            .density(15).viscosity(5).sound(SoundEvents.BLOCK_WATER_AMBIENT).overlay(WATER_OVERLAY_RL).color(0x992e1515)).slopeFindDistance(4).levelDecreasePerBlock(2)
            .block(() -> ModFluids.CRUDE_OIL_BLOCK.get()).bucket(() -> ModItems.CRUDE_OIL_BUCKET.get());
    public static final RegistryObject<FlowingFluidBlock> CRUDE_OIL_BLOCK = ModBlocks.BLOCKS.register("crude_oil",
            () -> new FlowingFluidBlock(() -> ModFluids.CRUDE_OIL_FLUID.get(), AbstractBlock.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100f).noDrops()));

}
