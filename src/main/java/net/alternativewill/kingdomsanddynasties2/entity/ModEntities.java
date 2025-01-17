package net.alternativewill.kingdomsanddynasties2.entity;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.entity.custom.YoroiStandEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, KingdomsAndDynasties2.MOD_ID);

    public static final RegistryObject<EntityType<YoroiStandEntity>> YOROI_STAND =
            ENTITY_TYPES.register("yoroi_stand",
                    () -> EntityType.Builder.of(YoroiStandEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "yoroi_stand").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
