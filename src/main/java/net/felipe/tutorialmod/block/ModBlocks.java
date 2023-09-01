package net.felipe.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.felipe.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {



    public static final Block JONAS = registerBLock("jonas",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block RUBY_BLOCK = registerBLock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));





    public static final Block ARVORE = registerBLock("bloco_arvore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block CABECA = registerBLock("cabeca",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block FOLHA = registerBLock("folha",
            new Block(FabricBlockSettings.copyOf(Blocks.BIRCH_LEAVES)));

    public static final Block BLOCO_ADES = registerBLock("bloco_ades",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block BLOCO_MEDUSA = registerBLock("bloco_medusaa",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block FOLHA_AZUL = registerBLock("folha_azul",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));


    private static Block registerBLock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK,new Identifier(TutorialMod.MOD_ID, name),block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name)
                ,new BlockItem(block , new FabricItemSettings()));
    }

    public static void registerModBloks(){

        TutorialMod.LOGGER.info("registring mod bloks for "+ TutorialMod.MOD_ID);
    }
}
