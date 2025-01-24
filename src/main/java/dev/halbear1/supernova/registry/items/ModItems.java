package dev.halbear1.supernova.registry.items;

import dev.halbear1.supernova.SuperNova;
import dev.halbear1.supernova.registry.blocks.ModFluids;
import dev.halbear1.supernova.registry.util.ModSoundEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = // hal
            DeferredRegister.create(ForgeRegistries.ITEMS, SuperNova.MOD_ID);

//the items will appear in inventory as in order of declaration here, please keep all item types grouped together
//such as group ores together, group crystal+powdered forms together, keep it relatively organised in both the registry AND the en_us.json - hal

    //REMEMBER TO PUT REGISTERED ITEMS AND BLOCKS IN THE EN_US.JSON, an example would be ""block.supernova.bauxite_ore": "Bauxite Ore","
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

    public static final RegistryObject<Item> ANATASE_CHUNK = ITEMS.register("anatase_chunk", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)){
                @Override
                public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
                    if (Screen.hasShiftDown()){
                        tooltip.add(new TranslationTextComponent("tooltip.supernova.anatasechunk_tooltip"));
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
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)));

    //whatever carborundum is
    public static final RegistryObject<Item> CARBORUNDUM = ITEMS.register("carborundum", // hal
            () -> new Item(new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB)));

    //buckets
    public static final RegistryObject<Item> SALT_WATER_BUCKET = ITEMS.register("salt_water_bucket",()-> new BucketItem(()-> ModFluids.SALT_WATER_FLUID.get(),
            new Item.Properties().maxStackSize(1).group(ItemGroups.SUPERNOVA_ITEMS_TAB)));
    public static final RegistryObject<Item> CRUDE_OIL_BUCKET = ITEMS.register("crude_oil_bucket",()-> new BucketItem(()-> ModFluids.CRUDE_OIL_FLUID.get(),
            new Item.Properties().maxStackSize(1).group(ItemGroups.SUPERNOVA_ITEMS_TAB)));
    public static final RegistryObject<Item> REFINED_OIL_BUCKET = ITEMS.register("refined_oil_bucket",()-> new BucketItem(()-> ModFluids.REFINED_OIL_FLUID.get(),
            new Item.Properties().maxStackSize(1).group(ItemGroups.SUPERNOVA_ITEMS_TAB)));
    public static final RegistryObject<Item> KEROSENE_BUCKET = ITEMS.register("kerosene_bucket",()-> new BucketItem(()-> ModFluids.KEROSENE_FLUID.get(),
            new Item.Properties().maxStackSize(1).group(ItemGroups.SUPERNOVA_ITEMS_TAB)));

    //music disks
    public static final RegistryObject<Item> ASTRAL_NIGHTMARE = ITEMS.register("astral_nightmare_md",
            ()-> new MusicDiscItem(1, () -> ModSoundEvents.ASTRAL_NIGHTMARE.get(),
                    new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB).maxStackSize(1)));
    public static final RegistryObject<Item> NEW_WORLD_MD = ITEMS.register("new_world_md",
            ()-> new MusicDiscItem(1, () -> ModSoundEvents.NEW_WORLD.get(),
                    new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB).maxStackSize(1)));
    public static final RegistryObject<Item> NEBULA_MD = ITEMS.register("nebula_md",
            ()-> new MusicDiscItem(1, () -> ModSoundEvents.NEBULA.get(),
                    new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB).maxStackSize(1)));
    public static final RegistryObject<Item> STARDUST_MOUNTAIN_MD = ITEMS.register("stardust_mountain_md",
            ()-> new MusicDiscItem(1, () -> ModSoundEvents.STARDUST_MOUNTAIN.get(),
                    new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB).maxStackSize(1)));
    public static final RegistryObject<Item> FISSURE_IN_SPACE_MD = ITEMS.register("fissure_in_space_md",
            ()-> new MusicDiscItem(1, () -> ModSoundEvents.FISSURE_IN_SPACE.get(),
                    new Item.Properties().group(ItemGroups.SUPERNOVA_ITEMS_TAB).maxStackSize(1)));


}
