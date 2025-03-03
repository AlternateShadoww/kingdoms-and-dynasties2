package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.KariginuItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.renderer.DyeableGeoArmorRenderer;

public class KariginuRenderer extends DyeableGeoArmorRenderer<KariginuItem> {

    public static final String PRIMARY_PART = "_primary";
    public static final String SECONDARY_PART = "_secondary";
    public static final String GOLD_PART = "_gold";
    public static final String SILVER_PART = "_silver";


    public KariginuRenderer() {
        super(new KariginuModel());
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

        if (itemStack.getItem() instanceof KariginuItem armorItem) {
            int primaryColor = armorItem.getPrimaryColor(itemStack);
            int secondaryColor = armorItem.getSecondaryColor(itemStack);
            int goldColor = armorItem.getGoldColor(itemStack);
            int silverColor = armorItem.getSilverColor(itemStack);


            String boneName = geoBone.getName();

            if (boneName.endsWith(KariginuRenderer.PRIMARY_PART)) {
                return applyDyeToBone(geoBone, primaryColor, KariginuRenderer.PRIMARY_PART);
            } else if (boneName.endsWith(KariginuRenderer.SECONDARY_PART)) {
                return applyDyeToBone(geoBone, secondaryColor, KariginuRenderer.SECONDARY_PART);
            } else if (boneName.endsWith(KariginuRenderer.GOLD_PART)) {
                return applyDyeToBone(geoBone, goldColor, KariginuRenderer.GOLD_PART);
            } else if (boneName.endsWith(KariginuRenderer.SILVER_PART)) {
                return applyDyeToBone(geoBone, silverColor, KariginuRenderer.SILVER_PART);
            }
        }

        return Color.ofOpaque(OyoroiArmorItem.STANDARD_COLOR);
    }

    public Color applyDyeToBone(GeoBone geoBone, int color, String boneEndsWith) {
        return Color.ofOpaque(color);
    }
}