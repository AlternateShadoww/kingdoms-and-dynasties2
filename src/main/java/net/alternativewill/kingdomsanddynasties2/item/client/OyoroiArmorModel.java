package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class OyoroiArmorModel extends GeoModel<OyoroiArmorItem> {
    @Override
    public ResourceLocation getModelResource(OyoroiArmorItem oyoroiArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/oyoroi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OyoroiArmorItem oyoroiArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/oyoroi_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OyoroiArmorItem oyoroiArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
