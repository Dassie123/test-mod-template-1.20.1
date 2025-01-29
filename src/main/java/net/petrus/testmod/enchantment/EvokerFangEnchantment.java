package net.petrus.testmod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class EvokerFangEnchantment extends Enchantment {
    public EvokerFangEnchantment(Rarity weight, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.getWorld().isClient()) {
            ServerWorld world = ((ServerWorld) user.getWorld());
            BlockPos position = target.getBlockPos();

            if(level == 1) {
                EntityType.EVOKER_FANGS.spawn(world, position, SpawnReason.TRIGGERED);
            }

            if(level == 2) {
                EntityType.EVOKER_FANGS.spawn(world, position, SpawnReason.TRIGGERED);
                EntityType.EVOKER_FANGS.spawn(world, position, SpawnReason.TRIGGERED);
            }
        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}

