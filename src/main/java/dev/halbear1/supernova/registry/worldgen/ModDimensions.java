package dev.halbear1.supernova.registry.worldgen;

import dev.halbear1.supernova.SuperNova;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class ModDimensions {
    public static RegistryKey<World> SPACE = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(SuperNova.MOD_ID, "space"){
        @SubscribeEvent
        public void onPlayerChangedDimensionEvent(PlayerEvent.PlayerChangedDimensionEvent dimension) {
            PlayerEntity player = dimension.getPlayer();
            MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
            if (server != null){
                server.getPlayerList().func_232641_a_(new StringTextComponent("dimension change registry"), ChatType.SYSTEM, Util.DUMMY_UUID);
            }
            if (dimension.getFrom() == ModDimensions.SPACE) {
                player.setNoGravity(false);
            }
            if (dimension.getTo() == ModDimensions.SPACE) {
                player.setNoGravity(true);
            }
        }
    });


}
