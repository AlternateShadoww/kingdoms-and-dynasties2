package net.alternativewill.kingdomsanddynasties2.entity.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.entity.custom.YoroiStandEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YoroiStandModel extends GeoModel<YoroiStandEntity> {



    @Override
    public ResourceLocation getModelResource(YoroiStandEntity object) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/yoroi_stand.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(YoroiStandEntity object) {
        String woodType = object.WoodUsedInRecipe;
        if (woodType == null) {
            return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/entity/yoroi_stand/yoroi_stand_red_pine.png");
        }
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/entity/yoroi_stand/yoroi_stand_" + woodType + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(YoroiStandEntity animatable) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/yoroi_stand.animation.json");
    }
}
