package MurkyConspiracy.mod.util.handlers;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public class CraftingHandler implements IRecipe
{
	
	//Temporary: add user friendly block additions through for loop manipulation. Block ArrayList instead of item
	private static List<Item> rejectRecipes = Lists.newArrayList(Item.getItemFromBlock(Blocks.FURNACE), Item.getItemFromBlock(Blocks.CRAFTING_TABLE), Item.getItemFromBlock(Blocks.ANVIL), Item.getItemFromBlock(Blocks.CAULDRON));
	public static void registerRecipes(IRecipe recipe) 
	{
		
		
	}
	
	public static void removeRecipies()
	{
		
		ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;
        ArrayList<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValuesCollection());
        
        for(IRecipe r : recipes)
        {
        	
        	ItemStack output = r.getRecipeOutput();
        	if(rejectRecipes.contains(output.getItem()))
        	{
        		
        		recipeRegistry.remove(r.getRegistryName());
        		recipeRegistry.register(DummyRecipe.from(r));
        		
        	}
        	
        }
		
	}

	@Override
	public IRecipe setRegistryName(ResourceLocation name)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceLocation getRegistryName()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<IRecipe> getRegistryType()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canFit(int width, int height)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getRecipeOutput()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}

