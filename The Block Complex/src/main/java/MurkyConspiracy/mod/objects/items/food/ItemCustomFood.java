package MurkyConspiracy.mod.objects.items.food;

import MurkyConspiracy.mod.Main;
import MurkyConspiracy.mod.init.ItemInit;
import MurkyConspiracy.mod.util.interfaces.IHasModel;
import net.minecraft.item.ItemFood;

public class ItemCustomFood extends ItemFood implements IHasModel
{

	public ItemCustomFood(String name, int amount, float saturation)
	{
		this(name, amount, saturation, false);
	}
	
	public ItemCustomFood(String name, int amount, float saturation, boolean isWolfFood)
	{
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName("food/" + name);
		setCreativeTab(Main.theblockcomplextab);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
