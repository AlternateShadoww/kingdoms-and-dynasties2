package net.alternativewill.kingdomsanddynasties2.events;

import net.alternativewill.kingdomsanddynasties2.commands.ScreenCommand;
import net.alternativewill.kingdomsanddynasties2.screen.ScreenRegistry;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ServerEvents {

    @SubscribeEvent
    public static void serverLoad(RegisterCommandsEvent event) {
        ScreenCommand.register(event.getDispatcher());

        // Register Screens
        ScreenRegistry.registerScreen("yoroi_stand");
    }

}
