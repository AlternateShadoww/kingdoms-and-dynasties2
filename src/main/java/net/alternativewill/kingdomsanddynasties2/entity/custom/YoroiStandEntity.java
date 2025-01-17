package net.alternativewill.kingdomsanddynasties2.entity.custom;

import io.netty.buffer.Unpooled;
import net.alternativewill.kingdomsanddynasties2.world.inventory.YoroiStandMenu;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
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

public class YoroiStandEntity extends LivingEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public String WoodUsedInRecipe;

    public YoroiStandEntity(EntityType<? extends LivingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.WoodUsedInRecipe = "red_pine";
    }
    
    private void shakeEntity() {
        this.setDeltaMovement(this.getDeltaMovement().add(0, 0.1, 0));
    }

    private void breakEntity() {
        this.discard();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return createLivingAttributes().add(Attributes.MAX_HEALTH, 100000.0);
    }

    @Override
    public void setCustomNameVisible(boolean pAlwaysRenderNameTag) {
        super.setCustomNameVisible(false);
    }

    @Override
    public @NotNull Iterable<ItemStack> getArmorSlots() {
        return Collections.emptyList();
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
    public @NotNull ItemStack getItemBySlot(EquipmentSlot equipmentSlot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void setItemSlot(EquipmentSlot equipmentSlot, ItemStack itemStack) {
    }

    @Override
    public @NotNull HumanoidArm getMainArm() {
        return HumanoidArm.LEFT;
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

    // Code From Armor Stand
    private void showBreakingParticles() {
        if (this.level() instanceof ServerLevel) {
            ((ServerLevel)this.level())
                    .sendParticles(
                            new BlockParticleOption(ParticleTypes.BLOCK, Blocks.OAK_PLANKS.defaultBlockState()),
                            this.getX(),
                            this.getY(0.6666666666666666),
                            this.getZ(),
                            10,
                            (double)(this.getBbWidth() / 4.0F),
                            (double)(this.getBbHeight() / 4.0F),
                            (double)(this.getBbWidth() / 4.0F),
                            0.05
                    );
        }
    }

    @Override
    protected float tickHeadTurn(float p_31644_, float p_31645_) {
        this.yBodyRotO = this.yRotO;
        this.yBodyRot = this.getYRot();
        return 0.0F;
    }

    @Override
    public void setYBodyRot(float p_31670_) {
        this.yBodyRotO = this.yRotO = p_31670_;
        this.yHeadRotO = this.yHeadRot = p_31670_;
    }

    @Override
    public void setYHeadRot(float p_31668_) {
        this.yBodyRotO = this.yRotO = p_31668_;
        this.yHeadRotO = this.yHeadRot = p_31668_;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void pushEntities() {
        for (Entity entity : this.level().getEntities(this, this.getBoundingBox())) {
            if (this.distanceToSqr(entity) <= 0.2) {
                entity.push(this);
            }
        }
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double p_31574_) {
        double d0 = this.getBoundingBox().getSize() * 4.0;
        if (Double.isNaN(d0) || d0 == 0.0) {
            d0 = 4.0;
        }

        d0 *= 64.0;
        return p_31574_ < d0 * d0;
    }

    @Override
    public void kill() {
        this.remove(Entity.RemovalReason.KILLED);
        this.gameEvent(GameEvent.ENTITY_DIE);
    }

    @Override
    public boolean attackable() {
        return false;
    }
}
