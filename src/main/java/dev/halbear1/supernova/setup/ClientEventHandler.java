package dev.halbear1.supernova.setup;

import  dev.halbear1.supernova.SuperNova;
import  dev.halbear1.supernova.registry.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.block.Block;

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
                ModBlocks.COPPER_ORE
                //blocks here
        );

        /*SetCollectionRenderType(RenderType.getCutoutMipped(), // Cutout Mipped: Cutout but with mipmapping. Textures from far away are simplified for performance.
                //blocks here
        );

        SetCollectionRenderType(RenderType.getTranslucent(), // Translucent: Texture pixels with a transparency element are mixed, slowest method.
                //blocks here
        );*/
    }

    /*@SubscribeEvent
    public static void registerFactory(ParticleFactoryRegisterEvent event){
        //register particles here, an example would be:
        //Minecraft.GetInstance().particleEngine.register(ModParticleTypes.ExampleParticle.get(), ExampleParticle.Factory::new);
    }*/
}
