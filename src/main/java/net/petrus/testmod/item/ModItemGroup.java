package net.petrus.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.petrus.testmod.TestMod;
import net.petrus.testmod.block.ModBlocks;

public class ModItemGroup {
    public static final ItemGroup MAGIC_BLANKET_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestMod.MOD_ID, "magic_blanket_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.magic_blanket_group"))
                    .icon(() -> new ItemStack(ModItems.MAGIC_BLANKET)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MAGIC_BLANKET);
                        entries.add(ModItems.RAW_MAGIC_BLANKET);
                        entries.add(ModItems.TREASURE_FINDER);
                        entries.add(ModItems.BROCCOLI);
                        entries.add(ModItems.COAL_COKE);

                        entries.add(ModItems.MAGIC_BLANKET_SWORD);
                        entries.add(ModItems.MAGIC_BLANKET_PICKAXE);
                        entries.add(ModItems.MAGIC_BLANKET_SHOVEL);
                        entries.add(ModItems.MAGIC_BLANKET_AXE);
                        entries.add(ModItems.MAGIC_BLANKET_HOE);
                        entries.add(ModItems.MAGIC_BLANKET_PAXEL);

                        entries.add(ModItems.MAGIC_BLANKET_HELMET);
                        entries.add(ModItems.MAGIC_BLANKET_CHESTPLATE);
                        entries.add(ModItems.MAGIC_BLANKET_LEGGINGS);
                        entries.add(ModItems.MAGIC_BLANKET_BOOTS);

                        entries.add(ModItems.MAGIC_BLANKET_HORSE_ARMOR);

                        entries.add(ModItems.DATA_TABLET);
                        //hi

                        entries.add(ModBlocks.MAGIC_BLANKET_BLOCK);
                        entries.add(ModBlocks.RAW_MAGIC_BLANKET_BLOCK);

                        entries.add(ModBlocks.DEEPSLATE_MAGIC_BLANKET_ORE);
                        entries.add(ModBlocks.END_STONE_MAGIC_BLANKET_ORE);
                        entries.add(ModBlocks.NETHER_MAGIC_BLANKET_ORE);
                        entries.add(ModBlocks.MAGIC_BLANKET_ORE);

                        entries.add(ModBlocks.MUSIC_BLOCK);

                        entries.add(ModBlocks.MAGIC_BLANKET_STAIRS);
                        entries.add(ModBlocks.MAGIC_BLANKET_SLAB);

                        entries.add(ModBlocks.MAGIC_BLANKET_BUTTON);
                        entries.add(ModBlocks.MAGIC_BLANKET_PRESSURE_PLATE);

                        entries.add(ModBlocks.MAGIC_BLANKET_FENCE);
                        entries.add(ModBlocks.MAGIC_BLANKET_FENCE_GATE);
                        entries.add(ModBlocks.MAGIC_BLANKET_WALL);

                        entries.add(ModBlocks.MAGIC_BLANKET_DOOR);
                        entries.add(ModBlocks.MAGIC_BLANKET_TRAPDOOR);

                        entries.add(ModBlocks.MAGIC_BLANKET_LAMP_BLOCK);

                    }).build());

/*  public static final ItemGroup MAGIC_BLANKET_GROUP_2 = Registry.register(Registries.ITEM_GROUP,                // Proses om meer as een itemgroup te add
            new Identifier(testmodMod.MOD_ID, "MAGIC_BLANKET_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.MAGIC_BLANKET_group"))
                    .icon(() -> new ItemStack(ModItems.MAGIC_BLANKET)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MAGIC_BLANKET);
                        entries.add(ModItems.RAW_MAGIC_BLANKET);

                        entries.add(ModBlocks.MAGIC_BLANKET_BLOCK);
                        entries.add(ModBlocks.RAW_MAGIC_BLANKET_BLOCK);

                    }).build()); */

    public static void registerItemGroups() {

    }
}
