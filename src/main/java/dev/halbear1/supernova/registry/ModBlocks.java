package dev.halbear1.supernova.registry;

import dev.halbear1.supernova.SuperNova;

import dev.halbear1.supernova.custom.block.ArcFurnace;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SuperNova.MOD_ID);

    //Overworld
    public static final RegistryObject<Block> BAUXITE_ORE =
            registerBlock("bauxite_ore", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_ORE)
                    .harvestLevel(2)));

    public static final RegistryObject<Block> RUTILE_ORE =
            registerBlock("rutile_ore", () -> new Block(AbstractBlock.Properties.from(Blocks.DIAMOND_ORE)
                    .harvestLevel(3))); //pal: tf is a harvest level? hal: pickaxe level required to get drops, 1 is stone, 2 is iron etc...


    //Technology
    public static final RegistryObject<Block> ARC_FURNACE =
            registerBlock("arc_furnace", () -> new ArcFurnace(AbstractBlock.Properties.create(Material.IRON)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = ModBlocks.BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ItemGroups.SUPERNOVA_BLOCKS_TAB)));
    }


}
