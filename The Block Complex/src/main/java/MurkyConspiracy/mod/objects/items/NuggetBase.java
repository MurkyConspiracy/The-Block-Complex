package MurkyConspiracy.mod.objects.items;

import MurkyConspiracy.mod.Main;
import MurkyConspiracy.mod.init.ItemInit;
import MurkyConspiracy.mod.util.interfaces.IHasModel;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class NuggetBase extends Item implements IHasModel
{
	
	public NuggetBase(String name, Boolean hasIngot)
	{
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.theblockcomplextab);
		
		ItemInit.ITEMS.add(this);
		
		if(hasIngot)
		{
			/*add ingot implementations*/
		}
		
	}
	
	public NuggetBase(String name, Boolean hasIngot, Material material)
	{
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.theblockcomplextab);
		
		ItemInit.ITEMS.add(this);
		
		if(hasIngot)
		{
			/*add ingot implementations*/
		}
		/* add block implementations*/
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	
	
}
