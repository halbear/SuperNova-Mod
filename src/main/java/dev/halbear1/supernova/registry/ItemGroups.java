package dev.halbear1.supernova.registry;

import dev.halbear1.supernova.SuperNova;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroups {

    public static final ItemGroup SUPERNOVA_TAB = new ItemGroup("supernovaModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.BAUXITE_CHUNK.get());
        }
    };
}
