package dev.halbear1.supernova.registry;

import dev.halbear1.supernova.SuperNova;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = // hal
            DeferredRegister.create(ForgeRegistries.ITEMS, SuperNova.MOD_ID);

//the items will appear in inventory as in order of declaration in the en_us.json, please keep all item types grouped together
//such as group ores together, group crystal+powdered forms together, keep it relatively organised in both the registry AND the en_us.json - hal

    //ores
    public static final RegistryObject<Item> BAUXITE_CHUNK = ITEMS.register("bauxite_chunk", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)){
                @Override
                public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
                    if (Screen.hasShiftDown()){
                        tooltip.add(new TranslationTextComponent("tooltip.supernova.bauxite_tooltip"));
                    } else{
                        tooltip.add(new TranslationTextComponent("tooltip.supernova.tooltip_prompt"));
                    }
                }});

    public static final RegistryObject<Item> RUTILE_CHUNK = ITEMS.register("rutile_chunk", // pal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)){
                @Override
                public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
                    if (Screen.hasShiftDown()){
                        tooltip.add(new TranslationTextComponent("tooltip.supernova.rutile_tooltip"));
                    } else{
                        tooltip.add(new TranslationTextComponent("tooltip.supernova.tooltip_prompt"));
                    }
                }});

    public static final RegistryObject<Item> COPPER_CHUNK = ITEMS.register("copper_chunk", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)){
                @Override
                public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
                    if (Screen.hasShiftDown()){
                        tooltip.add(new TranslationTextComponent("tooltip.supernova.copperchunk_tooltip"));
                    } else{
                        tooltip.add(new TranslationTextComponent("tooltip.supernova.tooltip_prompt"));
                    }
                }});

    //crystals
    public static final RegistryObject<Item> SILICA_CRYSTAL = ITEMS.register("silica_crystal", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)){
                @Override
                public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
                    if (Screen.hasShiftDown()){
                        tooltip.add(new TranslationTextComponent("tooltip.supernova.silicachunk_tooltip"));
                    } else{
                        tooltip.add(new TranslationTextComponent("tooltip.supernova.tooltip_prompt"));
                    }
                }});

    public static final RegistryObject<Item> SILICA_POWDER = ITEMS.register("silica_powder", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)){
                @Override
                public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
                    if (Screen.hasShiftDown()){
                        tooltip.add(new TranslationTextComponent("tooltip.supernova.silicapowder_tooltip"));
                    } else{
                        tooltip.add(new TranslationTextComponent("tooltip.supernova.tooltip_prompt"));
                    }
                }});

    //ingots & alloys
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)));
    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)));

    public static final RegistryObject<Item> CARBORUNDUM = ITEMS.register("carborundum", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)));


}
