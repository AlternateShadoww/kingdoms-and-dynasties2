package net.alternativewill.kingdomsanddynasties2.datagen.loot;

import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.alternativewill.kingdomsanddynasties2.block.custom.CottonCropBlock;
import net.alternativewill.kingdomsanddynasties2.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.COTTON_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CottonCropBlock.AGE, 4))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.COTTON_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CottonCropBlock.AGE, 5)));

        // LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
        //         .hasBlockStateProperties(ModBlocks.COTTON_CROP.get())
        //         .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CottonCropBlock.AGE, 8));

        this.add(ModBlocks.COTTON_CROP.get(), createCropDrops(ModBlocks.COTTON_CROP.get(), ModItems.COTTON.get(),
                ModItems.COTTONSEED.get(), lootitemcondition$builder2));

        this.dropSelf(ModBlocks.MULLBERRY_LOG.get());
        this.dropSelf(ModBlocks.MULLBERRY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MULLBERRY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MULLBERRY_WOOD.get());
        this.dropSelf(ModBlocks.MULLBERRY_PLANKS.get());

        this.add(ModBlocks.MULLBERRY_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.IRON_SAND_BLOCK.get(), NORMAL_LEAVES_SAPLING_CHANCES)); // TODO: Change to Sapling!

        this.dropSelf(ModBlocks.SUGI_LOG.get());
        this.dropSelf(ModBlocks.SUGI_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_SUGI_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_SUGI_WOOD.get());
        this.dropSelf(ModBlocks.SUGI_PLANKS.get());

        this.add(ModBlocks.SUGI_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.IRON_SAND_BLOCK.get(), NORMAL_LEAVES_SAPLING_CHANCES)); // TODO: Change to Sapling!

        this.dropSelf(ModBlocks.RED_PINE_LOG.get());
        this.dropSelf(ModBlocks.RED_PINE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_RED_PINE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_RED_PINE_WOOD.get());
        this.dropSelf(ModBlocks.RED_PINE_PLANKS.get());

        this.add(ModBlocks.RED_PINE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.IRON_SAND_BLOCK.get(), NORMAL_LEAVES_SAPLING_CHANCES)); // TODO: Change to Sapling!
    }
}
