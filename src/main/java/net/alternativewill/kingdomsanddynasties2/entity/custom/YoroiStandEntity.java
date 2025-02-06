package net.alternativewill.kingdomsanddynasties2.entity.custom;

import io.netty.buffer.Unpooled;
import net.alternativewill.kingdomsanddynasties2.item.ModItems;
import net.alternativewill.kingdomsanddynasties2.world.inventory.YoroiStandMenu;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Collections;

public class YoroiStandEntity extends ArmorStand implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public String WoodUsedInRecipe;

    public YoroiStandEntity(EntityType<? extends ArmorStand> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.WoodUsedInRecipe = "red_pine";
    }

    @Override
    protected void dropAllDeathLoot(@NotNull DamageSource damageSource) {
        super.dropAllDeathLoot(damageSource);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (!this.level().isClientSide && !this.isRemoved()) {
            if (pSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                this.kill();
                return false;
            } else if (!this.isInvulnerableTo(pSource) && !this.isMarker()) {
                if (pSource.is(DamageTypeTags.IS_EXPLOSION)) {
                    this.brokenByAnything(pSource);
                    this.kill();
                    return false;
                } else if (pSource.is(DamageTypeTags.IGNITES_ARMOR_STANDS)) {
                    if (this.isOnFire()) {
                        this.causeDamage(pSource, 0.15F);
                    } else {
                        this.setSecondsOnFire(5);
                    }

                    return false;
                } else if (pSource.is(DamageTypeTags.BURNS_ARMOR_STANDS) && this.getHealth() > 0.5F) {
                    this.causeDamage(pSource, 4.0F);
                    return false;
                } else {
                    boolean flag = pSource.getDirectEntity() instanceof AbstractArrow;
                    boolean flag1 = flag && ((AbstractArrow)pSource.getDirectEntity()).getPierceLevel() > 0;
                    boolean flag2 = "player".equals(pSource.getMsgId());
                    if (!flag2 && !flag) {
                        return false;
                    } else {
                        Entity entity = pSource.getEntity();
                        if (entity instanceof Player) {
                            Player player = (Player)entity;
                            if (!player.getAbilities().mayBuild) {
                                return false;
                            }
                        }

                        if (pSource.isCreativePlayer()) {
                            this.playBrokenSound();
                            this.showBreakingParticles();
                            this.kill();
                            return flag1;
                        } else {
                            long i = this.level().getGameTime();
                            if (i - this.lastHit > 5L && !flag) {
                                this.level().broadcastEntityEvent(this, (byte)32);
                                this.gameEvent(GameEvent.ENTITY_DAMAGE, pSource.getEntity());
                                this.lastHit = i;
                            } else {
                                this.brokenByPlayer(pSource);
                                this.showBreakingParticles();
                                this.kill();
                            }

                            return true;
                        }
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void showBreakingParticles() {
        if (this.level() instanceof ServerLevel) {
            ((ServerLevel)this.level()).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.OAK_PLANKS.defaultBlockState()), this.getX(), this.getY(0.6666666666666666D), this.getZ(), 10, (double)(this.getBbWidth() / 4.0F), (double)(this.getBbHeight() / 4.0F), (double)(this.getBbWidth() / 4.0F), 0.05D);
        }

    }

    private void causeDamage(DamageSource pDamageSource, float pAmount) {
        float f = this.getHealth();
        f -= pAmount;
        if (f <= 0.5F) {
            this.brokenByAnything(pDamageSource);
            this.kill();
        } else {
            this.setHealth(f);
            this.gameEvent(GameEvent.ENTITY_DAMAGE, pDamageSource.getEntity());
        }

    }

    private void brokenByPlayer(DamageSource pDamageSource) {
        ItemStack itemstack = new ItemStack(ModItems.YOROI_STAND_ITEM.get());
        if (this.hasCustomName()) {
            itemstack.setHoverName(this.getCustomName());
        }

        Block.popResource(this.level(), this.blockPosition(), itemstack);
        this.brokenByAnything(pDamageSource);
    }

    private void brokenByAnything(DamageSource pDamageSource) {
        this.playBrokenSound();
        this.dropAllDeathLoot(pDamageSource);
    }

    // TODO: Add Custom Sound?
    private void playBrokenSound() {
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ARMOR_STAND_BREAK, this.getSoundSource(), 1.0F, 1.0F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return createLivingAttributes().add(Attributes.MAX_HEALTH, 100000.0);
    }

    @Override
    public void setCustomNameVisible(boolean pAlwaysRenderNameTag) {
        super.setCustomNameVisible(false);
    }

    @Override
    public @NotNull InteractionResult interactAt(Player pPlayer, Vec3 pVec, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (itemstack.is(Items.NAME_TAG)) {
            return InteractionResult.PASS;
        }

        if (itemstack.isEmpty()) {
            if (pPlayer instanceof ServerPlayer pServerPlayer) {
                NetworkHooks.openScreen(pServerPlayer, new MenuProvider() {
                    @Override
                    public @NotNull Component getDisplayName() {
                        return Component.literal("Yoroi Stand");
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int pId, @NotNull Inventory pInventory, @NotNull Player player) {
                        FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                        packetBuffer.writeBlockPos(pPlayer.blockPosition());
                        packetBuffer.writeVarInt(YoroiStandEntity.this.getId());
                        return new YoroiStandMenu(pId, pInventory, packetBuffer);
                    }
                }, buf -> {
                    buf.writeBlockPos(pPlayer.blockPosition());
                    buf.writeVarInt(this.getId());
                });
            }

        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "movement", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<YoroiStandEntity> event) {
        return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }
}
