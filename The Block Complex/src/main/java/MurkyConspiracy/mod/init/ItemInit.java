package MurkyConspiracy.mod.init;

import java.util.ArrayList;
import java.util.List;

import MurkyConspiracy.mod.objects.items.ItemBase;
import MurkyConspiracy.mod.objects.items.complex.GemCuts;
import MurkyConspiracy.mod.objects.items.complex.NuggetIngotBlock;
import net.minecraft.item.Item;

public class ItemInit 
{	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item decay_food = new ItemBase("decay_food");
	public static final Item copper = new NuggetIngotBlock("copper");	
	
}
