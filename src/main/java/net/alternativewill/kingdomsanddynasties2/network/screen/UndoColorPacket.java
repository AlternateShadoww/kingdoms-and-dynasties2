package net.alternativewill.kingdomsanddynasties2.network.screen;

import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UndoColorPacket {

    private final int colorIndex;

    public UndoColorPacket(int colorIndex) {
        this.colorIndex = colorIndex;
    }

    public static void encode(UndoColorPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.colorIndex);
    }

    public static UndoColorPacket decode(FriendlyByteBuf buffer) {
        return new UndoColorPacket(buffer.readInt());
    }

    public static void handle(UndoColorPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            if (player != null) {
                for (int armorSlotIndex = 1; armorSlotIndex < 8; armorSlotIndex += 2) {
                    var armorStack = player.getInventory().armor.get(armorSlotIndex / 2);

                    if (armorStack.getItem() instanceof OyoroiArmorItem yoroiArmorItem) {
                        yoroiArmorItem.undoColor(armorStack, packet.colorIndex);
                    }
                }
            }
        });
        context.setPacketHandled(true);
    }
}
