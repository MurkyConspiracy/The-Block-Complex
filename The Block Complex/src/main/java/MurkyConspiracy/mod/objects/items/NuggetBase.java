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
	
	public NuggetBase(String name, Boolean hasIngot)
	{
		String nuggetName = "Nugget_" + name;
		
		Item newNugget = new Item();
		newNugget.setUnlocalizedName(nuggetName);
		newNugget.setRegistryName(nuggetName);
		newNugget.setCreativeTab(Main.theblockcomplextab);
		
		ItemInit.ITEMS.add(newNugget);
		
		if(hasIngot)
		{
			String ingotName = "Ingot_" + name;
			
			Item newIngot = new Item();
			newIngot.setUnlocalizedName(ingotName);
			newIngot.setRegistryName(ingotName);
			newIngot.setCreativeTab(Main.theblockcomplextab);
			
			ItemInit.ITEMS.add(newIngot);
		}
		
	}
	
	public NuggetBase(String name, Boolean hasIngot, Material material)
	{
		
		String nuggetName = "Nugget_" + name;
		String oreName = "Ore_" + name;
		
		System.out.println(name);
		System.out.println(oreName);
		System.out.println(nuggetName);
		
		Item newNugget = new Item();
		newNugget.setUnlocalizedName(nuggetName);
		newNugget.setRegistryName(nuggetName);
		newNugget.setCreativeTab(Main.theblockcomplextab);
		
		ItemInit.ITEMS.add(newNugget);
		
		if(hasIngot)
		{
			String ingotName = "Ingot_" + name;
			
			Item newIngot = new Item();
			newIngot.setUnlocalizedName(ingotName);
			newIngot.setRegistryName(ingotName);
			newIngot.setCreativeTab(Main.theblockcomplextab);
			
			ItemInit.ITEMS.add(newIngot);
		}
		
		Block newBlock = new Block(material);
		newBlock.setUnlocalizedName(oreName);
		newBlock.setRegistryName(oreName);
		newBlock.setCreativeTab(Main.theblockcomplextab);
		
		BlockInit.BLOCKS.add(newBlock);
		ItemInit.ITEMS.add(new ItemBlock(newBlock).setRegistryName(newBlock.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	
	
}
