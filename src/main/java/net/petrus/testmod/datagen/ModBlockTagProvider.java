package net.petrus.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.petrus.testmod.block.ModBlocks;
import net.petrus.testmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Blocks.TREASURE_FINDER_DETECTABLE_BLOCKS)
                .add(Blocks.CHEST)
                .forceAddTag(BlockTags.PLANKS)
                .forceAddTag(BlockTags.STONE_BRICKS)
                .forceAddTag(BlockTags.FENCES)
                .add(Blocks.END_PORTAL_FRAME)
                .add(Blocks.COBWEB)
                .add(Blocks.RAIL)
                .add(Blocks.MOSSY_COBBLESTONE)
                .add(Blocks.COBBLESTONE)
                .add(Blocks.SPAWNER);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MAGIC_BLANKET_ORE,
                        ModBlocks.MAGIC_BLANKET_BLOCK,
                        ModBlocks.RAW_MAGIC_BLANKET_BLOCK,
                        ModBlocks.DEEPSLATE_MAGIC_BLANKET_ORE,
                        ModBlocks.END_STONE_MAGIC_BLANKET_ORE,
                        ModBlocks.NETHER_MAGIC_BLANKET_ORE,
                        ModBlocks.MUSIC_BLOCK,
                        ModBlocks.MAGIC_BLANKET_STAIRS,
                        ModBlocks.MAGIC_BLANKET_SLAB,
                        ModBlocks.MAGIC_BLANKET_PRESSURE_PLATE,
                        ModBlocks.MAGIC_BLANKET_FENCE,
                        ModBlocks.MAGIC_BLANKET_FENCE_GATE,
                        ModBlocks.MAGIC_BLANKET_WALL,
                        ModBlocks.MAGIC_BLANKET_DOOR,
                        ModBlocks.MAGIC_BLANKET_TRAPDOOR,
                        ModBlocks.MAGIC_BLANKET_LAMP_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_MAGIC_BLANKET_ORE,
                        ModBlocks.END_STONE_MAGIC_BLANKET_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MAGIC_BLANKET_ORE,
                        ModBlocks.MAGIC_BLANKET_BLOCK,
                        ModBlocks.RAW_MAGIC_BLANKET_BLOCK);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.MAGIC_BLANKET_WALL);
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.MAGIC_BLANKET_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.MAGIC_BLANKET_FENCE_GATE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.NETHER_MAGIC_BLANKET_ORE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_5")))
                .add(ModBlocks.DEEPSLATE_MAGIC_BLANKET_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.PAXEL_MINEABLE)
                .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(BlockTags.AXE_MINEABLE)
                .forceAddTag(BlockTags.SHOVEL_MINEABLE);
    }
}
