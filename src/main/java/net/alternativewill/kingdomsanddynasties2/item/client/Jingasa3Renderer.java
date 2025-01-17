package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.Jingasa3Item;
import net.alternativewill.kingdomsanddynasties2.item.custom.JingasaItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class Jingasa3Renderer extends GeoArmorRenderer<Jingasa3Item> {
    public Jingasa3Renderer() {
        super(new Jingasa3Model());
    }
}