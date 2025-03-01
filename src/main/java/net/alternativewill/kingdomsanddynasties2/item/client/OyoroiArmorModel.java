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
                fileName = "oyoroi_helmet";
                break;
            case CHESTPLATE:
                fileName = "oyoroi_chestplate";
                break;
            case LEGGINGS:
                fileName = "oyoroi_leggings";
                break;
            case BOOTS:
                fileName = "oyoroi_boots";
                break;
            default:
                fileName = "oyoroi_chestplate"; // Default fallback
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