package net.alternativewill.kingdomsanddynasties2.screen;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ScreenRegistry {

    private static final Set<String> screens = new HashSet<>();

    public static void registerScreen(String screenName) {
        screens.add(screenName);
    }

    public static Set<String> getScreens() {
        return screens;
    }

    public static Optional<String> getScreenByName(String screenName) {
        return screens.contains(screenName) ? Optional.of(screenName) : Optional.empty();
    }
}

