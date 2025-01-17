package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.Jingasa4Item;
import net.alternativewill.kingdomsanddynasties2.item.custom.JingasaItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class Jingasa4Renderer extends GeoArmorRenderer<Jingasa4Item> {
    public Jingasa4Renderer() {
        super(new Jingasa4Model());
    }
}