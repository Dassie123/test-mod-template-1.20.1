package net.petrus.testmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.petrus.testmod.TestMod;
import net.petrus.testmod.block.custom.MagicBlanketLampBlock;
import net.petrus.testmod.block.custom.MusicBlock;

public class ModBlocks {
    public static final Block MAGIC_BLANKET_BLOCK = registerBlock("magic_blanket_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block RAW_MAGIC_BLANKET_BLOCK = registerBlock("raw_magic_blanket_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block DEEPSLATE_MAGIC_BLANKET_ORE = registerBlock("deepslate_magic_blanket_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE), UniformIntProvider.create(3, 6)));
    public static final Block END_STONE_MAGIC_BLANKET_ORE = registerBlock("end_stone_magic_blanket_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE), UniformIntProvider.create(3, 6)));
    public static final Block NETHER_MAGIC_BLANKET_ORE = registerBlock("nether_magic_blanket_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK), UniformIntProvider.create(3, 6)));
    public static final Block MAGIC_BLANKET_ORE = registerBlock("magic_blanket_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE), UniformIntProvider.create(3, 6)));

    public static final Block MUSIC_BLOCK = registerBlock("music_block",
            new MusicBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block MAGIC_BLANKET_STAIRS = registerBlock("magic_blanket_stairs",
            new StairsBlock(ModBlocks.MAGIC_BLANKET_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block MAGIC_BLANKET_SLAB = registerBlock("magic_blanket_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block MAGIC_BLANKET_BUTTON = registerBlock("magic_blanket_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON), BlockSetType.IRON, 10, true));
    public static final Block MAGIC_BLANKET_PRESSURE_PLATE = registerBlock("magic_blanket_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.STONE_PRESSURE_PLATE), BlockSetType.IRON));

    public static final Block MAGIC_BLANKET_FENCE = registerBlock("magic_blanket_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block MAGIC_BLANKET_FENCE_GATE = registerBlock("magic_blanket_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), WoodType.ACACIA));
    public static final Block MAGIC_BLANKET_WALL = registerBlock("magic_blanket_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block MAGIC_BLANKET_DOOR = registerBlock("magic_blanket_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_DOOR), BlockSetType.IRON));
    public static final Block MAGIC_BLANKET_TRAPDOOR = registerBlock("magic_blanket_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_DOOR), BlockSetType.IRON));


    public static final Block MAGIC_BLANKET_LAMP_BLOCK = registerBlock("magic_blanket_lamp_block",
            new MagicBlanketLampBlock(FabricBlockSettings.create().mapColor(MapColor.RAW_IRON_PINK).instrument(Instrument.BASEDRUM)
                    .strength(4f).requiresTool().luminance(state -> state.get(MagicBlanketLampBlock.CLICKED) ? 15 : 0)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering Modblocks for " + TestMod.MOD_ID);
    }
}
