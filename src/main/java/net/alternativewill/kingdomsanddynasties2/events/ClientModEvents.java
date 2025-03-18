package net.alternativewill.kingdomsanddynasties2.events;

import net.alternativewill.kingdomsanddynasties2.util.ModItemProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "kingdomsanddynasties2", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(RegisterClientReloadListenersEvent event) {
        ModItemProperties.addCustomItemProperties();  // Ensure the item properties are applied
    }
}