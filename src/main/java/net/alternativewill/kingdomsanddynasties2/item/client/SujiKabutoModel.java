package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.SujiKabutoItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SujiKabutoModel extends GeoModel<SujiKabutoItem> {
    @Override
    public ResourceLocation getModelResource(SujiKabutoItem SujiKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/suji_kabuto.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SujiKabutoItem SujiKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/suji_kabuto_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SujiKabutoItem SujiKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
