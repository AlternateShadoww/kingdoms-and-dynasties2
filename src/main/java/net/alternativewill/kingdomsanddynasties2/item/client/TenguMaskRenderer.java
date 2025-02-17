package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.MenpoItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.TenguMaskItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class TenguMaskRenderer extends GeoArmorRenderer<TenguMaskItem> {
    public TenguMaskRenderer() {
        super(new TenguMaskModel());
    }
}