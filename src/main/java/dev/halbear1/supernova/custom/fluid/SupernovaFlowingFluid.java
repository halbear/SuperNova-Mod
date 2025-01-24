package dev.halbear1.supernova.custom.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public abstract class SupernovaFlowingFluid extends FlowingFluid {
    private final Supplier<? extends Fluid> flowing;
    private final Supplier<? extends Fluid> still;
    private final SupernovaFluidAttributes.Builder FluidBuilder;
    @Nullable
    private final Supplier<? extends Item> bucket;
    @Nullable
    private final Supplier<? extends FlammableFluid> block;
    private final boolean canMultiply;
    private final int slopeFindDistance;
    private final int levelDecreasePerBlock;
    private final float explosionResistance;
    private final int tickRate;
    
    protected SupernovaFlowingFluid(Properties properties) {
        this.FluidBuilder = properties.attributes;
        this.flowing = properties.flowing;
        this.still = properties.still;
        this.canMultiply = properties.canMultiply;
        this.bucket = properties.bucket;
        this.block = properties.block;
        this.slopeFindDistance = properties.slopeFindDistance;
        this.levelDecreasePerBlock = properties.levelDecreasePerBlock;
        this.explosionResistance = properties.explosionResistance;
        this.tickRate = properties.tickRate;
    }

    public Fluid getFlowingFluid() {
        return (Fluid)this.flowing.get();
    }

    public Fluid getStillFluid() {
        return (Fluid)this.still.get();
    }

    protected boolean canSourcesMultiply() {
        return this.canMultiply;
    }

    protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
        TileEntity tileentity = state.getBlock().hasTileEntity(state) ? worldIn.getTileEntity(pos) : null;
        Block.spawnDrops(state, worldIn, pos, tileentity);
    }

    protected int getSlopeFindDistance(IWorldReader worldIn) {
        return this.slopeFindDistance;
    }

    protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
        return this.levelDecreasePerBlock;
    }

    public Item getFilledBucket() {
        return this.bucket != null ? (Item)this.bucket.get() : Items.AIR;
    }

    protected boolean canDisplace(FluidState state, IBlockReader world, BlockPos pos, Fluid fluidIn, Direction direction) {
        return direction == Direction.DOWN && !this.isEquivalentTo(fluidIn);
    }

    public int getTickRate(IWorldReader world) {
        return this.tickRate;
    }

    protected float getExplosionResistance() {
        return this.explosionResistance;
    }

    protected BlockState getBlockState(FluidState state) {
        return this.block != null ? (BlockState)((FlowingFluidBlock)this.block.get()).getDefaultState().with(FlowingFluidBlock.LEVEL, getLevelFromState(state)) : Blocks.AIR.getDefaultState();
    }

    public boolean isEquivalentTo(Fluid fluidIn) {
        return fluidIn == this.still.get() || fluidIn == this.flowing.get();
    }


    protected FluidAttributes createAttributes() {
        return this.FluidBuilder.build(this);
    }

    public static class Properties {
        private Supplier<? extends Fluid> still;
        private Supplier<? extends Fluid> flowing;
        private SupernovaFluidAttributes.Builder attributes;
        private boolean canMultiply;
        private Supplier<? extends Item> bucket;
        private Supplier<? extends FlammableFluid> block;
        private int slopeFindDistance = 4;
        private int levelDecreasePerBlock = 1;
        private float explosionResistance = 1.0F;
        private int tickRate = 5;

        public Properties(Supplier<? extends Fluid> still, Supplier<? extends Fluid> flowing, SupernovaFluidAttributes.Builder attributes) {
            this.still = still;
            this.flowing = flowing;
            this.attributes = attributes;
        }
        public SupernovaFlowingFluid.Properties canMultiply() {
            this.canMultiply = true;
            return this;
        }
        public SupernovaFlowingFluid.Properties bucket(Supplier<? extends Item> bucket) {
            this.bucket = bucket;
            return this;
        }
        public SupernovaFlowingFluid.Properties block(Supplier<? extends FlammableFluid> block) {
            this.block = block;
            return this;
        }
        public SupernovaFlowingFluid.Properties slopeFindDistance(int slopeFindDistance) {
            this.slopeFindDistance = slopeFindDistance;
            return this;
        }
        public SupernovaFlowingFluid.Properties levelDecreasePerBlock(int levelDecreasePerBlock) {
            this.levelDecreasePerBlock = levelDecreasePerBlock;
            return this;
        }
        public SupernovaFlowingFluid.Properties explosionResistance(float explosionResistance) {
            this.explosionResistance = explosionResistance;
            return this;
        }
        public SupernovaFlowingFluid.Properties tickRate(int tickRate) {
            this.tickRate = tickRate;
            return this;
        }
    }

    public static class Source extends SupernovaFlowingFluid {
        public Source(Properties properties) {
            super(properties);
        }

        public int getLevel(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends SupernovaFlowingFluid {
        public Flowing(Properties properties) {
            super(properties);
            this.setDefaultState((FluidState)((FluidState)this.getStateContainer().getBaseState()).with(LEVEL_1_8, 7));
        }

        protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
            super.fillStateContainer(builder);
            builder.add(new Property[]{LEVEL_1_8});
        }

        public int getLevel(FluidState state) {
            return (Integer)state.get(LEVEL_1_8);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }
}
