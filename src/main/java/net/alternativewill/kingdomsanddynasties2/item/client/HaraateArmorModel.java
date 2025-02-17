package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.DomaruArmorItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.HaraateArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HaraateArmorModel extends GeoModel<HaraateArmorItem> {
    @Override
    public ResourceLocation getModelResource(HaraateArmorItem haraateArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/haraate.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HaraateArmorItem haraateArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/haraate_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HaraateArmorItem haraateArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
