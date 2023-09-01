package net.felipe.tutorialmod.item;


import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents  {
    public static final FoodComponent AZEITONA = new FoodComponent.Builder().hunger(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200), 0.25f).build();

    public static final FoodComponent AMBROSIA = new FoodComponent.Builder()
            .hunger(20)
            .saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 300, 10), 100f)
            .build();




}