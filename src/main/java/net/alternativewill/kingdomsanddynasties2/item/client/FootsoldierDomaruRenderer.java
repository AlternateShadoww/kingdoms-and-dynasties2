package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.FootsoldierDomaruItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.renderer.DyeableGeoArmorRenderer;

public class FootsoldierDomaruRenderer extends DyeableGeoArmorRenderer<FootsoldierDomaruItem> {

    public static final String PRIMARY_PART = "_primary";
    public static final String SECONDARY_PART = "_secondary";
    public static final String GOLD_PART = "_gold";
    public static final String SILVER_PART = "_silver";
    public static final String CRAFTING_TABLE_PART = "_craftingtable";

    public FootsoldierDomaruRenderer() {
        super(new FootsoldierDomaruModel());
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

        if (itemStack.getItem() instanceof FootsoldierDomaruItem armorItem) {
            int primaryColor = armorItem.getPrimaryColor(itemStack);
            int secondaryColor = armorItem.getSecondaryColor(itemStack);
            int goldColor = armorItem.getGoldColor(itemStack);
            int silverColor = armorItem.getSilverColor(itemStack);
            int craftingTableColor = armorItem.getCraftingTableColor(itemStack);

            String boneName = geoBone.getName();

            if (boneName.endsWith(FootsoldierDomaruRenderer.PRIMARY_PART)) {
                return applyDyeToBone(geoBone, primaryColor, FootsoldierDomaruRenderer.PRIMARY_PART);
            } else if (boneName.endsWith(FootsoldierDomaruRenderer.SECONDARY_PART)) {
                return applyDyeToBone(geoBone, secondaryColor, FootsoldierDomaruRenderer.SECONDARY_PART);
            } else if (boneName.endsWith(FootsoldierDomaruRenderer.GOLD_PART)) {
                return applyDyeToBone(geoBone, goldColor, FootsoldierDomaruRenderer.GOLD_PART);
            } else if (boneName.endsWith(FootsoldierDomaruRenderer.SILVER_PART)) {
                return applyDyeToBone(geoBone, silverColor, FootsoldierDomaruRenderer.SILVER_PART);
            } else if (boneName.endsWith(FootsoldierDomaruRenderer.CRAFTING_TABLE_PART)) {
                return applyDyeToBone(geoBone, craftingTableColor, FootsoldierDomaruRenderer.CRAFTING_TABLE_PART);
            }
        }

        return Color.ofOpaque(FootsoldierDomaruItem.STANDARD_COLOR);
    }

    public Color applyDyeToBone(GeoBone geoBone, int color, String boneEndsWith) {
        GeoBone parentBone = geoBone.getParent();
        if (parentBone == null || !parentBone.getName().endsWith(boneEndsWith)) {
            return Color.ofOpaque(color);
        }
        return Color.ofOpaque(FootsoldierDomaruItem.STANDARD_COLOR);
    }
}