package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.Jingasa3Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class Jingasa3Model extends GeoModel<Jingasa3Item> {
    @Override
    public ResourceLocation getModelResource(Jingasa3Item Jingasa3Item) {
        ArmorItem.Type armorType = Jingasa3Item.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "jingasa_3";
                break;
            default:
                fileName = "jingasa_3"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Jingasa3Item Jingasa3Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/jingasa_3.texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Jingasa3Item Jingasa3Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
