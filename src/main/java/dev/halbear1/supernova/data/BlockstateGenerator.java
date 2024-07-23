package dev.halbear1.supernova.data;

import dev.halbear1.supernova.SuperNova;
import dev.halbear1.supernova.registry.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockstateGenerator extends BlockStateProvider {
    public BlockstateGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper){
            super(generator, SuperNova.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerStatesAndModels(){

        ResourceLocation bauxite_ore = modLoc("block/bauxite_ore");

        simpleBlock(ModBlocks.BAUXITE_ORE.get());
    }

}
