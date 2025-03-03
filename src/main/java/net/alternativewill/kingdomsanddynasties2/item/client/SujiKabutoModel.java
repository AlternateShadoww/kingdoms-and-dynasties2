package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.SujiKabutoItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class SujiKabutoModel extends GeoModel<SujiKabutoItem> {
    @Override
    public ResourceLocation getModelResource(SujiKabutoItem sujiKabutoItem) {
        ArmorItem.Type armorType = sujiKabutoItem.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "suji_kabuto";
                break;
            default:
                fileName = "suji_kabuto"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SujiKabutoItem sujiKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/suji_kabuto_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SujiKabutoItem sujiKabutoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
