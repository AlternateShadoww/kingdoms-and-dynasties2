package net.alternativewill.kingdomsanddynasties2.block;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.block.custom.CottonCropBlock;
import net.alternativewill.kingdomsanddynasties2.block.custom.ModFlamableRotatedPillarBlock;
import net.alternativewill.kingdomsanddynasties2.block.custom.PlankBlock;
import net.alternativewill.kingdomsanddynasties2.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, KingdomsAndDynasties2.MOD_ID);

    public static final RegistryObject<Block> IRON_SAND_BLOCK = registerBlock("iron_sand_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(Blocks.SAND).mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BELL).requiresCorrectToolForDrops().strength(3.0F, 4.0F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> GRAVELLED_IRON_SAND_BLOCK = registerBlock("gravelled_iron_sand_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F, 4.0F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> MOSSY_IRON_SAND_BLOCK = registerBlock("mossy_iron_sand_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).mapColor(MapColor.TERRACOTTA_GREEN).requiresCorrectToolForDrops().strength(3.0F, 4.0F).sound(SoundType.SAND)));

    public static final RegistryObject<Block> COTTON_CROP = BLOCKS.register("cotton_crop",
            () -> new CottonCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> RED_PINE_LOG = registerBlock("red_pine_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> RED_PINE_WOOD = registerBlock("red_pine_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_RED_PINE_LOG = registerBlock("stripped_red_pine_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_RED_PINE_WOOD = registerBlock("stripped_red_pine_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));
    public static final RegistryObject<Block> RED_PINE_PLANKS = registerBlock("red_pine_planks",
            () -> new PlankBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> RED_PINE_LEAVES = registerBlock("red_pine_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> MULLBERRY_LOG = registerBlock("mullberry_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> MULLBERRY_WOOD = registerBlock("mullberry_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_MULLBERRY_LOG = registerBlock("stripped_mullberry_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_MULLBERRY_WOOD = registerBlock("stripped_mullberry_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));
    public static final RegistryObject<Block> MULLBERRY_PLANKS = registerBlock("mullberry_planks",
            () -> new PlankBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> MULLBERRY_LEAVES = registerBlock("mullberry_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            }
            );






    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
