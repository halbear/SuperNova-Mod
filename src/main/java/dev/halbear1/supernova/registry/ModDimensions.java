package dev.halbear1.supernova.registry;

import dev.halbear1.supernova.SuperNova;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;
import net.minecraft.world.World;

public class ModDimensions {
    public static RegistryKey<World> SPACE = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(SuperNova.MOD_ID, "space"));
}
