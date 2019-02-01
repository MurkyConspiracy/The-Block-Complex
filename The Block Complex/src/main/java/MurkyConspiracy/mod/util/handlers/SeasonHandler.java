package MurkyConspiracy.mod.util.handlers;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import MurkyConspiracy.mod.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class SeasonHandler
{

	private static int SPRING = 0;
	private static int SUMMER = 1;
	private static int FALL = 2;
	private static int WINTER = 3;
	
	private static World myWorld;
	
	private static List<Block> springCrops = new ArrayList<>();
	private static List<Block> summerCrops = new ArrayList<>();
	private static List<Block> fallCrops = new ArrayList<>();
	private static List<Block> winterCrops = new ArrayList<>();
	private static List<List<Block>> seasonHolder = new ArrayList<>();
	
	public static World setMyWorld(World newWorld) {return myWorld = newWorld;}
	public static World getMyWorld() {return myWorld;}
	public static String getSeasonName(int seasonID)
	{
		switch(seasonID)
		{
		case 0:
			return "Spring";
		case 1:
			return "Summer";
		case 2:
			return "Fall";
		case 3:
			return "Winter";
		default:
			throw new InvalidParameterException("Season ID is outside of range, expecting 0-3, got: " + seasonID);
		}
	}
	
	public static int getSeason()
	{
		
		return (int) (myWorld.getWorldTime()/24000 / ConfigHandler.days_per_season)%4;
		
	}
	
	public static List<Block> getSeasonalCrops(int season)
	{
		return seasonHolder.get(season);
	}
	
	public static void postInit()
	{
		
		seasonHolder.add(springCrops);
		seasonHolder.add(summerCrops);
		seasonHolder.add(fallCrops);
		seasonHolder.add(winterCrops);
		
		for(int i : ConfigHandler.wheat_seasons)
		{
			seasonHolder.get(i).add(Blocks.WHEAT);
		}
		for(int i : ConfigHandler.carrot_seasons)
		{
			seasonHolder.get(i).add(Blocks.CARROTS);
		}
		for(int i : ConfigHandler.potato_seasons)
		{
			seasonHolder.get(i).add(Blocks.POTATOES);
		}
		for(int i : ConfigHandler.beet_seasons)
		{
			seasonHolder.get(i).add(Blocks.BEETROOTS);
		}
		for(int i : ConfigHandler.melon_seasons)
		{
			seasonHolder.get(i).add(Blocks.MELON_STEM);
		}
		for(int i : ConfigHandler.pumpkin_seasons)
		{
			seasonHolder.get(i).add(Blocks.PUMPKIN_STEM);
		}
		for(int i : ConfigHandler.sugarcane_seasons)
		{
			seasonHolder.get(i).add(Blocks.REEDS);
		}
		for(int i : ConfigHandler.broccoli_seasons)
		{
			seasonHolder.get(i).add(BlockInit.BROCCOLI_PLANT);
		}
		for(int i : ConfigHandler.cauliflower_seasons)
		{
			seasonHolder.get(i).add(BlockInit.CAULIFLOWER_PLANT);
		}
		for(int i : ConfigHandler.coffee_seasons)
		{
			seasonHolder.get(i).add(BlockInit.COFFEE_PLANT);
		}
		for(int i : ConfigHandler.garlic_seasons)
		{
			seasonHolder.get(i).add(BlockInit.GARLIC_PLANT);
		}
		for(int i : ConfigHandler.rhubarb_seasons)
		{
			seasonHolder.get(i).add(BlockInit.RHUBARB_PLANT);
		}
		for(int i : ConfigHandler.strawberry_seasons)
		{
			seasonHolder.get(i).add(BlockInit.STRAWBERRY_PLANT);
		}
		for(int i : ConfigHandler.tomato_seasons)
		{
			seasonHolder.get(i).add(BlockInit.TOMATO_PLANT);
		}
	}
}
