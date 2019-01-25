package MurkyConspiracy.mod.objects.items.complex;

import MurkyConspiracy.mod.Main;
import MurkyConspiracy.mod.init.ItemInit;
import MurkyConspiracy.mod.util.interfaces.IHasModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;

public class NuggetIngotBlock extends Item implements IHasModel
{

	private boolean iHasNugget, iHasIngot, iHasBlock;
	public NuggetIngotBlock(String name)
	{

		setUnlocalizedName(name);
		setRegistryName(name);
		setHasSubtypes(true);
		setMaxDamage(0);
		setCreativeTab(Main.theblockcomplextab);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
	{
		if(this.isInCreativeTab(tab))
		{
			for(int i = 0; i < 2; ++i)
			{
				items.add(new ItemStack(this, 1, i));
			}
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		int i = stack.getMetadata();
		return super.getUnlocalizedName() + "_" + NIB.byNIBMeta(i).getUnlocalizedName();
	}

	@Override
	public void registerModels()
	{
		for(int i = 0; i < 2; ++i)
		{
			ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(this.getRegistryName() + "_" + NIB.byNIBMeta(i).getName(), "inventory"));
		}
	}
	
}

enum NIB
{
	NUGGET(0, "nugget"),
	INGOT(1, "ingot");
	
	private final int meta;

	private final String name, unlocalizedName;

    private static final NIB[] META_LOOKUP = new NIB[values().length];
	
	private NIB(int meta, String name)
	{
		this(meta, name, name);
	}
	
	private NIB(int meta, String name, String unlocalizedName)
	{
		this.meta = meta;
		this.name = name;
		this.unlocalizedName = unlocalizedName;
	}
	
	public String getName()
	{
		return name;		
	}
	
	static
    {
        for (NIB NugIngBloc : values())
        {
            META_LOOKUP[NugIngBloc.getMetadata()] = NugIngBloc;
        }
    }

	private int getMetadata()
	{
		return this.meta;
	}
	
	public static NIB byNIBMeta(int damage)
    {
        if (damage < 0 || damage >= META_LOOKUP.length)
        {
            damage = 0;
        }

        return META_LOOKUP[damage];
    }
	public String getUnlocalizedName()
    {
        return this.unlocalizedName;
    }
}