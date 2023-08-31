package net.felipe.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.felipe.tutorialmod.TutorialMod;
import net.felipe.tutorialmod.block.ModBlocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroup {

    public static final ItemGroup KAISER_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID,"kaiser_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.kaiser_group"))
                    .icon(() -> new ItemStack(ModItems.ZEUS)).entries((displayContext, entries) -> {

                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.GRAVETO_DOURADO);
                        entries.add(ModBlocks.JONAS);

                        entries.add(ModBlocks.RUBY_BLOCK);



                        entries.add(ModBlocks.ARVORE);

                        entries.add(ModBlocks.FOLHA);

                        entries.add(ModItems.POTATO_SWORD);

                        entries.add(ModBlocks.BLOCO_ADES);

                        entries.add(ModBlocks.BLOCO_MEDUSA);

                        entries.add(ModBlocks.FOLHA_AZUL);

                        entries.add(ModItems.FIRE_STAFF);
                        entries.add(ModItems.WIND_STAFF);
                        entries.add(ModItems.EC_STAFF);
                        entries.add(ModItems.THUNDER_STAFF);
                        entries.add(ModItems.ICE_STAFF);
                        entries.add(ModItems.POSEIDON_STAFF);



                        entries.add(ModItems.RUBY_CHEST);
                        entries.add(ModItems.RUBY_HELMET);
                        entries.add(ModItems.RUBY_LEGGINGS);
                        entries.add(ModItems.RUBY_BOOTS);

                        entries.add(ModItems.ESPADA_RUBY);


                        entries.add(ModItems.PICARETA_RUBY);




                        entries.add(ModItems.AZEITONA);
                        entries.add(ModItems.AMBROSIA);

                        entries.add(ModItems.CAPACETE_POSEIDON);
                        entries.add(ModItems.BOTA_DE_HERMES);
                        entries.add(ModItems.CALCA_ATENA);
                        entries.add(ModItems.COLETE_ARES);


                        entries.add(ModItems.POSEIDON);
                        entries.add(ModItems.ATENA);
                        entries.add(ModItems.HERMES);
                        entries.add(ModItems.ARES);
                        entries.add(ModItems.ADES);
                        entries.add(ModItems.GELO);
                        entries.add(ModItems.ZEUS);









                    }).build());







    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("registring Item Group for "+TutorialMod.MOD_ID );
    }
}
