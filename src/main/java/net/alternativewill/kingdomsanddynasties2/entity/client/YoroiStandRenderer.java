package net.alternativewill.kingdomsanddynasties2.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.alternativewill.kingdomsanddynasties2.entity.custom.YoroiStandEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class YoroiStandRenderer extends GeoEntityRenderer<YoroiStandEntity> {

    public YoroiStandRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new YoroiStandModel());
    }

    @Override
    public boolean shouldShowName(YoroiStandEntity animatable) {
        return false;
    }
}
