package dev.halbear1.supernova.custom.fluid;
import net.minecraft.fluid.*;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class SaltWater extends Fluid {
    @Override
    public Item getFilledBucket() {
        return null;
    }

    @Override
    protected boolean canDisplace(FluidState fluidState, IBlockReader iBlockReader, BlockPos blockPos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    protected Vector3d getFlow(IBlockReader iBlockReader, BlockPos blockPos, FluidState fluidState) {
        return null;
    }

    @Override
    public int getTickRate(IWorldReader iWorldReader) {
        return 0;
    }

    @Override
    protected float getExplosionResistance() {
        return 0;
    }

    @Override
    public float getActualHeight(FluidState fluidState, IBlockReader iBlockReader, BlockPos blockPos) {
        return 0;
    }

    @Override
    public float getHeight(FluidState fluidState) {
        return 0;
    }

    @Override
    protected BlockState getBlockState(FluidState fluidState) {
        return null;
    }

    @Override
    public boolean isSource(FluidState fluidState) {
        return false;
    }

    @Override
    public int getLevel(FluidState fluidState) {
        return 0;
    }

    @Override
    public VoxelShape func_215664_b(FluidState fluidState, IBlockReader iBlockReader, BlockPos blockPos) {
        return null;
    }
}
