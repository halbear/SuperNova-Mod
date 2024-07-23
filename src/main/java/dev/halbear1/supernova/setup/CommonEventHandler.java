package dev.halbear1.supernova.setup;
import  dev.halbear1.supernova.SuperNova;
import  dev.halbear1.supernova.registry.ModConfiguredFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SuperNova.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEventHandler {

    @SubscribeEvent
    public static void biomeModification(BiomeLoadingEvent event){ // this will add features such as ore to the overworld
        event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModConfiguredFeatures.BAXUITE_ORE);
    }

}
