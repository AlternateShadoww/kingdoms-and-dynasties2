package net.alternativewill.kingdomsanddynasties2.datagen;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.alternativewill.kingdomsanddynasties2.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        //LOG TO PLANKS | WOOD TO PLANKS

            //LOG  ---- WILL PROBABLY NEED TO USE TAGS FOR THE WOOD RECIPE BECAUSE EACH THING CAN ONLY HAVE ONE "RECIPE" HERE
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.MULLBERRY_PLANKS.get(), 4)
                .requires(ModBlocks.MULLBERRY_LOG.get())
                .unlockedBy(getHasName(ModBlocks.MULLBERRY_LOG.get()), has(ModBlocks.MULLBERRY_LOG.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.RED_PINE_PLANKS.get(), 4)
                .requires(ModBlocks.RED_PINE_LOG.get())
                .unlockedBy(getHasName(ModBlocks.RED_PINE_LOG.get()), has(ModBlocks.RED_PINE_LOG.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.SUGI_PLANKS.get(), 4)
                .requires(ModBlocks.SUGI_LOG.get())
                .unlockedBy(getHasName(ModBlocks.SUGI_LOG.get()), has(ModBlocks.SUGI_LOG.get()))
                .save(pWriter);

        //LOG TO WOOD
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MULLBERRY_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.MULLBERRY_LOG.get())
                .unlockedBy(getHasName(ModBlocks.MULLBERRY_LOG.get()), has(ModBlocks.MULLBERRY_LOG.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_PINE_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.RED_PINE_LOG.get())
                .unlockedBy(getHasName(ModBlocks.RED_PINE_LOG.get()), has(ModBlocks.RED_PINE_LOG.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SUGI_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.SUGI_LOG.get())
                .unlockedBy(getHasName(ModBlocks.SUGI_LOG.get()), has(ModBlocks.SUGI_LOG.get()))
                .save(pWriter);

        //INGOT RECIPES

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TAMAHAGANE_INGOT.get())
                .requires(ModItems.TAMAHAGANE_NUGGET.get(), 9)
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_NUGGET.get()), has(ModItems.TAMAHAGANE_NUGGET.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TAMAHAGANE_NUGGET.get(), 9)
                .requires(ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .save(pWriter);

        //MATERIAL RECIPE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.KASURI.get(), 2)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModItems.COTTON.get())
                .unlockedBy(getHasName(ModItems.COTTON.get()), has(ModItems.COTTON.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TAMAHAGANE_PLATE.get(), 1)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SODE.get(), 1)
                .pattern("NNN")
                .pattern("STS")
                .pattern("NTN")
                .define('S', ModItems.SILK.get())
                .define('N', ModItems.TAMAHAGANE_NUGGET.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_NUGGET.get()), has(ModItems.TAMAHAGANE_NUGGET.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.KABUTO.get(), 1)
                .pattern("TPT")
                .pattern("T T")
                .pattern("SSS")
                .define('S', ModItems.SILK.get())
                .define('P', ModItems.TAMAHAGANE_PLATE.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_PLATE.get()), has(ModItems.TAMAHAGANE_PLATE.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .save(pWriter);
        //JINGASA VARIANTS
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JINGASA.get(), 1)
                .pattern(" W ")
                .pattern("WWW")
                .pattern("BSB")
                .define('W', Items.WHEAT)
                .define('B', Items.BAMBOO)
                .define('S', ModItems.SILK.get())
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(Items.BAMBOO), has(Items.BAMBOO))
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JINGASA2.get(), 1)
                .pattern(" W ")
                .pattern("WWW")
                .pattern("SSS")
                .define('W', Items.WHEAT)
                .define('S', ModItems.SILK.get())
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JINGASA3.get(), 1)
                .pattern(" W ")
                .pattern("W W")
                .pattern("SSS")
                .define('W', Items.WHEAT)
                .define('S', ModItems.SILK.get())
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JINGASA4.get(), 1)
                .pattern(" W ")
                .pattern("WBW")
                .pattern("SSS")
                .define('W', Items.WHEAT)
                .define('B', Items.BAMBOO)
                .define('S', ModItems.SILK.get())
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(Items.BAMBOO), has(Items.BAMBOO))
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JINGASA5.get(), 1)
                .pattern(" W ")
                .pattern("WWW")
                .pattern("WSW")
                .define('W', Items.WHEAT)
                .define('S', ModItems.SILK.get())
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EBOSHIHAT.get(), 1)
                .pattern("SSS")
                .pattern("SPS")
                .define('P', Items.PAPER)
                .define('S', ModItems.SILK.get())
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EBOSHIHAT2.get(), 1)
                .pattern(" S ")
                .pattern("SKS")
                .pattern("P P")
                .define('P', Items.PAPER)
                .define('S', ModItems.SILK.get())
                .define('K', ModItems.KASURI.get())
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .unlockedBy(getHasName(ModItems.KASURI.get()), has(ModItems.KASURI.get()))
                .save(pWriter);
        //KABUTO VARIANTS
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OYOROI_HELMET.get(), 1)
                .pattern("GTG")
                .pattern("TKT")
                .define('G', Items.GOLD_NUGGET)
                .define('K', ModItems.KABUTO.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                .unlockedBy(getHasName(ModItems.KABUTO.get()), has(ModItems.KABUTO.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EBOSHI_HELMET.get(), 1)
                .pattern(" N ")
                .pattern("GPG")
                .pattern("TKT")
                .define('G', Items.GOLD_NUGGET)
                .define('K', ModItems.KABUTO.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .define('N', ModItems.TAMAHAGANE_NUGGET.get())
                .define('P', ModItems.TAMAHAGANE_PLATE.get())
                .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                .unlockedBy(getHasName(ModItems.KABUTO.get()), has(ModItems.KABUTO.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_PLATE.get()), has(ModItems.TAMAHAGANE_PLATE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TOPPAINARI_HELMET.get(), 1)
                .pattern("GNG")
                .pattern("TKT")
                .define('G', Items.GOLD_NUGGET)
                .define('K', ModItems.KABUTO.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .define('N', ModItems.TAMAHAGANE_NUGGET.get())
                .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                .unlockedBy(getHasName(ModItems.KABUTO.get()), has(ModItems.KABUTO.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUJI_HELMET.get(), 1)
                .pattern("G G")
                .pattern("NNN")
                .pattern("TKT")
                .define('G', Items.GOLD_NUGGET)
                .define('K', ModItems.KABUTO.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .define('N', ModItems.TAMAHAGANE_NUGGET.get())
                .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                .unlockedBy(getHasName(ModItems.KABUTO.get()), has(ModItems.KABUTO.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ZUNARI_HELMET.get(), 1)
                .pattern("TTT")
                .pattern("TKT")
                .define('K', ModItems.KABUTO.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.KABUTO.get()), has(ModItems.KABUTO.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HOSHI_HELMET.get(), 1)
                .pattern("NTN")
                .pattern("GKG")
                .define('G', Items.GOLD_INGOT)
                .define('K', ModItems.KABUTO.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .define('N', ModItems.TAMAHAGANE_NUGGET.get())
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .unlockedBy(getHasName(ModItems.KABUTO.get()), has(ModItems.KABUTO.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .save(pWriter);
        //O-yoroi
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OYOROI_CHESTPLATE.get(), 1)
                .pattern("S S")
                .pattern("PPP")
                .pattern("CLC")
                .define('L', Items.LEATHER)
                .define('S', ModItems.SODE.get())
                .define('C', ModItems.COTTON.get())
                .define('P', ModItems.TAMAHAGANE_PLATE.get())
                .unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
                .unlockedBy(getHasName(ModItems.SODE.get()), has(ModItems.SODE.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_PLATE.get()), has(ModItems.TAMAHAGANE_PLATE.get()))
                .unlockedBy(getHasName(ModItems.COTTON.get()), has(ModItems.COTTON.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OYOROI_LEGGINGS.get(), 1)
                .pattern("PTP")
                .pattern("T T")
                .pattern("G G")
                .define('G', Items.GOLD_NUGGET)
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .define('P', ModItems.TAMAHAGANE_PLATE.get())
                .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_PLATE.get()), has(ModItems.TAMAHAGANE_PLATE.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OYOROI_BOOTS.get(), 1)
                .pattern("P P")
                .pattern("N N")
                .define('N', ModItems.TAMAHAGANE_NUGGET.get())
                .define('P', ModItems.TAMAHAGANE_PLATE.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_PLATE.get()), has(ModItems.TAMAHAGANE_PLATE.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_NUGGET.get()), has(ModItems.TAMAHAGANE_NUGGET.get()))
                .save(pWriter);
        //DOMARU
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DOMARU_CHESTPLATE.get(), 1)
                .pattern("S S")
                .pattern("TPT")
                .pattern("CCC")
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .define('S', ModItems.SODE.get())
                .define('C', ModItems.COTTON.get())
                .define('P', ModItems.TAMAHAGANE_PLATE.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.SODE.get()), has(ModItems.SODE.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_PLATE.get()), has(ModItems.TAMAHAGANE_PLATE.get()))
                .unlockedBy(getHasName(ModItems.COTTON.get()), has(ModItems.COTTON.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DOMARU_LEGGINGS.get(), 1)
                .pattern("TTT")
                .pattern("T T")
                .pattern("G G")
                .define('G', Items.GOLD_NUGGET)
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DOMARU_BOOTS.get(), 1)
                .pattern("T T")
                .pattern("T T")
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .save(pWriter);
        //Hara-ate
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HARAATE_CHESTPLATE.get(), 1)
                .pattern("T T")
                .pattern("TTT")
                .pattern("CCC")
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .define('C', ModItems.COTTON.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.COTTON.get()), has(ModItems.COTTON.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HARAATE_LEGGINGS.get(), 1)
                .pattern("NTN")
                .pattern("T T")
                .pattern("G G")
                .define('G', Items.GOLD_NUGGET)
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .define('N', ModItems.TAMAHAGANE_NUGGET.get())
                .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_NUGGET.get()), has(ModItems.TAMAHAGANE_NUGGET.get()))
                .save(pWriter);
        //HAKAMA & GI
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GI.get(), 1)
                .pattern("C C")
                .pattern("KKK")
                .pattern("KKK")
                .define('K', ModItems.KASURI.get())
                .define('C', ModItems.COTTON.get())
                .unlockedBy(getHasName(ModItems.KASURI.get()), has(ModItems.KASURI.get()))
                .unlockedBy(getHasName(ModItems.COTTON.get()), has(ModItems.COTTON.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAKAMA.get(), 1)
                .pattern("SSS")
                .pattern("K K")
                .pattern("S S")
                .define('S', ModItems.SILK.get())
                .define('K', ModItems.KASURI.get())
                .unlockedBy(getHasName(ModItems.KASURI.get()), has(ModItems.KASURI.get()))
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HARAATEHAKAMA_CHESTPLATE.get())
                .requires(ModItems.GI.get(), 1)
                .requires(ModItems.HARAATE_CHESTPLATE.get(), 1)
                .unlockedBy(getHasName(ModItems.GI.get()), has(ModItems.GI.get()))
                .unlockedBy(getHasName(ModItems.HARAATE_CHESTPLATE.get()), has(ModItems.HARAATE_CHESTPLATE.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HARAATEHAKAMA_LEGGINGS.get())
                .requires(ModItems.HAKAMA.get(), 1)
                .requires(ModItems.HARAATE_LEGGINGS.get(), 1)
                .unlockedBy(getHasName(ModItems.HAKAMA.get()), has(ModItems.HAKAMA.get()))
                .unlockedBy(getHasName(ModItems.HARAATE_CHESTPLATE.get()), has(ModItems.HARAATE_CHESTPLATE.get()))
                .save(pWriter);
        //KARIGINU
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.KARIGINU.get(), 1)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SILK.get())
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.KARIGINU_SASHINUKI.get(), 1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.SILK.get())
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .save(pWriter);

        //TSUKAS
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TSUKA.get(), 1)
                .pattern("S")
                .pattern("T")
                .pattern("T")
                .define('S', ModItems.SILK.get())
                .define('T', Items.STICK)
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SMALLTSUKA.get(), 1)
                .pattern("S")
                .pattern("T")
                .define('S', ModItems.SILK.get())
                .define('T', Items.STICK)
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LONGTSUKA.get(), 1)
                .pattern(" T ")
                .pattern("STS")
                .pattern(" T ")
                .define('S', ModItems.SILK.get())
                .define('T', Items.STICK)
                .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pWriter);

        //WEAPONS
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TANTO.get(), 1)
                .pattern("N")
                .pattern("T")
                .pattern("S")
                .define('S', ModItems.SMALLTSUKA.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .define('N', ModItems.TAMAHAGANE_NUGGET.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_NUGGET.get()), has(ModItems.TAMAHAGANE_NUGGET.get()))
                .unlockedBy(getHasName(ModItems.SMALLTSUKA.get()), has(ModItems.SMALLTSUKA.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WAKIZASHI.get(), 1)
                .pattern("T")
                .pattern("T")
                .pattern("S")
                .define('S', ModItems.SMALLTSUKA.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.SMALLTSUKA.get()), has(ModItems.SMALLTSUKA.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.KATANA.get(), 1)
                .pattern("T")
                .pattern("T")
                .pattern("S")
                .define('S', ModItems.TSUKA.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.TSUKA.get()), has(ModItems.TSUKA.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TACHI.get(), 1)
                .pattern("TT ")
                .pattern(" T ")
                .pattern(" S ")
                .define('S', ModItems.TSUKA.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.TSUKA.get()), has(ModItems.TSUKA.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ODACHI.get(), 1)
                .pattern("T")
                .pattern("T")
                .pattern("S")
                .define('S', ModItems.LONGTSUKA.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.LONGTSUKA.get()), has(ModItems.LONGTSUKA.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.YARI.get(), 1)
                .pattern("T")
                .pattern("S")
                .pattern("S")
                .define('S', ModItems.LONGTSUKA.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.LONGTSUKA.get()), has(ModItems.LONGTSUKA.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NAGINATA.get(), 1)
                .pattern("NT")
                .pattern(" R")
                .pattern(" S")
                .define('S', ModItems.LONGTSUKA.get())
                .define('N', ModItems.TAMAHAGANE_NUGGET.get())
                .define('R', ModItems.TSUKA.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.TSUKA.get()), has(ModItems.TSUKA.get()))
                .unlockedBy(getHasName(ModItems.LONGTSUKA.get()), has(ModItems.LONGTSUKA.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NAGAMAKI.get(), 1)
                .pattern("T")
                .pattern("S")
                .pattern("S")
                .define('S', ModItems.TSUKA.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.TSUKA.get()), has(ModItems.TSUKA.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HOKO.get(), 1)
                .pattern("T")
                .pattern("R")
                .pattern("S")
                .define('S', ModItems.LONGTSUKA.get())
                .define('R', ModItems.TSUKA.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.TSUKA.get()), has(ModItems.TSUKA.get()))
                .unlockedBy(getHasName(ModItems.LONGTSUKA.get()), has(ModItems.LONGTSUKA.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHUKOTO.get(), 1)
                .pattern("NN")
                .pattern(" T")
                .pattern(" S")
                .define('S', ModItems.TSUKA.get())
                .define('N', ModItems.TAMAHAGANE_NUGGET.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_NUGGET.get()), has(ModItems.TAMAHAGANE_NUGGET.get()))
                .unlockedBy(getHasName(ModItems.TSUKA.get()), has(ModItems.TSUKA.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TSURUGI.get(), 1)
                .pattern("N")
                .pattern("T")
                .pattern("S")
                .define('S', ModItems.TSUKA.get())
                .define('N', ModItems.TAMAHAGANE_NUGGET.get())
                .define('T', ModItems.TAMAHAGANE_INGOT.get())
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_INGOT.get()), has(ModItems.TAMAHAGANE_INGOT.get()))
                .unlockedBy(getHasName(ModItems.TAMAHAGANE_NUGGET.get()), has(ModItems.TAMAHAGANE_NUGGET.get()))
                .unlockedBy(getHasName(ModItems.TSUKA.get()), has(ModItems.TSUKA.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.YOROI_STAND_ITEM.get(), 1)
                .pattern("SSS")
                .pattern(" S ")
                .pattern("SSS")
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pWriter);

        //Smelting
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_TAMAHAGANE.get())
                .requires(ModItems.IRON_SAND.get(), 4)
                .unlockedBy(getHasName(ModItems.IRON_SAND.get()), has(ModItems.IRON_SAND.get()))
                .save(pWriter);
        oreSmelting(pWriter, List.of(ModItems.RAW_TAMAHAGANE.get()),
                RecipeCategory.MISC, ModItems.TAMAHAGANE_INGOT.get(),
                0.7f, 200, "tamahagane_ingot");

        //PLACEHOLDER RECIPES
        oreBlasting(pWriter, List.of(Items.IRON_INGOT),
                RecipeCategory.MISC, ModItems.TAMAHAGANE_INGOT.get(),
                0.7f, 210, "tamahagane_ingot");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILK.get())
                .requires(Items.STRING, 2)
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COTTONSEED.get())
                .requires(Items.WHITE_WOOL, 1)
                .requires(Items.WHEAT_SEEDS, 1)
                .unlockedBy(getHasName(Items.WHEAT_SEEDS), has(Items.WHEAT_SEEDS))
                .save(pWriter);


    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");

    }


    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  KingdomsAndDynasties2.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}