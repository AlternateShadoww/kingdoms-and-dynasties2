package net.alternativewill.kingdomsanddynasties2.network.screen;

import net.alternativewill.kingdomsanddynasties2.item.custom.*;
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
                    if (slot.getItem() instanceof TankoArmorItem TankoArmorItem) {
                        TankoArmorItem.clearColor(slot);
                        TankoArmorItem.wipeColors(slot, TankoArmorItem.PRIMARY_PART, TankoArmorItem.STANDARD_PRIMARY_COLOR, player);
                        TankoArmorItem.wipeColors(slot, TankoArmorItem.SECONDARY_PART, TankoArmorItem.STANDARD_SECONDARY_COLOR, player);
                        TankoArmorItem.wipeColors(slot, TankoArmorItem.GOLD_PART, TankoArmorItem.STANDARD_GOLD_COLOR, player);
                        TankoArmorItem.wipeColors(slot, TankoArmorItem.SILVER_PART, TankoArmorItem.STANDARD_SILVER_COLOR, player);
                        TankoArmorItem.wipeColors(slot, TankoArmorItem.CRAFTING_TABLE_PART, TankoArmorItem.STANDARD_CRAFTING_TABLE_COLOR, player);
                    }
                    if (slot.getItem() instanceof DomaruArmorItem DomaruArmorItem) {
                        DomaruArmorItem.clearColor(slot);
                        DomaruArmorItem.wipeColors(slot, DomaruArmorItem.PRIMARY_PART, DomaruArmorItem.STANDARD_PRIMARY_COLOR, player);
                        DomaruArmorItem.wipeColors(slot, DomaruArmorItem.SECONDARY_PART, DomaruArmorItem.STANDARD_SECONDARY_COLOR, player);
                        DomaruArmorItem.wipeColors(slot, DomaruArmorItem.GOLD_PART, DomaruArmorItem.STANDARD_GOLD_COLOR, player);
                        DomaruArmorItem.wipeColors(slot, DomaruArmorItem.SILVER_PART, DomaruArmorItem.STANDARD_SILVER_COLOR, player);
                        DomaruArmorItem.wipeColors(slot, DomaruArmorItem.CRAFTING_TABLE_PART, DomaruArmorItem.STANDARD_CRAFTING_TABLE_COLOR, player);
                    }
                    if (slot.getItem() instanceof EboshiKabutoItem EboshiKabutoItem) {
                        EboshiKabutoItem.clearColor(slot);
                        EboshiKabutoItem.wipeColors(slot, EboshiKabutoItem.PRIMARY_PART, EboshiKabutoItem.STANDARD_PRIMARY_COLOR, player);
                        EboshiKabutoItem.wipeColors(slot, EboshiKabutoItem.SECONDARY_PART, EboshiKabutoItem.STANDARD_SECONDARY_COLOR, player);
                        EboshiKabutoItem.wipeColors(slot, EboshiKabutoItem.GOLD_PART, EboshiKabutoItem.STANDARD_GOLD_COLOR, player);
                        EboshiKabutoItem.wipeColors(slot, EboshiKabutoItem.SILVER_PART, EboshiKabutoItem.STANDARD_SILVER_COLOR, player);
                        EboshiKabutoItem.wipeColors(slot, EboshiKabutoItem.CRAFTING_TABLE_PART, EboshiKabutoItem.STANDARD_CRAFTING_TABLE_COLOR, player);
                    }
                    if (slot.getItem() instanceof ZunariKabutoItem ZunariKabutoItem) {
                        ZunariKabutoItem.clearColor(slot);
                        ZunariKabutoItem.wipeColors(slot, ZunariKabutoItem.PRIMARY_PART, ZunariKabutoItem.STANDARD_PRIMARY_COLOR, player);
                        ZunariKabutoItem.wipeColors(slot, ZunariKabutoItem.SECONDARY_PART, ZunariKabutoItem.STANDARD_SECONDARY_COLOR, player);
                        ZunariKabutoItem.wipeColors(slot, ZunariKabutoItem.GOLD_PART, ZunariKabutoItem.STANDARD_GOLD_COLOR, player);
                        ZunariKabutoItem.wipeColors(slot, ZunariKabutoItem.SILVER_PART, ZunariKabutoItem.STANDARD_SILVER_COLOR, player);
                        ZunariKabutoItem.wipeColors(slot, ZunariKabutoItem.CRAFTING_TABLE_PART, ZunariKabutoItem.STANDARD_CRAFTING_TABLE_COLOR, player);
                    }
                    if (slot.getItem() instanceof ToppainariKabutoItem ToppainariKabutoItem) {
                        ToppainariKabutoItem.clearColor(slot);
                        ToppainariKabutoItem.wipeColors(slot, ToppainariKabutoItem.PRIMARY_PART, ToppainariKabutoItem.STANDARD_PRIMARY_COLOR, player);
                        ToppainariKabutoItem.wipeColors(slot, ToppainariKabutoItem.SECONDARY_PART, ToppainariKabutoItem.STANDARD_SECONDARY_COLOR, player);
                        ToppainariKabutoItem.wipeColors(slot, ToppainariKabutoItem.GOLD_PART, ToppainariKabutoItem.STANDARD_GOLD_COLOR, player);
                        ToppainariKabutoItem.wipeColors(slot, ToppainariKabutoItem.SILVER_PART, ToppainariKabutoItem.STANDARD_SILVER_COLOR, player);
                        ToppainariKabutoItem.wipeColors(slot, ToppainariKabutoItem.CRAFTING_TABLE_PART, ToppainariKabutoItem.STANDARD_CRAFTING_TABLE_COLOR, player);
                    }
                    if (slot.getItem() instanceof SujiKabutoItem SujiKabutoItem) {
                        SujiKabutoItem.clearColor(slot);
                        SujiKabutoItem.wipeColors(slot, SujiKabutoItem.PRIMARY_PART, SujiKabutoItem.STANDARD_PRIMARY_COLOR, player);
                        SujiKabutoItem.wipeColors(slot, SujiKabutoItem.SECONDARY_PART, SujiKabutoItem.STANDARD_SECONDARY_COLOR, player);
                        SujiKabutoItem.wipeColors(slot, SujiKabutoItem.GOLD_PART, SujiKabutoItem.STANDARD_GOLD_COLOR, player);
                        SujiKabutoItem.wipeColors(slot, SujiKabutoItem.SILVER_PART, SujiKabutoItem.STANDARD_SILVER_COLOR, player);
                        SujiKabutoItem.wipeColors(slot, SujiKabutoItem.CRAFTING_TABLE_PART, SujiKabutoItem.STANDARD_CRAFTING_TABLE_COLOR, player);
                    }
                    if (slot.getItem() instanceof GihakamaItem GihakamaItem) {
                        GihakamaItem.clearColor(slot);
                        GihakamaItem.wipeColors(slot, GihakamaItem.PRIMARY_PART, GihakamaItem.STANDARD_PRIMARY_COLOR, player);
                        GihakamaItem.wipeColors(slot, GihakamaItem.SECONDARY_PART, GihakamaItem.STANDARD_SECONDARY_COLOR, player);
                     }
                    if (slot.getItem() instanceof HaraateHakamaArmorItem HaraateHakamaArmorItem) {
                        HaraateHakamaArmorItem.clearColor(slot);
                        HaraateHakamaArmorItem.wipeColors(slot, HaraateHakamaArmorItem.PRIMARY_PART, HaraateHakamaArmorItem.STANDARD_PRIMARY_COLOR, player);
                        HaraateHakamaArmorItem.wipeColors(slot, HaraateHakamaArmorItem.SECONDARY_PART, HaraateHakamaArmorItem.STANDARD_SECONDARY_COLOR, player);
                        HaraateHakamaArmorItem.wipeColors(slot, HaraateHakamaArmorItem.GOLD_PART, HaraateHakamaArmorItem.STANDARD_GOLD_COLOR, player);
                        HaraateHakamaArmorItem.wipeColors(slot, HaraateHakamaArmorItem.SILVER_PART, HaraateHakamaArmorItem.STANDARD_SILVER_COLOR, player);
                        HaraateHakamaArmorItem.wipeColors(slot, HaraateHakamaArmorItem.CRAFTING_TABLE_PART, HaraateHakamaArmorItem.STANDARD_CRAFTING_TABLE_COLOR, player);
                    }
                    if (slot.getItem() instanceof HaraateArmorItem HaraateArmorItem) {
                        HaraateArmorItem.clearColor(slot);
                        HaraateArmorItem.wipeColors(slot, HaraateArmorItem.PRIMARY_PART, HaraateArmorItem.STANDARD_PRIMARY_COLOR, player);
                        HaraateArmorItem.wipeColors(slot, HaraateArmorItem.SECONDARY_PART, HaraateArmorItem.STANDARD_SECONDARY_COLOR, player);
                        HaraateArmorItem.wipeColors(slot, HaraateArmorItem.GOLD_PART, HaraateArmorItem.STANDARD_GOLD_COLOR, player);
                        HaraateArmorItem.wipeColors(slot, HaraateArmorItem.SILVER_PART, HaraateArmorItem.STANDARD_SILVER_COLOR, player);
                        HaraateArmorItem.wipeColors(slot, HaraateArmorItem.CRAFTING_TABLE_PART, HaraateArmorItem.STANDARD_CRAFTING_TABLE_COLOR, player);
                    }
                    if (slot.getItem() instanceof HoshiKabutoItem HoshiKabutoItem) {
                        HoshiKabutoItem.clearColor(slot);
                        HoshiKabutoItem.wipeColors(slot, HoshiKabutoItem.PRIMARY_PART, HoshiKabutoItem.STANDARD_PRIMARY_COLOR, player);
                        HoshiKabutoItem.wipeColors(slot, HoshiKabutoItem.SECONDARY_PART, HoshiKabutoItem.STANDARD_SECONDARY_COLOR, player);
                        HoshiKabutoItem.wipeColors(slot, HoshiKabutoItem.GOLD_PART, HoshiKabutoItem.STANDARD_GOLD_COLOR, player);
                        HoshiKabutoItem.wipeColors(slot, HoshiKabutoItem.SILVER_PART, HoshiKabutoItem.STANDARD_SILVER_COLOR, player);
                        HoshiKabutoItem.wipeColors(slot, HoshiKabutoItem.CRAFTING_TABLE_PART, HoshiKabutoItem.STANDARD_CRAFTING_TABLE_COLOR, player);
                    }
                    if (slot.getItem() instanceof FootsoldierDomaruItem FootsoldierDomaruItem) {
                        FootsoldierDomaruItem.clearColor(slot);
                        FootsoldierDomaruItem.wipeColors(slot, FootsoldierDomaruItem.PRIMARY_PART, FootsoldierDomaruItem.STANDARD_PRIMARY_COLOR, player);
                        FootsoldierDomaruItem.wipeColors(slot, FootsoldierDomaruItem.SECONDARY_PART, FootsoldierDomaruItem.STANDARD_SECONDARY_COLOR, player);
                        FootsoldierDomaruItem.wipeColors(slot, FootsoldierDomaruItem.GOLD_PART, FootsoldierDomaruItem.STANDARD_GOLD_COLOR, player);
                        FootsoldierDomaruItem.wipeColors(slot, FootsoldierDomaruItem.SILVER_PART, FootsoldierDomaruItem.STANDARD_SILVER_COLOR, player);
                        FootsoldierDomaruItem.wipeColors(slot, FootsoldierDomaruItem.CRAFTING_TABLE_PART, FootsoldierDomaruItem.STANDARD_CRAFTING_TABLE_COLOR, player);
                    }
                    if (slot.getItem() instanceof KariginuItem KariginuItem) {
                        KariginuItem.clearColor(slot);
                        KariginuItem.wipeColors(slot, KariginuItem.PRIMARY_PART, KariginuItem.STANDARD_PRIMARY_COLOR, player);
                        KariginuItem.wipeColors(slot, KariginuItem.SECONDARY_PART, KariginuItem.STANDARD_SECONDARY_COLOR, player);
                        KariginuItem.wipeColors(slot, KariginuItem.GOLD_PART, KariginuItem.STANDARD_GOLD_COLOR, player);
                        KariginuItem.wipeColors(slot, KariginuItem.SILVER_PART, KariginuItem.STANDARD_SILVER_COLOR, player);
                    }
                    if (slot.getItem() instanceof HakamaNewItem HakamaItem) {
                        HakamaItem.clearColor(slot);
                        HakamaItem.wipeColors(slot, HakamaItem.PRIMARY_PART, HakamaItem.STANDARD_PRIMARY_COLOR, player);
                        HakamaItem.wipeColors(slot, HakamaItem.SECONDARY_PART, HakamaItem.STANDARD_SECONDARY_COLOR, player);
                    }
                    if (slot.getItem() instanceof GiNewItem GiNewItem) {
                        GiNewItem.clearColor(slot);
                        GiNewItem.wipeColors(slot, GiNewItem.PRIMARY_PART, GiNewItem.STANDARD_PRIMARY_COLOR, player);
                        GiNewItem.wipeColors(slot, GiNewItem.SECONDARY_PART, GiNewItem.STANDARD_SECONDARY_COLOR, player);
                    }
                    if (slot.getItem() instanceof WarajiItem WarajiItem) {
                        WarajiItem.clearColor(slot);
                        WarajiItem.wipeColors(slot, WarajiItem.PRIMARY_PART, WarajiItem.STANDARD_PRIMARY_COLOR, player);
                        WarajiItem.wipeColors(slot, WarajiItem.SECONDARY_PART, WarajiItem.STANDARD_SECONDARY_COLOR, player);
                    }


                });
            }
        });
        context.setPacketHandled(true);
    }
}
