package dev.halbear1.supernova.registry;

import dev.halbear1.supernova.SuperNova;

import net.minecraft.block.*;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SuperNova.MOD_ID);

    //properties
    static AbstractBlock.Properties stone = AbstractBlock.Properties.from(Blocks.STONE);

    //environment
    public static final RegistryObject<Block> BAUXITE_ORE = registerBlock("bauxite_ore", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_ORE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = ModBlocks.BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().group(SuperNova.TAB)));
        return toReturn;
    }
}
