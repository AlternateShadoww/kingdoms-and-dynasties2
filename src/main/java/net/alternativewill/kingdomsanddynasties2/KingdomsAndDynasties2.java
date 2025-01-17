package net.alternativewill.kingdomsanddynasties2;

import com.mojang.logging.LogUtils;
import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.alternativewill.kingdomsanddynasties2.entity.ModEntities;
import net.alternativewill.kingdomsanddynasties2.entity.custom.YoroiStandEntity;
import net.alternativewill.kingdomsanddynasties2.entity.client.YoroiStandRenderer;
import net.alternativewill.kingdomsanddynasties2.item.ModCreativeModeTabs;
import net.alternativewill.kingdomsanddynasties2.item.ModItems;
import net.alternativewill.kingdomsanddynasties2.network.ModNetworking;
import net.alternativewill.kingdomsanddynasties2.world.inventory.ModMenus;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// THINGS TO DO FOR THE FUTURE: COTTON CROP TEXTURE, SAPLING TEXTURE,


// The value here should match an entry in the META-INF/mods.toml file
@Mod(KingdomsAndDynasties2.MOD_ID)
public class KingdomsAndDynasties2
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "kingdomsanddynasties2";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public KingdomsAndDynasties2()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModNetworking.register();


        ModMenus.REGISTRY.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(WoodType.BAMBOO);
        }

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ModEntities.YOROI_STAND.get(), YoroiStandRenderer::new);
        }

        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(ModEntities.YOROI_STAND.get(), YoroiStandEntity.createAttributes().build());
        }
    }
}
