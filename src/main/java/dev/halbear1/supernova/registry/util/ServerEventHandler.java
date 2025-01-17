package dev.halbear1.supernova.registry.util;
import  dev.halbear1.supernova.SuperNova;

import net.minecraft.entity.Entity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = SuperNova.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class ServerEventHandler {

    //SPACE STUFF
    //if you can't tell what these do by the function names... bro.. cmon
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

    @SubscribeEvent
    public static void ChunkGravityCheck(EntityEvent.EnteringChunk chunkEvent){
        Entity entity = chunkEvent.getEntity();
        World world = entity.world;
        Biome entityBiome = world.getBiome(entity.getPosition());
        if (Objects.equals(entityBiome.getRegistryName(), new ResourceLocation("supernova:space")) && !entity.hasNoGravity()){
            entity.setNoGravity(true);
        } else if (!Objects.equals(entityBiome.getRegistryName(), new ResourceLocation("supernova:space")) && entity.hasNoGravity()) {
            entity.setNoGravity(false);
        }
    }

    @SubscribeEvent
    public static void EntityGravityCheck(LivingSpawnEvent SpawnEvent){
        Entity entity = SpawnEvent.getEntity();
        World world = entity.world;
        Biome entityBiome = world.getBiome(entity.getPosition());
        if (Objects.equals(entityBiome.getRegistryName(), new ResourceLocation("supernova:space")) && !entity.hasNoGravity()){
            entity.setNoGravity(true);
        }
    }
}
