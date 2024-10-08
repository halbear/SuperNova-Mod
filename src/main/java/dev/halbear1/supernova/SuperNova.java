package dev.halbear1.supernova;

import dev.halbear1.supernova.registry.ModParticles;
import dev.halbear1.supernova.registry.blocks.ModBlocks;
import dev.halbear1.supernova.registry.blocks.ModFluids;
import dev.halbear1.supernova.registry.items.ModItems;
import dev.halbear1.supernova.registry.util.ModSoundEvents;
import dev.halbear1.supernova.registry.worldgen.ModBiomes;
import dev.halbear1.supernova.registry.worldgen.ModConfiguredFeatures;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SuperNova.MOD_ID)
public class SuperNova // to chef, peaceful and pal, no touchy
{
    // string for the 'supernova' mod ID, this string will be used A LOT throughout the project to avoid retyping this variable
    public static final String MOD_ID = "supernova";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public SuperNova() { //hal
        //creates a mod event bus
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        //register the mod elements on the mod event bus (loads them)
        ModBlocks.BLOCKS.register(bus);
        ModItems.ITEMS.register(bus);
        ModFluids.FLUIDS.register(bus);
        ModSoundEvents.SOUND_EVENTS.register(bus);
        ModBiomes.BIOMES.register(bus);
        ModParticles.PARTICLE_TYPES.register(bus);
        //ModEntities.ENTITIES.register(bus);
        //ModFeatures.FEATURES.register(bus);
        //ModSurfaceBuilders.SURFACE_BUILDERS.register(bus);
        //ModBiomes.registerBiomes();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        bus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModConfiguredFeatures::registerConfiguredFeatures);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo(SuperNova.MOD_ID, "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
