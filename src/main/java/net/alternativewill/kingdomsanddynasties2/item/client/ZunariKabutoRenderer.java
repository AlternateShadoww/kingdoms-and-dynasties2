package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.EboshiKabutoItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.ZunariKabutoItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ZunariKabutoRenderer extends GeoArmorRenderer<ZunariKabutoItem> {
    public ZunariKabutoRenderer() {
        super(new ZunariKabutoModel());
    }
}