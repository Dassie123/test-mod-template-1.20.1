package net.petrus.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.petrus.testmod.block.ModBlocks;
import net.petrus.testmod.item.ModItems;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MAGIC_BLANKET_BLOCK);
        addDrop(ModBlocks.RAW_MAGIC_BLANKET_BLOCK);
        addDrop(ModBlocks.MUSIC_BLOCK);

        addDrop(ModBlocks.MAGIC_BLANKET_ORE, oreDrops(ModBlocks.MAGIC_BLANKET_ORE, ModItems.RAW_MAGIC_BLANKET));
        addDrop(ModBlocks.DEEPSLATE_MAGIC_BLANKET_ORE, oreDrops(ModBlocks.DEEPSLATE_MAGIC_BLANKET_ORE, ModItems.RAW_MAGIC_BLANKET));
        addDrop(ModBlocks.END_STONE_MAGIC_BLANKET_ORE, oreDrops(ModBlocks.END_STONE_MAGIC_BLANKET_ORE, ModItems.RAW_MAGIC_BLANKET));
        addDrop(ModBlocks.NETHER_MAGIC_BLANKET_ORE, oreDrops(ModBlocks.NETHER_MAGIC_BLANKET_ORE, ModItems.RAW_MAGIC_BLANKET));

        addDrop(ModBlocks.MAGIC_BLANKET_STAIRS);
        addDrop(ModBlocks.MAGIC_BLANKET_SLAB, slabDrops(ModBlocks.MAGIC_BLANKET_SLAB));

        addDrop(ModBlocks.MAGIC_BLANKET_BUTTON);
        addDrop(ModBlocks.MAGIC_BLANKET_PRESSURE_PLATE);

        addDrop(ModBlocks.MAGIC_BLANKET_FENCE);
        addDrop(ModBlocks.MAGIC_BLANKET_FENCE_GATE);
        addDrop(ModBlocks.MAGIC_BLANKET_WALL);

        addDrop(ModBlocks.MAGIC_BLANKET_DOOR, doorDrops(ModBlocks.MAGIC_BLANKET_DOOR));
        addDrop(ModBlocks.MAGIC_BLANKET_TRAPDOOR);

        addDrop(ModBlocks.MAGIC_BLANKET_LAMP_BLOCK);

    }
}
