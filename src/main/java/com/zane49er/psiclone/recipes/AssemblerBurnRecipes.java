package com.zane49er.psiclone.recipes;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.zane49er.psiclone.init.ModBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class AssemblerBurnRecipes {
	private static final AssemblerBurnRecipes INSTANCE = new AssemblerBurnRecipes();
	//private final Table<ItemStack, ItemStack, ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack, ItemStack, ItemStack> create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float> newHashMap();

	public static AssemblerBurnRecipes getInstance() {
		return INSTANCE;
	}

	private AssemblerBurnRecipes() {
		//addSinteringRecipe(new ItemStack(Blocks.ACACIA_FENCE), new ItemStack(Blocks.ACACIA_FENCE_GATE), new ItemStack(BlockInit.COPPER_CHEST), 5.0F);
		//addPsiBurnRecipe(new ItemStack(Blocks.GLOWSTONE), new ItemStack(Blocks.IRON_BLOCK), new ItemStack(ModBlocks.PSI_BLOCK), 0.5f);
	}

	public void addPsiBurnRecipe(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4, ItemStack result, float experience) {
		if (getPsiBurnResult(input1, input2, input3, input4) != ItemStack.EMPTY) return;
		//this.smeltingList.put(input1, input2, input3, input4, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}

	public ItemStack getPsiBurnResult(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4) {
		/*for (Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) {
			if (this.compareItemStacks(input1, (ItemStack) entry.getKey())) {
				for (Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
					if (this.compareItemStacks(input2, (ItemStack) ent.getKey())) {
						return (ItemStack) ent.getValue();
					}
				}
			}
		}*/
		return ItemStack.EMPTY;
	}

	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}

	//public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() {
		//return this.smeltingList;
	//}

	public float getPsiBurnExperience(ItemStack stack) {
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
			if (this.compareItemStacks(stack, (ItemStack) entry.getKey())) {
				return ((Float) entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}
