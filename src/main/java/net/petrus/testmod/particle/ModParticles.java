package net.petrus.testmod.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.petrus.testmod.TestMod;

public class ModParticles {
    public static final DefaultParticleType MAGIC_BLANKET_PARTICLE =
            registerParticle("magic_blanket_particle", FabricParticleTypes.simple());

    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(TestMod.MOD_ID, name), particleType);
    }

    public static void registerParticles () {
        TestMod.LOGGER.info("Registering Particles for " + TestMod.MOD_ID);
    }
}
