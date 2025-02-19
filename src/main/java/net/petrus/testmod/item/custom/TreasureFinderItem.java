package net.petrus.testmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.petrus.testmod.item.ModItems;
import net.petrus.testmod.particle.ModParticles;
import net.petrus.testmod.sound.ModSounds;
import net.petrus.testmod.util.InventoryUtil;
import net.petrus.testmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TreasureFinderItem extends Item {
    public TreasureFinderItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState blockState = context.getWorld().getBlockState(positionClicked.down(i));
                Block block = blockState.getBlock();

                if(isValuableBlock(blockState)) {
                    outputValuableCoordinates(positionClicked.down(i), player, block);
                    foundBlock = true;

                    if(InventoryUtil.hasPlayerStackInventory(player, ModItems.DATA_TABLET)) {
                        addNbtDataToDataTablet(player, positionClicked.down(i), block);
                    }

                    spawnFoundParticles(context, positionClicked, blockState);

                    context.getWorld().playSound(null, positionClicked, ModSounds.TREASURE_FINDER_FOUND_TREASURE,
                            SoundCategory.BLOCKS, 1f, 1f);

                    break;
                }
            }

            if(!foundBlock) {
                player.sendMessage(Text.translatable("item.testmod.treasure_finder.no_treasure"));
            }
        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void spawnFoundParticles(ItemUsageContext context, BlockPos positionClicked, BlockState blockState) {
        for(int i = 0; i < 20; i++) {
            ServerWorld world =((ServerWorld) context.getWorld());

            world.spawnParticles(/*ModParticles.MAGIC_BLANKET_PARTICLE*/new BlockStateParticleEffect(ParticleTypes.BLOCK, blockState),
                    positionClicked.getX() + 0.5d, positionClicked.getY() + 1, positionClicked.getZ() + 0.5d, 2,
                    Math.cos(i * 18) + 0.25d, 0.15d, Math.sin(i * 18) * 0.25d, 1f);
        }
    }

    private void addNbtDataToDataTablet(PlayerEntity player, BlockPos position, Block block) {
        ItemStack dataTabletStack = player.getInventory().getStack(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET));

        NbtCompound nbtData = new NbtCompound();
        nbtData.putString("testmod.last_treasure_found","Treasure Found: " + block.getName().getString() + " at " +
                "(" + position.getX() + ", " + position.getY() + ", " + position.getZ() + ")");

        dataTabletStack.setNbt(nbtData);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.testmod.treasure_finder.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("tooltip.testmod.treasure_finder.tooltip"));
        }
    }

    private void outputValuableCoordinates(BlockPos position, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Treasure Found: " + block.getName().getString() + " at " +
                "(" + position.getX() + ", " + position.getY() + ", " + position.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState blockState) {
        return blockState.isIn(ModTags.Blocks.TREASURE_FINDER_DETECTABLE_BLOCKS);
    }
}
