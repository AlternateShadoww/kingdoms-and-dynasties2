package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.TenguMaskItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class TenguMaskModel extends GeoModel<TenguMaskItem> {
    @Override
    public ResourceLocation getModelResource(TenguMaskItem tenguMaskItem) {
        ArmorItem.Type armorType = tenguMaskItem.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "tengu_mask";
                break;
            default:
                fileName = "tengu_mask"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TenguMaskItem tenguMaskItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/tengu.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TenguMaskItem tenguMaskItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
