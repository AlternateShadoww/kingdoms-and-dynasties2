package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.TaikoItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class TaikoRenderer extends GeoItemRenderer<TaikoItem> {
    public TaikoRenderer() {
        super(new TaikoModel());
    }
}
