package net.alternativewill.kingdomsanddynasties2.item;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.alternativewill.kingdomsanddynasties2.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.common.extensions.IForgeItem;

import java.util.List;
import java.util.Properties;

public class ModToolTiers {
    public static final Tier TAMAHAGANE = TierSortingRegistry.registerTier(
            new ForgeTier(3, 750, 0.2f, 1f, 10,
                    ModTags.Blocks.NEEDS_TAMAHAGANE_TOOL, () -> Ingredient.of(ModItems.TAMAHAGANE_INGOT.get())),
            new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "tamahagane"), List.of(Tiers.DIAMOND), List.of());
    public static final Tier REDPINE = TierSortingRegistry.registerTier(
            new ForgeTier(3, 250, 0.2f, 1f, 10,
                    Tags.Blocks.NEEDS_WOOD_TOOL, () -> Ingredient.of(ModBlocks.RED_PINE_PLANKS.get())),
            new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "red_pine"), List.of(Tiers.WOOD), List.of());
    public static final Tier TANTO = TierSortingRegistry.registerTier(
            new ForgeTier(3, 450, 0.2f, 1f, 10,
                    ModTags.Blocks.NEEDS_TAMAHAGANE_TOOL, () -> Ingredient.of(ModItems.TAMAHAGANE_INGOT.get())),
            new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "tanto"), List.of(Tiers.DIAMOND), List.of());
    public static final Tier WAKIZASHI = TierSortingRegistry.registerTier(
            new ForgeTier(3, 350, 0.2f, 1f, 10,
                    ModTags.Blocks.NEEDS_TAMAHAGANE_TOOL, () -> Ingredient.of(ModItems.TAMAHAGANE_INGOT.get())),
            new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "wakizashi"), List.of(Tiers.DIAMOND), List.of());
    public static final Tier ODACHI = TierSortingRegistry.registerTier(
            new ForgeTier(3, 700, 0.2f, 2.25f, 10,
                    ModTags.Blocks.NEEDS_TAMAHAGANE_TOOL, () -> Ingredient.of(ModItems.TAMAHAGANE_INGOT.get())),
            new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "odachi"), List.of(Tiers.DIAMOND), List.of());
    public static final Tier NAGINATA = TierSortingRegistry.registerTier(
            new ForgeTier(3, 700, 0.2f, 1f, 10,
                    ModTags.Blocks.NEEDS_TAMAHAGANE_TOOL, () -> Ingredient.of(ModItems.TAMAHAGANE_INGOT.get())),
            new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "naginata"), List.of(Tiers.DIAMOND), List.of());
    public static final Tier NAGAMAKI = TierSortingRegistry.registerTier(
            new ForgeTier(3, 670, 0.2f, 1f, 10,
                    ModTags.Blocks.NEEDS_TAMAHAGANE_TOOL, () -> Ingredient.of(ModItems.TAMAHAGANE_INGOT.get())),
            new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "nagamaki"), List.of(Tiers.DIAMOND), List.of());
    public static final Tier YARI = TierSortingRegistry.registerTier(
            new ForgeTier(3, 700, 0.2f, 1f, 10,
                    ModTags.Blocks.NEEDS_TAMAHAGANE_TOOL, () -> Ingredient.of(ModItems.TAMAHAGANE_INGOT.get())),
            new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "yari"), List.of(Tiers.DIAMOND), List.of());


    public static final Tier BAMBOO = TierSortingRegistry.registerTier(
            new ForgeTier(3, 450, 0.2f, 1f, 10,
                    Tags.Blocks.NEEDS_WOOD_TOOL, () -> Ingredient.of(Items.BAMBOO)),
            new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "bamboo"), List.of(Tiers.WOOD), List.of());
}
