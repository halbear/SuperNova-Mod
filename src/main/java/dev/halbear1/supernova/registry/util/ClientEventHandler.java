package dev.halbear1.supernova.registry.util;

import  dev.halbear1.supernova.SuperNova;
//import dev.halbear1.supernova.custom.particle.StarSparkle;
import dev.halbear1.supernova.registry.ModParticles;
import dev.halbear1.supernova.registry.blocks.ModBlocks;
import dev.halbear1.supernova.registry.blocks.ModFluids;
import dev.halbear1.supernova.registry.worldgen.ModBiomes;
import dev.halbear1.supernova.registry.worldgen.ModDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.Dimension;
import net.minecraft.world.World;
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

@Mod.EventBusSubscriber(modid = SuperNova.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {

    @SafeVarargs
    public static void SetCollectionRenderType(RenderType type, RegistryObject<Block>... blocks_list) { //hal
        for (RegistryObject<Block> blockRegistryObject : blocks_list) {
            RenderTypeLookup.setRenderLayer(blockRegistryObject.get(), type);
        }
    }
    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) { // block render types, examples for paladin and chef to see
        // pal: drying up your code
        SetCollectionRenderType(RenderType.getSolid(), // Cutout: Texture pixels with a transparency element are discarded, fastest method, prevents re-ordering at render.
                ModBlocks.ARC_FURNACE,
                ModBlocks.STEEL_PIPE
                //blocks here
        );
        SetCollectionRenderType(RenderType.getCutout(), // Cutout: Texture pixels with a transparency element are discarded, fastest method, prevents re-ordering at render.
                ModBlocks.BAUXITE_ORE, //hal
                ModBlocks.RUTILE_ORE, // pal: rutile, generator
                ModBlocks.COPPER_ORE,
                ModBlocks.ANATASE_ORE
                //blocks here
        );
        RenderTypeLookup.setRenderLayer(ModFluids.SALT_WATER_FLUID.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModFluids.SALT_WATER_FLOWING.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModFluids.SALT_WATER_BLOCK.get(), RenderType.getTranslucent());

        /*SetCollectionRenderType(RenderType.getCutoutMipped(), // Cutout Mipped: Cutout but with mipmapping. Textures from far away are simplified for performance.
                //blocks here
        );


        SetCollectionRenderType(RenderType.getTranslucent(), // Translucent: Texture pixels with a transparency element are mixed, slowest method.
            //blocks here
        );*/

    }

    /*@SubscribeEvent
    public static void registerFactory(final ParticleFactoryRegisterEvent event){
        //register particles here, an example would be:
        //Minecraft.GetInstance().particleEngine.register(ModParticleTypes.ExampleParticle.get(), ExampleParticle.Factory::new);
        Minecraft.getInstance().particles.registerFactory(ModParticles.STAR_SPARKLE.get(), StarSparkle.Factory::new);
    }*/
}
