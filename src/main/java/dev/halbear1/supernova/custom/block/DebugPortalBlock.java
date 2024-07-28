package dev.halbear1.supernova.custom.block;

import dev.halbear1.supernova.registry.ModDimensions;
import dev.halbear1.supernova.world.dimension.DebugTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class DebugPortalBlock extends Block {
    public DebugPortalBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }
    @Override
    public ActionResultType onBlockActivated(BlockState bstate, World worldin, BlockPos blockPos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit){
        if (!worldin.isRemote){
            if (!player.isCrouching()){
                MinecraftServer server = worldin.getServer();
                if (server != null){
                    if (worldin.getDimensionKey() == ModDimensions.SPACE){
                        ServerWorld OverWorld = server.getWorld(World.OVERWORLD);
                        if (OverWorld != null){
                            player.changeDimension(OverWorld, new DebugTeleporter(blockPos, true));
                        }
                    }
                    return ActionResultType.SUCCESS;
                }
            }

        }
        return super.onBlockActivated(bstate, worldin, blockPos, player, handIn, hit);
    }

}
