package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.EboshiHatItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class EboshiHatModel extends GeoModel<EboshiHatItem> {
    @Override
    public ResourceLocation getModelResource(EboshiHatItem eboshiHatItem) {
        ArmorItem.Type armorType = eboshiHatItem.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "eboshi_hat";
                break;
            default:
                fileName = "eboshi_hat"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EboshiHatItem eboshiHatItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/eboshi_hat_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EboshiHatItem EboshiHatItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
