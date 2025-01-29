package net.petrus.testmod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.petrus.testmod.TestMod;

public class ModEnchantments {
    public static final Enchantment EVOKER_FANG = register("evoker_fang",
            new EvokerFangEnchantment(Enchantment.Rarity.COMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(TestMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        TestMod.LOGGER.info("Registering ModEnchantments for " + TestMod.MOD_ID);
    }
}
