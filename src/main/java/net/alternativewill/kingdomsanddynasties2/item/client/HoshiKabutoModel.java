package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.item.custom.DomaruArmorItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.HoshiKabutoItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.SujiKabutoItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class HoshiKabutoModel extends GeoModel<HoshiKabutoItem> {
    @Override
    public ResourceLocation getModelResource(HoshiKabutoItem hoshiKabutoItem) {
        ArmorItem.Type armorType = hoshiKabutoItem.getType();
        String fileName;

        switch (armorType) {
            case HELMET:
                fileName = "hoshi_kabuto";
                break;
            default:
                fileName = "hoshi_kabuto"; // Default fallback
        }

        return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "geo/" + fileName + ".geo.json");
        }

        @Override
        public ResourceLocation getTextureResource(HoshiKabutoItem HoshiKabutoItem) {
            return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/armor/hoshi_kabuto_texture.png");
        }

        @Override
        public ResourceLocation getAnimationResource(HoshiKabutoItem HoshiKabutoItem) {
            return new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "animations/oyoroi.animation.json");
        }
    }
