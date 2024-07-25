package dev.halbear1.supernova.registry;

import dev.halbear1.supernova.*;
import dev.halbear1.supernova.loot_modifiers.ModReplaceLootDrop;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
