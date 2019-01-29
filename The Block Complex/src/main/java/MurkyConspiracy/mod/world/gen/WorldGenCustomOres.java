package MurkyConspiracy.mod.world.gen;

import java.util.Random;

import MurkyConspiracy.mod.init.BlockInit;
import MurkyConspiracy.mod.objects.blocks.ores.BlockOresEnd;
import MurkyConspiracy.mod.objects.blocks.ores.BlockOresNether;
import MurkyConspiracy.mod.objects.blocks.ores.BlockOresOverworldMetals;
import MurkyConspiracy.mod.objects.blocks.ores.BlockOresOverworldMinerals;
import MurkyConspiracy.mod.util.handlers.EnumHandler;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator
{
	private WorldGenerator ore_overworld_opal, ore_overworld_peridot, ore_overworld_apatite;
	private WorldGenerator metal_overworld_copper, metal_overworld_tin, metal_overworld_lead, metal_overworld_zinc, metal_overworld_nickel, metal_overworld_platinum, metal_overworld_tungsten;
	private WorldGenerator ore_nether_agate, ore_nether_peridot, ore_nether_flourite;
	private WorldGenerator ore_end_zircon, ore_end_iridium, ore_end_blackopal, ore_end_redberyl;

	public WorldGenCustomOres()
	{
		ore_overworld_opal = new WorldGenMinable(BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOresOverworldMinerals.VARIANT, EnumHandler.EnumTypeOverworld.OPAL), 3, BlockMatcher.forBlock(Blocks.COAL_ORE));
		ore_overworld_peridot = new WorldGenMinable(BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOresOverworldMinerals.VARIANT, EnumHandler.EnumTypeOverworld.PERIDOT), 3, BlockMatcher.forBlock(Blocks.STONE));
		ore_overworld_apatite = new WorldGenMinable(BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOresOverworldMinerals.VARIANT, EnumHandler.EnumTypeOverworld.APATITE), 3, BlockMatcher.forBlock(Blocks.STONE));
		
		metal_overworld_copper = new WorldGenMinable(BlockInit.METAL_OVERWORLD.getDefaultState().withProperty(BlockOresOverworldMetals.VARIANT, EnumHandler.EnumTypeOverworldMetals.COPPER), 3, BlockMatcher.forBlock(Blocks.STONE));
		metal_overworld_tin = new WorldGenMinable(BlockInit.METAL_OVERWORLD.getDefaultState().withProperty(BlockOresOverworldMetals.VARIANT, EnumHandler.EnumTypeOverworldMetals.TIN), 3, BlockMatcher.forBlock(Blocks.STONE));
		metal_overworld_lead = new WorldGenMinable(BlockInit.METAL_OVERWORLD.getDefaultState().withProperty(BlockOresOverworldMetals.VARIANT, EnumHandler.EnumTypeOverworldMetals.LEAD), 3, BlockMatcher.forBlock(Blocks.STONE));
		metal_overworld_zinc = new WorldGenMinable(BlockInit.METAL_OVERWORLD.getDefaultState().withProperty(BlockOresOverworldMetals.VARIANT, EnumHandler.EnumTypeOverworldMetals.ZINC), 3, BlockMatcher.forBlock(Blocks.STONE));
		metal_overworld_nickel = new WorldGenMinable(BlockInit.METAL_OVERWORLD.getDefaultState().withProperty(BlockOresOverworldMetals.VARIANT, EnumHandler.EnumTypeOverworldMetals.NICKEL), 3, BlockMatcher.forBlock(Blocks.STONE));
		metal_overworld_platinum = new WorldGenMinable(BlockInit.METAL_OVERWORLD.getDefaultState().withProperty(BlockOresOverworldMetals.VARIANT, EnumHandler.EnumTypeOverworldMetals.PLATINUM), 3, BlockMatcher.forBlock(Blocks.STONE));
		metal_overworld_tungsten = new WorldGenMinable(BlockInit.METAL_OVERWORLD.getDefaultState().withProperty(BlockOresOverworldMetals.VARIANT, EnumHandler.EnumTypeOverworldMetals.TUNGSTEN), 3, BlockMatcher.forBlock(Blocks.STONE));
		
		ore_nether_agate = new WorldGenMinable(BlockInit.ORE_NETHER.getDefaultState().withProperty(BlockOresNether.VARIANT, EnumHandler.EnumTypeNether.AGATE), 3, BlockMatcher.forBlock(Blocks.NETHERRACK));
		ore_nether_peridot = new WorldGenMinable(BlockInit.ORE_NETHER.getDefaultState().withProperty(BlockOresNether.VARIANT, EnumHandler.EnumTypeNether.PERIDOT), 3, BlockMatcher.forBlock(Blocks.NETHERRACK));
		ore_nether_flourite = new WorldGenMinable(BlockInit.ORE_NETHER.getDefaultState().withProperty(BlockOresNether.VARIANT, EnumHandler.EnumTypeNether.FLOURITE ), 3, BlockMatcher.forBlock(Blocks.QUARTZ_ORE));
		
		ore_end_zircon = new WorldGenMinable(BlockInit.ORE_END.getDefaultState().withProperty(BlockOresEnd.VARIANT, EnumHandler.EnumTypeEnd.ZIRCON), 3, BlockMatcher.forBlock(Blocks.END_STONE));
		ore_end_iridium = new WorldGenMinable(BlockInit.ORE_END.getDefaultState().withProperty(BlockOresEnd.VARIANT, EnumHandler.EnumTypeEnd.IRIDIUM), 3, BlockMatcher.forBlock(Blocks.END_STONE));
		ore_end_blackopal = new WorldGenMinable(BlockInit.ORE_END.getDefaultState().withProperty(BlockOresEnd.VARIANT, EnumHandler.EnumTypeEnd.BLACKOPAL), 3, BlockMatcher.forBlock(Blocks.END_STONE));
		ore_end_redberyl = new WorldGenMinable(BlockInit.ORE_END.getDefaultState().withProperty(BlockOresEnd.VARIANT, EnumHandler.EnumTypeEnd.REDBERYL), 3, BlockMatcher.forBlock(Blocks.END_STONE));
		
		
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256){throw new IllegalArgumentException("Ore generated out of bounds");}
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i =0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
		case -1:
			runGenerator(ore_nether_agate, world, random, chunkX, chunkZ, 15, 0, 100);
			runGenerator(ore_nether_peridot, world, random, chunkX, chunkZ, 15, 0, 100);
			runGenerator(ore_nether_flourite, world, random, chunkX, chunkZ, 35, 0, 100);
			break;
		case 0:
			runGenerator(ore_overworld_apatite, world, random, chunkX, chunkZ, 15, 0, 100);
			runGenerator(ore_overworld_opal, world, random, chunkX, chunkZ, 35, 0, 100);
			runGenerator(ore_overworld_peridot, world, random, chunkX, chunkZ, 20, 0, 100);
			runGenerator(metal_overworld_copper, world, random, chunkX, chunkZ, 25, 0, 65);
			runGenerator(metal_overworld_tin, world, random, chunkX, chunkZ, 25, 0, 65);
			runGenerator(metal_overworld_lead, world, random, chunkX, chunkZ, 25, 0, 65);
			runGenerator(metal_overworld_zinc, world, random, chunkX, chunkZ, 25, 0, 65);
			runGenerator(metal_overworld_nickel, world, random, chunkX, chunkZ, 25, 0, 65);
			runGenerator(metal_overworld_platinum, world, random, chunkX, chunkZ, 25, 0, 65);
			runGenerator(metal_overworld_tungsten, world, random, chunkX, chunkZ, 25, 0, 65);
			break;
		case 1:
			runGenerator(ore_end_zircon, world, random, chunkX, chunkZ, 25, 0, 256);
			runGenerator(ore_end_iridium, world, random, chunkX, chunkZ, 25, 0, 256);
			runGenerator(ore_end_blackopal, world, random, chunkX, chunkZ, 25, 0, 256);
			runGenerator(ore_end_redberyl, world, random, chunkX, chunkZ, 25, 0, 256);
		}
	}
}
