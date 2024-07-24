package dev.halbear1.supernova.custom.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class ArcFurnace extends HorizontalBlock{

    public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

    public ArcFurnace(Properties builder){
            super(builder);

    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder){
        builder.add(HORIZONTAL_FACING);
    }
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context){
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
}
