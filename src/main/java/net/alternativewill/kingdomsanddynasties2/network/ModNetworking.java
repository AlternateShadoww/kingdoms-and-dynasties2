package net.alternativewill.kingdomsanddynasties2.network;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.network.screen.CleanArmorPacket;
import net.alternativewill.kingdomsanddynasties2.network.screen.UndoColorPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModNetworking {
    private static final String PROTOCOL_VERSION = "1.0";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "main_channel"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void register() {
        int id = 0;

        INSTANCE.registerMessage(id++, CleanArmorPacket.class,
                CleanArmorPacket::encode,
                CleanArmorPacket::decode,
                CleanArmorPacket::handle
        );

        INSTANCE.registerMessage(id++, UndoColorPacket.class,
                UndoColorPacket::encode,
                UndoColorPacket::decode,
                UndoColorPacket::handle
        );
    }

}
