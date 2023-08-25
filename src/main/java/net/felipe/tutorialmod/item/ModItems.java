package net.felipe.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.felipe.tutorialmod.TutorialMod;
import net.felipe.tutorialmod.item.staffs.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));


    public static final Item VEX_WING = registerItem("vex_wing", new Item(new FabricItemSettings()));
    // Staffs
    public static final Item WIND_STAFF = registerItem("wind_staff", WindStaffItem.INSTANCE);

    public static final Item FIRE_STAFF = registerItem("fire_staff", FireStaffItem.INSTANCE);
    public static final Item WEATHER_STAFF = registerItem("weather_staff", WeatherStaffItem.INSTANCE);
    public static final Item EC_STAFF = registerItem("ec_staff", EnderChestStaffItem.INSTANCE);

    public static final Item THUNDER_STAFF = registerItem("thunder_staff", ThunderStaffItem.INSTANCE);
    public static final Item LATENT_STAFF = registerItem("latent_staff", new Item(new FabricItemSettings()));

    // Misc
    public static final Item ICE_PROJECTILE = registerItem("frost_projectile", new Item(new FabricItemSettings()));

    public static final Item POTATO_SWORD = registerItem("espada",
    new SwordItem(SwordToolMaterial.INSTANCE, 3, -2.4F, new Item.Settings()));


  /*  public class RegisterItems {

        public static final ArmorMaterial ARMADURA = new CustomArmorMaterial();
        public static final Item CAPACETE = new ArmorItem(ARMADURA, EquipmentSlot.HEAD, new Item.Settings());
        public static final Item PEITA = new ArmorItem(ARMADURA, EquipmentSlot.CHEST, new Item.Settings());
        public static final Item CALCA = new ArmorItem(ARMADURA, EquipmentSlot.LEGS, new Item.Settings());
        public static final Item PE = new ArmorItem(ARMADURA, EquipmentSlot.FEET, new Item.Settings());

    }

    public static void register() {
        Registry.register(Registries.ITEM, new Identifier("capacete1", "custom_material_helmet"), CAPACETE);
        Registry.register(Registries.ITEM, new Identifier("colete1", "custom_material_chestplate"), PEITA);
        Registry.register(Registries.ITEM, new Identifier("calca1", "custom_material_leggings"), CALCA);
        Registry.register(Registries.ITEM, new Identifier("bota1", "custom_material_boots"), PE);
    }






*/



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
