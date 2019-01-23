package MurkyConspiracy.mod;

import MurkyConspiracy.mod.proxy.CommonProxy;
import MurkyConspiracy.mod.tabs.TheBlockComplexTab;
import MurkyConspiracy.mod.util.References;
import MurkyConspiracy.mod.util.handlers.CraftingHandler;
import MurkyConspiracy.mod.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class Main 
{
	
	public static final CreativeTabs theblockcomplextab = new TheBlockComplexTab("theblockcomplextab");
	
	@Instance
	public static Main Instance;
	
	@SidedProxy(clientSide = References.CLIENT, serverSide = References.COMMON)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {RegistryHandler.otherRegistries();}
	
	//added a RegistryHandler.initRegristries for smelting
	@EventHandler
	public static void init(FMLInitializationEvent event) {CraftingHandler.removeRecipies(); /*RegistryHandler.initRegistries();*/}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {}
	
}
