package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.HakamaNewItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.renderer.DyeableGeoArmorRenderer;

public class HakamaRenderer extends DyeableGeoArmorRenderer<HakamaNewItem> {

    public static final String PRIMARY_PART = "_primary";
    public static final String SECONDARY_PART = "_secondary";

    public HakamaRenderer() {
        super(new HakamaModel());
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

        if (itemStack.getItem() instanceof HakamaNewItem armorItem) {
            int primaryColor = armorItem.getPrimaryColor(itemStack);
            int secondaryColor = armorItem.getSecondaryColor(itemStack);

            String boneName = geoBone.getName();

            if (boneName.endsWith(HakamaRenderer.PRIMARY_PART)) {
                return applyDyeToBone(geoBone, primaryColor, HakamaRenderer.PRIMARY_PART);
            } else if (boneName.endsWith(HakamaRenderer.SECONDARY_PART)) {
                return applyDyeToBone(geoBone, secondaryColor, HakamaRenderer.SECONDARY_PART);
            }
        }

        return Color.ofOpaque(OyoroiArmorItem.STANDARD_COLOR);
    }

    public Color applyDyeToBone(GeoBone geoBone, int color, String boneEndsWith) {
        return Color.ofOpaque(color);
    }
}