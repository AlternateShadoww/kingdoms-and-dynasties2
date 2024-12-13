package net.alternativewill.kingdomsanddynasties2.datagen;
import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, KingdomsAndDynasties2.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.IRON_SAND_BLOCK.get())
                .add(ModBlocks.GRAVELLED_IRON_SAND_BLOCK.get())
                .add(ModBlocks.MOSSY_IRON_SAND_BLOCK.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MULLBERRY_LOG.get())
                .add(ModBlocks.MULLBERRY_WOOD.get())
                .add(ModBlocks.STRIPPED_MULLBERRY_LOG.get())
                .add(ModBlocks.STRIPPED_MULLBERRY_WOOD.get())
                .add(ModBlocks.RED_PINE_LOG.get())
                .add(ModBlocks.RED_PINE_WOOD.get())
                .add(ModBlocks.STRIPPED_RED_PINE_LOG.get())
                .add(ModBlocks.STRIPPED_RED_PINE_WOOD.get())
                .add(ModBlocks.SUGI_LOG.get())
                .add(ModBlocks.SUGI_WOOD.get())
                .add(ModBlocks.STRIPPED_SUGI_LOG.get())
                .add(ModBlocks.STRIPPED_SUGI_WOOD.get());




        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.MULLBERRY_PLANKS.get())
                .add(ModBlocks.RED_PINE_PLANKS.get())
                .add(ModBlocks.SUGI_PLANKS.get());
    }

}

