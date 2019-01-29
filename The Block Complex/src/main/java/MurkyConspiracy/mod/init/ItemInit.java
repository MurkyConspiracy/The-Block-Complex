package MurkyConspiracy.mod.init;

import java.util.ArrayList;
import java.util.List;

import MurkyConspiracy.mod.objects.items.food.ItemCustomFood;
import MurkyConspiracy.mod.objects.items.seeds.ItemCoffeeCherry;
import MurkyConspiracy.mod.objects.items.seeds.ItemTomatoSeeds;
import MurkyConspiracy.mod.objects.items.ItemBase;
import MurkyConspiracy.mod.objects.items.complex.NuggetIngotBlock;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class ItemInit 
{	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item DECAY_FOOD = new ItemBase("decay_food");
	public static final Item COPPER = new NuggetIngotBlock("copper");
	
	//Food
	public static final Item COFFEE_CAKE = new ItemCustomFood("coffee_cake", 8 , 3);
	public static final Item COFFEE_BEAN = new ItemCustomFood("coffee_bean", 1, 0);
	public static final Item TOMATO = new ItemCustomFood("tomato", 2, 1);
	
	//Seeds
	public static final Item COFFEE_CHERRY = new ItemCoffeeCherry("coffee_cherry", 1, 0);
	public static final Item TOMATO_SEEDS = new ItemTomatoSeeds("tomato_seeds", 1, 0);
	
}
