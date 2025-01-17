package net.alternativewill.kingdomsanddynasties2.client.button;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ImageButton extends Button {
    private final boolean playTurnSound;
    private SoundEvent soundEvent = SoundEvents.BOOK_PAGE_TURN;
    private final ResourceLocation image;
    private final int width;
    private final int height;
    private final int imageWidth;
    private final int imageHeight;

    public ImageButton(ResourceLocation pImage, int pX, int pY, int pWidth, int pHeight, int pImageWidth, int pImageHeight, Button.OnPress pOnPress, boolean pPlayTurnSound, SoundEvent pSoundEvent) {
        super(pX, pY, pWidth, pHeight, CommonComponents.EMPTY, pOnPress, DEFAULT_NARRATION);
        this.width = pWidth;
        this.height = pHeight;
        this.playTurnSound = pPlayTurnSound;
        this.soundEvent = pSoundEvent;
        this.image = pImage;
        this.imageHeight = pImageHeight;
        this.imageWidth = pImageWidth;
    }

    public ImageButton(ResourceLocation pImage, int pX, int pY, int pWidth, int pHeight, int pImageWidth, int pImageHeight, Button.OnPress pOnPress, boolean pPlayTurnSound) {
        super(pX, pY, pWidth, pHeight, CommonComponents.EMPTY, pOnPress, DEFAULT_NARRATION);
        this.width = pWidth;
        this.height = pHeight;
        this.playTurnSound = pPlayTurnSound;
        this.image = pImage;
        this.imageHeight = pImageHeight;
        this.imageWidth = pImageWidth;
    }

    public void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        int uOffset = 0;
        int vOffset = 0;
        int posX = this.getX();
        int posY = this.getY();

        if (this.isHoveredOrFocused()) {
            uOffset += 1;
            vOffset += 1;
            posX -= 1;
            posY -= 1;
        }

        pGuiGraphics.blit(image, posX, posY, uOffset, vOffset, width, height, imageWidth, imageHeight);
    }

    public void playDownSound(SoundManager pHandler) {
        if (this.playTurnSound) {
            pHandler.play(SimpleSoundInstance.forUI(soundEvent, 1.0F));
        }
    }
}
