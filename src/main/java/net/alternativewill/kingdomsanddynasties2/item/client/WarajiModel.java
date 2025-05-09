package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.WarajiItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class WarajiModel extends GeoModel<WarajiItem> {
    @Override
    public ResourceLocation getModelResource(WarajiItem WarajiItem) {
        ArmorItem.Type armorType = WarajiItem.getType();
        String fileName;

        switch (armorType) {
            case BOOTS:
                fileName = "waraji";
                break;
            default:
                fileName = "waraji"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WarajiItem WarajiItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/waraji_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WarajiItem WarajiItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}