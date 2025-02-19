package net.petrus.testmod.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.petrus.testmod.TestMod;
import net.petrus.testmod.item.ModItems;

public class ModModelPredicateProvider {
    public static void registerModModels () {
        ModelPredicateProviderRegistry.register(ModItems.DATA_TABLET, new Identifier(TestMod.MOD_ID, "on"),
                (stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f);

        registerBow(ModItems.MAGIC_BLANKET_BOW);

        ModelPredicateProviderRegistry.register(ModItems.MAGIC_BLANKET_SHIELD, new Identifier("blocking"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);
    }

    private static void registerBow (Item bow) {
        ModelPredicateProviderRegistry.register(new Identifier("pull"), (stack, world, entity, seed) -> {
            if(entity == null) {
                return 0.0f;
            } else {
                return entity.getActiveItem() != stack ? 0.0f : (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
            }
        });
        ModelPredicateProviderRegistry.register(bow, new Identifier("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);
    }
}
