package MurkyConspiracy.mod.objects.blocks;

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

public class BlockOresOverworldMetals extends Block implements IHasModel, IMetaName 
{
	
	public static final PropertyEnum<EnumTypeOverworldMetals> VARIANT = PropertyEnum.<EnumHandler.EnumTypeOverworldMetals>create("variant", EnumHandler.EnumTypeOverworldMetals.class);
		
		@SuppressWarnings("unused")
		private String name;
		
		public BlockOresOverworldMetals(String name, Material material)
		{
			
			super(material);
			setUnlocalizedName(name);
			setRegistryName(name);
			setCreativeTab(Main.theblockcomplextab);
			setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumTypeOverworldMetals.COPPER));
			
			this.name = name;
			
			BlockInit.BLOCKS.add(this);
			ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
		}
	
		@Override
		public int damageDropped(IBlockState state) 
		{
			return ((EnumHandler.EnumTypeOverworldMetals)state.getValue(VARIANT)).getMeta();
		}
		
		@Override
		public int getMetaFromState(IBlockState state) 
		{
			return ((EnumHandler.EnumTypeOverworldMetals)state.getValue(VARIANT)).getMeta();
		}
		
		@Override
		public IBlockState getStateFromMeta(int meta) 
		{
			return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumTypeOverworldMetals.byMetaData(meta));
		}
		
		@Override
		public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) 
		{
			return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
		}
		
		@Override
		public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
		{
			for(EnumHandler.EnumTypeOverworldMetals variant : EnumHandler.EnumTypeOverworldMetals.values())
			{
				items.add(new ItemStack(this, 1, variant.getMeta()));
			}
		}
		
		@Override
		protected BlockStateContainer createBlockState()
		{
			return new BlockStateContainer(this, new IProperty[] {VARIANT});
		}
		
		@Override
		public String getSpecialName(ItemStack stack)
		{
			return EnumHandler.EnumTypeOverworldMetals.values()[stack.getItemDamage()].getName();
		}
		
		@Override
		public void registerModels() {
			for(int i = 0; i < EnumHandler.EnumTypeOverworldMetals.values().length; i++)
			{
				Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "metal_overworld_" + EnumHandler.EnumTypeOverworldMetals.values()[i].getName(), "inventory");
			}
		}
	
}
