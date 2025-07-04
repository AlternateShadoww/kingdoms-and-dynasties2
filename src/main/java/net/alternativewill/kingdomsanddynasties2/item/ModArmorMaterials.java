package net.alternativewill.kingdomsanddynasties2.item;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    OYOROI("oyoroi", 25, (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (p_266655_) -> {
        p_266655_.put(ArmorItem.Type.BOOTS, 2);
        p_266655_.put(ArmorItem.Type.LEGGINGS, 7);
        p_266655_.put(ArmorItem.Type.CHESTPLATE, 7);
        p_266655_.put(ArmorItem.Type.HELMET, 3);
    }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
        return Ingredient.of(ModItems.TAMAHAGANE_INGOT.get());

    }),
    DOMARU("domaru", 25, (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (p_266655_) -> {
        p_266655_.put(ArmorItem.Type.BOOTS, 3);
        p_266655_.put(ArmorItem.Type.LEGGINGS, 5);
        p_266655_.put(ArmorItem.Type.CHESTPLATE, 6);
        p_266655_.put(ArmorItem.Type.HELMET, 2);
    }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 1.0F, 0, () -> {
        return Ingredient.of(ModItems.TAMAHAGANE_INGOT.get());

    }),
    TANKO("tanko", 25, (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (p_266655_) -> {
        p_266655_.put(ArmorItem.Type.LEGGINGS, 6);
        p_266655_.put(ArmorItem.Type.CHESTPLATE, 7);
        p_266655_.put(ArmorItem.Type.HELMET, 3);
    }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 1.0F, 0, () -> {
        return Ingredient.of(ModItems.TAMAHAGANE_INGOT.get());

    }),
    BAREARMOR("barearmor", 25, (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (p_266655_) -> {
        p_266655_.put(ArmorItem.Type.BOOTS, 1);
        p_266655_.put(ArmorItem.Type.LEGGINGS, 3);
        p_266655_.put(ArmorItem.Type.CHESTPLATE, 5);
        p_266655_.put(ArmorItem.Type.HELMET, 1);
    }), 15, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> {
        return Ingredient.of(ModItems.TAMAHAGANE_INGOT.get());
    }),
    GIHAKAMA("gihakama", 25, (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (p_266655_) -> {
        p_266655_.put(ArmorItem.Type.LEGGINGS, 2);
        p_266655_.put(ArmorItem.Type.CHESTPLATE, 3);
    }), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0F, 0F, () -> {
        return Ingredient.of(ModItems.COTTON.get());

    }),
    MENYOROI("menyoroi", 25, (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (p_266655_) -> {
        p_266655_.put(ArmorItem.Type.HELMET, 2);
    }), 15, SoundEvents.ARMOR_EQUIP_IRON, 0F, 0F, () -> {
        return Ingredient.of(ModItems.TAMAHAGANE_INGOT.get());

    }),
    BAMBOO("bamboo", 25, (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (p_266655_) -> {
        p_266655_.put(ArmorItem.Type.HELMET, 1);
        p_266655_.put(ArmorItem.Type.BOOTS, 1);
    }), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0F, 0F, () -> {
        return Ingredient.of(Items.BAMBOO);

    });


    public static final StringRepresentable.EnumCodec<ArmorMaterials> CODEC = StringRepresentable.fromEnum(ArmorMaterials::values);
    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = (EnumMap) Util.make(new EnumMap(ArmorItem.Type.class), (p_266653_) -> {
        p_266653_.put(ArmorItem.Type.BOOTS, 13);
        p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
        p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
        p_266653_.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private ModArmorMaterials(String pName, int pDurabilityMultiplier, EnumMap pProtectionFunctionForType, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier pRepairIngredient) {
        this.name = pName;
        this.durabilityMultiplier = pDurabilityMultiplier;
        this.protectionFunctionForType = pProtectionFunctionForType;
        this.enchantmentValue = pEnchantmentValue;
        this.sound = pSound;
        this.toughness = pToughness;
        this.knockbackResistance = pKnockbackResistance;
        this.repairIngredient = new LazyLoadedValue(pRepairIngredient);
    }

    public int getDurabilityForType(ArmorItem.Type pType) {
        return (Integer)HEALTH_FUNCTION_FOR_TYPE.get(pType) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.Type pType) {
        return (Integer)this.protectionFunctionForType.get(pType);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public String getSerializedName() {
        return this.name;
    }
}
