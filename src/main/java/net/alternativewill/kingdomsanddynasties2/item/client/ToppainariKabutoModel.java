package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.ToppainariKabutoItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class ToppainariKabutoModel extends GeoModel<ToppainariKabutoItem> {
    @Override
    public ResourceLocation getModelResource(ToppainariKabutoItem toppainariKabutoItem) {
        ArmorItem.Type armorType = toppainariKabutoItem.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "toppainari_kabuto";
                break;
            default:
                fileName = "toppainari_kabuto"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ToppainariKabutoItem toppainariKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/toppainari_kabuto_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ToppainariKabutoItem toppainariKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
