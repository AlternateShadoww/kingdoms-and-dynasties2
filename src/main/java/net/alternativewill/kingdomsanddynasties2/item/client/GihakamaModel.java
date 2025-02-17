package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.GihakamaItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GihakamaModel extends GeoModel<GihakamaItem> {
    @Override
    public ResourceLocation getModelResource(GihakamaItem gihakamaItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/hakamagi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GihakamaItem gihakamaItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/hakamagi.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GihakamaItem gihakamaItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }

}
