package net.petrus.testmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent BROCCOLI = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1200), 0.25f).build();          // duration is custom, nie deur kaupenjoe
}
