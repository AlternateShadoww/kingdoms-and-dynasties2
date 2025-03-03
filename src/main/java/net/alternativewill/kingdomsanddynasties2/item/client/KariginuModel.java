package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.KariginuItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class KariginuModel extends GeoModel<KariginuItem> {
    @Override
    public ResourceLocation getModelResource(KariginuItem kariginuItem) {
        ArmorItem.Type armorType = kariginuItem.getType();
        String fileName;

        switch (armorType) {
            case CHESTPLATE:
                fileName = "kariginu_gi";
                break;
            case LEGGINGS:
                fileName = "kariginu_sashinuki";
                break;
            default:
                fileName = "kariginu_gi"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KariginuItem kariginuItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/kariginu_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KariginuItem kariginuItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}