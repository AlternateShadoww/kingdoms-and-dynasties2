package net.alternativewill.kingdomsanddynasties2.block;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.block.custom.CottonCropBlock;
import net.alternativewill.kingdomsanddynasties2.block.custom.ModFlamableRotatedPillarBlock;
import net.alternativewill.kingdomsanddynasties2.block.custom.PlankBlock;
import net.alternativewill.kingdomsanddynasties2.item.ModItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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

    public static final RegistryObject<Block> PALE_GRANITE = registerBlock("pale_granite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(1, 3).sound(SoundType.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> PALE_GRANITE_BRICKS = registerBlock("pale_granite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(1, 3).sound(SoundType.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> MOSSY_PALE_GRANITE_BRICKS = registerBlock("mossy_pale_granite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(1, 3).sound(SoundType.DEEPSLATE_BRICKS)));


    public static final RegistryObject<Block> IRON_SAND_BLOCK = registerBlock("iron_sand_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(Blocks.SAND).mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BELL).requiresCorrectToolForDrops().strength(3.0F, 4.0F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> GRAVELLED_IRON_SAND_BLOCK = registerBlock("gravelled_iron_sand_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F, 4.0F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> MOSSY_IRON_SAND_BLOCK = registerBlock("mossy_iron_sand_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).mapColor(MapColor.TERRACOTTA_GREEN).requiresCorrectToolForDrops().strength(3.0F, 4.0F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> DIRTY_SILT = registerBlock("dirty_silt",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(Blocks.SAND).mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BELL).strength(0.4F, 0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> GRAVELLED_SILT = registerBlock("gravelled_silt",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(Blocks.SAND).mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BELL).strength(0.4F, 0.5F).sound(SoundType.SAND)));
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
    public static final RegistryObject<Block> RED_PINE_STAIRS = registerBlock("red_pine_stairs",
            () -> new StairBlock(() -> ModBlocks.RED_PINE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> RED_PINE_SLAB = registerBlock("red_pine_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> RED_PINE_BUTTON = registerBlock("red_pine_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    BlockSetType.OAK, 30, true));
    public static final RegistryObject<Block> RED_PINE_PRESSURE_PLATE = registerBlock("red_pine_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS),
                    BlockSetType.OAK));
    public static final RegistryObject<Block> RED_PINE_FENCE = registerBlock("red_pine_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> RED_PINE_FENCE_GATE = registerBlock("red_pine_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> RED_PINE_WALL = registerBlock("red_pine_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> RED_PINE_DOOR = registerBlock("red_pine_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion().sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> RED_PINE_TRAPDOOR = registerBlock("red_pine_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion().sound(SoundType.WOOD), BlockSetType.OAK));
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

    public static final RegistryObject<Block> SUGI_LOG = registerBlock("sugi_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> SUGI_WOOD = registerBlock("sugi_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_SUGI_LOG = registerBlock("stripped_sugi_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_SUGI_WOOD = registerBlock("stripped_sugi_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));
    public static final RegistryObject<Block> SUGI_PLANKS = registerBlock("sugi_planks",
            () -> new PlankBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SUGI_STAIRS = registerBlock("sugi_stairs",
            () -> new StairBlock(() -> ModBlocks.SUGI_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> SUGI_SLAB = registerBlock("sugi_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SUGI_BUTTON = registerBlock("sugi_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    BlockSetType.OAK, 30, true));
    public static final RegistryObject<Block> SUGI_PRESSURE_PLATE = registerBlock("sugi_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS),
                    BlockSetType.OAK));
    public static final RegistryObject<Block> SUGI_FENCE = registerBlock("sugi_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SUGI_FENCE_GATE = registerBlock("sugi_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> SUGI_WALL = registerBlock("sugi_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SUGI_DOOR = registerBlock("sugi_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion().sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> SUGI_TRAPDOOR = registerBlock("sugi_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion().sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> SUGI_LEAVES = registerBlock("sugi_leaves",
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
    public static final RegistryObject<Block> MULLBERRY_STAIRS = registerBlock("mullberry_stairs",
            () -> new StairBlock(() -> ModBlocks.MULLBERRY_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> MULLBERRY_SLAB = registerBlock("mullberry_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> MULLBERRY_BUTTON = registerBlock("mullberry_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    BlockSetType.OAK, 30, true));
    public static final RegistryObject<Block> MULLBERRY_PRESSURE_PLATE = registerBlock("mullberry_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS),
                    BlockSetType.OAK));
    public static final RegistryObject<Block> MULLBERRY_FENCE = registerBlock("mullberry_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> MULLBERRY_FENCE_GATE = registerBlock("mullberry_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> MULLBERRY_WALL = registerBlock("mullberry_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MULLBERRY_DOOR = registerBlock("mullberry_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion().sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> MULLBERRY_TRAPDOOR = registerBlock("mullberry_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion().sound(SoundType.WOOD), BlockSetType.OAK));
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

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
