package dev.halbear1.supernova.custom.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class StraightSteelPipe extends DirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public StraightSteelPipe(AbstractBlock.Properties builder){
        super(builder);
    }

    private static final VoxelShape NORTHBOX = Block.makeCuboidShape(4, 4, 0, 12, 12, 16);
    private static final VoxelShape WESTBOX = Block.makeCuboidShape(0, 4, 4, 16, 12, 12);
    private static final VoxelShape VERTICALBOX = Block.makeCuboidShape(4, 0, 4, 12, 16, 12);

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos position, ISelectionContext context){
        switch (state.get(FACING)){
            case NORTH:
                return NORTHBOX;
            case SOUTH:
                return NORTHBOX;
            case WEST:
                return WESTBOX;
            case EAST:
                return WESTBOX;
            case UP:
                return VERTICALBOX;
            case DOWN:
                return VERTICALBOX;
            default:
                return NORTHBOX;
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder){
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context){
        return this.getDefaultState().with(FACING, context.getNearestLookingDirection().getOpposite());
    }
}
