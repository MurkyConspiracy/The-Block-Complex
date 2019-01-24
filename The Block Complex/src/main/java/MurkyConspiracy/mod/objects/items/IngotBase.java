package MurkyConspiracy.mod.objects.items;

import MurkyConspiracy.mod.Main;
import MurkyConspiracy.mod.init.BlockInit;
import MurkyConspiracy.mod.init.ItemInit;
import MurkyConspiracy.mod.objects.blocks.item.ItemBlockVariants;
import MurkyConspiracy.mod.util.handlers.EnumHandler;
import MurkyConspiracy.mod.util.handlers.EnumHandler.EnumTypeOverworldMetals;
import MurkyConspiracy.mod.util.interfaces.IHasModel;
import MurkyConspiracy.mod.util.interfaces.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class IngotBase extends ItemBase implements IHasModel, IMetaName 
{
	private String name;
	
	public IngotBase(String name, Material material, Boolean Block, Boolean Ingot)
	{
		super(material)
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.theblockcomplextab);
		
		if (Block == true)
		{
			
		}
		if (Ingot == true)
		{
			
		}
		
	}
	
}
