package MurkyConspiracy.mod.init;

import java.util.ArrayList;
import java.util.List;

import MurkyConspiracy.mod.objects.blocks.BlockBase;
import MurkyConspiracy.mod.objects.blocks.BlockOresEnd;
import MurkyConspiracy.mod.objects.blocks.BlockOresNether;
import MurkyConspiracy.mod.objects.blocks.BlockOresOverworldMinerals;
import MurkyConspiracy.mod.objects.blocks.machines.BlockMachineGrindStone;
import MurkyConspiracy.mod.objects.blocks.BlockOresOverworldMetals;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BLOCK_DECAY_NATURAL = new BlockBase("block_decay", Material.PLANTS);
	
	public static final Block ORE_END = new BlockOresEnd("ore_end", Material.ROCK);
	public static final Block ORE_NETHER = new BlockOresNether("ore_nether", Material.ROCK);
	public static final Block ORE_OVERWORLD = new BlockOresOverworldMinerals("ore_overworld", Material.ROCK);
	public static final Block METAL_OVERWORLD = new BlockOresOverworldMetals("metal_overworld", Material.ROCK);
	
	//Machines
	public static final Block GRIND_STONE = new BlockMachineGrindStone("grind_stone");
}
