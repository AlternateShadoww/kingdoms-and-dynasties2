package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.HaraateHakamaArmorItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class HaraateHakamaArmorModel extends GeoModel<HaraateHakamaArmorItem> {
    @Override
    public ResourceLocation getModelResource(HaraateHakamaArmorItem haraateHakamaArmorItem) {
        ArmorItem.Type armorType = haraateHakamaArmorItem.getType();
        String fileName;

        switch (armorType) {
            case CHESTPLATE:
                fileName = "hara-ate_gi";
                break;
            case LEGGINGS:
                fileName = "hara-ate_hakama";
                break;
            default:
                fileName = "hara-ate_gi"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HaraateHakamaArmorItem HaraateHakamaArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/haraate_hakama_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HaraateHakamaArmorItem HaraateHakamaArmorItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}