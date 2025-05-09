package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.HappuriItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HappuriModel extends GeoModel<HappuriItem> {
    @Override
    public ResourceLocation getModelResource(HappuriItem HappuriItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/happuri.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HappuriItem HappuriItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/happuri.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HappuriItem HappuriItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
