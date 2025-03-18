package net.alternativewill.kingdomsanddynasties2.item.custom;

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
                        arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, power * 3.0F, 1.0F);
                        arrow.setBaseDamage(arrow.getBaseDamage() * 2.0);  // Double the base arrow damage
                        world.addFreshEntity(arrow);
                    }

                    stack.hurtAndBreak(1, player, (e) -> e.broadcastBreakEvent(player.getUsedItemHand()));
                    world.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);
                }
            }
        }
    }
}