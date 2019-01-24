package MurkyConspiracy.mod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.material.Material;
import MurkyConspiracy.mod.objects.items.ItemBase;
import MurkyConspiracy.mod.objects.items.NuggetBase; 
import net.minecraft.item.Item;

public class ItemInit 
{	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item decay_food = new ItemBase("decay_food");
	
	//public static final Item ingot_copper = new ItemBase("ingot_copper");
	public static final Item copper = new NuggetBase("copper", true, Material.ROCK);
	public static final Item ingot_tin = new ItemBase("ingot_tin");
	public static final Item ingot_lead = new ItemBase("ingot_lead");
	public static final Item ingot_zinc = new ItemBase("ingot_zinc");
	public static final Item ingot_nickel = new ItemBase("ingot_nickel");
	public static final Item ingot_platinum = new ItemBase("ingot_platinum");
	public static final Item ingot_tungsten = new ItemBase("ingot_tungsten");
	
}
