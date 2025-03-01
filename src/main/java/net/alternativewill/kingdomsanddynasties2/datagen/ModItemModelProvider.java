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
        simpleItem(ModItems.COTTONSEED);
        simpleItem(ModItems.YOROI_STAND_ITEM);

        //BLOCK ITEMS
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

        //STAIRS
        evenSimplerBlockItem(ModBlocks.SUGI_STAIRS);
        evenSimplerBlockItem(ModBlocks.RED_PINE_STAIRS);
        evenSimplerBlockItem(ModBlocks.MULLBERRY_STAIRS);

        //SLABS
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

        //ARMOR ITEMS
        simpleItem(ModItems.EBOSHIHAT);
        simpleItem(ModItems.ZUNARI_HELMET);
        simpleItem(ModItems.TOPPAINARI_HELMET);
        simpleItem(ModItems.EBOSHI_HELMET);
        simpleItem(ModItems.SUJI_HELMET);
        simpleItem(ModItems.OYOROI_HELMET);
        simpleItem(ModItems.OYOROI_CHESTPLATE);
        simpleItem(ModItems.OYOROI_LEGGINGS);
        simpleItem(ModItems.OYOROI_BOOTS);

        simpleItem(ModItems.MENPO);

        simpleItem(ModItems.GI);
        simpleItem(ModItems.HAKAMA);

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
                .rotation(45,91,-2)
                .translation(0,8,2f)
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(45,-89,2)
                .translation(0,8,2f)
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(45,91,-2)
                .translation(0,8,2f)
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(45,-89,2)
                .translation(0,8,2f)
                .scale(1.2F, 1.2F, 1).end();

        getBuilder("odachi")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/odachi"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(-4, 4, 0) // Move the item slightly upward
                .scale(2.5F, 2.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GUI)
                .rotation(180, 180, 180) // Rotate the item to face forward in the item frame
                .translation(4, 5F, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(-4, 12, 0) // Move the item slightly upward
                .scale(2.4F, 2.4F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(45,91,-2)
                .translation(0,17,1.2f)
                .scale(2.4F, 2.4F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(45,-89,2)
                .translation(0,17,1.2f)
                .scale(2.4F , 2.4F, 1).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(45,91,-2)
                .translation(0,17,1.2f)
                .scale(2.4F, 2.4F, 1).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(45,-89,2)
                .translation(0,17,1.2f)
                .scale(2.4F, 2.4F, 1).end();

        getBuilder("tanto")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/tanto"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(-5, 5, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GUI)
                .rotation(180, 180, 180) // Rotate the item to face forward in the item frame
                .translation(6, 5.5F, 0) // Move the item slightly upward
                .scale(1.7F, 1.7F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(-5, 5, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(45,91,-2)
                .translation(0,8,2f)
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(45,-89,2)
                .translation(0,8,2f)
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(45,91,-2)
                .translation(0,8,2f)
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(45,-89,2)
                .translation(0,8,2f)
                .scale(1.2F, 1.2F, 1).end();

        getBuilder("wakizashi")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/wakizashi"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(-4, 4, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GUI)
                .rotation(180, 180, 180) // Rotate the item to face forward in the item frame
                .translation(3F, 3F, 0) // Move the item slightly upward
                .scale(1.3F, 1.3F, 1.3F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(-4, 4, 0) // Move the item slightly upward
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(45,91,-2)
                .translation(0,9.5f,2f)
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(45,-89,2)
                .translation(0,9.5f,2f)
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(45,91,-2)
                .translation(0,8,2f)
                .scale(1.2F, 1.2F, 1).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(45,-89,2)
                .translation(0,8,2f)
                .scale(1.2F, 1.2F, 1).end();

        getBuilder("tachi")
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/tachi"))
                .transforms()
                .transform(ItemDisplayContext.FIXED)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(-8, 5, 0) // Move the item slightly upward
                .scale(2.5F, 2.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GUI)
                .rotation(180, 180, 180) // Rotate the item to face forward in the item frame
                .translation(4.8F, 4.5F, 0) // Move the item slightly upward
                .scale(1.5F, 1.5F, 1.5F) // Scale the item up to 1.5x
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(180, 360, 180) // Rotate the item to face forward in the item frame
                .translation(-8, 12, 0) // Move the item slightly upward
                .scale(2.4F, 2.4F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(45,91,-2)
                .translation(0,18.2f,1.2f)
                .scale(2.4F, 2.4F, 1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(45,-89,2)
                .translation(0,18.2f,2f)
                .scale(2.4F , 2.4F, 1).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(45,91,-2)
                .translation(0,18.2f,2f)
                .scale(2.4F, 2.4F, 1).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(45,-89,2)
                .translation(0,18.2f,2f)
                .scale(2.4F, 2.4F, 1).end();
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