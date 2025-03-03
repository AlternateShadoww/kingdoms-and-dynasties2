package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.Jingasa4Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class Jingasa4Model extends GeoModel<Jingasa4Item> {
    @Override
    public ResourceLocation getModelResource(Jingasa4Item Jingasa4Item) {
        ArmorItem.Type armorType = Jingasa4Item.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "jingasa_4";
                break;
            default:
                fileName = "jingasa_4"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Jingasa4Item Jingasa4Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/jingasa_4.texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Jingasa4Item Jingasa4Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
