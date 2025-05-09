package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.HappuriItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class HappuriRenderer extends GeoArmorRenderer<HappuriItem> {
    public HappuriRenderer() {
        super(new HappuriModel());
    }
}