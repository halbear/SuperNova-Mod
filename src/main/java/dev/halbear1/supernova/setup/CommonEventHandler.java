package dev.halbear1.supernova.setup;
import  dev.halbear1.supernova.SuperNova;
import dev.halbear1.supernova.registry.worldgen.ModConfiguredFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SuperNova.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEventHandler {
    @SubscribeEvent //hal & pal
    public static void biomeModification(BiomeLoadingEvent event) { // this will add features such as ore to the overworld
        event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModConfiguredFeatures.BAUXITE_ORE_GEN);
        event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModConfiguredFeatures.RUTILE_ORE_GEN);
        event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModConfiguredFeatures.COPPER_ORE_GEN);
        event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModConfiguredFeatures.ANATASE_ORE_GEN);

    }
}
