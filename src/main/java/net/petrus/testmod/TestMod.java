package net.petrus.testmod;

import net.fabricmc.api.ModInitializer;

import net.petrus.testmod.block.ModBlocks;
import net.petrus.testmod.effect.ModEffects;
import net.petrus.testmod.enchantment.ModEnchantments;
import net.petrus.testmod.fluid.ModFluids;
import net.petrus.testmod.item.ModItemGroup;
import net.petrus.testmod.item.ModItems;
import net.petrus.testmod.painting.ModPaintings;
import net.petrus.testmod.particle.ModParticles;
import net.petrus.testmod.potion.ModPotions;
import net.petrus.testmod.sound.ModSounds;
import net.petrus.testmod.util.ModLootTableModifiers;
import net.petrus.testmod.util.ModRegistries;
import net.petrus.testmod.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();

		ModEnchantments.registerModEnchantments();

		ModSounds.registerSounds();

		ModLootTableModifiers.modifyLootTables();

		ModPaintings.registerPaintings();

		ModEffects.registerStatusEffects();

		ModPotions.registerPotions();

		ModParticles.registerParticles();

		ModVillagers.registerVillagers();

		ModFluids.registerFluids();
	}
}


