package net.alternativewill.kingdomsanddynasties2.item.client;

import net.alternativewill.kingdomsanddynasties2.item.custom.GihakamaItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.renderer.DyeableGeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import java.util.HashSet;
import java.util.Set;

public class GihakamaRenderer extends DyeableGeoArmorRenderer<GihakamaItem> {
    public GihakamaRenderer() {
        super(new GihakamaModel());
    }

    @Override
    public void setupAnim(Entity entity, float v, float v1, float v2, float v3, float v4) {

    }

    @Override
    protected boolean isBoneDyeable(GeoBone bone) {
        // Specify which bones should be dyeable based on their name
        Set<String> dyeableBones = new HashSet<>();
        dyeableBones.add("armorHead");
        dyeableBones.add("armorBody");
        dyeableBones.add("armorLeftLeg");
        dyeableBones.add("armorRightLeg");
        dyeableBones.add("armorLeftBoot");
        dyeableBones.add("armorRightBoot");
        dyeableBones.add("armorLeftArm");
        dyeableBones.add("armorRightArm");

        // If the bone is in the list, it can be dyed
        return dyeableBones.contains(bone.getName());
    }

    @Override
    protected @NotNull Color getColorForBone(GeoBone geoBone) {
        // Try to get the color for the armor bone from your custom logic
        DyeColor color = getDyeColorForArmor();
        if (color != null) {
            return Color.ofOpaque(color.getTextColor());  // Return the custom color
        }

        // No custom color found, fallback to a default color (e.g., gray or original texture)
        return Color.ofOpaque(0x808080);  // Gray as an example fallback
    }
    private DyeColor getDyeColorForArmor() {
        // This method will retrieve the dye color from the armor item.

        // For now, returning RED as a placeholder.
        return DyeColor.RED;
}
}