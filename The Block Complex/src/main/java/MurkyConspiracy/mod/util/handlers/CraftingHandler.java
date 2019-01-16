package MurkyConspiracy.mod.util.handlers;

import java.util.ArrayList;

import com.google.common.collect.Lists;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public class CraftingHandler
{
	
	public static void removeRecipies()
	{
		
		ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;
        ArrayList<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValuesCollection());
        
        for(IRecipe r : recipes)
        {
        	
        	recipeRegistry.remove(r.getRegistryName());
        	recipeRegistry.register(DummyRecipe.from(r));
        	
        }
		
	}
	
}
