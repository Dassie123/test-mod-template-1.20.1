package net.petrus.testmod.datagen;

import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PaintingVariantTags;
import net.minecraft.util.Identifier;
import net.petrus.testmod.TestMod;

import java.util.concurrent.CompletableFuture;

public class ModPaintingVariantTagProvider extends TagProvider<PaintingVariant> {
    public ModPaintingVariantTagProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, RegistryKeys.PAINTING_VARIANT, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(PaintingVariantTags.PLACEABLE)
                .addOptional(new Identifier(TestMod.MOD_ID, "saw_them"))
                .addOptional(new Identifier(TestMod.MOD_ID, "shrimp"))
                .addOptional(new Identifier(TestMod.MOD_ID, "world"));
    }
}
