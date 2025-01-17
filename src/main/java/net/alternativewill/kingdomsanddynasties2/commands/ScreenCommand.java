package net.alternativewill.kingdomsanddynasties2.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import io.netty.buffer.Unpooled;
import net.alternativewill.kingdomsanddynasties2.client.screen.YoroiStandScreen;
import net.alternativewill.kingdomsanddynasties2.commands.arguments.ScreenArgumentType;
import net.alternativewill.kingdomsanddynasties2.entity.custom.YoroiStandEntity;
import net.alternativewill.kingdomsanddynasties2.screen.ScreenRegistry;
import net.alternativewill.kingdomsanddynasties2.world.inventory.YoroiStandMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MouseSettingsScreen;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Supplier;

import static net.minecraft.commands.Commands.literal;

public class ScreenCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        LiteralArgumentBuilder<CommandSourceStack> builder = literal("screen")
                .then(
                        literal("open")
                                .then(
                                        Commands.argument("screen", ScreenArgumentType.screen())
                                                .suggests(ScreenArgumentType::suggestScreen)
                                                .executes(ScreenCommand::openScreen)));

        dispatcher.register(builder);
    }

    private static int openScreen(CommandContext<CommandSourceStack> context) {
        String screenName = ScreenArgumentType.getScreen(context, "screen");
        ServerPlayer player = context.getSource().getPlayer();

        if (player == null) {
            context.getSource().sendFailure(Component.literal("Player not found"));
            return 0;
        }

        String screenToOpen = ScreenRegistry.getScreenByName(screenName).orElse(null);


        if (screenToOpen == null) {
            context.getSource().sendFailure(Component.literal("Screen not found: " + screenName));
            return 0;
        }

        NetworkHooks.openScreen(player, new MenuProvider() {
            @Override
            public @NotNull Component getDisplayName() {
                return Component.literal(screenName);
            }

            @Override
            public AbstractContainerMenu createMenu(int pId, @NotNull Inventory pInventory, @NotNull Player pPlayer) {
                FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                packetBuffer.writeBlockPos(player.blockPosition());
                if (screenName.equals("yoroi_stand")) {
                    return new YoroiStandMenu(pId, pInventory, packetBuffer);
                }
                return null;
            }
        }, buf -> {
            buf.writeBlockPos(player.blockPosition());
        });

        return 1;
    }
}
