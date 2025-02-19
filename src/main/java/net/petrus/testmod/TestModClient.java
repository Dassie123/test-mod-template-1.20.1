package net.petrus.testmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.ModelIdentifier;
import net.petrus.testmod.block.ModBlocks;
import net.petrus.testmod.fluid.ModFluids;
import net.petrus.testmod.particle.ModParticles;
import net.petrus.testmod.particle.MagicBlanketParticle;
import net.petrus.testmod.util.ModModelPredicateProvider;

public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAGIC_BLANKET_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAGIC_BLANKET_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BROCCOLI_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ARUM_LILY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ARUM_LILY, RenderLayer.getCutout());

        ParticleFactoryRegistry.getInstance().register(ModParticles.MAGIC_BLANKET_PARTICLE, MagicBlanketParticle.Factory::new);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER,
                SimpleFluidRenderHandler.coloredWater(0xA1E038D0));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER);

        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> new ModelIdentifier(TestMod.MOD_ID, "radiation_staff_3d", "inventory"));

        ModModelPredicateProvider.registerModModels();
    }
}
