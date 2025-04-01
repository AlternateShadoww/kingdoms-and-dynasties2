package net.alternativewill.kingdomsanddynasties2.item.custom;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class YumiItem extends BowItem {

    public YumiItem(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player) {
            ItemStack ammo = player.getProjectile(stack);

            if (!ammo.isEmpty() || player.getAbilities().instabuild) {
                float power = getPowerForTime(this.getUseDuration(stack) - timeLeft);

                if (power >= 0.1) {
                    if (!world.isClientSide) {
                        AbstractArrow arrow = new Arrow(world, player);
                        arrow.setBaseDamage(arrow.getBaseDamage() * 1.5);
                        arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, power * 4.5F, 0.5F);
                        world.addFreshEntity(arrow);
                    }

                    stack.hurtAndBreak(1, player, (e) -> e.broadcastBreakEvent(player.getUsedItemHand()));
                    world.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);
                }
            }
        }
    }

    public static float getPowerForTime(int pCharge) {
        float f = (float)pCharge / /*change this to make the draw faster or slower -->*/ 40.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }
    //if you do change the draw speed, you have to edit the model too
    //change the value of minecraft:pull in the latter two overrides to multiples of 0.65 and 0.9 respectively, in seconds
}