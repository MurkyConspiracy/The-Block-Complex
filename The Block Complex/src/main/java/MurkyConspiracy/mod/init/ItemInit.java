package MurkyConspiracy.mod.init;

import java.util.ArrayList;
import java.util.List;

import MurkyConspiracy.mod.objects.items.ItemBase;
import MurkyConspiracy.mod.objects.items.SeedBase;
import MurkyConspiracy.mod.objects.items.complex.NuggetIngotBlock;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class ItemInit 
{	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item decay_food = new ItemBase("decay_food");
	public static final Item copper = new NuggetIngotBlock("copper");
	public static final Item hops_seeds = new SeedBase("hops_seeds", BlockInit.hops, Blocks.FARMLAND);	
	
}
