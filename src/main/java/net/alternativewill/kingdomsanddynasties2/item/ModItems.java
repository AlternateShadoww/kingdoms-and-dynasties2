package net.alternativewill.kingdomsanddynasties2.item;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KingdomsAndDynasties2.MOD_ID);

    public static final RegistryObject<Item> COTTON = ITEMS.register("cotton",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COTTONSEED = ITEMS.register("cottonseed",
            () -> new ItemNameBlockItem(ModBlocks.COTTON_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> SILK = ITEMS.register("silk",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> IRON_SAND = ITEMS.register("iron_sand",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TAMAHAGANE = ITEMS.register("raw_tamahagane",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TAMAHAGANE_INGOT = ITEMS.register("tamahagane_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TAMAHAGANE_NUGGET = ITEMS.register("tamahagane_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PATTERNED_SCROLL = ITEMS.register("patterned_scroll",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OYOROI_HELMET = ITEMS.register("oyoroi_kabuto",
            () -> new OyoroiArmorItem(ModArmorMaterials.OYOROI, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> OYOROI_CHESTPLATE = ITEMS.register("oyoroi_do",
            () -> new OyoroiArmorItem(ModArmorMaterials.OYOROI, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> OYOROI_LEGGINGS = ITEMS.register("oyoroi_haidate",
            () -> new OyoroiArmorItem(ModArmorMaterials.OYOROI, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> OYOROI_BOOTS = ITEMS.register("oyoroi_geta",
            () -> new OyoroiArmorItem(ModArmorMaterials.OYOROI, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> KATANA = ITEMS.register("katana",
            () -> new SwordItem(ModToolTiers.TAMAHAGANE, 4,2, new Item.Properties()));
    public static final RegistryObject<Item> TANTO = ITEMS.register("tanto",
            () -> new SwordItem(ModToolTiers.TAMAHAGANE, 4,2, new Item.Properties()));
    public static final RegistryObject<Item> WAKIZASHI = ITEMS.register("wakizashi",
            () -> new SwordItem(ModToolTiers.TAMAHAGANE, 4,2, new Item.Properties()));
    public static final RegistryObject<Item> TACHI = ITEMS.register("tachi",
            () -> new SwordItem(ModToolTiers.TAMAHAGANE, 4,2, new Item.Properties()));
    public static final RegistryObject<Item> ODACHI = ITEMS.register("odachi",
            () -> new SwordItem(ModToolTiers.TAMAHAGANE, 4,1, new Item.Properties()));

    public static final RegistryObject<Item> KATANA_SHEATH = ITEMS.register("katana_sheath",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TANTO_SHEATH = ITEMS.register("tanto_sheath",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WAKIZASHI_SHEATH = ITEMS.register("wakizashi_sheath",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TACHI_SHEATH = ITEMS.register("tachi_sheath",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ODACHI_SHEATH = ITEMS.register("odachi_sheath",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
