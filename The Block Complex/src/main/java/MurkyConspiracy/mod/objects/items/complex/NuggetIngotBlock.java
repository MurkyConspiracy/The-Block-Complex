package MurkyConspiracy.mod.objects.items.complex;

import MurkyConspiracy.mod.Main;
import MurkyConspiracy.mod.init.BlockInit;
import MurkyConspiracy.mod.init.ItemInit;
import MurkyConspiracy.mod.objects.blocks.BlockBase;
import MurkyConspiracy.mod.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;

public class NuggetIngotBlock extends Item implements IHasModel
{
	
	private ItemStack myNugget, myIngot;
	private Block myBlock;
	private String myName;
	
	public NuggetIngotBlock(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name + "/" + name);
		setHasSubtypes(true);
		setMaxDamage(0);
		setCreativeTab(Main.theblockcomplextab);
		
		myNugget = new ItemStack(this, 1, 0);
		myIngot = new ItemStack(this, 1, 1);
		
		myBlock = new BlockBase(name + "/" + name + "_block", name + "_block", Material.IRON);
		
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
	
	public Block getBlock()
	{ return this.myBlock; }
	
	public Item getNugget()
	{ return this.myNugget.getItem(); }
	
	public Item getIngot()
	{ return this.myIngot.getItem(); }
	
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
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this.getBlock()), 0, "inventory");
	}
	
}

enum NIB
{
	NUGGET(0, "nugget"),
	INGOT(1, "ingot"),
	BLOCK(2, "block");
	
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

