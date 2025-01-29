package net.petrus.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.petrus.testmod.block.ModBlocks;
import net.petrus.testmod.block.custom.MagicBlanketLampBlock;
import net.petrus.testmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool pinkGarnetTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MAGIC_BLANKET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_MAGIC_BLANKET_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLANKET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_MAGIC_BLANKET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_MAGIC_BLANKET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_MAGIC_BLANKET_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MUSIC_BLOCK);

        pinkGarnetTexturePool.stairs(ModBlocks.MAGIC_BLANKET_STAIRS);
        pinkGarnetTexturePool.slab(ModBlocks.MAGIC_BLANKET_SLAB);

        pinkGarnetTexturePool.button(ModBlocks.MAGIC_BLANKET_BUTTON);
        pinkGarnetTexturePool.pressurePlate(ModBlocks.MAGIC_BLANKET_PRESSURE_PLATE);

        pinkGarnetTexturePool.fence(ModBlocks.MAGIC_BLANKET_FENCE);
        pinkGarnetTexturePool.fenceGate(ModBlocks.MAGIC_BLANKET_FENCE_GATE);
        pinkGarnetTexturePool.wall(ModBlocks.MAGIC_BLANKET_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.MAGIC_BLANKET_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.MAGIC_BLANKET_TRAPDOOR);

        registerCustomLamp(blockStateModelGenerator);
    }

    private void registerCustomLamp(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = TexturedModel.CUBE_ALL.upload(ModBlocks.MAGIC_BLANKET_LAMP_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(ModBlocks.MAGIC_BLANKET_LAMP_BLOCK, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.MAGIC_BLANKET_LAMP_BLOCK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(MagicBlanketLampBlock.CLICKED, identifier2, identifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MAGIC_BLANKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_MAGIC_BLANKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.BROCCOLI, Models.GENERATED);
        itemModelGenerator.register(ModItems.COAL_COKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TREASURE_FINDER, Models.GENERATED);

        itemModelGenerator.register(ModItems.MAGIC_BLANKET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MAGIC_BLANKET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MAGIC_BLANKET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MAGIC_BLANKET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MAGIC_BLANKET_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MAGIC_BLANKET_PAXEL, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MAGIC_BLANKET_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MAGIC_BLANKET_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MAGIC_BLANKET_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MAGIC_BLANKET_BOOTS));

        itemModelGenerator.register(ModItems.MAGIC_BLANKET_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.DATA_TABLET, Models.GENERATED);

    }
}
