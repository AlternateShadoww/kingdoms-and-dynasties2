package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.DomaruArmorItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.EboshiKabutoItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.SujiKabutoItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class EboshiKabutoModel extends GeoModel<EboshiKabutoItem> {
    @Override
    public ResourceLocation getModelResource(EboshiKabutoItem eboshiKabutoItem) {
        ArmorItem.Type armorType = eboshiKabutoItem.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "eboshi_kabuto";
                break;
            default:
                fileName = "eboshi_kabuto"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EboshiKabutoItem eboshiKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/eboshi_kabuto_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EboshiKabutoItem eboshiKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
