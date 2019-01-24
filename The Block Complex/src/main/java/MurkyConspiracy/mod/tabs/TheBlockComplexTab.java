package MurkyConspiracy.mod.tabs;

import MurkyConspiracy.mod.init.BlockInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TheBlockComplexTab extends CreativeTabs
{

	public TheBlockComplexTab(String label)
	{
		super("theblockcomplextab");
		this.setBackgroundImageName("tbc.png");
	}

	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(Item.getItemFromBlock(BlockInit.ORE_OVERWORLD));
	}
	
}
