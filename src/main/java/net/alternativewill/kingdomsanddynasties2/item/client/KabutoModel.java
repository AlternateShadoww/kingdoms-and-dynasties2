package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.KabutoItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.MenpoItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KabutoModel extends GeoModel<KabutoItem> {
    @Override
    public ResourceLocation getModelResource(KabutoItem kabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/kabuto.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KabutoItem kabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/kabuto_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KabutoItem kabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
