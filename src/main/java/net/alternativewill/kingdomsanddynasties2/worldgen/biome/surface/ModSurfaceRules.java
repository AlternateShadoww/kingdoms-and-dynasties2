package net.alternativewill.kingdomsanddynasties2.worldgen.biome.surface;

import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.alternativewill.kingdomsanddynasties2.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource IRON_SAND_BLOCK = makeStateRule(ModBlocks.IRON_SAND_BLOCK.get());
    private static final SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);


    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TEST_BIOME),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, IRON_SAND_BLOCK)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, MUD)),


                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
