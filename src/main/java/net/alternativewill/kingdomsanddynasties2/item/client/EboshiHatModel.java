package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.EboshiHatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EboshiHatModel extends GeoModel<EboshiHatItem> {
    @Override
    public ResourceLocation getModelResource(EboshiHatItem EboshiHatItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/eboshi_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EboshiHatItem EboshiHatItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/eboshi_hat_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EboshiHatItem EboshiHatItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
