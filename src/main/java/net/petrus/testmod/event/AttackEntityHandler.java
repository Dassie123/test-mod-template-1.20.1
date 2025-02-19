package net.petrus.testmod.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.petrus.testmod.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class AttackEntityHandler implements AttackEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity,
                                 @Nullable EntityHitResult entityHitResult) {
        if(entity instanceof SheepEntity && !world.isClient() && !player.isSpectator()) {
            if(player.getStackInHand(hand).getItem() == ModItems.MAGIC_BLANKET_SWORD) {
                player.sendMessage(Text.literal(player.getName().getString() + " just hurt a sheep with the Magicblanket Sword"));
            } else {
                player.sendMessage(Text.literal(player.getName().getString() + " just hurt a sheep!"));
            }
        }

        return ActionResult.PASS;
    }
}
