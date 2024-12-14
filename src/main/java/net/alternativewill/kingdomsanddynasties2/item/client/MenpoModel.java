package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.MenpoItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MenpoModel extends GeoModel<MenpoItem> {
    @Override
    public ResourceLocation getModelResource(MenpoItem menpoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/menpo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MenpoItem menpoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/menpo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MenpoItem menpoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
