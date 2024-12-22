package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.EboshiKabutoItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.MenpoItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class EboshiKabutoRenderer extends GeoArmorRenderer<EboshiKabutoItem> {
    public EboshiKabutoRenderer() {
        super(new EboshiKabutoModel());
    }
}