package net.alternativewill.kingdomsanddynasties2.datagen;
import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.alternativewill.kingdomsanddynasties2.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, KingdomsAndDynasties2.MOD_ID, existingFileHelper);
    }


    @Override
    protected void registerModels() {
        //BASE ITEMS
        simpleItem(ModItems.SILK);
        simpleItem(ModItems.PATTERNED_SCROLL);
        simpleItem(ModItems.IRON_SAND);
        simpleItem(ModItems.COTTON);
        simpleItem(ModItems.KASURI);
        simpleItem(ModItems.COTTONSEED);
        simpleItem(ModItems.YOROI_STAND_ITEM);
        simpleItem(ModItems.FIRESTICK);

        //BLOCK ITEMS
        evenSimplerBlockItem(ModBlocks.WILD_COTTON);
        evenSimplerBlockItem(ModBlocks.IRON_SAND_BLOCK);
        evenSimplerBlockItem(ModBlocks.GRAVELLED_IRON_SAND_BLOCK);
        evenSimplerBlockItem(ModBlocks.MOSSY_IRON_SAND_BLOCK);
        evenSimplerBlockItem(ModBlocks.RED_PINE_LOG);
        evenSimplerBlockItem(ModBlocks.RED_PINE_WOOD);
        evenSimplerBlockItem(ModBlocks.STRIPPED_RED_PINE_LOG);
        evenSimplerBlockItem(ModBlocks.STRIPPED_RED_PINE_WOOD);
        evenSimplerBlockItem(ModBlocks.RED_PINE_PLANKS);
        evenSimplerBlockItem(ModBlocks.RED_PINE_LEAVES);
        evenSimplerBlockItem(ModBlocks.SUGI_LOG);
        evenSimplerBlockItem(ModBlocks.SUGI_WOOD);
        evenSimplerBlockItem(ModBlocks.STRIPPED_SUGI_LOG);
        evenSimplerBlockItem(ModBlocks.STRIPPED_SUGI_WOOD);
        evenSimplerBlockItem(ModBlocks.SUGI_PLANKS);
        evenSimplerBlockItem(ModBlocks.SUGI_LEAVES);
        evenSimplerBlockItem(ModBlocks.MULLBERRY_LOG);
        evenSimplerBlockItem(ModBlocks.MULLBERRY_WOOD);
        evenSimplerBlockItem(ModBlocks.STRIPPED_MULLBERRY_LOG);
        evenSimplerBlockItem(ModBlocks.STRIPPED_MULLBERRY_WOOD);
        evenSimplerBlockItem(ModBlocks.MULLBERRY_PLANKS);
        evenSimplerBlockItem(ModBlocks.MULLBERRY_LEAVES);
        evenSimplerBlockItem(ModBlocks.SHIKKUI_PLASTER);

        //STAIRS
        evenSimplerBlockItem(ModBlocks.PALE_GRANITE_STAIRS);
        evenSimplerBlockItem(ModBlocks.PALE_GRANITE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.MOSSY_PALE_GRANITE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.SUGI_STAIRS);
        evenSimplerBlockItem(ModBlocks.RED_PINE_STAIRS);
        evenSimplerBlockItem(ModBlocks.MULLBERRY_STAIRS);

        //SLABS
        evenSimplerBlockItem(ModBlocks.PALE_GRANITE_SLAB);
        evenSimplerBlockItem(ModBlocks.PALE_GRANITE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.MOSSY_PALE_GRANITE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.SUGI_SLAB);
        evenSimplerBlockItem(ModBlocks.RED_PINE_SLAB);
        evenSimplerBlockItem(ModBlocks.MULLBERRY_SLAB);

        //BUTTONS
        buttonItem(ModBlocks.SUGI_BUTTON, ModBlocks.SUGI_PLANKS);
        buttonItem(ModBlocks.RED_PINE_BUTTON, ModBlocks.RED_PINE_PLANKS);
        buttonItem(ModBlocks.MULLBERRY_BUTTON, ModBlocks.MULLBERRY_PLANKS);

        //PRESSUREPLATES
        evenSimplerBlockItem(ModBlocks.SUGI_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.RED_PINE_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.MULLBERRY_PRESSURE_PLATE);
        //FENCES
        fenceItem(ModBlocks.SUGI_FENCE, ModBlocks.SUGI_PLANKS);
        fenceItem(ModBlocks.RED_PINE_FENCE, ModBlocks.RED_PINE_PLANKS);
        fenceItem(ModBlocks.MULLBERRY_FENCE, ModBlocks.MULLBERRY_PLANKS);

        //FENCE GATES
        evenSimplerBlockItem(ModBlocks.SUGI_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.RED_PINE_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.MULLBERRY_FENCE_GATE);

        //WALLS
        wallItem(ModBlocks.PALE_GRANITE_WALL, ModBlocks.PALE_GRANITE);
        wallItem(ModBlocks.PALE_GRANITE_BRICK_WALL, ModBlocks.PALE_GRANITE_BRICKS);
        wallItem(ModBlocks.MOSSY_PALE_GRANITE_BRICK_WALL, ModBlocks.MOSSY_PALE_GRANITE_BRICKS);
        wallItem(ModBlocks.SUGI_WALL, ModBlocks.SUGI_LOG);
        wallItem(ModBlocks.RED_PINE_WALL, ModBlocks.RED_PINE_LOG);
        wallItem(ModBlocks.MULLBERRY_WALL, ModBlocks.MULLBERRY_LOG);

        //DOORS
        simpleBlockItem(ModBlocks.SUGI_DOOR);
        simpleBlockItem(ModBlocks.RED_PINE_DOOR);
        simpleBlockItem(ModBlocks.MULLBERRY_DOOR);

        //TRAPDOORS
        trapdoorItem(ModBlocks.SUGI_TRAPDOOR);
        trapdoorItem(ModBlocks.RED_PINE_TRAPDOOR);
        trapdoorItem(ModBlocks.MULLBERRY_TRAPDOOR);

        //INGOT ITEMS
        simpleItem(ModItems.TAMAHAGANE_INGOT);
        simpleItem(ModItems.TAMAHAGANE_NUGGET);
        simpleItem(ModItems.TAMAHAGANE_PLATE);

        //ARMOR CRAFTING ITEMS
        simpleItem(ModItems.KABUTO);
        simpleItem(ModItems.SODE);

        //ORE ITEMS
        simpleItem(ModItems.RAW_TAMAHAGANE);

        //ARMOR ITEM

        simpleItem(ModItems.MENPO);
        simpleItem(ModItems.HAPPURI);
        simpleItem(ModItems.HANBO);


        //TOOLS & WEAPONS
        simpleItem(ModItems.KATANA_SHEATH);
        simpleItem(ModItems.TANTO_SHEATH);
        simpleItem(ModItems.WAKIZASHI_SHEATH);
        simpleItem(ModItems.TACHI_SHEATH);
        simpleItem(ModItems.ODACHI_SHEATH);

        handheldItem(ModItems.KATANA);
        handheldItem(ModItems.TANTO);
        handheldItem(ModItems.WAKIZASHI);
        handheldItem(ModItems.TACHI);
        handheldItem(ModItems.ODACHI);

        simpleItem(ModItems.TSUKA);
        simpleItem(ModItems.SMALLTSUKA);
        simpleItem(ModItems.LONGTSUKA);


        getBuilder("kozuchi")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/kozuchi"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 8, 2)  // Move up and slightly forward
                .scale(1F, 1F, 1F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0, 8, 2)  // Reverse X translation
                .scale(1F, 1F, 1F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(1.0F, 1.0F, 1.0F).end();
        getBuilder("paddle")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/paddle"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 8, 2)  // Move up and slightly forward
                .scale(1.2F, 1.2F, 1F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0, 8, 2)  // Reverse X translation
                .scale(1.2F, 1.2F, 1F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(1.0F, 1.0F, 1.0F).end();
        getBuilder("katana")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/katana"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 8, 2)  // Move up and slightly forward
                .scale(1.2F, 1.2F, 1F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0, 8, 2)  // Reverse X translation
                .scale(1.2F, 1.2F, 1F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(1.0F, 1.0F, 1.0F).end();
        getBuilder("tanto")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/tanto"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1F, 1F, 1F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(0.7F, 0.7F, 0.7F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 4, 2)  // Move up and slightly forward
                .scale(0.7F, 0.7F, 1F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0, 4, 2)  // Reverse X translation
                .scale(0.7F, 0.7F, 1F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(0.7F, 0.7F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(0.7F, 0.7F, 1.0F).end();
        getBuilder("wakizashi")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/wakizashi"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1F, 1F, 1F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(0.9F, 0.9F, 0.9F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 5.5F, 2)  // Move up and slightly forward
                .scale(0.9F, 0.9F, 1F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0, 5.5F, 2)  // Reverse X translation
                .scale(0.9F, 0.9F, 1F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(0.9F, 0.9F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(0.9F, 0.9F, 1.0F).end();
        getBuilder("chukoto")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/chukoto"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 8, 2)  // Move up and slightly forward
                .scale(1.2F, 1.2F, 1F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0, 8, 2)  // Reverse X translation
                .scale(1.2F, 1.2F, 1F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(1.0F, 1.0F, 1.0F).end();
        getBuilder("tsurugi")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/tsurugi"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 8, 2)  // Move up and slightly forward
                .scale(1.2F, 1.2F, 1F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0, 8, 2)  // Reverse X translation
                .scale(1.2F, 1.2F, 1F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(1.0F, 1.0F, 1.0F).end();
        getBuilder("tachi")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/tachi"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 8, 2)  // Move up and slightly forward
                .scale(1.4F, 1.4F, 1F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0, 8, 2)  // Reverse X translation
                .scale(1.4F, 1.4F, 1F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(1.0F, 1.0F, 1.0F).end();
        getBuilder("kanabo")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/kanabo"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 8, 2)  // Move up and slightly forward
                .scale(1.4F, 1.4F, 1F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0, 8, 2)  // Reverse X translation
                .scale(1.4F, 1.4F, 1F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(1.0F, 1.0F, 1.0F).end();
        getBuilder("wooden_kanabo")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/wooden_kanabo"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 8, 2)  // Move up and slightly forward
                .scale(1.4F, 1.4F, 1F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0, 8, 2)  // Reverse X translation
                .scale(1.4F, 1.4F, 1F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(1.0F, 1.0F, 1.0F).end();
        getBuilder("odachi")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/odachi"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 11, 4)  // Move up and slightly forward
                .scale(1.6F, 1.6F, 1F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0F, 11, 4)  // Reverse X translation
                .scale(1.6F, 1.6F, 1F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(1.2F, 1.2F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(1.2F, 1.2F, 1.0F).end();
        getBuilder("nagamaki")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/nagamaki"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 8, 2)  // Move up and slightly forward
                .scale(1.8F, 1.8F, 1F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0, 8, 2)  // Reverse X translation
                .scale(1.8F, 1.8F, 1F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(1.0F, 1.0F, 1.0F).end();
        getBuilder("naginata")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/naginata"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 8, 2)  // Move up and slightly forward
                .scale(2.4F, 2.4F, 1F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0, 8, 2)  // Reverse X translation
                .scale(2.4F, 2.4F, 1F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(1.0F, 1.0F, 1.0F).end();
        getBuilder("yari")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/yari"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 8, 2)  // Move up and slightly forward
                .scale(2.4F, 2.4F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0, 8, 2)  // Reverse X translation
                .scale(2.4F, 2.4F, 1).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(1.0F, 1.0F, 1.0F).end();
        getBuilder("hoko")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/hoko"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 1, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(0, 7, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 45)  // Tilt it slightly to align with the hand
                .translation(0F, 8, 2)  // Move up and slightly forward
                .scale(2.4F, 2.4F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -45)  // Mirrored rotation
                .translation(0, 8, 2)  // Reverse X translation
                .scale(2.4F, 2.4F, 1).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, -90, 25) // Keep rotation similar to the diamond sword
                .translation(2, 4, 0) // Increase X translation slightly (move right)
                .scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0, 90, -25) // Mirror rotation for left hand
                .translation(2, 4, 0) // Adjust X translation slightly for left hand
                .scale(1.0F, 1.0F, 1.0F).end();
    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(KingdomsAndDynasties2.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(KingdomsAndDynasties2.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(KingdomsAndDynasties2.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(KingdomsAndDynasties2.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(KingdomsAndDynasties2.MOD_ID,"item/" + item.getId().getPath()));
    }
}