package net.alternativewill.kingdomsanddynasties2.datagen;

import net.alternativewill.kingdomsanddynasties2.KingdomsAndDynasties2;
import net.alternativewill.kingdomsanddynasties2.block.ModBlocks;
import net.alternativewill.kingdomsanddynasties2.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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