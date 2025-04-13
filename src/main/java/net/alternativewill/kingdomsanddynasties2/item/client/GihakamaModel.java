package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.GihakamaItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class GihakamaModel extends GeoModel<GihakamaItem> {
    @Override
    public ResourceLocation getModelResource(GihakamaItem gihakamaItem) {
        ArmorItem.Type armorType = gihakamaItem.getType();
        String fileName;

        switch (armorType) {
            case CHESTPLATE:
                fileName = "gi";
                break;
            case LEGGINGS:
                fileName = "tattsuke_bakama";
                break;
            default:
                fileName = "gi"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GihakamaItem GihakamaItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/hakamagi.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GihakamaItem GihakamaItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}