package MurkyConspiracy.mod.tabs;

import java.util.Random;

import MurkyConspiracy.mod.init.BlockInit;
import MurkyConspiracy.mod.init.ItemInit;
import MurkyConspiracy.mod.util.handlers.EnumHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TheBlockComplexNatureTab extends CreativeTabs
{

	public TheBlockComplexNatureTab(String label)
	{
		super("theblockcomplexnaturetab");
		this.setBackgroundImageName("tbc.png");
	}

	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(ItemInit.SEEDS.get(new Random().nextInt(ItemInit.SEEDS.size())));
	}
	
}
