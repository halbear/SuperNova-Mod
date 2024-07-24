package dev.halbear1.supernova.setup;

import  dev.halbear1.supernova.SuperNova;
import  dev.halbear1.supernova.registry.ModBlocks;
import  net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import java.util.ArrayList;
import net.minecraft.block.Block;
import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = SuperNova.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {
    @SafeVarargs
    public static void SetCollectionRenderType(RenderType type, RegistryObject<Block>... blocks_list) {
        for (RegistryObject<Block> blockRegistryObject : blocks_list) {
            RenderTypeLookup.setRenderLayer(blockRegistryObject.get(), type);
        }
    }
    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) { // block render types, examples for paladin and chef to see
        // pal: drying up your code
        SetCollectionRenderType(RenderType.getCutout(), // Cutout: Texture pixels with a transparency element are discarded, fastest method, prevents re-ordering at render.
                ModBlocks.BAUXITE_ORE,
                ModBlocks.RUTILE_ORE // pal: rutile!
        );
        /*SetCollectionRenderType(RenderType.getCutoutMipped(), // Cutout Mipped: Cutout but with mipmapping. Textures from far away are simplified for performance.

        );
        SetCollectionRenderType(RenderType.getTranslucent(), // Translucent: Texture pixels with a transparency element are mixed, slowest method.

        );*/
    }

    /*@SubscribeEvent
    public static void registerFactory(ParticleFactoryRegisterEvent event){
        //register particles here, an example would be:
        //Minecraft.GetInstance().particleEngine.register(ModParticleTypes.ExampleParticle.get(), ExampleParticle.Factory::new);
    }*/
}
