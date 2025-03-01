package net.alternativewill.kingdomsanddynasties2.world.inventory;

import net.alternativewill.kingdomsanddynasties2.item.custom.*;
import net.alternativewill.kingdomsanddynasties2.world.inventory.slots.DyeSlot;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class YoroiStandMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
    public final Level world;
    public final Player entity;
    public int x, y, z;
    private ContainerLevelAccess access = ContainerLevelAccess.NULL;
    private final IItemHandler internal;
    private final Map<Integer, Slot> customSlots = new HashMap<>();
    private final Supplier<Boolean> boundItemMatcher = null;
    private final Entity boundEntity = null;
    private final BlockEntity boundBlockEntity = null;


    public YoroiStandMenu(int pId, Inventory pInv, FriendlyByteBuf pData) {
        super(ModMenus.YOROI_STAND_GUI.get(), pId);
        this.entity = pInv.player;
        this.world = pInv.player.level();
        this.internal = new ItemStackHandler(9);
        BlockPos pos;
        if (pData != null) {
            pos = pData.readBlockPos();
            this.x = pos.getX();
            this.y = pos.getY();
            this.z = pos.getZ();
            access = ContainerLevelAccess.create(world, pos);
        }

        addDyeSlots();
        addArmorSlots(pInv);
        this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 134, 18)));
        addInventorySlots(pInv);
    }

    private void addDyeSlots() {
        for (int row = 0; row < 4; ++row) {
            int slotIndex = row * 2;
            int xPosition = 62 - 35;
            int yPosition = 15 + row * 18;

            this.customSlots.put(slotIndex, this.addSlot(new DyeSlot(internal, slotIndex, xPosition, yPosition) {
                @Override
                public void set(@NotNull ItemStack stack) {
                    super.set(stack);
                    if (!world.isClientSide()) {
                        handleArmorSlotModification(stack, slotIndex);
                    }
                }
            }));
        }
    }

    private void addArmorSlots(Inventory pInv) {
        for (int row = 0; row < 4; ++row) {
            int slotIndex = row * 2 + 1;
            int xPosition = 62;
            int yPosition = 15 + row * 18;

            int armorSlotIndex = 3 - row;
            this.customSlots.put(slotIndex, this.addSlot(new Slot(pInv, 36 + armorSlotIndex, xPosition, yPosition) {
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    if (!(stack.getItem() instanceof ArmorItem armorItem)) {
                        return false;
                    }
                    return switch (armorSlotIndex) {
                        case 3 -> // Helmet slot
                                armorItem.getEquipmentSlot() == EquipmentSlot.HEAD;
                        case 2 -> // Chestplate slot
                                armorItem.getEquipmentSlot() == EquipmentSlot.CHEST;
                        case 1 -> // Leggings slot
                                armorItem.getEquipmentSlot() == EquipmentSlot.LEGS;
                        case 0 -> // Boots slot
                                armorItem.getEquipmentSlot() == EquipmentSlot.FEET;
                        default -> false;
                    };
                }
            }));
        }
    }

    private void addInventorySlots(Inventory pInv) {
        for (int si = 0; si < 3; ++si)
            for (int sj = 0; sj < 9; ++sj)
                this.addSlot(new Slot(pInv, sj + (si + 1) * 9, 8 + sj * 18, 84 + si * 18));
        for (int si = 0; si < 9; ++si)
            this.addSlot(new Slot(pInv, si, 8 + si * 18, 142));

    }

    public void handleArmorSlotModification(@NotNull ItemStack dyeStack, int dyeIndex) {
    System.out.println("handleArmorSlotModification called with dyeIndex: " + dyeIndex);
    if (dyeStack.getItem() instanceof DyeItem dyeItem) {
        int dyeColor = dyeItem.getDyeColor().getTextColor();
        System.out.println("Dye color: " + dyeColor);

        for (int armorSlotIndex = 1; armorSlotIndex < 8; armorSlotIndex += 2) {
            if (dyeStack.isEmpty()) {
                System.out.println("Dye stack is empty, exiting loop.");
                return;
            }
            Slot armorSlot = customSlots.get(armorSlotIndex);
            ItemStack armorStack = armorSlot.getItem();
            System.out.println("Processing armor slot index: " + armorSlotIndex);

            if (armorStack.getItem() instanceof OyoroiArmorItem yoroiArmorItem) {
                System.out.println("Found OyoroiArmorItem in slot: " + armorSlotIndex);
                switch (dyeIndex) {
                    case 0: // Primary color
                        yoroiArmorItem.setPrimaryColor(armorStack, dyeColor);
                        System.out.println("Set primary color to: " + dyeColor);
                        break;
                    case 2: // Secondary color
                        yoroiArmorItem.setSecondaryColor(armorStack, dyeColor);
                        System.out.println("Set secondary color to: " + dyeColor);
                        break;
                    case 4: // Gold Part
                        yoroiArmorItem.setGoldColor(armorStack, dyeColor);
                        System.out.println("Set gold color to: " + dyeColor);
                        break;
                    case 6: // Silver Part
                        yoroiArmorItem.setSilverColor(armorStack, dyeColor);
                        System.out.println("Set silver color to: " + dyeColor);
                        break;
                    default:
                        System.out.println("Invalid dye index: " + dyeIndex);
                        break;
                }


                dyeStack.shrink(1);
                System.out.println("Dye stack shrunk, new count: " + dyeStack.getCount());
                if (dyeStack.getCount() == 0) {
                    dyeStack = ItemStack.EMPTY;
                    System.out.println("Dye stack is now empty.");
                }
            }
            if (armorStack.getItem() instanceof DomaruArmorItem DomaruArmorItem) {
                System.out.println("Found OyoroiArmorItem in slot: " + armorSlotIndex);
                switch (dyeIndex) {
                    case 0: // Primary color
                        DomaruArmorItem.setPrimaryColor(armorStack, dyeColor);
                        System.out.println("Set primary color to: " + dyeColor);
                        break;
                    case 2: // Secondary color
                        DomaruArmorItem.setSecondaryColor(armorStack, dyeColor);
                        System.out.println("Set secondary color to: " + dyeColor);
                        break;
                    case 4: // Gold Part
                        DomaruArmorItem.setGoldColor(armorStack, dyeColor);
                        System.out.println("Set gold color to: " + dyeColor);
                        break;
                    case 6: // Silver Part
                        DomaruArmorItem.setSilverColor(armorStack, dyeColor);
                        System.out.println("Set silver color to: " + dyeColor);
                        break;
                    default:
                        System.out.println("Invalid dye index: " + dyeIndex);
                        break;
                }


                dyeStack.shrink(1);
                System.out.println("Dye stack shrunk, new count: " + dyeStack.getCount());
                if (dyeStack.getCount() == 0) {
                    dyeStack = ItemStack.EMPTY;
                    System.out.println("Dye stack is now empty.");
                }
            }
            if (armorStack.getItem() instanceof EboshiKabutoItem EboshiKabutoItem) {
                System.out.println("Found EboshiKabutoItem in slot: " + armorSlotIndex);
                switch (dyeIndex) {
                    case 0: // Primary color
                        EboshiKabutoItem.setPrimaryColor(armorStack, dyeColor);
                        System.out.println("Set primary color to: " + dyeColor);
                        break;
                    case 2: // Secondary color
                        EboshiKabutoItem.setSecondaryColor(armorStack, dyeColor);
                        System.out.println("Set secondary color to: " + dyeColor);
                        break;
                    case 4: // Gold Part
                        EboshiKabutoItem.setGoldColor(armorStack, dyeColor);
                        System.out.println("Set gold color to: " + dyeColor);
                        break;
                    case 6: // Silver Part
                        EboshiKabutoItem.setSilverColor(armorStack, dyeColor);
                        System.out.println("Set silver color to: " + dyeColor);
                        break;
                    default:
                        System.out.println("Invalid dye index: " + dyeIndex);
                        break;
                }


                dyeStack.shrink(1);
                System.out.println("Dye stack shrunk, new count: " + dyeStack.getCount());
                if (dyeStack.getCount() == 0) {
                    dyeStack = ItemStack.EMPTY;
                    System.out.println("Dye stack is now empty.");
                }

            }
            if (armorStack.getItem() instanceof ZunariKabutoItem ZunariKabutoItem) {
                System.out.println("Found ZunariKabutoItem in slot: " + armorSlotIndex);
                switch (dyeIndex) {
                    case 0: // Primary color
                        ZunariKabutoItem.setPrimaryColor(armorStack, dyeColor);
                        System.out.println("Set primary color to: " + dyeColor);
                        break;
                    case 2: // Secondary color
                        ZunariKabutoItem.setSecondaryColor(armorStack, dyeColor);
                        System.out.println("Set secondary color to: " + dyeColor);
                        break;
                    case 4: // Gold Part
                        ZunariKabutoItem.setGoldColor(armorStack, dyeColor);
                        System.out.println("Set gold color to: " + dyeColor);
                        break;
                    case 6: // Silver Part
                        ZunariKabutoItem.setSilverColor(armorStack, dyeColor);
                        System.out.println("Set silver color to: " + dyeColor);
                        break;
                    default:
                        System.out.println("Invalid dye index: " + dyeIndex);
                        break;
                }


                dyeStack.shrink(1);
                System.out.println("Dye stack shrunk, new count: " + dyeStack.getCount());
                if (dyeStack.getCount() == 0) {
                    dyeStack = ItemStack.EMPTY;
                    System.out.println("Dye stack is now empty.");
                }
            }
            if (armorStack.getItem() instanceof ToppainariKabutoItem ToppainariKabutoItem) {
                System.out.println("Found ToppainariKabutoItem in slot: " + armorSlotIndex);
                switch (dyeIndex) {
                    case 0: // Primary color
                        ToppainariKabutoItem.setPrimaryColor(armorStack, dyeColor);
                        System.out.println("Set primary color to: " + dyeColor);
                        break;
                    case 2: // Secondary color
                        ToppainariKabutoItem.setSecondaryColor(armorStack, dyeColor);
                        System.out.println("Set secondary color to: " + dyeColor);
                        break;
                    case 4: // Gold Part
                        ToppainariKabutoItem.setGoldColor(armorStack, dyeColor);
                        System.out.println("Set gold color to: " + dyeColor);
                        break;
                    case 6: // Silver Part
                        ToppainariKabutoItem.setSilverColor(armorStack, dyeColor);
                        System.out.println("Set silver color to: " + dyeColor);
                        break;
                    default:
                        System.out.println("Invalid dye index: " + dyeIndex);
                        break;
                }


                dyeStack.shrink(1);
                System.out.println("Dye stack shrunk, new count: " + dyeStack.getCount());
                if (dyeStack.getCount() == 0) {
                    dyeStack = ItemStack.EMPTY;
                    System.out.println("Dye stack is now empty.");
                }
            }
            if (armorStack.getItem() instanceof SujiKabutoItem SujiKabutoItem) {
                System.out.println("Found SujiKabutoItem in slot: " + armorSlotIndex);
                switch (dyeIndex) {
                    case 0: // Primary color
                        SujiKabutoItem.setPrimaryColor(armorStack, dyeColor);
                        System.out.println("Set primary color to: " + dyeColor);
                        break;
                    case 2: // Secondary color
                        SujiKabutoItem.setSecondaryColor(armorStack, dyeColor);
                        System.out.println("Set secondary color to: " + dyeColor);
                        break;
                    case 4: // Gold Part
                        SujiKabutoItem.setGoldColor(armorStack, dyeColor);
                        System.out.println("Set gold color to: " + dyeColor);
                        break;
                    case 6: // Silver Part
                        SujiKabutoItem.setSilverColor(armorStack, dyeColor);
                        System.out.println("Set silver color to: " + dyeColor);
                        break;
                    default:
                        System.out.println("Invalid dye index: " + dyeIndex);
                        break;
                }


                dyeStack.shrink(1);
                System.out.println("Dye stack shrunk, new count: " + dyeStack.getCount());
                if (dyeStack.getCount() == 0) {
                    dyeStack = ItemStack.EMPTY;
                    System.out.println("Dye stack is now empty.");
                }
            }
            if (armorStack.getItem() instanceof GihakamaItem GihakamaItem) {
                System.out.println("Found GihakamaItem in slot: " + armorSlotIndex);
                switch (dyeIndex) {
                    case 0: // Primary color
                        GihakamaItem.setPrimaryColor(armorStack, dyeColor);
                        System.out.println("Set primary color to: " + dyeColor);
                        break;
                    case 2: // Secondary color
                        GihakamaItem.setSecondaryColor(armorStack, dyeColor);
                        System.out.println("Set secondary color to: " + dyeColor);
                        break;
                    default:
                        System.out.println("Invalid dye index: " + dyeIndex);
                        break;
                }


                dyeStack.shrink(1);
                System.out.println("Dye stack shrunk, new count: " + dyeStack.getCount());
                if (dyeStack.getCount() == 0) {
                    dyeStack = ItemStack.EMPTY;
                    System.out.println("Dye stack is now empty.");
                }
            }
            if (armorStack.getItem() instanceof HaraateHakamaArmorItem HaraateHakamaArmorItem) {
                System.out.println("Found HaraateHakamaArmorItem in slot: " + armorSlotIndex);
                switch (dyeIndex) {
                    case 0: // Primary color
                        HaraateHakamaArmorItem.setPrimaryColor(armorStack, dyeColor);
                        System.out.println("Set primary color to: " + dyeColor);
                        break;
                    case 2: // Secondary color
                        HaraateHakamaArmorItem.setSecondaryColor(armorStack, dyeColor);
                        System.out.println("Set secondary color to: " + dyeColor);
                        break;
                    case 4: // Gold Part
                        HaraateHakamaArmorItem.setGoldColor(armorStack, dyeColor);
                        System.out.println("Set gold color to: " + dyeColor);
                        break;
                    case 6: // Silver Part
                        HaraateHakamaArmorItem.setSilverColor(armorStack, dyeColor);
                        System.out.println("Set silver color to: " + dyeColor);
                        break;
                    default:
                        System.out.println("Invalid dye index: " + dyeIndex);
                        break;
                }


                dyeStack.shrink(1);
                System.out.println("Dye stack shrunk, new count: " + dyeStack.getCount());
                if (dyeStack.getCount() == 0) {
                    dyeStack = ItemStack.EMPTY;
                    System.out.println("Dye stack is now empty.");
                }
            }
            if (armorStack.getItem() instanceof HaraateArmorItem HaraateArmorItem) {
                System.out.println("Found HaraateHakamaArmorItem in slot: " + armorSlotIndex);
                switch (dyeIndex) {
                    case 0: // Primary color
                        HaraateArmorItem.setPrimaryColor(armorStack, dyeColor);
                        System.out.println("Set primary color to: " + dyeColor);
                        break;
                    case 2: // Secondary color
                        HaraateArmorItem.setSecondaryColor(armorStack, dyeColor);
                        System.out.println("Set secondary color to: " + dyeColor);
                        break;
                    case 4: // Gold Part
                        HaraateArmorItem.setGoldColor(armorStack, dyeColor);
                        System.out.println("Set gold color to: " + dyeColor);
                        break;
                    case 6: // Silver Part
                        HaraateArmorItem.setSilverColor(armorStack, dyeColor);
                        System.out.println("Set silver color to: " + dyeColor);
                        break;
                    default:
                        System.out.println("Invalid dye index: " + dyeIndex);
                        break;
                }


                dyeStack.shrink(1);
                System.out.println("Dye stack shrunk, new count: " + dyeStack.getCount());
                if (dyeStack.getCount() == 0) {
                    dyeStack = ItemStack.EMPTY;
                    System.out.println("Dye stack is now empty.");
                }
            }
            if (armorStack.getItem() instanceof HoshiKabutoItem HoshiKabutoItem) {
                System.out.println("Found HoshiKabutoItem in slot: " + armorSlotIndex);
                switch (dyeIndex) {
                    case 0: // Primary color
                        HoshiKabutoItem.setPrimaryColor(armorStack, dyeColor);
                        System.out.println("Set primary color to: " + dyeColor);
                        break;
                    case 2: // Secondary color
                        HoshiKabutoItem.setSecondaryColor(armorStack, dyeColor);
                        System.out.println("Set secondary color to: " + dyeColor);
                        break;
                    case 4: // Gold Part
                        HoshiKabutoItem.setGoldColor(armorStack, dyeColor);
                        System.out.println("Set gold color to: " + dyeColor);
                        break;
                    case 6: // Silver Part
                        HoshiKabutoItem.setSilverColor(armorStack, dyeColor);
                        System.out.println("Set silver color to: " + dyeColor);
                        break;
                    default:
                        System.out.println("Invalid dye index: " + dyeIndex);
                        break;
                }


                dyeStack.shrink(1);
                System.out.println("Dye stack shrunk, new count: " + dyeStack.getCount());
                if (dyeStack.getCount() == 0) {
                    dyeStack = ItemStack.EMPTY;
                    System.out.println("Dye stack is now empty.");
                }
            }
            if (armorStack.getItem() instanceof KariginuItem KariginuItem) {
                System.out.println("Found KariginuItem in slot: " + armorSlotIndex);
                switch (dyeIndex) {
                    case 0: // Primary color
                        KariginuItem.setPrimaryColor(armorStack, dyeColor);
                        System.out.println("Set primary color to: " + dyeColor);
                        break;
                    case 2: // Secondary color
                        KariginuItem.setSecondaryColor(armorStack, dyeColor);
                        System.out.println("Set secondary color to: " + dyeColor);
                        break;
                    case 4: // Gold Part
                        KariginuItem.setGoldColor(armorStack, dyeColor);
                        System.out.println("Set gold color to: " + dyeColor);
                        break;
                    case 6: // Silver Part
                        KariginuItem.setSilverColor(armorStack, dyeColor);
                        System.out.println("Set silver color to: " + dyeColor);
                        break;
                    default:
                        System.out.println("Invalid dye index: " + dyeIndex);
                        break;
                }


                dyeStack.shrink(1);
                System.out.println("Dye stack shrunk, new count: " + dyeStack.getCount());
                if (dyeStack.getCount() == 0) {
                    dyeStack = ItemStack.EMPTY;
                    System.out.println("Dye stack is now empty.");
                }
            }





            }
    } else {
        System.out.println("Item is not a DyeItem.");
    }
}


    @Override
    public Map<Integer, Slot> get() {
        return customSlots;
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (pIndex < 1) {
                if (!this.moveItemStackTo(itemstack1, 1, this.slots.size(), true))
                    return ItemStack.EMPTY;
                slot.onQuickCraft(itemstack1, itemstack);
            } else if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                if (pIndex < 1 + 27) {
                    if (!this.moveItemStackTo(itemstack1, 1 + 27, this.slots.size(), true))
                        return ItemStack.EMPTY;
                } else {
                    if (!this.moveItemStackTo(itemstack1, 1, 1 + 27, false))
                        return ItemStack.EMPTY;
                }
                return ItemStack.EMPTY;
            }
            if (itemstack1.getCount() == 0)
                slot.set(ItemStack.EMPTY);
            else
                slot.setChanged();
            if (itemstack1.getCount() == itemstack.getCount())
                return ItemStack.EMPTY;
            slot.onTake(playerIn, itemstack1);
        }
        return itemstack;
    }

    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);

        for (int i = 0; i < internal.getSlots(); i++) {
            ItemStack stack = internal.getStackInSlot(i);
            if (!stack.isEmpty()) {
                if (!player.getInventory().add(stack)) {
                    player.drop(stack, false);
                }
                internal.extractItem(i, stack.getCount(), false);
            }
        }
    }


    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        boolean bound = false;
        if (bound) {
            if (this.boundItemMatcher != null)
                return this.boundItemMatcher.get();
            else if (this.boundBlockEntity != null)
                return AbstractContainerMenu.stillValid(this.access, pPlayer, this.boundBlockEntity.getBlockState().getBlock());
            else if (this.boundEntity != null)
                return this.boundEntity.isAlive();
        }
        return true;
    }

}
