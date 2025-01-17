package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.Jingasa3Item;
import net.alternativewill.kingdomsanddynasties2.item.custom.JingasaItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Jingasa3Model extends GeoModel<Jingasa3Item> {
    @Override
    public ResourceLocation getModelResource(Jingasa3Item jingasa3Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/jingasa3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Jingasa3Item jingasa3Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/jingasa3.texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Jingasa3Item jingasa3Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
