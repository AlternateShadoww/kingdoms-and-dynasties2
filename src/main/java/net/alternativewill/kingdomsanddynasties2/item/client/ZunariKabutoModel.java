package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.EboshiKabutoItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.ZunariKabutoItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ZunariKabutoModel extends GeoModel<ZunariKabutoItem> {
    @Override
    public ResourceLocation getModelResource(ZunariKabutoItem zunariKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/zunari_kabuto.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ZunariKabutoItem zunariKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/zunari_kabuto.texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ZunariKabutoItem zunariKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
