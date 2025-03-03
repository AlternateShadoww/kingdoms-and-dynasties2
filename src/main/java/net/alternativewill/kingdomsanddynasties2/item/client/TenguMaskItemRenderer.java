package net.alternativewill.kingdomsanddynasties2.item.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.alternativewill.kingdomsanddynasties2.item.custom.TenguMaskItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.core.object.DataTicket;

public class TenguMaskItemRenderer extends DyeableGeoItemRenderer<TenguMaskItem> {

    protected float partialTick;

    public TenguMaskItemRenderer() {
        super(new TenguMaskModel());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        this.currentItemStack = stack;
        this.animatable = (TenguMaskItem)stack.getItem();
        this.renderPerspective = displayContext;
        this.partialTick = Minecraft.getInstance().getFrameTime();

        ArmorItem.Type armorType = ((ArmorItem)stack.getItem()).getType();

        long instanceId = getInstanceId(this.animatable);
        this.animatable.getAnimatableInstanceCache().getManagerForId(instanceId).setData(
                DataTickets.ITEM_RENDER_PERSPECTIVE, displayContext);
        this.animatable.getAnimatableInstanceCache().getManagerForId(instanceId).setData(
                new DataTicket<>("armorType", ArmorItem.Type.class), armorType);

        if (displayContext == ItemDisplayContext.GUI) {
            //GUI
            poseStack.pushPose();

            poseStack.scale(0.8F, 0.8F, 0.8F);

            applyGuiTransformations(poseStack, armorType);

            RenderType renderType = this.getRenderType(this.animatable, this.getTextureLocation(this.animatable), bufferSource, partialTick);
            VertexConsumer buffer = ItemRenderer.getFoilBufferDirect(bufferSource, renderType, false, stack.hasFoil());

            this.defaultRender(poseStack, this.animatable, bufferSource, renderType, buffer, 0.0F, partialTick, packedLight);

            poseStack.popPose();
        } else if (displayContext == ItemDisplayContext.GROUND) {
            //Ground, thanks Sherlock
            poseStack.pushPose();

            float scaleFactor = 0.35F;
            poseStack.scale(scaleFactor, scaleFactor, scaleFactor);

            applyGroundTransformations(poseStack, armorType);

            RenderType renderType = this.getRenderType(this.animatable, this.getTextureLocation(this.animatable), bufferSource, partialTick);
            VertexConsumer buffer = ItemRenderer.getFoilBufferDirect(bufferSource, renderType, false, stack.hasFoil());

            this.defaultRender(poseStack, this.animatable, bufferSource, renderType, buffer, 0.0F, partialTick, packedLight);

            poseStack.popPose();
        } else if (displayContext == ItemDisplayContext.FIXED) {
            // Item frames
            poseStack.pushPose();

            poseStack.scale(0.75F, 0.75F, 0.75F);

            applyFixedTransformations(poseStack, armorType);

            RenderType renderType = this.getRenderType(this.animatable, this.getTextureLocation(this.animatable), bufferSource, partialTick);
            VertexConsumer buffer = ItemRenderer.getFoilBufferDirect(bufferSource, renderType, false, stack.hasFoil());

            this.defaultRender(poseStack, this.animatable, bufferSource, renderType, buffer, 0.0F, partialTick, packedLight);

            poseStack.popPose();
        } else {
            // Default/other perspectives (FIRST_PERSON, THIRD_PERSON, etc.)
            poseStack.pushPose();

            float scaleFactor = 0.70F;
            poseStack.scale(scaleFactor, scaleFactor, scaleFactor);

            applyDefaultTransformations(poseStack, armorType, displayContext);

            RenderType renderType = this.getRenderType(this.animatable, this.getTextureLocation(this.animatable), bufferSource, partialTick);
            VertexConsumer buffer = ItemRenderer.getFoilBufferDirect(bufferSource, renderType, false, stack.hasFoil());

            this.defaultRender(poseStack, this.animatable, bufferSource, renderType, buffer, 0.0F, partialTick, packedLight);

            poseStack.popPose();
        }
    }

