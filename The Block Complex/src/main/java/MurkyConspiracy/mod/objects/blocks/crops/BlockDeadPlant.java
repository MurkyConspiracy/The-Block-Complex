package MurkyConspiracy.mod.objects.blocks.crops;

import java.util.Random;

import MurkyConspiracy.mod.init.BlockInit;
import MurkyConspiracy.mod.init.ItemInit;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDeadPlant extends BlockCrops
{
	private static final AxisAlignedBB[] DEAD_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D)};

	private Random rand = new Random();
	
	public BlockDeadPlant(String name, Material material)
	{
		setUnlocalizedName(name);
		setRegistryName("crops/" + name);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
		
	}

	@Override
	public BlockRenderLayer getBlockLayer()
	{
		// TODO Auto-generated method stub
		return super.getBlockLayer().CUTOUT;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!worldIn.isRemote)
		{
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		return false;
	}
	
	@Override
	protected Item getSeed()
	{
		return Items.AIR;
	}
	
	@Override
	protected Item getCrop()
	{
		return Items.AIR;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return DEAD_AABB[0];
	}
	 
}
