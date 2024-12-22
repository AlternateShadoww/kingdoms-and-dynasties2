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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.OYOROI_HELMET .get()))
                    .title(Component.translatable("creativetab.kingdomsanddynasty_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //WOOD
                        output.accept(ModBlocks.MULLBERRY_LOG.get());
                        output.accept(ModBlocks.MULLBERRY_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_MULLBERRY_LOG.get());
                        output.accept(ModBlocks.STRIPPED_MULLBERRY_WOOD.get());
                        output.accept(ModBlocks.MULLBERRY_PLANKS.get());
                        output.accept(ModBlocks.MULLBERRY_STAIRS.get());
                        output.accept(ModBlocks.MULLBERRY_SLAB.get());
                        output.accept(ModBlocks.MULLBERRY_BUTTON.get());
                        output.accept(ModBlocks.MULLBERRY_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.MULLBERRY_FENCE.get());
                        output.accept(ModBlocks.MULLBERRY_FENCE_GATE.get());
                        output.accept(ModBlocks.MULLBERRY_WALL.get());
                        output.accept(ModBlocks.MULLBERRY_DOOR.get());
                        output.accept(ModBlocks.MULLBERRY_TRAPDOOR.get());
                        output.accept(ModBlocks.RED_PINE_LOG.get());
                        output.accept(ModBlocks.RED_PINE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_RED_PINE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_RED_PINE_WOOD.get());
                        output.accept(ModBlocks.RED_PINE_PLANKS.get());
                        output.accept(ModBlocks.RED_PINE_STAIRS.get());
                        output.accept(ModBlocks.RED_PINE_SLAB.get());
                        output.accept(ModBlocks.RED_PINE_BUTTON.get());
                        output.accept(ModBlocks.RED_PINE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.RED_PINE_FENCE.get());
                        output.accept(ModBlocks.RED_PINE_FENCE_GATE.get());
                        output.accept(ModBlocks.RED_PINE_WALL.get());
                        output.accept(ModBlocks.RED_PINE_DOOR.get());
                        output.accept(ModBlocks.RED_PINE_TRAPDOOR.get());
                        output.accept(ModBlocks.SUGI_LOG.get());
                        output.accept(ModBlocks.SUGI_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_SUGI_LOG.get());
                        output.accept(ModBlocks.STRIPPED_SUGI_WOOD.get());
                        output.accept(ModBlocks.SUGI_PLANKS.get());
                        output.accept(ModBlocks.SUGI_STAIRS.get());
                        output.accept(ModBlocks.SUGI_SLAB.get());
                        output.accept(ModBlocks.SUGI_BUTTON.get());
                        output.accept(ModBlocks.SUGI_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.SUGI_FENCE.get());
                        output.accept(ModBlocks.SUGI_FENCE_GATE.get());
                        output.accept(ModBlocks.SUGI_WALL.get());
                        output.accept(ModBlocks.SUGI_DOOR.get());
                        output.accept(ModBlocks.SUGI_TRAPDOOR.get());
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
                        output.accept(ModItems.GI.get());
                        output.accept(ModItems.HAKAMA.get());

                        output.accept(ModItems.ZUNARI_HELMET.get());
                        output.accept(ModItems.EBOSHI_HELMET.get());
                        output.accept(ModItems.OYOROI_HELMET.get());
                        output.accept(ModItems.OYOROI_CHESTPLATE.get());
                        output.accept(ModItems.OYOROI_LEGGINGS.get());
                        output.accept(ModItems.OYOROI_BOOTS.get());

                        output.accept(ModItems.MENPO.get());

                        output.accept(ModItems.KATANA.get());
                        output.accept(ModItems.TANTO.get());
                        output.accept(ModItems.WAKIZASHI.get());
                        output.accept(ModItems.TACHI.get());
                        output.accept(ModItems.ODACHI.get());

                        output.accept(ModItems.PATTERNED_SCROLL.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
