package MurkyConspiracy.mod.tabs;

import java.util.Random;

import MurkyConspiracy.mod.init.BlockInit;
import MurkyConspiracy.mod.util.handlers.EnumHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TheBlockComplexWorldTab extends CreativeTabs
{

	public TheBlockComplexWorldTab(String label)
	{
		super("theblockcomplexworldtab");
		this.setBackgroundImageName("tbc.png");
	}

	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(Item.getItemFromBlock(BlockInit.METAL_OVERWORLD), 1, new Random().nextInt(EnumHandler.EnumTypeOverworldMetals.values().length));
	}
	
}
