package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.EboshiKabutoItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.JingasaItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class JingasaRenderer extends GeoArmorRenderer<JingasaItem> {
    public JingasaRenderer() {
        super(new JingasaModel());
    }
}