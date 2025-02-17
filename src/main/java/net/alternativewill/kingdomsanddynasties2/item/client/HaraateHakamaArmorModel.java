package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.HaraateArmorItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.HaraateHakamaArmorItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HaraateHakamaArmorModel extends GeoModel<HaraateHakamaArmorItem> {
    @Override
    public ResourceLocation getModelResource(HaraateHakamaArmorItem HaraateHakamaArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/haraatehakama.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HaraateHakamaArmorItem HaraateHakamaArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/haraate_hakama_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HaraateHakamaArmorItem HaraateHakamaArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
