package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.TaikoItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TaikoModel extends GeoModel<TaikoItem> {
    @Override
    public ResourceLocation getModelResource(TaikoItem taikoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/taiko.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TaikoItem taikoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/item/taiko.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TaikoItem animatable) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/taiko.animation.json");
    }
}
