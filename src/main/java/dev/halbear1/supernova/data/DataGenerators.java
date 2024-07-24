package dev.halbear1.supernova.data;

import dev.halbear1.supernova.SuperNova;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = SuperNova.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        //generator.addProvider(new BlockstateGenerator(generator, event.getExistingFileHelper()));
        //generator.addProvider(new ItemModelGenerator(generator, event.getExistingFileHelper()));
    }
}
