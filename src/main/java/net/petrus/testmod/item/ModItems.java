package net.petrus.testmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.petrus.testmod.TestMod;
import net.petrus.testmod.block.ModBlocks;
import net.petrus.testmod.item.custom.*;

public class ModItems {
    public static final Item MAGIC_BLANKET = registerItem("magic_blanket",
            new Item(new FabricItemSettings()));
    public static final Item RAW_MAGIC_BLANKET = registerItem("raw_magic_blanket",
            new Item(new FabricItemSettings()));

    public static final Item TREASURE_FINDER = registerItem("treasure_finder",
            new TreasureFinderItem(new FabricItemSettings().maxDamage(256)));

    public static final Item BROCCOLI = registerItem("broccoli",
            new Item(new FabricItemSettings().food(ModFoodComponents.BROCCOLI)));
    public static final Item COAL_COKE = registerItem("coal_coke",
            new Item(new FabricItemSettings()));

    public static final Item MAGIC_BLANKET_SWORD = registerItem("magic_blanket_sword",
            new ModDeathPlungeBladeItem(ModToolMaterial.MAGIC_BLANKET, 0, -2.4f, new FabricItemSettings()));
    public static final Item MAGIC_BLANKET_PICKAXE = registerItem("magic_blanket_pickaxe",
            new PickaxeItem(ModToolMaterial.MAGIC_BLANKET, 0, -2.4f, new FabricItemSettings()));
    public static final Item MAGIC_BLANKET_SHOVEL = registerItem("magic_blanket_shovel",
            new ShovelItem(ModToolMaterial.MAGIC_BLANKET, 0, -2.4f, new FabricItemSettings()));
    public static final Item MAGIC_BLANKET_AXE = registerItem("magic_blanket_axe",
            new AxeItem(ModToolMaterial.MAGIC_BLANKET, 0, -2.4f, new FabricItemSettings()));
    public static final Item MAGIC_BLANKET_HOE = registerItem("magic_blanket_hoe",
            new HoeItem(ModToolMaterial.MAGIC_BLANKET, 0, -2.4f, new FabricItemSettings()));

    public static final Item MAGIC_BLANKET_PAXEL = registerItem("magic_blanket_paxel",
            new PaxelItem(ModToolMaterial.MAGIC_BLANKET, 0, 0f, new FabricItemSettings()));

    public static final Item MAGIC_BLANKET_HELMET = registerItem("magic_blanket_helmet",
            new ModArmorItem(ModArmorMaterials.MAGIC_BLANKET, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item MAGIC_BLANKET_CHESTPLATE = registerItem("magic_blanket_chestplate",
            new ModArmorItem(ModArmorMaterials.MAGIC_BLANKET, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item MAGIC_BLANKET_LEGGINGS = registerItem("magic_blanket_leggings",
            new ModArmorItem(ModArmorMaterials.MAGIC_BLANKET, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item MAGIC_BLANKET_BOOTS = registerItem("magic_blanket_boots",
            new ModArmorItem(ModArmorMaterials.MAGIC_BLANKET, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item MAGIC_BLANKET_HORSE_ARMOR = registerItem("magic_blanket_horse_armor",
            new HorseArmorItem(14, "magic_blanket", new FabricItemSettings()));

    public static final Item DATA_TABLET = registerItem("data_tablet",
            new DataTabletItem(new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        entries.add(MAGIC_BLANKET);
        entries.add(RAW_MAGIC_BLANKET);

        entries.add(ModBlocks.MAGIC_BLANKET_BLOCK);
        entries.add(ModBlocks.RAW_MAGIC_BLANKET_BLOCK);
        entries.add(ModBlocks.DEEPSLATE_MAGIC_BLANKET_ORE);
        entries.add(ModBlocks.END_STONE_MAGIC_BLANKET_ORE);
        entries.add(ModBlocks.NETHER_MAGIC_BLANKET_ORE);
        entries.add(ModBlocks.MAGIC_BLANKET_ORE);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
