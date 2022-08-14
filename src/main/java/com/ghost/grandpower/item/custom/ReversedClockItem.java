package com.ghost.grandpower.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;


import java.util.List;

public class ReversedClockItem extends Item {
    public ReversedClockItem(Properties properties) {
        super(properties);
    }

    private void playerDead(Player player){

        if (player.isDeadOrDying()){

            player.setHealth(player.getMaxHealth());

        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {




        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            if (player.isHurt()){
                player.heal(player.getMaxHealth());
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,getRandomNumber()));
            }

            player.getCooldowns().addCooldown(this, 600);

            if (player.isCreative()){
                player.getCooldowns().removeCooldown(this);
            }
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if (Screen.hasShiftDown()){
            components.add(Component.literal("When hurt Right Click will heal to max health ").withStyle(ChatFormatting.DARK_PURPLE));
        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.BOLD.DARK_GRAY));
        }


        super.appendHoverText(stack, level, components, flag);
    }

    private int getRandomNumber() {
        return RandomSource.createNewThreadLocalInstance().nextInt(999);
    }


}