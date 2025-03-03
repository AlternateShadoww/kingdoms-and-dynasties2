package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.ZunariKabutoItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class ZunariKabutoModel extends GeoModel<ZunariKabutoItem> {
    @Override
    public ResourceLocation getModelResource(ZunariKabutoItem zunariKabutoItem) {
        ArmorItem.Type armorType = zunariKabutoItem.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "zunari_kabuto";
                break;
            default:
                fileName = "zunari_kabuto"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ZunariKabutoItem ZunariKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/zunari_kabuto_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ZunariKabutoItem ZunariKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
