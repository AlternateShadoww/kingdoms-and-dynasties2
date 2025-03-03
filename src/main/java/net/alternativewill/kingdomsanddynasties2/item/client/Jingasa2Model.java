package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.Jingasa2Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class Jingasa2Model extends GeoModel<Jingasa2Item> {
    @Override
    public ResourceLocation getModelResource(Jingasa2Item Jingasa2Item) {
        ArmorItem.Type armorType = Jingasa2Item.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "jingasa_2";
                break;
            default:
                fileName = "jingasa_2"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Jingasa2Item Jingasa2Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/jingasa_2.texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Jingasa2Item Jingasa2Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
