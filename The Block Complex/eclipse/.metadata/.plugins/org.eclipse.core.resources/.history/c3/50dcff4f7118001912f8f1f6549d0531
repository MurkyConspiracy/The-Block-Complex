package MurkyConspiracy.mod.util.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler 
{
	
	public static enum EnumTypeOverworld implements IStringSerializable
	{
		
		OPAL(0, "opal"),
		PERIDOT(1, "peridot"),
		APATITE(2, "apatite");
		
		private static final EnumTypeOverworld[] META_LOOKUP = new EnumTypeOverworld[values().length];
		private final int meta;
		private final String name, unlocializedName;
		
		private EnumTypeOverworld(int meta, String name)
		{
			this(meta, name, name);
		}
		
		private EnumTypeOverworld(int meta, String name, String unlocializedName)
		{
			this.meta = meta;
			this.name = name;
			this.unlocializedName = unlocializedName;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		public int getMeta() {
			return this.meta;
		}
		
		public String getUnlocializedName() {
			return this.unlocializedName;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
		public static EnumTypeOverworld byMetaData(int meta)
		{
			return META_LOOKUP[meta];
		}
		
		static
		{
			
			for(EnumTypeOverworld enumtype : values())
			{
				META_LOOKUP[enumtype.getMeta()] = enumtype;
			}
			
		}
		
	}
	
	public static enum EnumTypeNether implements IStringSerializable
	{
		
		AGATE(0, "agate"),
		PERIDOT(1, "peridot"),
		FLOURITE(2, "flourite");
		
		private static final EnumTypeNether[] META_LOOKUP = new EnumTypeNether[values().length];
		private final int meta;
		private final String name, unlocializedName;
		
		private EnumTypeNether(int meta, String name)
		{
			this(meta, name, name);
		}
		
		private EnumTypeNether(int meta, String name, String unlocializedName)
		{
			this.meta = meta;
			this.name = name;
			this.unlocializedName = unlocializedName;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		public int getMeta() {
			return this.meta;
		}
		
		public String getUnlocializedName() {
			return this.unlocializedName;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
		public static EnumTypeNether byMetaData(int meta)
		{
			return META_LOOKUP[meta];
		}
		
		static
		{
			
			for(EnumTypeNether enumtype : values())
			{
				META_LOOKUP[enumtype.getMeta()] = enumtype;
			}
			
		}
		
	}
	
	public static enum EnumTypeEnd implements IStringSerializable
	{
		
		ZIRCON(0, "zircon");
		
		private static final EnumTypeEnd[] META_LOOKUP = new EnumTypeEnd[values().length];
		private final int meta;
		private final String name, unlocializedName;
		
		private EnumTypeEnd(int meta, String name)
		{
			this(meta, name, name);
		}
		
		private EnumTypeEnd(int meta, String name, String unlocializedName)
		{
			this.meta = meta;
			this.name = name;
			this.unlocializedName = unlocializedName;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		public int getMeta() {
			return this.meta;
		}
		
		public String getUnlocializedName() {
			return this.unlocializedName;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
		public static EnumTypeEnd byMetaData(int meta)
		{
			return META_LOOKUP[meta];
		}
		
		static
		{
			
			for(EnumTypeEnd enumtype : values())
			{
				META_LOOKUP[enumtype.getMeta()] = enumtype;
			}
			
		}
		
	}

}
