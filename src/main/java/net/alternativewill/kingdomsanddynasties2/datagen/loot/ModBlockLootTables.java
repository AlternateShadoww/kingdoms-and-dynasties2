package net.alternativewill.kingdomsanddynasties2.datagen.loot;

import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.alternativewill.kingdomsanddynasties2.block.custom.CottonCropBlock;
import net.alternativewill.kingdomsanddynasties2.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //ONLY BLOCKS UNTIL FURTHER NOTICE
        this.add(ModBlocks.IRON_SAND_BLOCK.get(), createOreDrop(ModBlocks.IRON_SAND_BLOCK.get(), ModItems.IRON_SAND.get()));
        this.add(ModBlocks.DIRTY_SILT.get(), createOreDrop(ModBlocks.DIRTY_SILT.get(), Items.DIRT));
        this.add(ModBlocks.GRAVELLED_SILT.get(), createOreDrop(ModBlocks.GRAVELLED_SILT.get(), Items.GRAVEL));
        this.add(ModBlocks.WILD_COTTON.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.COTTONSEED.get()))
                )
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.SILK.get()))
                )
        );;
        this.dropSelf(ModBlocks.GRAVELLED_IRON_SAND_BLOCK.get());
        this.dropSelf(ModBlocks.MOSSY_IRON_SAND_BLOCK.get());

        this.dropSelf(ModBlocks.PALE_GRANITE.get());
        this.dropSelf(ModBlocks.PALE_GRANITE_BRICKS.get());
        this.dropSelf(ModBlocks.MOSSY_PALE_GRANITE_BRICKS.get());

        this.dropSelf(ModBlocks.MULLBERRY_LOG.get());
        this.dropSelf(ModBlocks.MULLBERRY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MULLBERRY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MULLBERRY_WOOD.get());
        this.dropSelf(ModBlocks.MULLBERRY_PLANKS.get());
        this.dropSelf(ModBlocks.MULLBERRY_STAIRS.get());
        this.dropSelf(ModBlocks.MULLBERRY_BUTTON.get());
        this.dropSelf(ModBlocks.MULLBERRY_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.MULLBERRY_TRAPDOOR.get());
        this.dropSelf(ModBlocks.MULLBERRY_FENCE.get());
        this.dropSelf(ModBlocks.MULLBERRY_FENCE_GATE.get());
        this.dropSelf(ModBlocks.MULLBERRY_WALL.get());

        this.add(ModBlocks.MULLBERRY_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MULLBERRY_SLAB.get()));
        this.add(ModBlocks.MULLBERRY_DOOR.get(),
                block -> createDoorTable(ModBlocks.MULLBERRY_DOOR.get()));

        this.add(ModBlocks.MULLBERRY_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.IRON_SAND_BLOCK.get(), NORMAL_LEAVES_SAPLING_CHANCES)); // TODO: Change to Sapling!

        this.dropSelf(ModBlocks.SUGI_LOG.get());
        this.dropSelf(ModBlocks.SUGI_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_SUGI_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_SUGI_WOOD.get());
        this.dropSelf(ModBlocks.SUGI_PLANKS.get());
        this.dropSelf(ModBlocks.SUGI_STAIRS.get());
        this.dropSelf(ModBlocks.SUGI_BUTTON.get());
        this.dropSelf(ModBlocks.SUGI_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.SUGI_TRAPDOOR.get());
        this.dropSelf(ModBlocks.SUGI_FENCE.get());
        this.dropSelf(ModBlocks.SUGI_FENCE_GATE.get());
        this.dropSelf(ModBlocks.SUGI_WALL.get());

        this.add(ModBlocks.SUGI_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SUGI_SLAB.get()));
        this.add(ModBlocks.SUGI_DOOR.get(),
                block -> createDoorTable(ModBlocks.SUGI_DOOR.get()));

        this.add(ModBlocks.SUGI_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.IRON_SAND_BLOCK.get(), NORMAL_LEAVES_SAPLING_CHANCES)); // TODO: Change to Sapling!

        this.dropSelf(ModBlocks.RED_PINE_LOG.get());
        this.dropSelf(ModBlocks.RED_PINE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_RED_PINE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_RED_PINE_WOOD.get());
        this.dropSelf(ModBlocks.RED_PINE_PLANKS.get());
        this.dropSelf(ModBlocks.RED_PINE_STAIRS.get());
        this.dropSelf(ModBlocks.RED_PINE_BUTTON.get());
        this.dropSelf(ModBlocks.RED_PINE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.RED_PINE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.RED_PINE_FENCE.get());
        this.dropSelf(ModBlocks.RED_PINE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.RED_PINE_WALL.get());

        this.add(ModBlocks.RED_PINE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_PINE_SLAB.get()));
        this.add(ModBlocks.RED_PINE_DOOR.get(),
                block -> createDoorTable(ModBlocks.RED_PINE_DOOR.get()));

        this.add(ModBlocks.RED_PINE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.IRON_SAND_BLOCK.get(), NORMAL_LEAVES_SAPLING_CHANCES)); // TODO: Change to Sapling!

        //ONLY CROPS UNTIL FURTHER NOTICE
        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.COTTON_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CottonCropBlock.AGE, 7))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.COTTON_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CottonCropBlock.AGE, 8)));


        this.add(ModBlocks.COTTON_CROP.get(), createCropDrops(ModBlocks.COTTON_CROP.get(), ModItems.COTTON.get(),
                ModItems.COTTONSEED.get(), lootitemcondition$builder2));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

