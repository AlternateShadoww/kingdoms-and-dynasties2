package net.alternativewill.kingdomsanddynasties2.worldgen.biome;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "overworld"), 5));
    }
}
