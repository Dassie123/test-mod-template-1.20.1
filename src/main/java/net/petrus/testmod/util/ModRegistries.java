package net.petrus.testmod.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.petrus.testmod.item.ModItems;

public class ModRegistries {
    public static void registerModStuffs () {
        registerFuels();
    }

    private static void registerFuels () {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.COAL_COKE, 200);
    }

}
