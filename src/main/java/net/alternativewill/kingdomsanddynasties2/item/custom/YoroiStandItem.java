package net.alternativewill.kingdomsanddynasties2.item.custom;

import net.alternativewill.kingdomsanddynasties2.entity.ModEntities;
import net.alternativewill.kingdomsanddynasties2.entity.custom.YoroiStandEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class YoroiStandItem extends Item {

    public YoroiStandItem(Properties pProperties) {
        super(pProperties);
    }

    // Code From Armor Stand
    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Direction direction = pContext.getClickedFace();
        if (direction == Direction.DOWN) {
            return InteractionResult.FAIL;
        } else {
            Level level = pContext.getLevel();
            BlockPlaceContext blockPlaceContext = new BlockPlaceContext(pContext);
            BlockPos blockPos = blockPlaceContext.getClickedPos();
            ItemStack itemStack = pContext.getItemInHand();
            Vec3 vec3 = Vec3.atBottomCenterOf(blockPos);

            YoroiStandEntity yoroiStandEntity = new YoroiStandEntity(ModEntities.YOROI_STAND.get(), level);
            yoroiStandEntity.setPos(vec3.x(), vec3.y(), vec3.z());

            level.addFreshEntity(yoroiStandEntity);
            itemStack.shrink(1);

            return InteractionResult.SUCCESS;
        }
    }


}
