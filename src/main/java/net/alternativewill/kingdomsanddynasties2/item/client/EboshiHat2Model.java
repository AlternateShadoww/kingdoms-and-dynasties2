package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.EboshiHat2Item;
import net.alternativewill.kingdomsanddynasties2.item.custom.EboshiHatItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class EboshiHat2Model extends GeoModel<EboshiHat2Item> {
    @Override
    public ResourceLocation getModelResource(EboshiHat2Item eboshiHat2Item) {
        ArmorItem.Type armorType = eboshiHat2Item.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "eboshi_hat2";
                break;
            default:
                fileName = "eboshi_hat2"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EboshiHat2Item eboshiHat2Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/eboshi_hat2_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EboshiHat2Item EboshiHat2Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
