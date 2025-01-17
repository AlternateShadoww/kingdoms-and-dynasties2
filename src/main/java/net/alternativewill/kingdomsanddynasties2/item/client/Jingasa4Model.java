package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.Jingasa4Item;
import net.alternativewill.kingdomsanddynasties2.item.custom.JingasaItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Jingasa4Model extends GeoModel<Jingasa4Item> {
    @Override
    public ResourceLocation getModelResource(Jingasa4Item jingasa4Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/jingasa4.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Jingasa4Item jingasa4Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/jingasa4.texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Jingasa4Item jingasa4Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
