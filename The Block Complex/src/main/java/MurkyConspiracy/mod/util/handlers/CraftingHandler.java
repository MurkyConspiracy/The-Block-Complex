package MurkyConspiracy.mod.util.handlers;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import MurkyConspiracy.mod.init.BlockInit;
import MurkyConspiracy.mod.init.ItemInit;
import MurkyConspiracy.mod.objects.blocks.BlockOresOverworldMetals;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistry;

public class CraftingHandler
{
	
	//Temporary: add user friendly block additions through for loop manipulation. Block ArrayList instead of item
	private static List<Item> rejectRecipes = Lists.newArrayList(Item.getItemFromBlock(Blocks.FURNACE), Item.getItemFromBlock(Blocks.CRAFTING_TABLE), Item.getItemFromBlock(Blocks.ANVIL), Item.getItemFromBlock(Blocks.CAULDRON));
	
	public static void handleRecipes()
	{
		
		removeRecipies();
		registerRecipes();
		registerSmelting();
		
		
	}
	
	private static void registerSmelting()
	{
		//ForgeRegistry.addSmelting(new ItemStack(Block.COPPER, 1, 0), new ItemStack(Item.COPPER_INGOT, 1, 0));
		//You always have to use a reference through variant for ores
		//you were missing an EXP argument
		//For items we have added, always use ItemInit.ITEMNAME
		GameRegistry.addSmelting(new ItemStack(BlockInit.METAL_OVERWORLD.getDefaultState().withProperty(BlockOresOverworldMetals.VARIANT, EnumHandler.EnumTypeOverworldMetals.COPPER).getBlock(), 1, 0), new ItemStack(ItemInit.decay_food, 3), 1.5f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.METAL_OVERWORLD.getDefaultState().withProperty(BlockOresOverworldMetals.VARIANT, EnumHandler.EnumTypeOverworldMetals.TIN).getBlock(), 1, 1), new ItemStack(ItemInit.decay_food, 3), 1.5f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.METAL_OVERWORLD.getDefaultState().withProperty(BlockOresOverworldMetals.VARIANT, EnumHandler.EnumTypeOverworldMetals.LEAD).getBlock(), 1, 2), new ItemStack(ItemInit.decay_food, 3), 1.5f);

	}

	private static void registerRecipes() 
	{
		
		
	}
	
	private static void removeRecipies()
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
		
}

