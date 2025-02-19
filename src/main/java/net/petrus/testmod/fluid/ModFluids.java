package net.petrus.testmod.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.petrus.testmod.TestMod;

public class ModFluids {
    public static final FlowableFluid STILL_SOAP_WATER = Registry.register(Registries.FLUID,
            new Identifier(TestMod.MOD_ID, "soap_water"), new SoapWaterFluid.Still());
    public static final FlowableFluid FLOWING_SOAP_WATER = Registry.register(Registries.FLUID,
            new Identifier(TestMod.MOD_ID, "flowing_soap_water"), new SoapWaterFluid.Flowing());

    public static final Block SOAP_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID,
            "soap_water_bucket"), new FluidBlock(ModFluids.STILL_SOAP_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));
    public static final Item SOAP_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID,
            "soap_water_bucket"), new BucketItem(ModFluids.STILL_SOAP_WATER,
                new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

    public static void registerFluids () {
        TestMod.LOGGER.info("Registering Fluid for " + TestMod.MOD_ID);
    }
}
