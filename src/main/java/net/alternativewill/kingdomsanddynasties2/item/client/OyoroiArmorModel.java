package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class OyoroiArmorModel extends GeoModel<OyoroiArmorItem> {
    @Override
    public ResourceLocation getModelResource(OyoroiArmorItem oyoroiArmorItem) {
        ArmorItem.Type armorType = oyoroiArmorItem.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "oyoroi_kabuto";
                break;
            case CHESTPLATE:
                fileName = "oyoroi_do";
                break;
            case LEGGINGS:
                fileName = "oyoroi_haidate";
                break;
            case BOOTS:
                fileName = "oyoroi_geta";
                break;
            default:
                fileName = "oyoroi_do"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OyoroiArmorItem oyoroiArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/oyoroi_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OyoroiArmorItem oyoroiArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}