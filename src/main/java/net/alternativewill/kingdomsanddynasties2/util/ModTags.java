package net.alternativewill.kingdomsanddynasties2.util;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;


public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_TAMAHAGANE_TOOL = tag("needs_tamahagane_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(KingdomsAndDynasties2.MOD_ID, name));
        }
    }
}