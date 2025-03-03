package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.Jingasa5Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class Jingasa5Model extends GeoModel<Jingasa5Item> {
    @Override
    public ResourceLocation getModelResource(Jingasa5Item Jingasa5Item) {
        ArmorItem.Type armorType = Jingasa5Item.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "jingasa_5";
                break;
            default:
                fileName = "jingasa_5"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Jingasa5Item Jingasa5Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/jingasa_5.texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Jingasa5Item Jingasa5Item) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
