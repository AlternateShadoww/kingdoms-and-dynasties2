package net.alternativewill.kingdomsanddynasties2.item.custom;

import net.alternativewill.kingdomsanddynasties2.item.client.RendererInstances;
import net.alternativewill.kingdomsanddynasties2.item.client.ToppainariKabutoRenderer;
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

public class ToppainariKabutoItem extends DyeableArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    // Standard Colors
    public static final int STANDARD_CRAFTING_TABLE_COLOR = 16777215;
    public static final int STANDARD_PRIMARY_COLOR = 11579568;
    public static final int STANDARD_SECONDARY_COLOR = 16777215;
    public static final int STANDARD_GOLD_COLOR = 15124606;
    public static final int STANDARD_SILVER_COLOR = 16777215;
    public static final int STANDARD_COLOR = 16777215;

    public static final String PRIMARY_PART = "primary";
    public static final String SECONDARY_PART = "secondary";
    public static final String GOLD_PART = "gold";
    public static final String SILVER_PART = "silver";
    public static final String CRAFTING_TABLE_PART = "color";

    public ToppainariKabutoItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private ToppainariKabutoRenderer renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                   EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null)
                    this.renderer = new ToppainariKabutoRenderer();

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return RendererInstances.TOPPAINARI_ITEM_RENDERER;
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

    public void setPrimaryColor(@NotNull ItemStack stack, int color) {
        setColorTag(stack, ToppainariKabutoItem.PRIMARY_PART, color, STANDARD_PRIMARY_COLOR);
    }

    public void setSecondaryColor(@NotNull ItemStack stack, int color) {
        setColorTag(stack, ToppainariKabutoItem.SECONDARY_PART, color, STANDARD_SECONDARY_COLOR);
    }

    public void setGoldColor(@NotNull ItemStack stack, int color) {
        setColorTag(stack, ToppainariKabutoItem.GOLD_PART, color, STANDARD_GOLD_COLOR);
    }

    public void setSilverColor(@NotNull ItemStack stack, int color) {
        setColorTag(stack, ToppainariKabutoItem.SILVER_PART, color, STANDARD_SILVER_COLOR);
    }

    public int getPrimaryColor(@NotNull ItemStack stack) {
        return getColorTag(stack, ToppainariKabutoItem.PRIMARY_PART, STANDARD_PRIMARY_COLOR);
    }

    public int getSecondaryColor(@NotNull ItemStack stack) {
        return getColorTag(stack, ToppainariKabutoItem.SECONDARY_PART, STANDARD_SECONDARY_COLOR);
    }

    public int getGoldColor(@NotNull ItemStack stack) {
        return getColorTag(stack, ToppainariKabutoItem.GOLD_PART, STANDARD_GOLD_COLOR);
    }

    public int getSilverColor(@NotNull ItemStack stack) {
        return getColorTag(stack, ToppainariKabutoItem.SILVER_PART, STANDARD_SILVER_COLOR);
    }

    @Override
    public int getColor(@NotNull ItemStack stack) {
        return getColorTag(stack, ToppainariKabutoItem.CRAFTING_TABLE_PART, STANDARD_CRAFTING_TABLE_COLOR);
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

    public void undoColor(ItemStack stack, int buttonIndex) {
        if (stack.getItem() instanceof ToppainariKabutoItem ToppainariKabutoItem) {
            switch (buttonIndex) {
                case 0: // Primary color
                    ToppainariKabutoItem.undoColorTag(stack, PRIMARY_PART, STANDARD_PRIMARY_COLOR);
                    break;
                case 1: // Secondary color
                    ToppainariKabutoItem.undoColorTag(stack, SECONDARY_PART, STANDARD_SECONDARY_COLOR);
                    break;
                case 2: // Gold part
                    ToppainariKabutoItem.undoColorTag(stack, GOLD_PART, STANDARD_GOLD_COLOR);
                    break;
                case 3: // Silver part
                    ToppainariKabutoItem.undoColorTag(stack, SILVER_PART, STANDARD_SILVER_COLOR);
                    break;
                default:
                    break;
            }
        }
    }
}