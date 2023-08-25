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
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {

                        entries.add(ModItems.RUBY);

                        entries.add(ModBlocks.JONAS);

                        entries.add(ModBlocks.RUBY_BLOCK);

                        entries.add(ModBlocks.SOUND_BLOCK);

                        entries.add(ModBlocks.BLOCO_X);

                        entries.add(ModBlocks.ARVORE);

                        entries.add(ModBlocks.CABECA);

                        entries.add(ModBlocks.FOLHA);

                        entries.add(ModItems.POTATO_SWORD);

                        entries.add(ModBlocks.BLOCO_ADES);

                        entries.add(ModBlocks.BLOCO_MEDUSA);

                        entries.add(ModBlocks.FOLHA_AZUL);

                        entries.add(ModItems.FIRE_STAFF);
                        entries.add(ModItems.WIND_STAFF);
                        entries.add(ModItems.WEATHER_STAFF);
                        entries.add(ModItems.EC_STAFF);
                        entries.add(ModItems.THUNDER_STAFF);
                        entries.add(ModItems.LATENT_STAFF);
                        entries.add(ModItems.VEX_WING);
                        entries.add(ModItems.ICE_PROJECTILE);




                    }).build());







    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("registring Item Group for "+TutorialMod.MOD_ID );
    }
}
