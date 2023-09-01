package net.felipe.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.felipe.tutorialmod.TutorialMod;
import net.felipe.tutorialmod.item.custom.*;
import net.felipe.tutorialmod.item.custom.BootOfHermes;
import net.felipe.tutorialmod.item.staffs.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));



    public static final Item DEUSES = registerItem("deuses", new Item(new FabricItemSettings()));


    public static final Item HERMES = registerItem("hermes", new Item(new FabricItemSettings()));
    public static final Item ATENA = registerItem("atena", new Item(new FabricItemSettings()));
    public static final Item POSEIDON = registerItem("poseidon", new Item(new FabricItemSettings()));
    public static final Item ARES = registerItem("ares", new Item(new FabricItemSettings()));
    public static final Item GELO = registerItem("gelo", new Item(new FabricItemSettings()));
    public static final Item ADES = registerItem("ades", new Item(new FabricItemSettings()));
    public static final Item ZEUS = registerItem("zeus", new Item(new FabricItemSettings()));
    public static final Item GRAVETO_DOURADO = registerItem("graveto_dourado", new Item(new FabricItemSettings()));



    // Staffs
    public static final Item WIND_STAFF = registerItem("wind_staff", WindStaffItem.INSTANCE);

    public static final Item FIRE_STAFF = registerItem("fire_staff", FireStaffItem.INSTANCE);


    public static final Item EC_STAFF = registerItem("ec_staff", EnderChestStaffItem.INSTANCE);

    public static final Item THUNDER_STAFF = registerItem("thunder_staff", ThunderStaffItem.INSTANCE);

    public static final Item ICE_STAFF = registerItem("frost_staff", FrostStaffItem.INSTANCE);

    public static final Item POSEIDON_STAFF = registerItem("poseidon_staff", WaterStaffItem.INSTANCE);




    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ArmorItem(ModArmorMaterials.RUBY,ArmorItem.Type.HELMET,new FabricItemSettings()));

    public static final Item RUBY_CHEST = registerItem("ruby_chest",
            new ArmorItem(ModArmorMaterials.RUBY,ArmorItem.Type.CHESTPLATE,new FabricItemSettings()));

    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ArmorItem(ModArmorMaterials.RUBY,ArmorItem.Type.LEGGINGS,new FabricItemSettings()));

    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ArmorItem(ModArmorMaterials.RUBY,ArmorItem.Type.BOOTS,new FabricItemSettings()));






    public static final Item CAPACETE_POSEIDON = registerItem("deus_capacete_poseidon",
            new HelmetOfPoseidon(ModArmorEffects.RUBY, ArmorItem.Type.HELMET, new FabricItemSettings()));


    public static final Item BOTA_DE_HERMES = registerItem("deus_bota_hermes",
            new BootOfHermes(ModArmorEffects.RUBY,ArmorItem.Type.BOOTS,new FabricItemSettings()));

    public static final Item CALCA_ATENA = registerItem("deus_calca_atena",
            new AtenaLeggings(ModArmorEffects.RUBY,ArmorItem.Type.LEGGINGS,new FabricItemSettings()));

    public static final Item COLETE_ARES = registerItem("deus_colete_ares",
            new AresChestplate(ModArmorEffects.RUBY,ArmorItem.Type.CHESTPLATE,new FabricItemSettings()));











    public static final Item AZEITONA = registerItem("azeitona", new Item(new FabricItemSettings().food(ModFoodComponents.AZEITONA)));

    public static final Item AMBROSIA = registerItem("ambrosia", new Item(new FabricItemSettings().food(ModFoodComponents.AMBROSIA)));



    public static final Item POTATO_SWORD = registerItem("espada",
    new SwordItem(SwordToolMaterial.INSTANCE, 11, -2.4F, new Item.Settings()));

    public static final Item ESPADA_RUBY = registerItem("espada_ruby",
            new SwordItem(SwordToolMaterial.INSTANCE, 8, -2.4F, new Item.Settings()));








    public static final Item PICARETA_RUBY = registerItem("picareta_ruby",
            new PickaxeItem(PichaxeToolMaterial.INSTANCE, 0, 2,new Item.Settings()));







    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {

        entries.add(RUBY);


    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering Mod Items for "+ TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
