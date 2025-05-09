package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.HanboItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.MenpoItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HanboModel extends GeoModel<HanboItem> {
    @Override
    public ResourceLocation getModelResource(HanboItem HanboItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/hanbo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HanboItem HanboItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/hanbo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HanboItem HanboItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
