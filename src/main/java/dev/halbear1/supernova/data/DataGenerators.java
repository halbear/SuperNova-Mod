package dev.halbear1.supernova.data;

import net.minecraft.data.DataGenerator;
import  dev.halbear1.supernova.SuperNova;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = SuperNova.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public  static  void GatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        generator.addProvider(new BlockstateGenerator(generator, event.getExistingFileHelper()));
        generator.addProvider(new ItemModelGenerators(generator, event.getExistingFileHelper()));
    }
}
