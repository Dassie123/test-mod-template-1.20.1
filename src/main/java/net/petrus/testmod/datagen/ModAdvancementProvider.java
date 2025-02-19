package net.petrus.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.petrus.testmod.TestMod;
import net.petrus.testmod.item.ModItems;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.MAGIC_BLANKET), Text.literal("Testmod"), Text.literal("The Heart of the SMMEC"),
                        new Identifier(TestMod.MOD_ID, "textures/block/magic_blanket_ore.png"), AdvancementFrame.TASK,
                                true, true, false))
                .criterion("has_magic_blanket", InventoryChangedCriterion.Conditions.items(ModItems.MAGIC_BLANKET))
                .build(consumer, TestMod.MOD_ID + ":testmod");

       Advancement treasureFinder = Advancement.Builder.create()
               .display(new AdvancementDisplay(new ItemStack(ModItems.TREASURE_FINDER), Text.literal("Treasure Finder"), Text.literal("Your number one partner in making a fortune"),
                       new Identifier(TestMod.MOD_ID, "textures/block/magic_blanket_ore"), AdvancementFrame.TASK,
                       true, true, false))
               .criterion("has_used_treasure_finder", InventoryChangedCriterion.Conditions.items(ModItems.TREASURE_FINDER))
               .parent(rootAdvancement)
               .build(consumer, TestMod.MOD_ID + ":treasure_finder");
    }
}
