package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.HoshiKabutoItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.SujiKabutoItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HoshiKabutoModel extends GeoModel<HoshiKabutoItem> {
    @Override
    public ResourceLocation getModelResource(HoshiKabutoItem HoshiKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/hoshi_kabuto.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HoshiKabutoItem HoshiKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/hoshi_kabuto_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HoshiKabutoItem HoshiKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
