package dev.halbear1.supernova.custom.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class SupernovaFluidAttributes {

    public static final int BUCKET_VOLUME = 1000;
    private String translationKey;
    private final ResourceLocation stillTexture;
    private final ResourceLocation flowingTexture;
    @Nullable
    private final ResourceLocation overlayTexture;
    private final SoundEvent fillSound;
    private final SoundEvent emptySound;
    private final int luminosity;
    private final int density;
    private final int temperature;
    private final int viscosity;
    private final boolean isGaseous;
    private final Rarity rarity;
    private final int color;

    protected SupernovaFluidAttributes(SupernovaFluidAttributes.Builder builder, Fluid fluid) {
        this.translationKey = builder.translationKey != null ? builder.translationKey : Util.makeTranslationKey("fluid", fluid.getRegistryName());
        this.stillTexture = builder.stillTexture;
        this.flowingTexture = builder.flowingTexture;
        this.overlayTexture = builder.overlayTexture;
        this.color = builder.color;
        this.fillSound = builder.fillSound;
        this.emptySound = builder.emptySound;
        this.luminosity = builder.luminosity;
        this.temperature = builder.temperature;
        this.viscosity = builder.viscosity;
        this.density = builder.density;
        this.isGaseous = builder.isGaseous;
        this.rarity = builder.rarity;
    }

    public ItemStack getBucket(FluidStack stack) {
        return new ItemStack(stack.getFluid().getFilledBucket());
    }

    public BlockState getBlock(IBlockDisplayReader reader, BlockPos pos, FluidState state) {
        return state.getBlockState();
    }

    public FluidState getStateForPlacement(IBlockDisplayReader reader, BlockPos pos, FluidStack state) {
        return state.getFluid().getDefaultState();
    }

    public final boolean canBePlacedInWorld(IBlockDisplayReader reader, BlockPos pos, FluidState state) {
        return !this.getBlock(reader, pos, state).isAir(reader, pos);
    }

    public final boolean canBePlacedInWorld(IBlockDisplayReader reader, BlockPos pos, FluidStack state) {
        return !this.getBlock(reader, pos, this.getStateForPlacement(reader, pos, state)).isAir(reader, pos);
    }

    public final boolean isLighterThanAir() {
        return this.density <= 0;
    }

    public boolean doesVaporize(IBlockDisplayReader reader, BlockPos pos, FluidStack fluidStack) {
        BlockState blockstate = this.getBlock(reader, pos, this.getStateForPlacement(reader, pos, fluidStack));
        if (blockstate == null) {
            return false;
        } else {
            return blockstate.getMaterial() == Material.WATER;
        }
    }

    public void vaporize(@Nullable PlayerEntity player, World worldIn, BlockPos pos, FluidStack fluidStack) {
        worldIn.playSound(player, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

        for(int l = 0; l < 8; ++l) {
            worldIn.addOptionalParticle(ParticleTypes.LARGE_SMOKE, (double)pos.getX() + Math.random(), (double)pos.getY() + Math.random(), (double)pos.getZ() + Math.random(), 0.0, 0.0, 0.0);
        }

    }

    public ITextComponent getDisplayName(FluidStack stack) {
        return new TranslationTextComponent(this.getTranslationKey());
    }

    public String getTranslationKey(FluidStack stack) {
        return this.getTranslationKey();
    }

    public String getTranslationKey() {
        return this.translationKey;
    }

    public final int getLuminosity() {
        return this.luminosity;
    }

    public final int getDensity() {
        return this.density;
    }

    public final int getTemperature() {
        return this.temperature;
    }

    public final int getViscosity() {
        return this.viscosity;
    }

    public final boolean isGaseous() {
        return this.isGaseous;
    }

    public Rarity getRarity() {
        return this.rarity;
    }

    public int getColor() {
        return this.color;
    }

    public ResourceLocation getStillTexture() {
        return this.stillTexture;
    }

    public ResourceLocation getFlowingTexture() {
        return this.flowingTexture;
    }

    @Nullable
    public ResourceLocation getOverlayTexture() {
        return this.overlayTexture;
    }

    public SoundEvent getFillSound() {
        return this.fillSound;
    }

    public SoundEvent getEmptySound() {
        return this.emptySound;
    }

    public int getLuminosity(FluidStack stack) {
        return this.getLuminosity();
    }

    public int getDensity(FluidStack stack) {
        return this.getDensity();
    }

    public int getTemperature(FluidStack stack) {
        return this.getTemperature();
    }

    public int getViscosity(FluidStack stack) {
        return this.getViscosity();
    }

    public boolean isGaseous(FluidStack stack) {
        return this.isGaseous();
    }

    public Rarity getRarity(FluidStack stack) {
        return this.getRarity();
    }

    public int getColor(FluidStack stack) {
        return this.getColor();
    }

    public ResourceLocation getStillTexture(FluidStack stack) {
        return this.getStillTexture();
    }

    public ResourceLocation getFlowingTexture(FluidStack stack) {
        return this.getFlowingTexture();
    }

    public SoundEvent getFillSound(FluidStack stack) {
        return this.getFillSound();
    }

    public SoundEvent getEmptySound(FluidStack stack) {
        return this.getEmptySound();
    }

    public int getLuminosity(IBlockDisplayReader world, BlockPos pos) {
        return this.getLuminosity();
    }

    public int getDensity(IBlockDisplayReader world, BlockPos pos) {
        return this.getDensity();
    }

    public int getTemperature(IBlockDisplayReader world, BlockPos pos) {
        return this.getTemperature();
    }

    public int getViscosity(IBlockDisplayReader world, BlockPos pos) {
        return this.getViscosity();
    }

    public boolean isGaseous(IBlockDisplayReader world, BlockPos pos) {
        return this.isGaseous();
    }

    public Rarity getRarity(IBlockDisplayReader world, BlockPos pos) {
        return this.getRarity();
    }

    public int getColor(IBlockDisplayReader world, BlockPos pos) {
        return this.getColor();
    }

    public ResourceLocation getStillTexture(IBlockDisplayReader world, BlockPos pos) {
        return this.getStillTexture();
    }

    public ResourceLocation getFlowingTexture(IBlockDisplayReader world, BlockPos pos) {
        return this.getFlowingTexture();
    }

    public SoundEvent getFillSound(IBlockDisplayReader world, BlockPos pos) {
        return this.getFillSound();
    }

    public SoundEvent getEmptySound(IBlockDisplayReader world, BlockPos pos) {
        return this.getEmptySound();
    }

    public static SupernovaFluidAttributes.Builder builder(ResourceLocation stillTexture, ResourceLocation flowingTexture) {
        return new SupernovaFluidAttributes.Builder(stillTexture, flowingTexture, SupernovaFluidAttributes::new);
    }

    public Stream<ResourceLocation> getTextures() {
        return this.overlayTexture != null ? Stream.of(this.stillTexture, this.flowingTexture, this.overlayTexture) : Stream.of(this.stillTexture, this.flowingTexture);
    }

    public static class Water extends SupernovaFluidAttributes {
        protected Water(Builder builder, Fluid fluid) {
            super(builder, fluid);
        }

        public int getColor(IBlockDisplayReader world, BlockPos pos) {
            return BiomeColors.getWaterColor(world, pos) | -16777216;
        }

        public static Builder builder(ResourceLocation stillTexture, ResourceLocation flowingTexture) {
            return new Builder(stillTexture, flowingTexture, Water::new);
        }
    }

    public static class Builder {
        private final ResourceLocation stillTexture;
        private final ResourceLocation flowingTexture;
        private ResourceLocation overlayTexture;
        private int color = -1;
        private String translationKey;
        private SoundEvent fillSound;
        private SoundEvent emptySound;
        private int luminosity = 0;
        private int density = 1000;
        private int temperature = 300;
        private int viscosity = 1000;
        private boolean isGaseous;
        private Rarity rarity;
        private BiFunction<SupernovaFluidAttributes.Builder, Fluid, SupernovaFluidAttributes> factory;

        protected Builder(ResourceLocation stillTexture, ResourceLocation flowingTexture, BiFunction<SupernovaFluidAttributes.Builder, Fluid, SupernovaFluidAttributes> factory) {
            this.rarity = Rarity.COMMON;
            this.factory = factory;
            this.stillTexture = stillTexture;
            this.flowingTexture = flowingTexture;
        }

        public final SupernovaFluidAttributes.Builder translationKey(String translationKey) {
            this.translationKey = translationKey;
            return this;
        }

        public final SupernovaFluidAttributes.Builder color(int color) {
            this.color = color;
            return this;
        }

        public final SupernovaFluidAttributes.Builder overlay(ResourceLocation texture) {
            this.overlayTexture = texture;
            return this;
        }

        public final SupernovaFluidAttributes.Builder luminosity(int luminosity) {
            this.luminosity = luminosity;
            return this;
        }

        public final SupernovaFluidAttributes.Builder density(int density) {
            this.density = density;
            return this;
        }

        public final SupernovaFluidAttributes.Builder temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        public final SupernovaFluidAttributes.Builder viscosity(int viscosity) {
            this.viscosity = viscosity;
            return this;
        }

        public final SupernovaFluidAttributes.Builder gaseous() {
            this.isGaseous = true;
            return this;
        }

        public final SupernovaFluidAttributes.Builder rarity(Rarity rarity) {
            this.rarity = rarity;
            return this;
        }

        public final SupernovaFluidAttributes.Builder sound(SoundEvent sound) {
            this.fillSound = this.emptySound = sound;
            return this;
        }

        public final SupernovaFluidAttributes.Builder sound(SoundEvent fillSound, SoundEvent emptySound) {
            this.fillSound = fillSound;
            this.emptySound = emptySound;
            return this;
        }

        public SupernovaFluidAttributes build(Fluid fluid) {
            return (SupernovaFluidAttributes)this.factory.apply(this, fluid);
        }
    }
}
