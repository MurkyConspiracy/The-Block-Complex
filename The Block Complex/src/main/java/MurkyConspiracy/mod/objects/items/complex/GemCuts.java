package MurkyConspiracy.mod.objects.items.complex;

import MurkyConspiracy.mod.Main;
import MurkyConspiracy.mod.init.ItemInit;
import MurkyConspiracy.mod.util.interfaces.IHasModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class GemCuts extends Item implements IHasModel
{
	
	public GemCuts(String name)
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
			for(int i = 0; i < 14; ++i)
			{
				items.add(new ItemStack(this, 1, i));
			}
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		int i = stack.getMetadata();
		return super.getUnlocalizedName() + "_" + CutGrades.byCutMeta(i).getUnlocalizedName();
	}
	
	@Override
	public void registerModels()
	{
		for(int i = 0; i < 14; ++i)
		{
			ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(this.getRegistryName() + "_" + CutGrades.byCutMeta(i).getName(), "inventory"));
		}
		
	}
	
}

enum CutGrades
{
	
	CHIPPED(0, "chipped"),
	FLAWED(1, "flawed"),
	BASE(2, "normal"),
	FLAWLESS(3, "flawless"),
	PERFECT(4, "perfect"),
	RADIANT(5, "radiant"),
	SQUARE(6, "square"),
	FLAWLESS_SQUARE(7, "flawless_square"),
	PERFECT_SQUARE(8, "perfect_square"),
	RADIANT_SQUARE(9, "radiant_square"),
	STAR(10, "star"),
	FLAWLESS_STAR(11, "flawless_star"),
	PERFECT_STAR(12, "perfect_star"),
	RADIANT_STAR(13, "radiant_star");
	
	private final int meta;

	private final String name, unlocalizedName;
	private static final CutGrades[] META_LOOKUP = new CutGrades[values().length];
	
	private CutGrades(int meta, String name)
	{
		
		this(meta, name, name);
		
	}
	
	public String getName()
	{
		return this.name;
	}

	public String getUnlocalizedName()
	{
		return this.unlocalizedName;
	}

	private CutGrades(int meta, String name, String unlocalizedName)
	{
		this.meta = meta;
		this.name = name;
		this.unlocalizedName = name;
	}
	
	static
	{
		for(CutGrades grade : values())
		{
			META_LOOKUP[grade.getMetadata()] = grade;
		}
	}

	private int getMetadata()
	{
		return this.meta;
	}
	
	public static CutGrades byCutMeta(int meta)
	{
		if(meta < 0 || meta >= META_LOOKUP.length)
			meta = 0;
		
		return META_LOOKUP[meta];
	}
	
}