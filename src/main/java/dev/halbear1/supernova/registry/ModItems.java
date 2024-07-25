package dev.halbear1.supernova.registry;

import dev.halbear1.supernova.SuperNova;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = // hal
            DeferredRegister.create(ForgeRegistries.ITEMS, SuperNova.MOD_ID);

//the items will appear in inventory as in order of declaration here, please keep all item types grouped together
    // such as group ores together, group crystal+powdered forms together, keep it relatively organised - hal

    //ores
    public static final RegistryObject<Item> BAUXITE_CHUNK = ITEMS.register("bauxite_chunk", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)));

    public static final RegistryObject<Item> RUTILE_CHUNK = ITEMS.register("rutile_chunk", // pal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)));

    public static final RegistryObject<Item> COPPER_CHUNK = ITEMS.register("copper_chunk", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)));

    //crystals
    public static final RegistryObject<Item> SILICA_CRYSTAL = ITEMS.register("silica_crystal", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)));

    public static final RegistryObject<Item> SILICA_POWDER = ITEMS.register("silica_powder", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)));

    //ingots & alloys
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)));


}
