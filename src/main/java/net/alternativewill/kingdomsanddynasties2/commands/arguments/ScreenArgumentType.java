package net.alternativewill.kingdomsanddynasties2.commands.arguments;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.alternativewill.kingdomsanddynasties2.screen.ScreenRegistry;
import net.minecraft.commands.CommandSourceStack;

public class ScreenArgumentType {

    public static StringArgumentType screen() {
        return StringArgumentType.word();
    }

    public static String getScreen(CommandContext<?> pContext, String pName) {
        return StringArgumentType.getString(pContext, pName);
    }

    public static CompletableFuture<Suggestions> suggestScreen(CommandContext<CommandSourceStack> pContext, SuggestionsBuilder pBuilder) {
        String input = pBuilder.getRemaining().toLowerCase();

        Set<String> screens = ScreenRegistry.getScreens();

        for (String screen : screens) {
            if (screen.toLowerCase().startsWith(input)) {
                pBuilder.suggest(screen);
            }
        }

        return pBuilder.buildFuture();
    }
}

