package net.alternativewill.kingdomsanddynasties2.item;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.alternativewill.kingdomsanddynasties2.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier TAMAHAGANE = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1000, 0.2f, 1f, 10,
                    ModTags.Blocks.NEEDS_TAMAHAGANE_TOOL, () -> Ingredient.of(ModItems.TAMAHAGANE_INGOT.get())),
            new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "tamahagane"), List.of(Tiers.DIAMOND), List.of());
}
