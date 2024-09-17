package dev.halbear1.supernova.world.dimension;

import dev.halbear1.supernova.custom.block.ArcFurnace;
import dev.halbear1.supernova.registry.blocks.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class DebugTeleporter implements ITeleporter {
        public static BlockPos CurPos = BlockPos.ZERO;
        public static boolean insideDimension = false;

        public DebugTeleporter(BlockPos position, boolean insideDimensionBool){
            CurPos = position;
            insideDimension = insideDimensionBool;
        }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld DestinationWorld, float yaw, Function<Boolean, Entity> repositionEntity){
        entity = repositionEntity.apply(false);
        double y = 61;
        if (!insideDimension){
            y = CurPos.getY();
        }
        BlockPos DestinationPos = new BlockPos(CurPos.getX(), y, CurPos.getZ());
        int tries = 0;
        while ((DestinationWorld.getBlockState(DestinationPos).getMaterial()!= Material.AIR) && !DestinationWorld.getBlockState(DestinationPos).isReplaceable(Fluids.WATER) && DestinationWorld.getBlockState(DestinationPos.up()).getMaterial() != Material.AIR && !DestinationWorld.getBlockState(DestinationPos.up()).isReplaceable(Fluids.WATER) && tries < 25) {
            DestinationPos = DestinationPos.up(2);
            tries++;
        }
        entity.setPositionAndUpdate(DestinationPos.getX(),DestinationPos.getY(),DestinationPos.getZ());

        if (insideDimension){
            boolean doSetBlock = true;
            for (BlockPos positionCheck : BlockPos.getAllInBoxMutable(DestinationPos.down(10).west(10), DestinationPos.up(10).east(10))){
                if (DestinationWorld.getBlockState(positionCheck).getBlock()instanceof ArcFurnace){
                    doSetBlock = false;
                    break;
                }
                if (doSetBlock) {
                    DestinationWorld.setBlockState(DestinationPos.down(), ModBlocks.DEBUG_PORTAL_BLOCK.get().getDefaultState());
                }
            }

        }
        return entity;
    }

}