    private void applyGuiTransformations(PoseStack poseStack, ArmorItem.Type armorType) {
        switch (armorType) {
            case HELMET:
                poseStack.translate(0.7F, -1.5F, 0.0F);
                poseStack.mulPose(new Quaternionf().rotationXYZ(
                        (float)Math.toRadians(0),
                        (float)Math.toRadians(140),
                        (float)Math.toRadians(0)
                ));
                break;
        }
    }

    private void applyGroundTransformations(PoseStack poseStack, ArmorItem.Type armorType) {
        switch (armorType) {
            case HELMET:
                poseStack.translate(1F, -0.7F, 1F);
                break;
        }
    }

    private void applyFixedTransformations(PoseStack poseStack, ArmorItem.Type armorType) {
        switch (armorType) {
            case HELMET:
                poseStack.translate(0.15F, -1.5F, -0.1F);
                break;
        }
    }

    private void applyDefaultTransformations(PoseStack poseStack, ArmorItem.Type armorType, ItemDisplayContext displayContext) {
        if (displayContext == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND ||
                displayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND) {
            switch (armorType) {
                case HELMET:
                    poseStack.scale(0.6F, 0.6F, 0.6F);
                    poseStack.translate(1.65F, -1F, 1.5F);
                    poseStack.mulPose(new Quaternionf().rotationXYZ(
                            (float) Math.toRadians(0),
                            (float) Math.toRadians(180),
                            (float) Math.toRadians(0)
                    ));
                    break;
            }
        } else if (displayContext == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND ||
                displayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND) {
            switch (armorType) {
                case HELMET:
                    poseStack.translate(0.95F, -1.35F, 0.7F);
                    poseStack.mulPose(new Quaternionf().rotationXYZ(
                            (float) Math.toRadians(0),
                            (float) Math.toRadians(120),
                            (float) Math.toRadians(0)
                    ));
                    break;
            }
        }
    }

    @Override
    protected boolean isBoneDyeable(GeoBone geoBone) {
        return true;
    }

    public static final String PRIMARY_PART = "_primary";
    public static final String SECONDARY_PART = "_secondary";
    public static final String GOLD_PART = "_gold";
    public static final String SILVER_PART = "_silver";
    public static final String CRAFTING_TABLE_PART = "_craftingtable";

    @Override
    protected @NotNull Color getColorForBone(GeoBone geoBone) {
        ItemStack itemStack = this.currentItemStack;

        if (itemStack.getItem() instanceof TenguMaskItem armorItem) {
            int primaryColor = armorItem.getPrimaryColor(itemStack);
            int secondaryColor = armorItem.getSecondaryColor(itemStack);
            int goldColor = armorItem.getGoldColor(itemStack);
            int silverColor = armorItem.getSilverColor(itemStack);
            int craftingTableColor = armorItem.getCraftingTableColor(itemStack);

            String boneName = geoBone.getName();

            if (boneName.endsWith(PRIMARY_PART)) {
                return applyDyeToBone(geoBone, primaryColor, PRIMARY_PART);
            } else if (boneName.endsWith(SECONDARY_PART)) {
                return applyDyeToBone(geoBone, secondaryColor, SECONDARY_PART);
            } else if (boneName.endsWith(GOLD_PART)) {
                return applyDyeToBone(geoBone, goldColor, GOLD_PART);
            } else if (boneName.endsWith(SILVER_PART)) {
                return applyDyeToBone(geoBone, silverColor, SILVER_PART);
            } else if (boneName.endsWith(CRAFTING_TABLE_PART)) {
                return applyDyeToBone(geoBone, craftingTableColor, CRAFTING_TABLE_PART);
            }
        }

        return Color.ofOpaque(TenguMaskItem.STANDARD_COLOR);
    }

    public Color applyDyeToBone(GeoBone geoBone, int color, String boneEndsWith) {
        return Color.ofOpaque(color);
    }

    @Override
    public RenderType getRenderType(TenguMaskItem animatable, ResourceLocation texture,
                                    MultiBufferSource renderTypeBuffer, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }
}