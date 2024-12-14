package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.MenpoItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MenpoRenderer extends GeoArmorRenderer<MenpoItem> {
    public MenpoRenderer() {
        super(new MenpoModel());
    }
}