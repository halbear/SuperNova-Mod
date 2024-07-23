package dev.halbear1.supernova.setup;

import  dev.halbear1.supernova.SuperNova;
import  dev.halbear1.supernova.registry.ModBlocks;
import  net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SuperNova.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {
    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) { // block render types
        //cutout
            //place cutout blocks here
                // an example would be
                //RenderTypeLookup.setRenderLayer(ModBlocks.ExampleBlock.get(), RenderType.cutout());
        //cutoutmipped
            //place cutoutmipped here
                // an example would be
                //RenderTypeLookup.setRenderLayer(ModBlocks.ExampleBlock.get(), RenderType.cutout_mipped());
        //translucent
            //place translucent blocks here(i.e. glass)
                // an example would be
                //RenderTypeLookup.setRenderLayer(ModBlocks.ExampleBlock.get(), RenderType.translucent());
    }

    @SubscribeEvent
    public static void registerFactory(ParticleFactoryRegisterEvent event){
        //register particles here, an example would be:
        //Minecraft.GetInstance().particleEngine.register(ModParticleTypes.ExampleParticle.get(), ExampleParticle.Factory::new);
    }
}
