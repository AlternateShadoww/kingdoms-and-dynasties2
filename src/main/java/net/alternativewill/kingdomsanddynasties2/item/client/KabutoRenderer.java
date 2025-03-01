package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.KabutoItem;
import net.alternativewill.kingdomsanddynasties2.item.custom.MenpoItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class KabutoRenderer extends GeoArmorRenderer<KabutoItem> {
    public KabutoRenderer() {
        super(new KabutoModel());
    }
}