package dev.halbear1.supernova.registry;

import dev.halbear1.supernova.*;
import dev.halbear1.supernova.loot_modifiers.ModReplaceLootDrop;
import dev.halbear1.supernova.registry.worldgen.ModDimensions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import javax.annotation.Nonnull;


@Mod.EventBusSubscriber(modid = SuperNova.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD) //hal
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerModifiderSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>event){ //hal
        event.getRegistry().registerAll(
                new ModReplaceLootDrop.Serializer().setRegistryName(
                        new ResourceLocation(SuperNova.MOD_ID,"silica_from_sand")), //hal
                new ModReplaceLootDrop.Serializer().setRegistryName(
                        new ResourceLocation(SuperNova.MOD_ID,"silica_powder_from_quartz_block")), //hal
                new ModReplaceLootDrop.Serializer().setRegistryName(
                        new ResourceLocation(SuperNova.MOD_ID,"silica_powder_from_smooth_quartz")) //hal
        );
    }
}
