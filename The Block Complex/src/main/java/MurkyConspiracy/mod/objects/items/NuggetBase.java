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
		String nuggetName = name + "_nugget";
		
		setUnlocalizedName(nuggetName);
		setRegistryName(nuggetName);
		setCreativeTab(Main.theblockcomplextab);
		
		ItemInit.ITEMS.add(this);
		
		if(hasIngot)
		{
			String ingotName = "Ingot_" + name;
			
			setUnlocalizedName(ingotName);
			setRegistryName(ingotName);
			setCreativeTab(Main.theblockcomplextab);
			
			ItemInit.ITEMS.add(this);
		}
		
	}
	
	public NuggetBase(String name, Boolean hasIngot, Material material)
	{
		
		String nuggetName = name = "_nugget";
		String oreName = name = "_ore";
		
		
		setUnlocalizedName(nuggetName);
		setRegistryName(nuggetName);
		setCreativeTab(Main.theblockcomplextab);
		
		ItemInit.ITEMS.add(this);
		
		if(hasIngot)
		{
			String ingotName = "Ingot_" + name;
			
			setUnlocalizedName(ingotName);
			setRegistryName(ingotName);
			setCreativeTab(Main.theblockcomplextab);
			
			ItemInit.ITEMS.add(this);
		}
		
		setUnlocalizedName(oreName);
		setRegistryName(oreName);
		setCreativeTab(Main.theblockcomplextab);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	
	
}
