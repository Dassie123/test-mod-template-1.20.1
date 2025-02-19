package net.petrus.testmod.util;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.petrus.testmod.command.ReturnHomeCommand;
import net.petrus.testmod.command.SetHomeCommand;
import net.petrus.testmod.event.AttackEntityHandler;
import net.petrus.testmod.event.PlayerCopyHandler;
import net.petrus.testmod.item.ModItems;
import net.petrus.testmod.mixin.BrewingRecipeRegistryMixin;
import net.petrus.testmod.potion.ModPotions;
import net.petrus.testmod.villager.ModVillagers;

public class ModRegistries {
    public static void registerModStuffs () {
        registerFuels();
        registerModCompostables();
        registerCommands();
        registerEvents();
        registerPotionRecipes();
        registerCustomTrades();
    }

    private static void registerFuels () {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.COAL_COKE, 200);
    }

    private static void registerModCompostables () {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.BROCCOLI, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.BROCCOLI_SEEDS, 0.25f);
    }

    private static void registerCommands () {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);

    }

    public static void registerEvents () {
        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
        ServerPlayerEvents.COPY_FROM.register(new PlayerCopyHandler());
    }

    private static void registerPotionRecipes () {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.MAGIC_BLANKET, ModPotions.SLIMEY_POTION);
    }

    private static void registerCustomTrades () {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                                factories.add((entity, random) -> new TradeOffer(
                                        new ItemStack(Items.EMERALD, 2),
                                        new ItemStack(ModItems.BROCCOLI, 2), 6, 2, 0.02f
                                ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1,
                factories -> {
                                factories.add((entity, random) -> new TradeOffer(
                                        new ItemStack(Items.EMERALD, 16),
                                        new ItemStack(ModItems.MAGIC_BLANKET_PAXEL, 1), 2, 6, 0.08f
                                ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 1,
                factories -> {
                                factories.add((entity, random) -> new TradeOffer(
                                        new ItemStack(Items.EMERALD, 4),
                                        new ItemStack(ModItems.RADIATION_STAFF, 1), 6, 19, 0.08f
                                ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 2,
                factories -> {
                                factories.add((entity, random) -> new TradeOffer(
                                        new ItemStack(Items.EMERALD, 16),
                                        new ItemStack(ModItems.TREASURE_FINDER, 1), 1, 5, 0.08f
                                ));
                });
    }
}
