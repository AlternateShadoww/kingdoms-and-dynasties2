package net.alternativewill.kingdomsanddynasties2.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.client.button.ImageButton;
import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import net.alternativewill.kingdomsanddynasties2.network.ModNetworking;
import net.alternativewill.kingdomsanddynasties2.network.screen.CleanArmorPacket;
import net.alternativewill.kingdomsanddynasties2.network.screen.UndoColorPacket;
import net.alternativewill.kingdomsanddynasties2.world.inventory.YoroiStandMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

import static net.minecraft.client.gui.screens.inventory.InventoryScreen.renderEntityInInventoryFollowsMouse;

@OnlyIn(Dist.CLIENT)
public class YoroiStandScreen extends AbstractContainerScreen<YoroiStandMenu> {
    private static final ResourceLocation BACKGROUND = new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/gui/armor_workbench_texture.png");
    private final Map<Integer, Slot> customSlots = menu.get();
    private final Level world;
    private final int x, y, z;
    private final Player entity;

    public YoroiStandScreen(YoroiStandMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    public void render(@NotNull GuiGraphics pGraphics, int mouseX, int mouseY, float partialTicks) {
        int i = this.leftPos + 105;
        int j = this.topPos;
        int adjustedMouseX = -(mouseX - i);
        int adjustedMouseY = -(mouseY - (j + 27));

        this.renderBackground(pGraphics);
        renderEntityInInventoryFollowsMouse(pGraphics, i, j + 78, 30, adjustedMouseX, adjustedMouseY, entity);
        renderClearButton();
        renderUndoButtons();
        super.render(pGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(pGraphics, mouseX, mouseY);

        //TODO: CODE THAT HIGHLIGHTS THE SLOTS IN RED
     //   for (Map.Entry<Integer, Slot> entry : menu.get().entrySet()) {
     //       Slot slot = entry.getValue();
     //       if (slot != null) {
     //           int x = leftPos + slot.x;
     //           int y = topPos + slot.y;
     //           pGraphics.fill(x, y, x + 16, y + 16, 0x80FF0000);
     //       }
     //   }
        //TODO: END OF CODE THAT HIGHLIGHTS THE SLOTS IN RED
    }

    private void renderClearButton() {
        ImageButton clearColorButton = this.addRenderableWidget(new ImageButton(
                new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/gui/clear_button.png"),
                this.leftPos + 153,
                this.topPos + 63,
                13,
                13,
                13,
                13,
                (button) -> {
                    cleanAllArmor();
                },
                false
        ));
        clearColorButton.visible = true;
    }

    private void renderUndoButtons() {
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            this.addRenderableWidget(new ImageButton(
                    new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "textures/gui/undo_button.png"),
                    this.leftPos + 10,
                    this.topPos + 10 + (i * 18),
                    13,
                    13,
                    13,
                    13,
                    (button) -> {
                        undoColor(finalI);
                    },
                    false
            ));
        }
    }

    private void undoColor(int pIndex) {
        ModNetworking.INSTANCE.sendToServer(new UndoColorPacket(pIndex));
    }

    @Override
    protected void renderBg(GuiGraphics pGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        pGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, 256, 256);
        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            assert Objects.requireNonNull(this.minecraft).player != null;
            assert this.minecraft.player != null;
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    public void containerTick() {
        super.containerTick();
    }

    @Override
    protected void renderLabels(@NotNull GuiGraphics pGraphics, int mouseX, int mouseY) {
    }

    @Override
    public void onClose() {
        super.onClose();
    }

    @Override
    public void init() {
        super.init();
    }

    private void cleanAllArmor() {
        if (Minecraft.getInstance().player != null) {
            ModNetworking.INSTANCE.sendToServer(new CleanArmorPacket());
        }

    }
}
