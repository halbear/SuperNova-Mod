package dev.halbear1.supernova.registry;

import dev.halbear1.supernova.SuperNova;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroups {

    public static final ItemGroup SUPERNOVA_BLOCKS_TAB = new ItemGroup("supernovaBlocksModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.ARC_FURNACE.get());
        }
    };
    public static final ItemGroup SUPERNOVA_ITEMS_TAB = new ItemGroup("supernovaItemsModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.BAUXITE_CHUNK.get());
        }
    };
}
