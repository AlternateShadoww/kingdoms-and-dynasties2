package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.HakamaNewItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class HakamaModel extends GeoModel<HakamaNewItem> {
    @Override
    public ResourceLocation getModelResource(HakamaNewItem hakamaItem) {
        ArmorItem.Type armorType = hakamaItem.getType();
        String fileName;

        switch (armorType) {
            case LEGGINGS:
                fileName = "hakama";
                break;
            default:
                fileName = "hakama"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HakamaNewItem HakamaItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/gihakamatexture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HakamaNewItem HakamaItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}