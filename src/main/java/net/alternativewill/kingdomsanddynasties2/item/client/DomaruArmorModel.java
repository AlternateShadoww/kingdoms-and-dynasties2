package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.DomaruArmorItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class DomaruArmorModel extends GeoModel<DomaruArmorItem> {
    @Override
    public ResourceLocation getModelResource(DomaruArmorItem domaruArmorItem) {
        ArmorItem.Type armorType = domaruArmorItem.getType();
        String fileName;

        switch (armorType) {
            case CHESTPLATE:
                fileName = "domaru_chestplate";
                break;
            case LEGGINGS:
                fileName = "domaru_leggings";
                break;
            case BOOTS:
                fileName = "domaru_boots";
                break;
            default:
                fileName = "domaru_chestplate"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DomaruArmorItem domaruArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/domaru_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DomaruArmorItem domaruArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
