package dev.halbear1.supernova.custom.block;

import com.sun.org.apache.xpath.internal.operations.Bool;
import dev.halbear1.supernova.registry.blocks.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.data.BlockModelDefinition;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class StraightSteelPipe extends DirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty FLOOR_PLACEMENT = BooleanProperty.create("floor_placement");
    public static final BooleanProperty ROOF_PLACEMENT = BooleanProperty.create("roof_placement");

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
        builder.add(FACING, FLOOR_PLACEMENT, ROOF_PLACEMENT);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos placementPos = context.getPos();
        World world = context.getWorld();
        int PlacementX = placementPos.getX();
        int PlacementY = placementPos.getY();
        int PlacementZ = placementPos.getZ();
        Direction facing = context.getNearestLookingDirection().getOpposite();
        boolean OnGround = false;
        boolean OnRoof = false;
        if (world.getBlockState(placementPos.down()).getBlock()!=Blocks.AIR &&
                world.getBlockState(placementPos.down()).getBlock()!=ModBlocks.STEEL_PIPE.get()
                    && facing != Direction.UP && facing != Direction.DOWN){
            OnGround = true;
        }
        if (world.getBlockState(placementPos.up()).getBlock()!=Blocks.AIR &&
                world.getBlockState(placementPos.up()).getBlock()!=ModBlocks.STEEL_PIPE.get()
                    && !OnGround && facing != Direction.UP && facing != Direction.DOWN){
            OnRoof = true;
        }
        return this.getDefaultState()
                .with(FACING, facing)
                .with(FLOOR_PLACEMENT, OnGround)
                .with(ROOF_PLACEMENT, OnRoof);
    }
}
