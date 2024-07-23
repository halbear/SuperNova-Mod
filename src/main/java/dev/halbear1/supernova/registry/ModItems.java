package dev.halbear1.supernova.registry;

import dev.halbear1.supernova.SuperNova;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SuperNova.MOD_ID);

    public static final RegistryObject<Item> BAUXITE_CHUNK = ITEMS.register("bauxite_ore", () -> new Item(new Item.Properties().group(SuperNova.TAB)));
}
