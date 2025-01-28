package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.DomaruArmorItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DomaruArmorModel extends GeoModel<DomaruArmorItem> {
    @Override
    public ResourceLocation getModelResource(DomaruArmorItem domaruArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/domaru.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DomaruArmorItem domaruArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/domaru_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DomaruArmorItem domaruArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
