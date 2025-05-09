package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.KomusoItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class KomusoModel extends GeoModel<KomusoItem> {
    @Override
    public ResourceLocation getModelResource(KomusoItem KomusoItem) {
        ArmorItem.Type armorType = KomusoItem.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "komuso";
                break;
            default:
                fileName = "komuso"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KomusoItem KomusoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/komuso_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KomusoItem KomusoItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
