package MurkyConspiracy.mod.objects.items;

import MurkyConspiracy.mod.Main;
import MurkyConspiracy.mod.init.BlockInit;
import MurkyConspiracy.mod.init.ItemInit;
import MurkyConspiracy.mod.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;


public class NuggetBase extends Item implements IHasModel
{
	
	private Item nugget = null;
	private Item ingot = null;
	private Block metalBlock = null;
	private int dummy;
	
	public NuggetBase(String name, Boolean hasIngot)
	{
		String nuggetName = "nugget_" + name;
		dummy = 0;
		
		nugget = new Item();
		nugget.setUnlocalizedName(nuggetName);
		nugget.setRegistryName(nuggetName);
		nugget.setCreativeTab(Main.theblockcomplextab);
		
		ItemInit.ITEMS.add(nugget);
		
		if(hasIngot)
		{
			
			dummy = 1;
			String ingotName = "ingot_" + name;
			
			ingot = new Item();
			ingot.setUnlocalizedName(ingotName);
			ingot.setRegistryName(ingotName);
			ingot.setCreativeTab(Main.theblockcomplextab);
			
			ItemInit.ITEMS.add(ingot);
		}
		
	}
	
	public NuggetBase(String name, Boolean hasIngot, Material material)
	{
		
		String nuggetName = "nugget_" + name;
		String blockName = "block_" + name;
		dummy = 2;
		
		nugget = new Item();
		nugget.setUnlocalizedName(nuggetName);
		nugget.setRegistryName(nuggetName);
		nugget.setCreativeTab(Main.theblockcomplextab);
		
		ItemInit.ITEMS.add(nugget);
		
		if(hasIngot)
		{
			dummy = 3;
			String ingotName = "ingot_" + name;
			
			Item ingot = new Item();
			ingot.setUnlocalizedName(ingotName);
			ingot.setRegistryName(ingotName);
			ingot.setCreativeTab(Main.theblockcomplextab);
			
			ItemInit.ITEMS.add(ingot);
		}
		
		metalBlock = new Block(material);
		metalBlock.setUnlocalizedName(blockName);
		metalBlock.setRegistryName(blockName);
		metalBlock.setCreativeTab(Main.theblockcomplextab);
		
		BlockInit.BLOCKS.add(metalBlock);
		ItemInit.ITEMS.add(new ItemBlock(metalBlock).setRegistryName(metalBlock.getRegistryName()));
		
	}
	
	@Override
	public void registerModels() {
		switch(dummy)
		{
			case 0:
				Main.proxy.registerItemRenderer(nugget, 0, "inventory");
				break;
			case 1:
				Main.proxy.registerItemRenderer(nugget, 0, "inventory");
				Main.proxy.registerItemRenderer(ingot, 0, "inventory");
				break;
			case 2:
				Main.proxy.registerItemRenderer(nugget, 0, "inventory");
				Main.proxy.registerItemRenderer(Item.getItemFromBlock(metalBlock), 0, "inventory");
				break;
			case 3:
				Main.proxy.registerItemRenderer(nugget, 0, "inventory");
				Main.proxy.registerItemRenderer(ingot, 0, "inventory");
				Main.proxy.registerItemRenderer(Item.getItemFromBlock(metalBlock), 0, "inventory");
				break;
				
		}		
	}
}
