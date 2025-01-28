package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.DomaruArmorItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.renderer.DyeableGeoArmorRenderer;

public class DomaruArmorRenderer extends DyeableGeoArmorRenderer<DomaruArmorItem> {

    public static final String PRIMARY_PART = "_primary";
    public static final String SECONDARY_PART = "_secondary";
    public static final String GOLD_PART = "_gold";
    public static final String SILVER_PART = "_silver";
    public static final String CRAFTING_TABLE_PART = "_craftingtable";

    public DomaruArmorRenderer() {
        super(new DomaruArmorModel());
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

        if (itemStack.getItem() instanceof DomaruArmorItem armorItem) {
            int primaryColor = armorItem.getPrimaryColor(itemStack);
            int secondaryColor = armorItem.getSecondaryColor(itemStack);
            int goldColor = armorItem.getGoldColor(itemStack);
            int silverColor = armorItem.getSilverColor(itemStack);
            int craftingTableColor = armorItem.getCraftingTableColor(itemStack);

            String boneName = geoBone.getName();

            if (boneName.endsWith(DomaruArmorRenderer.PRIMARY_PART)) {
                return applyDyeToBone(geoBone, primaryColor, DomaruArmorRenderer.PRIMARY_PART);
            } else if (boneName.endsWith(DomaruArmorRenderer.SECONDARY_PART)) {
                return applyDyeToBone(geoBone, secondaryColor, DomaruArmorRenderer.SECONDARY_PART);
            } else if (boneName.endsWith(DomaruArmorRenderer.GOLD_PART)) {
                return applyDyeToBone(geoBone, goldColor, DomaruArmorRenderer.GOLD_PART);
            } else if (boneName.endsWith(DomaruArmorRenderer.SILVER_PART)) {
                return applyDyeToBone(geoBone, silverColor, DomaruArmorRenderer.SILVER_PART);
            } else if (boneName.endsWith(DomaruArmorRenderer.CRAFTING_TABLE_PART)) {
                return applyDyeToBone(geoBone, craftingTableColor, DomaruArmorRenderer.CRAFTING_TABLE_PART);
            }
        }

        return Color.ofOpaque(DomaruArmorItem.STANDARD_COLOR);
    }

    public Color applyDyeToBone(GeoBone geoBone, int color, String boneEndsWith) {
        GeoBone parentBone = geoBone.getParent();
        if (parentBone == null || !parentBone.getName().endsWith(boneEndsWith)) {
            return Color.ofOpaque(color);
        }
        return Color.ofOpaque(DomaruArmorItem.STANDARD_COLOR);
    }
}