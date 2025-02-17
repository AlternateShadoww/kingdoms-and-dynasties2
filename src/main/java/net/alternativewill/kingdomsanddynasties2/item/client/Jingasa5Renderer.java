package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.Jingasa5Item;
import net.alternativewill.kingdomsanddynasties2.item.custom.JingasaItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class Jingasa5Renderer extends GeoArmorRenderer<Jingasa5Item> {
    public Jingasa5Renderer() {
        super(new Jingasa5Model());
    }
}