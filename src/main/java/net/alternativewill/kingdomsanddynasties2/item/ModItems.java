package net.alternativewill.kingdomsanddynasties2.item;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.alternativewill.kingdomsanddynasties2.entity.ModEntities;
import net.alternativewill.kingdomsanddynasties2.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.Items.registerItem;

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

    public static final RegistryObject<Item> TAIKO = ITEMS.register("taiko",
            () -> new TaikoItem(new Item.Properties()));

    public static final RegistryObject<Item> PATTERNED_SCROLL = ITEMS.register("patterned_scroll",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> YOROI_STAND_ITEM = ITEMS.register("yoroi_stand",
            () -> new YoroiStandItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> SUJI_HELMET = ITEMS.register("suji_kabuto",
            () -> new SujiKabutoItem(ModArmorMaterials.OYOROI, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TOPPAINARI_HELMET = ITEMS.register("toppainari_kabuto",
            () -> new ToppainariKabutoItem(ModArmorMaterials.OYOROI, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ZUNARI_HELMET = ITEMS.register("zunari_kabuto",
            () -> new ZunariKabutoItem(ModArmorMaterials.OYOROI, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> EBOSHI_HELMET = ITEMS.register("eboshi_kabuto",
            () -> new EboshiKabutoItem(ModArmorMaterials.OYOROI, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> OYOROI_HELMET = ITEMS.register("oyoroi_kabuto",
            () -> new OyoroiArmorItem(ModArmorMaterials.OYOROI, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> OYOROI_CHESTPLATE = ITEMS.register("oyoroi_do",
            () -> new OyoroiArmorItem(ModArmorMaterials.OYOROI, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> OYOROI_LEGGINGS = ITEMS.register("oyoroi_haidate",
            () -> new OyoroiArmorItem(ModArmorMaterials.OYOROI, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> OYOROI_BOOTS = ITEMS.register("oyoroi_geta",
            () -> new OyoroiArmorItem(ModArmorMaterials.OYOROI, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> DOMARU_CHESTPLATE = ITEMS.register("do-maru_do",
            () -> new DomaruArmorItem(ModArmorMaterials.DOMARU, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DOMARU_LEGGINGS = ITEMS.register("do-maru_haidate",
            () -> new DomaruArmorItem(ModArmorMaterials.DOMARU, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DOMARU_BOOTS = ITEMS.register("do-maru_geta",
            () -> new DomaruArmorItem(ModArmorMaterials.DOMARU, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> MENPO = ITEMS.register("menpo",
            () -> new MenpoItem(ModArmorMaterials.MENYOROI, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> GI = ITEMS.register("gi",
            () -> new GihakamaItem(ModArmorMaterials.GIHAKAMA, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> HAKAMA = ITEMS.register("hakama",
            () -> new GihakamaItem(ModArmorMaterials.GIHAKAMA, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> EBOSHIHAT = ITEMS.register("eboshi",
            () -> new EboshiHatItem(ModArmorMaterials.BAMBOO, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> JINGASA = ITEMS.register("jingasa_1",
            () -> new JingasaItem(ModArmorMaterials.BAMBOO, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> JINGASA2 = ITEMS.register("jingasa_2",
            () -> new Jingasa2Item(ModArmorMaterials.BAMBOO, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> JINGASA3 = ITEMS.register("jingasa_3",
            () -> new Jingasa3Item(ModArmorMaterials.BAMBOO, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> JINGASA4 = ITEMS.register("jingasa_4",
            () -> new Jingasa4Item(ModArmorMaterials.BAMBOO, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> KATANA = ITEMS.register("katana",
            () -> new SwordItem(ModToolTiers.TAMAHAGANE, 5,-2.4f, new Item.Properties()));
    public static final RegistryObject<Item> TANTO = ITEMS.register("tanto",
            () -> new SwordItem(ModToolTiers.TAMAHAGANE, 1,-1.3f, new Item.Properties()));
    public static final RegistryObject<Item> WAKIZASHI = ITEMS.register("wakizashi",
            () -> new SwordItem(ModToolTiers.TAMAHAGANE, 2,-1.6f, new Item.Properties()));
    public static final RegistryObject<Item> TACHI = ITEMS.register("tachi",
            () -> new SwordItem(ModToolTiers.TAMAHAGANE, 6,-2.7f, new Item.Properties()));
    public static final RegistryObject<Item> ODACHI = ITEMS.register("odachi",
            () -> new SwordItem(ModToolTiers.TAMAHAGANE, 7,-3, new Item.Properties()));

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
