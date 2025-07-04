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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SUGI_PLANKS.get()))
                    .title(Component.translatable("creativetab.kingdomsanddynasty_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //WOOD
                        //output.accept(ModBlocks.MULLBERRY_LOG.get());
                       // output.accept(ModBlocks.MULLBERRY_WOOD.get());
                        //output.accept(ModBlocks.STRIPPED_MULLBERRY_LOG.get());
                       // output.accept(ModBlocks.STRIPPED_MULLBERRY_WOOD.get());
                        //output.accept(ModBlocks.MULLBERRY_PLANKS.get());
                       // output.accept(ModBlocks.MULLBERRY_STAIRS.get());
                       // output.accept(ModBlocks.MULLBERRY_SLAB.get());
                      // output.accept(ModBlocks.MULLBERRY_BUTTON.get());
                      //  output.accept(ModBlocks.MULLBERRY_PRESSURE_PLATE.get());
                      //  output.accept(ModBlocks.MULLBERRY_FENCE.get());
                       // output.accept(ModBlocks.MULLBERRY_FENCE_GATE.get());
                       // output.accept(ModBlocks.MULLBERRY_WALL.get());
                       // output.accept(ModBlocks.MULLBERRY_DOOR.get());
                       //output.accept(ModBlocks.MULLBERRY_TRAPDOOR.get());
                        //output.accept(ModBlocks.RED_PINE_LOG.get());
                       // output.accept(ModBlocks.RED_PINE_WOOD.get());
                        //output.accept(ModBlocks.STRIPPED_RED_PINE_LOG.get());
                       // output.accept(ModBlocks.STRIPPED_RED_PINE_WOOD.get());
                       // output.accept(ModBlocks.RED_PINE_PLANKS.get());
                       // output.accept(ModBlocks.RED_PINE_STAIRS.get());
                       // output.accept(ModBlocks.RED_PINE_SLAB.get());
                       // output.accept(ModBlocks.RED_PINE_BUTTON.get());
                       // output.accept(ModBlocks.RED_PINE_PRESSURE_PLATE.get());
                       // output.accept(ModBlocks.RED_PINE_FENCE.get());
                       // output.accept(ModBlocks.RED_PINE_FENCE_GATE.get());
                       // output.accept(ModBlocks.RED_PINE_WALL.get());
                      //  output.accept(ModBlocks.RED_PINE_DOOR.get());
                       // output.accept(ModBlocks.RED_PINE_TRAPDOOR.get());
                      //  output.accept(ModBlocks.SUGI_LOG.get());
                        //output.accept(ModBlocks.SUGI_WOOD.get());
                      //  output.accept(ModBlocks.STRIPPED_SUGI_LOG.get());
                        //output.accept(ModBlocks.STRIPPED_SUGI_WOOD.get());
                       // output.accept(ModBlocks.SUGI_PLANKS.get());
                       // output.accept(ModBlocks.SUGI_STAIRS.get());
                       // output.accept(ModBlocks.SUGI_SLAB.get());
                       // output.accept(ModBlocks.SUGI_BUTTON.get());
                      // output.accept(ModBlocks.SUGI_PRESSURE_PLATE.get());
                      //  output.accept(ModBlocks.SUGI_FENCE.get());
                       // output.accept(ModBlocks.SUGI_FENCE_GATE.get());
                       // output.accept(ModBlocks.SUGI_WALL.get());
                       // output.accept(ModBlocks.SUGI_DOOR.get());
                       // output.accept(ModBlocks.SUGI_TRAPDOOR.get());
                        //FOILAGE
                       // output.accept(ModBlocks.RED_PINE_LEAVES.get());
                      //  output.accept(ModBlocks.MULLBERRY_LEAVES.get());
                       // output.accept(ModBlocks.SUGI_LEAVES.get());


                        output.accept(ModBlocks.SHIKKUI_PLASTER.get());
                        //PALE_GRANITE
                        output.accept(ModBlocks.PALE_GRANITE.get());
                        output.accept(ModBlocks.PALE_GRANITE_SLAB.get());
                        output.accept(ModBlocks.PALE_GRANITE_STAIRS.get());
                        output.accept(ModBlocks.PALE_GRANITE_WALL.get());
                        output.accept(ModBlocks.PALE_GRANITE_BRICKS.get());
                        output.accept(ModBlocks.PALE_GRANITE_BRICK_SLAB.get());
                        output.accept(ModBlocks.PALE_GRANITE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.PALE_GRANITE_BRICK_WALL.get());
                        output.accept(ModBlocks.MOSSY_PALE_GRANITE_BRICKS.get());
                        output.accept(ModBlocks.MOSSY_PALE_GRANITE_BRICK_SLAB.get());
                        output.accept(ModBlocks.MOSSY_PALE_GRANITE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.MOSSY_PALE_GRANITE_BRICK_WALL.get());

                        //IRONSAND
                        output.accept(ModBlocks.DIRTY_SILT.get());
                        output.accept(ModBlocks.GRAVELLED_SILT.get());
                        output.accept(ModBlocks.IRON_SAND_BLOCK.get());
                    //    output.accept(ModBlocks.GRAVELLED_IRON_SAND_BLOCK.get());
                     //   output.accept(ModBlocks.MOSSY_IRON_SAND_BLOCK.get());

                        //MATERIALS
                        output.accept(ModItems.FIRESTICK.get());
                        output.accept(ModItems.KOZUCHI.get());
                        output.accept(ModItems.PADDLE.get());
                        output.accept(ModItems.COTTON.get());
                        output.accept(ModItems.KASURI.get());
                        output.accept(ModItems.COTTONSEED.get());
                        output.accept(ModItems.SILK.get());
                        output.accept(ModItems.IRON_SAND.get());
                        output.accept(ModItems.RAW_TAMAHAGANE.get());
                        output.accept(ModItems.TAMAHAGANE_INGOT.get());
                        output.accept(ModItems.TAMAHAGANE_NUGGET.get());
                        output.accept(ModItems.TAMAHAGANE_PLATE.get());

                        output.accept(ModItems.KABUTO.get());
                        output.accept(ModItems.SODE.get());

                        output.accept(ModItems.SMALLTSUKA.get());
                        output.accept(ModItems.TSUKA.get());
                        output.accept(ModItems.LONGTSUKA.get());

                  //      output.accept(ModItems.PATTERNED_SCROLL.get());

                        output.accept(ModItems.YOROI_STAND_ITEM.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> KINGDOMSANDDYNASTYARMORS = CREATIVE_MODE_TABS.register("kingdoms_and_dynasties_armory",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.HOSHI_HELMET .get()))
                    .title(Component.translatable("creativetab.kingdomsanddynasty_armory"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //ARMORS
                        output.accept(ModItems.JINGASA.get());
                        output.accept(ModItems.JINGASA2.get());
                        output.accept(ModItems.JINGASA4.get());
                        output.accept(ModItems.JINGASA3.get());
                        output.accept(ModItems.JINGASA5.get());
                        output.accept(ModItems.KOMUSO.get());

                        output.accept(ModItems.EBOSHIHAT.get());
                        output.accept(ModItems.EBOSHIHAT2.get());

                        output.accept(ModItems.GI.get());
                        output.accept(ModItems.GINEW.get());
                        output.accept(ModItems.HAKAMANEW.get());
                        output.accept(ModItems.HAKAMA.get());
                        output.accept(ModItems.KARIGINU.get());
                        output.accept(ModItems.KARIGINU_SASHINUKI.get());


                        output.accept(ModItems.HOSHI_HELMET.get());
                        output.accept(ModItems.SUJI_HELMET.get());
                        output.accept(ModItems.TOPPAINARI_HELMET.get());
                        output.accept(ModItems.ZUNARI_HELMET.get());
                        output.accept(ModItems.EBOSHI_HELMET.get());
                        output.accept(ModItems.OYOROI_HELMET.get());
                        output.accept(ModItems.TANKO_HELMET.get());
                        output.accept(ModItems.TANKO_CHESTPLATE.get());
                        output.accept(ModItems.TANKO_LEGGINGS.get());
                        output.accept(ModItems.OYOROI_CHESTPLATE.get());
                        output.accept(ModItems.OYOROI_LEGGINGS.get());

                        output.accept(ModItems.DOMARU_CHESTPLATE.get());
                        output.accept(ModItems.DOMARU_LEGGINGS.get());
                        output.accept(ModItems.FOOTSOLDIERDOMARU_CHESTPLATE.get());
                        output.accept(ModItems.FOOTSOLDIERDOMARU_LEGGINGS.get());

                        output.accept(ModItems.HARAATE_CHESTPLATE.get());
                        output.accept(ModItems.HARAATE_LEGGINGS.get());
                        output.accept(ModItems.HARAATEHAKAMA_CHESTPLATE.get());
                        output.accept(ModItems.HARAATEHAKAMA_LEGGINGS.get());

                        output.accept(ModItems.WARAJI.get());
                        output.accept(ModItems.OYOROI_BOOTS.get());
                        output.accept(ModItems.DOMARU_BOOTS.get());

                        output.accept(ModItems.HANBO.get());
                        output.accept(ModItems.MENPO.get());
                        output.accept(ModItems.HAPPURI.get());
                        output.accept(ModItems.TENGUMASK.get());

                        output.accept(ModItems.TANTO.get());
                        output.accept(ModItems.WAKIZASHI.get());
                        output.accept(ModItems.KATANA.get());
                        output.accept(ModItems.TACHI.get());
                        output.accept(ModItems.ODACHI.get());
                        output.accept(ModItems.CHUKOTO.get());
                        output.accept(ModItems.TSURUGI.get());
                        output.accept(ModItems.NAGAMAKI.get());
                        output.accept(ModItems.NAGINATA.get());
                        output.accept(ModItems.YARI.get());
                        output.accept(ModItems.HOKO.get());
                        output.accept(ModItems.WOODENKANABO.get());
                        output.accept(ModItems.KANABO.get());
                        output.accept(ModItems.YUMI.get());


                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
