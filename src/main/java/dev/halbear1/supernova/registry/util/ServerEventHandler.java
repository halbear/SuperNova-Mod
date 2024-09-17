package dev.halbear1.supernova.registry.util;
import  dev.halbear1.supernova.SuperNova;

import dev.halbear1.supernova.registry.worldgen.ModDimensions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Mod.EventBusSubscriber(modid = SuperNova.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class ServerEventHandler {

    @SubscribeEvent
    public static void PlayerGravityCheck(PlayerEvent.PlayerChangedDimensionEvent event) {
        Entity player = event.getPlayer();
        if (event.getFrom() == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("supernova:space"))) {
            player.setNoGravity(false);
        }
        if (event.getTo() == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("supernova:space"))) {
            player.setNoGravity(true);
        }
    }
}
