package MurkyConspiracy.mod.proxy;

import net.minecraft.util.text.translation.I18n;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

public class CommonProxy {
	public static Configuration config;	
	public void registerItemRenderer(Item item, int meta, String id) {}
	public void registerItemRenderer(Item item, int meta, String locationPrefix, String id) {}
	public void registerVariantRenderer(Item item, int meta, String filename, String id) {}
    public String localize(String unlocalized, Object... args){
    	return I18n.translateToLocalFormatted(unlocalized, args);
}
}
