package net.petrus.testmod.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class MagicBlanketParticle extends SpriteBillboardParticle {
    public MagicBlanketParticle(ClientWorld world, double xCoord, double yCoord, double zCoord,
                                SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(world, xCoord, yCoord, zCoord, xd, yd, zd);

        this.velocityMultiplier = 0.5f;
        this.velocityX = xd;
        this.velocityY = yd;
        this.velocityX = zd;

        this.scale *= 0.75f;
        this.maxAge = 10;
        this.setSpriteForAge(spriteSet);

        this.red = 1;
        this.green = 1;
        this.blue = 1;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle (DefaultParticleType particleType, ClientWorld clientWorld,
                                        double x, double y, double z, double xd, double yd, double zd) {
            return new MagicBlanketParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd);
        }
    }
}
