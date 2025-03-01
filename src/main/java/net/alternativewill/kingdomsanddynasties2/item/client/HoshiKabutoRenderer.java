package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.HoshiKabutoItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.HoshiKabutoItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.renderer.DyeableGeoArmorRenderer;

import java.util.function.Supplier;

public class HoshiKabutoRenderer extends DyeableGeoArmorRenderer<HoshiKabutoItem> {

    public static final String PRIMARY_PART = "_primary";
    public static final String SECONDARY_PART = "_secondary";
    public static final String GOLD_PART = "_gold";
    public static final String SILVER_PART = "_silver";
    public static final String CRAFTING_TABLE_PART = "_craftingtable";

    public HoshiKabutoRenderer() {
        super(new HoshiKabutoModel());
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    protected boolean isBoneDyeable(GeoBone geoBone) {
        return true;
    }

    @Override
    protected @NotNull Color getColorForBone(GeoBone geoBone) {
        ItemStack itemStack = this.currentStack;

        if (itemStack.getItem() instanceof HoshiKabutoItem armorItem) {
            int primaryColor = armorItem.getPrimaryColor(itemStack);
            int secondaryColor = armorItem.getSecondaryColor(itemStack);
            int goldColor = armorItem.getGoldColor(itemStack);
            int silverColor = armorItem.getSilverColor(itemStack);
            int craftingTableColor = armorItem.getCraftingTableColor(itemStack);

            String boneName = geoBone.getName();

            if (boneName.endsWith(HoshiKabutoRenderer.PRIMARY_PART)) {
                return applyDyeToBone(geoBone, primaryColor, HoshiKabutoRenderer.PRIMARY_PART);
            } else if (boneName.endsWith(HoshiKabutoRenderer.SECONDARY_PART)) {
                return applyDyeToBone(geoBone, secondaryColor, HoshiKabutoRenderer.SECONDARY_PART);
            } else if (boneName.endsWith(HoshiKabutoRenderer.GOLD_PART)) {
                return applyDyeToBone(geoBone, goldColor, HoshiKabutoRenderer.GOLD_PART);
            } else if (boneName.endsWith(HoshiKabutoRenderer.SILVER_PART)) {
                return applyDyeToBone(geoBone, silverColor, HoshiKabutoRenderer.SILVER_PART);
            } else if (boneName.endsWith(HoshiKabutoRenderer.CRAFTING_TABLE_PART)) {
                return applyDyeToBone(geoBone, craftingTableColor, HoshiKabutoRenderer.CRAFTING_TABLE_PART);
            }
        }

        return Color.ofOpaque(HoshiKabutoItem.STANDARD_COLOR);
    }

    public Color applyDyeToBone(GeoBone geoBone, int color, String boneEndsWith) {
return Color.ofOpaque(color);
    }
}