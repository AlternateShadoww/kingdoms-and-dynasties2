package net.alternativewill.kingdomsanddynasties2.world.inventory;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, KingdomsAndDynasties2.MOD_ID);

    public static final RegistryObject<MenuType<YoroiStandMenu>> YOROI_STAND_GUI = REGISTRY.register("yoroi_stand_gui", () -> IForgeMenuType.create(YoroiStandMenu::new));
}
