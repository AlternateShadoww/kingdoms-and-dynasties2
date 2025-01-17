package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.EboshiKabutoItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.JingasaItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class JingasaModel extends GeoModel<JingasaItem> {
    @Override
    public ResourceLocation getModelResource(JingasaItem jingasaItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/jingasa.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(JingasaItem jingasaItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/jingasa.texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(JingasaItem jingasaItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
