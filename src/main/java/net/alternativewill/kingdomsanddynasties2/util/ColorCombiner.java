package net.alternativewill.kingdomsanddynasties2.util;

import java.util.List;

public class ColorCombiner {

    public static int combineColors(List<Integer> colors) {
        if (colors == null || colors.isEmpty()) {
            return 0;
        }

        int[] rgbTotals = new int[3];
        int maxBrightnessSum = 0;
        int count = colors.size();

        for (int color : colors) {
            int r = extractRed(color);
            int g = extractGreen(color);
            int b = extractBlue(color);

            rgbTotals[0] += r;
            rgbTotals[1] += g;
            rgbTotals[2] += b;

            maxBrightnessSum += Math.max(r, Math.max(g, b));
        }

        float avgR = (float) rgbTotals[0] / count;
        float avgG = (float) rgbTotals[1] / count;
        float avgB = (float) rgbTotals[2] / count;

        float brightnessFactor = (float) maxBrightnessSum / count;
        float maxComponent = Math.max(avgR, Math.max(avgG, avgB));

        if (maxComponent > 0) {
            avgR = adjustComponent(avgR, brightnessFactor, maxComponent);
            avgG = adjustComponent(avgG, brightnessFactor, maxComponent);
            avgB = adjustComponent(avgB, brightnessFactor, maxComponent);
        }

        return packColor(avgR, avgG, avgB);
    }

    private static int extractRed(int color) {
        return (color >> 16) & 255;
    }

    private static int extractGreen(int color) {
        return (color >> 8) & 255;
    }

    private static int extractBlue(int color) {
        return color & 255;
    }

    private static float adjustComponent(float component, float brightnessFactor, float maxComponent) {
        return Math.min(255, component * brightnessFactor / maxComponent);
    }

    private static int packColor(float r, float g, float b) {
        return ((int) r << 16) | ((int) g << 8) | (int) b;
    }
}
