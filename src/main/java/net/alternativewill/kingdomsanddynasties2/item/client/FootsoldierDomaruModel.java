package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.FootsoldierDomaruItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class FootsoldierDomaruModel extends GeoModel<FootsoldierDomaruItem> {
    @Override
    public ResourceLocation getModelResource(FootsoldierDomaruItem FootsoldierDomaruItem) {
        ArmorItem.Type armorType = FootsoldierDomaruItem.getType();
        String fileName;

        switch (armorType) {
            case CHESTPLATE:
                fileName = "footsoldierdomaru_chestplate";
                break;
            case LEGGINGS:
                fileName = "footsoldierdomaru_leggings";
                break;
            default:
                fileName = "footsoldierdomaru_chestplate"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FootsoldierDomaruItem FootsoldierDomaruItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/footsoldierdomaru_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FootsoldierDomaruItem FootsoldierDomaruItem) {
        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
    }
}
