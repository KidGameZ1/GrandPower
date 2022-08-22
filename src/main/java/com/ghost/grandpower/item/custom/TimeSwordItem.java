package com.ghost.grandpower.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class TimeSwordItem extends SwordItem {


    public TimeSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {


        if (player.isHurt()){
            if (player.isShiftKeyDown()){
                player.setInvisible(true);
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,2));
                player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST,5));

                
            }else {
                player.setInvisible(false);
            }

        }

        return super.use(level, player, hand);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {


       if (pTarget.isDeadOrDying()){

       }else {
            if (SwordsPower(pStack, pTarget, pAttacker)){
                pTarget.setHealth(1);
            }
           pTarget.setHealth(1);
       }






        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    public boolean SwordsPower(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.getMaxHealth();

        return true;
    }
}

