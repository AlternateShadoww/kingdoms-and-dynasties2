package net.alternativewill.kingdomsanddynasties2.client.screen;


import net.alternativewill.kingdomsanddynasties2.world.inventory.ModMenus;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModScreens {
    @SubscribeEvent
    public static void clientLoad(FMLClientSetupEvent pEvent) {
        pEvent.enqueueWork(() -> {
            MenuScreens.register(ModMenus.YOROI_STAND_GUI.get(), YoroiStandScreen::new);
        });
    }

}
