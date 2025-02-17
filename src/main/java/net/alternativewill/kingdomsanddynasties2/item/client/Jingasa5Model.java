package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.Jingasa5Item;
import net.alternativewill.kingdomsanddynasties2.item.custom.JingasaItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Jingasa5Model extends GeoModel<Jingasa5Item> {
    @Override
    public ResourceLocation getModelResource(Jingasa5Item jingasa5Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/jingasa5.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Jingasa5Item jingasa5Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/jingasa5.texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Jingasa5Item jingasa5Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
