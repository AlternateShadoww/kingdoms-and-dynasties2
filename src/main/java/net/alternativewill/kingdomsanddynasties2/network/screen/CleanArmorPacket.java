package net.alternativewill.kingdomsanddynasties2.network.screen;

import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CleanArmorPacket {
    public CleanArmorPacket() {
    }

    public static CleanArmorPacket decode(FriendlyByteBuf buffer) {
        return new CleanArmorPacket();
    }

    public void encode(FriendlyByteBuf buffer) {
    }

    public static void handle(CleanArmorPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        System.out.println("Cleaning armor");
        context.enqueueWork(() -> {
            System.out.println("Cleaning armor2");
            ServerPlayer player = context.getSender();
            if (player != null) {
                player.getArmorSlots().forEach(slot -> {
                    if (slot.getItem() instanceof OyoroiArmorItem yoroiArmorItem) {
                        yoroiArmorItem.clearColor(slot);
                        yoroiArmorItem.wipeColors(slot, OyoroiArmorItem.PRIMARY_PART, OyoroiArmorItem.STANDARD_PRIMARY_COLOR, player);
                        yoroiArmorItem.wipeColors(slot, OyoroiArmorItem.SECONDARY_PART, OyoroiArmorItem.STANDARD_SECONDARY_COLOR, player);
                        yoroiArmorItem.wipeColors(slot, OyoroiArmorItem.GOLD_PART, OyoroiArmorItem.STANDARD_GOLD_COLOR, player);
                        yoroiArmorItem.wipeColors(slot, OyoroiArmorItem.SILVER_PART, OyoroiArmorItem.STANDARD_SILVER_COLOR, player);
                        yoroiArmorItem.wipeColors(slot, OyoroiArmorItem.CRAFTING_TABLE_PART, OyoroiArmorItem.STANDARD_CRAFTING_TABLE_COLOR, player);
                    }
                });
            }
        });
        context.setPacketHandled(true);
    }
}
