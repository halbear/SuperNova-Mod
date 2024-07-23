package dev.halbear1.supernova.data;

import dev.halbear1.supernova.SuperNova;
import dev.halbear1.supernova.registry.ModItems;
import dev.halbear1.supernova.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;


public class ItemModelGenerators extends ItemModelProvider {

    public ItemModelGenerators(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, SuperNova.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
