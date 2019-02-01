package MurkyConspiracy.mod.util.handlers;

import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import MurkyConspiracy.mod.init.BlockInit;
import MurkyConspiracy.mod.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBeetroot;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockPotato;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EventHandler 
{
	private Random rand = new Random();
	
	@SubscribeEvent
	public void playerHarvestEvent(RightClickBlock event)
	{
		
		if (!event.getWorld().isRemote && event.getHand() == EnumHand.MAIN_HAND) 
		{
			if(SeasonHandler.getSeasonalCrops(0).contains(getBlock(event)) || SeasonHandler.getSeasonalCrops(1).contains(getBlock(event)) || SeasonHandler.getSeasonalCrops(2).contains(getBlock(event)) || SeasonHandler.getSeasonalCrops(3).contains(getBlock(event)))
			{
				if(!SeasonHandler.getSeasonalCrops(SeasonHandler.getSeason()).contains(getBlock(event)))
				{
					event.getWorld().setBlockState(event.getPos(), BlockInit.DEAD_PLANT.getDefaultState());
					event.setCanceled(true);
				}	
			}
			
			if(getBlock(event) == Blocks.WHEAT)
			{
				BlockCrops wheat = (BlockCrops) getBlock(event);
				if(wheat.isMaxAge(event.getWorld().getBlockState(event.getPos())))
				{
					int temp = rand.nextInt(2);
					event.getWorld().spawnEntity(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(Items.WHEAT)));
					event.getWorld().spawnEntity(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(Items.WHEAT_SEEDS, temp, 0)));
					event.getWorld().setBlockState(event.getPos(), wheat.withAge(0), 2);
				}
			}
			if(getBlock(event) == Blocks.CARROTS)
			{
				BlockCarrot carrot = (BlockCarrot) getBlock(event);
				if(carrot.isMaxAge(event.getWorld().getBlockState(event.getPos())))
				{
					int temp = rand.nextInt(2);
					event.getWorld().spawnEntity(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(Items.CARROT)));
					event.getWorld().spawnEntity(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(Items.CARROT, temp, 0)));
					event.getWorld().setBlockState(event.getPos(), carrot.withAge(0), 2);
				}
			}
			if(getBlock(event) == Blocks.POTATOES)
			{
				BlockPotato potatoe = (BlockPotato) getBlock(event);
				if(potatoe.isMaxAge(event.getWorld().getBlockState(event.getPos())))
				{
					int temp = rand.nextInt(2);
					event.getWorld().spawnEntity(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(Items.POTATO)));
					event.getWorld().spawnEntity(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(Items.POTATO, temp, 0)));
					if(temp == 0)
					{
						if(rand.nextFloat() < 0.08f)
							event.getEntityPlayer().addItemStackToInventory(new ItemStack(Items.POISONOUS_POTATO));
					}
					event.getWorld().setBlockState(event.getPos(), potatoe.withAge(0), 2);
				}
			}
			if(getBlock(event) == Blocks.BEETROOTS)
			{
				BlockBeetroot beet = (BlockBeetroot) getBlock(event);
				if(beet.isMaxAge(event.getWorld().getBlockState(event.getPos())))
				{
					int temp = rand.nextInt(2);
					event.getWorld().spawnEntity(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(Items.BEETROOT)));
					event.getWorld().spawnEntity(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(Items.BEETROOT, temp, 0)));
					event.getWorld().setBlockState(event.getPos(), beet.withAge(0), 2);
				}
			}
			
		}
		
	}
	
	@SubscribeEvent
	public void onCropGrow(CropGrowEvent event)
	{
		if(!SeasonHandler.getSeasonalCrops(SeasonHandler.getSeason()).contains(event.getState().getBlock()))
		{
			event.getWorld().setBlockState(event.getPos(), BlockInit.DEAD_PLANT.getDefaultState());
		}		
	}
	
	private Block getBlock(RightClickBlock event)
	{
		return event.getWorld().getBlockState(event.getPos()).getBlock();
	}
	
	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event)
	{
		SeasonHandler.setMyWorld(event.getWorld());
	}
	
}


