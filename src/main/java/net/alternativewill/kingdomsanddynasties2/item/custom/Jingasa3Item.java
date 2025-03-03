package net.alternativewill.kingdomsanddynasties2.item.custom;

import net.alternativewill.kingdomsanddynasties2.item.client.Jingasa3Renderer;
import net.alternativewill.kingdomsanddynasties2.item.client.RendererInstances;
import net.alternativewill.kingdomsanddynasties2.util.ColorCombiner;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

import java.util.List;
import java.util.function.Consumer;

public class Jingasa3Item extends DyeableArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    // Standard Colors
    public static final int STANDARD_CRAFTING_TABLE_COLOR = 14401916;

    public static final int STANDARD_COLOR = 16777215;

    public static final String CRAFTING_TABLE_PART = "color";

    public Jingasa3Item(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private Jingasa3Renderer renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                   EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null)
                    this.renderer = new Jingasa3Renderer();

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return RendererInstances.JINGASA3_ITEM_RENDERER;
            }
        });
    }

    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void setColor(@NotNull ItemStack stack, int color) {
        CompoundTag displayTag = stack.getOrCreateTagElement("display");
        displayTag.putInt(CRAFTING_TABLE_PART, color);
    }


    @Override
    public int getColor(@NotNull ItemStack stack) {
        return getColorTag(stack, Jingasa3Item.CRAFTING_TABLE_PART, STANDARD_CRAFTING_TABLE_COLOR);
    }

    public int getCraftingTableColor(ItemStack stack) {
        return getColor(stack);
    }

    public void wipeColors(@NotNull ItemStack stack, String tag, int color, Player player) {
        CompoundTag displayTag = stack.getOrCreateTagElement("display");

        if (displayTag.contains(tag)) {
            displayTag.remove(tag);

            stack.getOrCreateTagElement("display").putInt(tag, color);

            player.getInventory().armor.set(player.getInventory().armor.indexOf(stack), stack);

            player.getInventory().setChanged();
        } else {
            System.out.println("Tag " + tag + " not found in displayTag from stack: " + stack);
        }
    }


    private void setColorTag(@NotNull ItemStack stack, String tag, int color, int defaultColor) {
        CompoundTag displayTag = stack.getOrCreateTagElement("display");
        int currentColor = displayTag.getInt(tag) == 0 ? defaultColor : displayTag.getInt(tag);
        if (currentColor != color) {
            int blendedColor = ColorCombiner.combineColors(List.of(currentColor, color));
            displayTag.putInt(tag, blendedColor);
        }
    }

    private void undoColorTag(@NotNull ItemStack stack, String tag, int defaultColor) {
        CompoundTag displayTag = stack.getOrCreateTagElement("display");

        if (displayTag.contains("previous_" + tag)) {
            int previousColor = displayTag.getInt("previous_" + tag);
            displayTag.putInt(tag, previousColor);
            displayTag.remove("previous_" + tag);
        } else {
            displayTag.putInt(tag, defaultColor);
        }
    }



    private int getColorTag(@NotNull ItemStack stack, String tag, int defaultColor) {
        CompoundTag compoundTag = stack.getTagElement("display");
        return compoundTag != null && compoundTag.contains(tag, 99) ? compoundTag.getInt(tag) : defaultColor;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }


            }
