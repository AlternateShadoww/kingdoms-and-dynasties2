package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.ToppainariKabutoItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.renderer.DyeableGeoArmorRenderer;

public class ToppainariKabutoRenderer extends DyeableGeoArmorRenderer<ToppainariKabutoItem> {

    public static final String PRIMARY_PART = "_primary";
    public static final String SECONDARY_PART = "_secondary";
    public static final String GOLD_PART = "_gold";
    public static final String SILVER_PART = "_silver";
    public static final String CRAFTING_TABLE_PART = "_craftingtable";

    public ToppainariKabutoRenderer() {
        super(new ToppainariKabutoModel());
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

        if (itemStack.getItem() instanceof ToppainariKabutoItem armorItem) {
            int primaryColor = armorItem.getPrimaryColor(itemStack);
            int secondaryColor = armorItem.getSecondaryColor(itemStack);
            int goldColor = armorItem.getGoldColor(itemStack);
            int silverColor = armorItem.getSilverColor(itemStack);
            int craftingTableColor = armorItem.getCraftingTableColor(itemStack);

            String boneName = geoBone.getName();

            if (boneName.endsWith(ToppainariKabutoRenderer.PRIMARY_PART)) {
                return applyDyeToBone(geoBone, primaryColor, ToppainariKabutoRenderer.PRIMARY_PART);
            } else if (boneName.endsWith(ToppainariKabutoRenderer.SECONDARY_PART)) {
                return applyDyeToBone(geoBone, secondaryColor, ToppainariKabutoRenderer.SECONDARY_PART);
            } else if (boneName.endsWith(ToppainariKabutoRenderer.GOLD_PART)) {
                return applyDyeToBone(geoBone, goldColor, ToppainariKabutoRenderer.GOLD_PART);
            } else if (boneName.endsWith(ToppainariKabutoRenderer.SILVER_PART)) {
                return applyDyeToBone(geoBone, silverColor, ToppainariKabutoRenderer.SILVER_PART);
            } else if (boneName.endsWith(ToppainariKabutoRenderer.CRAFTING_TABLE_PART)) {
                return applyDyeToBone(geoBone, craftingTableColor, ToppainariKabutoRenderer.CRAFTING_TABLE_PART);
            }
        }

        return Color.ofOpaque(ToppainariKabutoItem.STANDARD_COLOR);
    }

    public Color applyDyeToBone(GeoBone geoBone, int color, String boneEndsWith) {
        GeoBone parentBone = geoBone.getParent();
        if (parentBone == null || !parentBone.getName().endsWith(boneEndsWith)) {
            return Color.ofOpaque(color);
        }
        return Color.ofOpaque(OyoroiArmorItem.STANDARD_COLOR);
    }
}