package net.felipe.tutorialmod.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SwordToolMaterial implements ToolMaterial {

    public static final SwordToolMaterial INSTANCE = new SwordToolMaterial();





    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 2.0F;
    }

    @Override
    public float getAttackDamage() {
        return 12.0F;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }


}
