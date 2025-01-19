package dev.halbear1.supernova.registry.blocks;

import dev.halbear1.supernova.SuperNova;

import dev.halbear1.supernova.custom.block.ArcFurnace;
import dev.halbear1.supernova.custom.block.DebugPortalBlock;
import dev.halbear1.supernova.custom.block.StraightSteelPipe;
import dev.halbear1.supernova.registry.items.ModItems;
import dev.halbear1.supernova.registry.items.ItemGroups;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks { //hal
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SuperNova.MOD_ID);
//the blocks will appear in inventory as in order of declaration here, please keep all block types grouped together
//such as group ores together, group organic materials together, keep it relatively organised in both the registry AND the en_us.json - hal

    //REMEMBER TO PUT REGISTERED ITEMS AND BLOCKS IN THE EN_US.JSON, an example would be ""block.supernova.bauxite_ore": "Bauxite Ore","

    //Overworld
        //ores
    public static final RegistryObject<Block> BAUXITE_ORE = //hal
            registerBlock("bauxite_ore", () -> new Block(AbstractBlock.Properties
                    .create(Material.ROCK)
                    .sound(SoundType.STONE)
                    .hardnessAndResistance(3.0f, 3.0f)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    )
            );

    public static final RegistryObject<Block> RUTILE_ORE = //hal & pal
            registerBlock("rutile_ore", () -> new Block(AbstractBlock.Properties
                    .create(Material.ROCK)
                    .sound(SoundType.STONE)
                    .hardnessAndResistance(3.0f, 3.0f)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    )//pal: tf is a harvest level? hal: pickaxe level required to get drops, 1 is stone, 2 is iron etc...
            );

    public static final RegistryObject<Block> COPPER_ORE = //hal & pal
            registerBlock("copper_ore", () -> new Block(AbstractBlock.Properties
                            .create(Material.ROCK)
                            .sound(SoundType.STONE)
                            .hardnessAndResistance(3.0f, 3.0f)
                            .harvestLevel(1)
                            .harvestTool(ToolType.PICKAXE)
                            .setRequiresTool()
                    )
            );
    public static final RegistryObject<Block> ANATASE_ORE = //hal & pal
            registerBlock("anatase_ore", () -> new Block(AbstractBlock.Properties
                            .create(Material.ROCK)
                            .sound(SoundType.STONE)
                            .hardnessAndResistance(3.0f, 3.0f)
                            .harvestLevel(3)
                            .harvestTool(ToolType.PICKAXE)
                            .setRequiresTool()
                    )
            );

    // Block of x
    public static final RegistryObject<Block> BAUXITE_BLOCK = //hal
            registerBlock("bauxite_block", () -> new Block(AbstractBlock.Properties
                            .create(Material.ROCK)
                            .sound(SoundType.STONE)
                            .hardnessAndResistance(2.0f, 1.0f)
                            .harvestTool(ToolType.PICKAXE)
                    )
            );

    public static final RegistryObject<Block> RUTILE_CHUNK_BLOCK = //hal
            registerBlock("rutile_chunk_block", () -> new Block(AbstractBlock.Properties
                            .create(Material.GLASS)
                            .sound(SoundType.METAL)
                            .hardnessAndResistance(2.0f, 1.0f)
                            .harvestTool(ToolType.PICKAXE)
                    )
            );
    public static final RegistryObject<Block> ANATASE_BLOCK = //hal
            registerBlock("anatase_block", () -> new Block(AbstractBlock.Properties
                            .create(Material.GLASS)
                            .sound(SoundType.METAL)
                            .hardnessAndResistance(2.0f, 1.0f)
                            .harvestTool(ToolType.PICKAXE)
                    )
            );
    public static final RegistryObject<Block> RAW_COPPER_BLOCK = //hal
            registerBlock("raw_copper_block", () -> new Block(AbstractBlock.Properties
                            .create(Material.IRON)
                            .sound(SoundType.METAL)
                            .hardnessAndResistance(2.0f, 1.0f)
                            .harvestTool(ToolType.PICKAXE)
                    )
            );
    public static final RegistryObject<Block> COPPER_BLOCK = //hal
            registerBlock("copper_block", () -> new Block(AbstractBlock.Properties
                            .create(Material.IRON)
                            .sound(SoundType.METAL)
                            .hardnessAndResistance(2.0f, 1.0f)
                            .harvestTool(ToolType.PICKAXE)
                    )
            );
    public static final RegistryObject<Block> CHISLED_COPPER_BLOCK = //hal
            registerBlock("chisled_copper_block", () -> new Block(AbstractBlock.Properties
                            .create(Material.IRON)
                            .sound(SoundType.METAL)
                            .hardnessAndResistance(2.0f, 1.0f)
                            .harvestTool(ToolType.PICKAXE)
                    )
            );

    //Technology
    public static final RegistryObject<Block> ARC_FURNACE = //hal & pal
            registerBlock("arc_furnace", () -> new ArcFurnace(AbstractBlock.Properties
                        .create(Material.IRON)
                        .hardnessAndResistance(3.0f,3.0f)
                        .harvestTool(ToolType.PICKAXE)
                        .sound(SoundType.METAL)
                    )
            );

    public static final RegistryObject<Block> DEBUG_PORTAL_BLOCK = //hal & pal
            registerBlock("debug_portal_block", () -> new DebugPortalBlock(AbstractBlock.Properties
                            .create(Material.IRON)
                            .hardnessAndResistance(1.0f,1.0f)
                            .harvestTool(ToolType.PICKAXE)
                            .sound(SoundType.METAL)
                    )
            );

    public static final RegistryObject<Block> STEEL_PIPE = //hal
            registerBlock("steel_pipe", () -> new StraightSteelPipe(AbstractBlock.Properties
                            .create(Material.IRON)
                            .hardnessAndResistance(3.0f,3.0f)
                            .harvestTool(ToolType.PICKAXE)
                            .sound(SoundType.METAL)
                            .setRequiresTool()
                            .notSolid()
                    )
            );



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){ //hal
        RegistryObject<T> toReturn = ModBlocks.BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) { //hal
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ItemGroups.SUPERNOVA_BLOCKS_TAB)));
    }


}
