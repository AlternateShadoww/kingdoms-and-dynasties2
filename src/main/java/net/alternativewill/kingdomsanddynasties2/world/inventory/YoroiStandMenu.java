package net.alternativewill.kingdomsanddynasties2.world.inventory;

import net.alternativewill.kingdomsanddynasties2.item.custom.OyoroiArmorItem;
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
