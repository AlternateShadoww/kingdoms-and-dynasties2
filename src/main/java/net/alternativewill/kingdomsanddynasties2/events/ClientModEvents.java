package net.alternativewill.kingdomsanddynasties2.events;

import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.alternativewill.kingdomsanddynasties2.item.ModItems;
import net.alternativewill.kingdomsanddynasties2.util.ModItemProperties;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = "kingdomsanddynasties2", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(RegisterClientReloadListenersEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_COTTON.get(), RenderType.cutout());
        ModItemProperties.addCustomItemProperties();  // Ensure the item properties are applied
    }


}

