package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.HanboItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class HanboRenderer extends GeoArmorRenderer<HanboItem> {
    public HanboRenderer() {
        super(new HanboModel());
    }
}