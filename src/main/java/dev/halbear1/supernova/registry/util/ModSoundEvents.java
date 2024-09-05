package dev.halbear1.supernova.registry.util;

import dev.halbear1.supernova.SuperNova;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SuperNova.MOD_ID);
    //Game Sounds

    //Entity Sounds

    //Music Disks
    public static final RegistryObject<SoundEvent> NEW_WORLD = registerSoundEvent("new_world");
    public static final RegistryObject<SoundEvent> NEBULA = registerSoundEvent("nebula");
    public static final RegistryObject<SoundEvent> STARDUST_MOUNTAIN = registerSoundEvent("stardust_mountain");

    public static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(SuperNova.MOD_ID, name)));
    }
}
