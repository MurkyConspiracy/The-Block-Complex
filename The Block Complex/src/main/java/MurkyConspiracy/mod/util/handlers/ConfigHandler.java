package MurkyConspiracy.mod.util.handlers;

import java.io.File;

import MurkyConspiracy.mod.Main;
import MurkyConspiracy.mod.util.References;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ConfigHandler
{

	public static Configuration config;	
	
	public static int days_per_season = 2;
	
	public static int[] wheat_seasons = {1, 2};
	public static int[] carrot_seasons = {0, 1};
	public static int[] potato_seasons = {1, 2};
	public static int[] beet_seasons = {0, 1};
	public static int[] melon_seasons = {1};
	public static int[] pumpkin_seasons = {1, 2};
	public static int[] sugarcane_seasons = {1};
	public static int[] broccoli_seasons = {0, 2};
	public static int[] cauliflower_seasons = {0, 2};
	public static int[] coffee_seasons = {0, 1};
	public static int[] garlic_seasons = {2};
	public static int[] rhubarb_seasons = {0};
	public static int[] strawberry_seasons = {0};
	public static int[] tomato_seasons = {1};
	
	public static void init(File file)
	{
		config = new Configuration(file);
		String category;		
		category = "Crop_Seasons";
		config.addCustomCategoryComment(category, "Crop growth in seasons, 0=spring 1=summer 2=fall 3=winter");
		days_per_season = config.getInt("days_per_season", category, 2, 1, 20, "Days per season");
		wheat_seasons = config.get(category, "wheat_seasons", new int[] {1, 2}, "Seasons wheat can grow in").getIntList();
		carrot_seasons = config.get(category, "carrot_seasons", new int[] {0, 1}, "Seasons carrot can grow in").getIntList();
		potato_seasons = config.get(category, "potato_seasons", new int[] {1, 2}, "Seasons potato can grow in").getIntList();
		beet_seasons = config.get(category, "beet_seasons", new int[] {0, 1}, "Seasons beet can grow in").getIntList();
		melon_seasons = config.get(category, "melon_seasons", new int[] {1}, "Seasons melon can grow in").getIntList();
		pumpkin_seasons = config.get(category, "pumpkin_seasons", new int[] {1, 2}, "Seasons pumpkin can grow in").getIntList();
		sugarcane_seasons = config.get(category, "sugarcane_seasons", new int[] {1}, "Seasons sugarcane can grow in").getIntList();
		broccoli_seasons = config.get(category, "broccoli_seasons", new int[] {0, 2}, "Seasons broccoli can grow in").getIntList();
		cauliflower_seasons = config.get(category, "cauliflower_seasons", new int[] {0, 2}, "Seasons cauliflower can grow in").getIntList();
		coffee_seasons = config.get(category, "coffee_seasons", new int[] {0, 1}, "Seasons coffee can grow in").getIntList();
		garlic_seasons = config.get(category, "garlic_seasons", new int[] {2}, "Seasons garlic can grow in").getIntList();
		rhubarb_seasons = config.get(category, "rhubarb_seasons", new int[] {0}, "Seasons rhubarb can grow in").getIntList();
		strawberry_seasons = config.get(category, "strawberry_seasons", new int[] {0}, "Seasons strawberry can grow in").getIntList();
		tomato_seasons = config.get(category, "tomato_seasons", new int[] {1}, "Seasons tomato can grow in").getIntList();
		
		config.save();
	}
	
	public static int[][] getCropSeaonsArray()
	{
		
		int[][] crops = {wheat_seasons, carrot_seasons, potato_seasons, beet_seasons, melon_seasons, pumpkin_seasons, sugarcane_seasons, broccoli_seasons, 
				cauliflower_seasons, coffee_seasons, garlic_seasons, rhubarb_seasons, strawberry_seasons, tomato_seasons};
		return crops;
	}
	
	public static void registerConfig(FMLPreInitializationEvent event)
	{
		Main.config = new File(event.getModConfigurationDirectory() + "/" + References.MODID);
		Main.config.mkdirs();
		init(new File(Main.config.getPath(), References.MODID + ".cfg"));
	}
	

	
}
