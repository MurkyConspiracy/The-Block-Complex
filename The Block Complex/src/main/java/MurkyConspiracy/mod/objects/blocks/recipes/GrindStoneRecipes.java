package MurkyConspiracy.mod.objects.blocks.recipes;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import MurkyConspiracy.mod.init.BlockInit;
import net.minecraft.item.ItemStack;

public class GrindStoneRecipes {
	
	private static final GrindStoneRecipes INSTANCE = new GrindStoneRecipes();
	private final Map<ItemStack, ItemStack> grindingList = Maps.<ItemStack, ItemStack>newHashMap();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	
	public static GrindStoneRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private GrindStoneRecipes() 
	{
		//addSinteringRecipe(new ItemStack(Blocks.ACACIA_FENCE), new ItemStack(Blocks.ACACIA_FENCE_GATE), new ItemStack(BlockInit.COPPER_CHEST), 5.0F);
	}

	
	public void addGrindingRecipe(ItemStack input1, ItemStack result, float experience) 
	{
		if(getGrindingResult(input1) != ItemStack.EMPTY) return;
		this.grindingList.put(input1, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}
	
    public ItemStack getGrindingResult(ItemStack stack)
    {
        for (Entry<ItemStack, ItemStack> entry : this.grindingList.entrySet())
        {
            if (this.compareItemStacks(stack, entry.getKey()))
            {
                return entry.getValue();
            }
        }

        return ItemStack.EMPTY;
    }
	
    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }
	
    public Map<ItemStack, ItemStack> getGrindingList()
    {
        return this.grindingList;
    }
	
	public float getGrindingExperience(ItemStack stack)
	{
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) 
		{
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) 
			{
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}
