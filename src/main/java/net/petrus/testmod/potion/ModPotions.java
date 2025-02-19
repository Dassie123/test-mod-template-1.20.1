package net.petrus.testmod.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.petrus.testmod.TestMod;
import net.petrus.testmod.effect.ModEffects;

public class ModPotions {
    public static final Potion SLIMEY_POTION = registerPotion("slimey_potion",
            new Potion(new StatusEffectInstance(ModEffects.SLIMEY, 3600, 0)));

    private static Potion registerPotion (String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(TestMod.MOD_ID, name), potion);
    }

    public static void registerPotions () {
        TestMod.LOGGER.info("Registering Mod Potions for " + TestMod.MOD_ID);
    }
}
