package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.GihakamaItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.KariginuItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KariginuModel extends GeoModel<KariginuItem> {
    @Override
    public ResourceLocation getModelResource(KariginuItem kariginuItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/kariginu.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KariginuItem kariginuItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/kariginu_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KariginuItem kariginuItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }

}
