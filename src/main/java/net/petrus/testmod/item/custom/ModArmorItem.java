package net.petrus.testmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.petrus.testmod.item.ModArmorMaterials;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.MAGIC_BLANKET,
                            List.of(new StatusEffectInstance(StatusEffects.RESISTANCE, 400, 5, false, false),
                            new StatusEffectInstance(StatusEffects.WATER_BREATHING, 400, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.STRENGTH, 400, 320, false, false),
                                    new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false,false),
                                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 5, false, false),
                                    new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 400, 5, false, false),
                                    new StatusEffectInstance(StatusEffects.SPEED, 400, 5, false, false),
                                    new StatusEffectInstance(StatusEffects.SATURATION, 400, 0, false, false))).build();

    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient() && entity instanceof PlayerEntity player) {
            if(hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for(Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapStatusEffect);
                break;
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, List<StatusEffectInstance> mapStatusEffect) {
        boolean hasPlayerEffectAlready = mapStatusEffect.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));

        if(!hasPlayerEffectAlready) {
            for(StatusEffectInstance instance : mapStatusEffect) {
                player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(),
                        instance.getDuration(), instance.getAmplifier()));
            }
        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial mapArmorMaterial, PlayerEntity player) {
        for(ItemStack armorStack : player.getArmorItems()) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == mapArmorMaterial && chestplate.getMaterial() == mapArmorMaterial &&
                leggings.getMaterial() == mapArmorMaterial && boots.getMaterial() == mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !boots.isEmpty() && !leggings.isEmpty()
                && !chestplate.isEmpty() && !helmet.isEmpty();
    }
}
