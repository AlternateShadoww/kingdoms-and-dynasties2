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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, KingdomsAndDynasties2.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        makeCottonCrop(((CropBlock) ModBlocks.COTTON_CROP.get()), "cotton_stage_", "cotton_stage_");
    }
    public void makeCottonCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cottonStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cottonStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CottonCropBlock) block).getAgeProperty()),
                new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "block/" + textureName + state.getValue(((CottonCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));

        logBlock(((RotatedPillarBlock) ModBlocks.MULLBERRY_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.MULLBERRY_WOOD.get()), blockTexture(ModBlocks.MULLBERRY_LOG.get()), blockTexture(ModBlocks.MULLBERRY_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_MULLBERRY_LOG.get()), blockTexture(ModBlocks.STRIPPED_MULLBERRY_LOG.get()),
        new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "block/stripped_mullberry_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_MULLBERRY_WOOD.get()), blockTexture(ModBlocks.STRIPPED_MULLBERRY_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_MULLBERRY_LOG.get()));

        blockItem(ModBlocks.MULLBERRY_LOG);
        blockItem(ModBlocks.MULLBERRY_WOOD);
        blockItem(ModBlocks.STRIPPED_MULLBERRY_LOG);
        blockItem(ModBlocks.STRIPPED_MULLBERRY_WOOD);

        blockWithItem(ModBlocks.MULLBERRY_PLANKS);

        leavesBlock(ModBlocks.MULLBERRY_LEAVES);

        logBlock(((RotatedPillarBlock) ModBlocks.RED_PINE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.RED_PINE_WOOD.get()), blockTexture(ModBlocks.RED_PINE_LOG.get()), blockTexture(ModBlocks.STRIPPED_RED_PINE_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_RED_PINE_LOG.get()), blockTexture(ModBlocks.STRIPPED_RED_PINE_LOG.get()),
                new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "block/stripped_red_pine_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_RED_PINE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_MULLBERRY_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_RED_PINE_LOG.get()));

        blockItem(ModBlocks.RED_PINE_LOG);
        blockItem(ModBlocks.RED_PINE_WOOD);
        blockItem(ModBlocks.STRIPPED_RED_PINE_LOG);
        blockItem(ModBlocks.STRIPPED_RED_PINE_WOOD);

        blockWithItem(ModBlocks.RED_PINE_PLANKS);

        leavesBlock(ModBlocks.RED_PINE_LEAVES);

        logBlock(((RotatedPillarBlock) ModBlocks.SUGI_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.SUGI_WOOD.get()), blockTexture(ModBlocks.SUGI_LOG.get()), blockTexture(ModBlocks.SUGI_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SUGI_LOG.get()), blockTexture(ModBlocks.STRIPPED_SUGI_LOG.get()),
                new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "block/stripped_sugi_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SUGI_WOOD.get()), blockTexture(ModBlocks.STRIPPED_SUGI_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_SUGI_LOG.get()));

        blockItem(ModBlocks.SUGI_LOG);
        blockItem(ModBlocks.SUGI_WOOD);
        blockItem(ModBlocks.STRIPPED_SUGI_LOG);
        blockItem(ModBlocks.STRIPPED_SUGI_WOOD);

        blockWithItem(ModBlocks.SUGI_PLANKS);

        leavesBlock(ModBlocks.SUGI_LEAVES);
    }
    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(KingdomsAndDynasties2.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
}