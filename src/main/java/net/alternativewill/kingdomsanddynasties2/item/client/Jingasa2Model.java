package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.Jingasa2Item;
import net.alternativewill.kingdomsanddynasties2.item.custom.JingasaItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Jingasa2Model extends GeoModel<Jingasa2Item> {
    @Override
    public ResourceLocation getModelResource(Jingasa2Item jingasa2Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/jingasa2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Jingasa2Item jingasa2Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/jingasa2.texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Jingasa2Item jingasa2Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
