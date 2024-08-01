package dev.halbear1.supernova.custom.block;

import dev.halbear1.supernova.registry.ModBlocks;
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
                    if(worldin.getBlockState(blockPos.down(1).east(1)).matchesBlock(ModBlocks.DEBUG_PORTAL_BLOCK.get())&&
                       worldin.getBlockState(blockPos.down(1).west(1)).matchesBlock(ModBlocks.DEBUG_PORTAL_BLOCK.get()) &&
                       worldin.getBlockState(blockPos.up(1)).matchesBlock(ModBlocks.DEBUG_PORTAL_BLOCK.get()) &&
                       worldin.getBlockState(blockPos.up(2)).matchesBlock(ModBlocks.DEBUG_PORTAL_BLOCK.get())) {
                        DimensionSwitch(worldin, blockPos, player);
                        return ActionResultType.SUCCESS;
                    } else if (worldin.getBlockState(blockPos.down(1).north(1)).matchesBlock(ModBlocks.DEBUG_PORTAL_BLOCK.get())&&
                            worldin.getBlockState(blockPos.down(1).south(1)).matchesBlock(ModBlocks.DEBUG_PORTAL_BLOCK.get()) &&
                            worldin.getBlockState(blockPos.up(1)).matchesBlock(ModBlocks.DEBUG_PORTAL_BLOCK.get()) &&
                            worldin.getBlockState(blockPos.up(2)).matchesBlock(ModBlocks.DEBUG_PORTAL_BLOCK.get())) {
                        DimensionSwitch(worldin, blockPos, player);
                        return ActionResultType.SUCCESS;
                    }
                }
            }
        }
        return super.onBlockActivated(bstate, worldin, blockPos, player, handIn, hit);
    }
    private static void DimensionSwitch(World worldin, BlockPos blockPos, PlayerEntity player){
        MinecraftServer server = worldin.getServer();
        if (worldin.getDimensionKey() == ModDimensions.SPACE) {
            ServerWorld OverWorld = server.getWorld(World.OVERWORLD);
            if (OverWorld != null) {
                player.changeDimension(OverWorld, new DebugTeleporter(blockPos, true));
            }
            player.setNoGravity(false);
        }
        if (worldin.getDimensionKey() != ModDimensions.SPACE) {
            ServerWorld OverWorld = server.getWorld(ModDimensions.SPACE);
            if (OverWorld != null) {
                player.changeDimension(OverWorld, new DebugTeleporter(blockPos, true));
            }
            player.setNoGravity(true);
        }
    }

}
