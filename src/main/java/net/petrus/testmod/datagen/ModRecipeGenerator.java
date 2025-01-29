package net.petrus.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.petrus.testmod.block.ModBlocks;
import net.petrus.testmod.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_MAGIC_BLANKET)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('P', ModItems.MAGIC_BLANKET)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.MAGIC_BLANKET), conditionsFromItem(ModItems.MAGIC_BLANKET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_MAGIC_BLANKET) + "_"));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.MAGIC_BLANKET, RecipeCategory.MISC, ModBlocks.MAGIC_BLANKET_BLOCK);

        offerSmelting(exporter, List.of(ModItems.RAW_MAGIC_BLANKET, ModBlocks.MAGIC_BLANKET_ORE, ModBlocks.DEEPSLATE_MAGIC_BLANKET_ORE,
                        ModBlocks.NETHER_MAGIC_BLANKET_ORE, ModBlocks.END_STONE_MAGIC_BLANKET_ORE), RecipeCategory.MISC, ModItems.MAGIC_BLANKET,
                0.25f, 200, "MAGIC_BLANKET");
        offerBlasting(exporter, List.of(ModItems.RAW_MAGIC_BLANKET, ModBlocks.MAGIC_BLANKET_ORE, ModBlocks.DEEPSLATE_MAGIC_BLANKET_ORE,
                        ModBlocks.NETHER_MAGIC_BLANKET_ORE, ModBlocks.END_STONE_MAGIC_BLANKET_ORE), RecipeCategory.MISC, ModItems.MAGIC_BLANKET,
                0.25f, 200, "MAGIC_BLANKET");

    }
}
