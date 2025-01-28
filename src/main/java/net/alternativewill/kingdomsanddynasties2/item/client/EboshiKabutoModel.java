package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.EboshiKabutoItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EboshiKabutoModel extends GeoModel<EboshiKabutoItem> {
    @Override
    public ResourceLocation getModelResource(EboshiKabutoItem eboshiKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/eboshi_kabuto.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EboshiKabutoItem eboshiKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/eboshi_kabuto_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EboshiKabutoItem eboshiKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
