package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.GiNewItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.HakamaNewItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class GiNewModel extends GeoModel<GiNewItem> {
    @Override
    public ResourceLocation getModelResource(GiNewItem giNewItem) {
        ArmorItem.Type armorType = giNewItem.getType();
        String fileName;

        switch (armorType) {
            case CHESTPLATE:
                fileName = "samue_gi";
                break;
            default:
                fileName = "samue_gi"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GiNewItem GiNewItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/gihakamatexture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GiNewItem GiNewItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}