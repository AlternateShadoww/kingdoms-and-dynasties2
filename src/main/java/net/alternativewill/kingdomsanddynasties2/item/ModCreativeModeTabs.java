package net.alternativewill.kingdomsanddynasties2.item;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KingdomsAndDynasties2.MOD_ID);

    public static final RegistryObject<CreativeModeTab> KINGDOMSANDDYNASTYTAB = CREATIVE_MODE_TABS.register("kingdoms_and_dynasties_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PATTERNED_SCROLL.get()))
                    .title(Component.translatable("creativetab.kingdomsanddynasty_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //WOOD
                        output.accept(ModBlocks.MULLBERRY_LOG.get());
                        output.accept(ModBlocks.MULLBERRY_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_MULLBERRY_LOG.get());
                        output.accept(ModBlocks.STRIPPED_MULLBERRY_WOOD.get());
                        output.accept(ModBlocks.MULLBERRY_PLANKS.get());
                        output.accept(ModBlocks.RED_PINE_LOG.get());
                        output.accept(ModBlocks.RED_PINE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_RED_PINE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_RED_PINE_WOOD.get());
                        output.accept(ModBlocks.RED_PINE_PLANKS.get());
                        output.accept(ModBlocks.SUGI_LOG.get());
                        output.accept(ModBlocks.SUGI_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_SUGI_LOG.get());
                        output.accept(ModBlocks.STRIPPED_SUGI_WOOD.get());
                        output.accept(ModBlocks.SUGI_PLANKS.get());
                        //FOILAGE
                        output.accept(ModBlocks.RED_PINE_LEAVES.get());
                        output.accept(ModBlocks.MULLBERRY_LEAVES.get());
                        output.accept(ModBlocks.SUGI_LEAVES.get());

                        //IRONSAND
                        output.accept(ModBlocks.IRON_SAND_BLOCK.get());
                        output.accept(ModBlocks.GRAVELLED_IRON_SAND_BLOCK.get());
                        output.accept(ModBlocks.MOSSY_IRON_SAND_BLOCK.get());

                        //MATERIALS
                        output.accept(ModItems.COTTON.get());
                        output.accept(ModItems.COTTONSEED.get());
                        output.accept(ModItems.SILK.get());
                        output.accept(ModItems.IRON_SAND.get());
                        output.accept(ModItems.RAW_TAMAHAGANE.get());
                        output.accept(ModItems.TAMAHAGANE_INGOT.get());
                        output.accept(ModItems.TAMAHAGANE_NUGGET.get());

                        //ARMORS
                        output.accept(ModItems.OYOROI_HELMET.get());
                        output.accept(ModItems.OYOROI_CHESTPLATE.get());
                        output.accept(ModItems.OYOROI_LEGGINGS.get());
                        output.accept(ModItems.OYOROI_BOOTS.get());

                        output.accept(ModItems.PATTERNED_SCROLL.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
