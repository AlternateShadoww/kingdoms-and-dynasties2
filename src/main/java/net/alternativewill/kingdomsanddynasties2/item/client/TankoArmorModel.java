package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.TankoArmorItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class TankoArmorModel extends GeoModel<TankoArmorItem> {
    @Override
    public ResourceLocation getModelResource(TankoArmorItem TankoArmorItem) {
        ArmorItem.Type armorType = TankoArmorItem.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "tanko_kabuto";
                break;
            case CHESTPLATE:
                fileName = "tanko_do";
                break;
            case LEGGINGS:
                fileName = "tanko_haidate";
                break;
            default:
                fileName = "tanko_do"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TankoArmorItem TankoArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/tanko_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TankoArmorItem TankoArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}