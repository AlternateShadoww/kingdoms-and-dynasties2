package net.alternativewill.kingdomsanddynasties2.datagen;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.alternativewill.kingdomsanddynasties2.block.custom.CottonCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, KingdomsAndDynasties2.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerTreeBlocks();
        registerCrops();
        registerGeneralBlocks();
    }

    private void registerGeneralBlocks() {
        // Simple cube blocks with uniform texture
        registerSimpleBlocks(
                ModBlocks.IRON_SAND_BLOCK,
                ModBlocks.MOSSY_IRON_SAND_BLOCK,
                ModBlocks.GRAVELLED_IRON_SAND_BLOCK
        );

        // Blocks with special rendering or custom textures
        registerSpecialBlocks();
    }

    private void registerSimpleBlocks(RegistryObject<Block>... blocks) {
        for (RegistryObject<Block> block : blocks) {
            simpleBlockWithItem(block.get(), cubeAll(block.get()));
        }
    }

    private void registerSpecialBlocks() {
        // Example of a block with custom rendering or texture
        // You can add specific logic for blocks that need special handling

        // For a block with different side and top/bottom textures
        // registerDirectionalBlock(ModBlocks.SOME_DIRECTIONAL_BLOCK,
        //     models().orientableBlock(
        //         "block_name",
        //         blockTexture(side),
        //         blockTexture(top),
        //         blockTexture(bottom)
        //     )
        // );

        // For blocks with special render types or custom models
        // customBlockRegistration(ModBlocks.SPECIAL_BLOCK);
    }

    private void registerTreeBlocks() {
        registerTreeType("mullberry", ModBlocks.MULLBERRY_LOG, ModBlocks.MULLBERRY_WOOD,
                ModBlocks.STRIPPED_MULLBERRY_LOG, ModBlocks.STRIPPED_MULLBERRY_WOOD,
                ModBlocks.MULLBERRY_PLANKS, ModBlocks.MULLBERRY_LEAVES);

        registerTreeType("red_pine", ModBlocks.RED_PINE_LOG, ModBlocks.RED_PINE_WOOD,
                ModBlocks.STRIPPED_RED_PINE_LOG, ModBlocks.STRIPPED_RED_PINE_WOOD,
                ModBlocks.RED_PINE_PLANKS, ModBlocks.RED_PINE_LEAVES);

        registerTreeType("sugi", ModBlocks.SUGI_LOG, ModBlocks.SUGI_WOOD,
                ModBlocks.STRIPPED_SUGI_LOG, ModBlocks.STRIPPED_SUGI_WOOD,
                ModBlocks.SUGI_PLANKS, ModBlocks.SUGI_LEAVES);
    }

    private void registerTreeType(String woodType,
                                  RegistryObject<Block> log,
                                  RegistryObject<Block> wood,
                                  RegistryObject<Block> strippedLog,
                                  RegistryObject<Block> strippedWood,
                                  RegistryObject<Block> planks,
                                  RegistryObject<Block> leaves) {
        // Log blocks
        logBlock((RotatedPillarBlock) log.get());

        // Wood blocks with appropriate textures
        axisBlock((RotatedPillarBlock) wood.get(),
                blockTexture(log.get()),
                blockTexture(log.get()));

        // Stripped log blocks
        axisBlock((RotatedPillarBlock) strippedLog.get(),
                blockTexture(strippedLog.get()),
                new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "block/stripped_" + woodType + "_log_top"));

        // Stripped wood blocks
        axisBlock((RotatedPillarBlock) strippedWood.get(),
                blockTexture(strippedLog.get()),
                blockTexture(strippedLog.get()));

        // Register block items
        registerBlockItem(log);
        registerBlockItem(wood);
        registerBlockItem(strippedLog);
        registerBlockItem(strippedWood);

        // Planks
        registerSimpleBlock(planks);

        // Leaves
        registerLeavesBlock(leaves);
    }

    private void registerCrops() {
        makeCottonCrop((CropBlock) ModBlocks.COTTON_CROP.get(), "cotton_crop", "wheat_stage");
    }

    public void makeCottonCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state ->
                generateCropStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] generateCropStates(BlockState state, CropBlock block,
                                                 String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];

        int age = state.getValue(((CottonCropBlock) block).getAgeProperty());
        models[0] = new ConfiguredModel(
                models().crop(modelName + age,
                        new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "block/" + textureName + age)
                ).renderType("cutout")
        );

        return models;
    }

    private void registerLeavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(
                        ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        new ResourceLocation("minecraft:block/leaves"),
                        "all",
                        blockTexture(blockRegistryObject.get())
                ).renderType("cutout")
        );
    }

    private void registerBlockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(),
                new ModelFile.UncheckedModelFile(
                        KingdomsAndDynasties2.MOD_ID + ":block/" +
                                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()
                )
        );
    }

    private void registerSimpleBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}