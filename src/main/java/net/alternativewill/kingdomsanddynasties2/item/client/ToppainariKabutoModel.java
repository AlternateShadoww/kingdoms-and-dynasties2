package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.ToppainariKabutoItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ToppainariKabutoModel extends GeoModel<ToppainariKabutoItem> {
    @Override
    public ResourceLocation getModelResource(ToppainariKabutoItem ToppainariKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/toppainari_kabuto.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ToppainariKabutoItem ToppainariKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/toppainari_kabuto_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ToppainariKabutoItem ToppainariKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
