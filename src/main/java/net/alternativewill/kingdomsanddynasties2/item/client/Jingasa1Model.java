package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.Jingasa1Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class Jingasa1Model extends GeoModel<Jingasa1Item> {
    @Override
    public ResourceLocation getModelResource(Jingasa1Item Jingasa1Item) {
        ArmorItem.Type armorType = Jingasa1Item.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "jingasa_1";
                break;
            default:
                fileName = "jingasa_1"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Jingasa1Item Jingasa1Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/jingasa_1.texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Jingasa1Item Jingasa1Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
