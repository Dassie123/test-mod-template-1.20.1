package net.petrus.testmod;

import net.fabricmc.api.ModInitializer;

import net.petrus.testmod.block.ModBlocks;
import net.petrus.testmod.enchantment.ModEnchantments;
import net.petrus.testmod.item.ModItemGroup;
import net.petrus.testmod.item.ModItems;
import net.petrus.testmod.util.ModRegistries;
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

	}
}


