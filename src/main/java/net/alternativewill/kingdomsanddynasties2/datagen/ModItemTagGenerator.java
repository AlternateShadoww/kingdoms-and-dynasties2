package net.alternativewill.kingdomsanddynasties2.datagen;
import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, KingdomsAndDynasties2.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MULLBERRY_LOG.get().asItem())
                .add(ModBlocks.MULLBERRY_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MULLBERRY_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MULLBERRY_WOOD.get().asItem())
                .add(ModBlocks.RED_PINE_LOG.get().asItem())
                .add(ModBlocks.RED_PINE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_RED_PINE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_RED_PINE_WOOD.get().asItem())
                .add(ModBlocks.SUGI_LOG.get().asItem())
                .add(ModBlocks.SUGI_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_SUGI_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_SUGI_LOG.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.MULLBERRY_PLANKS.get().asItem())
                .add(ModBlocks.RED_PINE_PLANKS.get().asItem())
                .add(ModBlocks.SHIKKUI_PLASTER.get().asItem())
                .add(ModBlocks.SUGI_PLANKS.get().asItem());

    }
}
