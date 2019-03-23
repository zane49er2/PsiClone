package com.zane49er.psiclone.util.handlers;

import com.zane49er.psiclone.init.ModBlocks;
import com.zane49er.psiclone.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabHandler {

	public static CreativeTabs tabResources = new CreativeTabs("TabResources") {
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.BASIC_CHASSIS);
		}
	};
	
	public static CreativeTabs tabMachines = new CreativeTabs("TabMachines") {
		public ItemStack getTabIconItem() {
			//return new ItemStack(ModBlocks.ASSEMBLER);
			return new ItemStack(ModBlocks.PSI_BLOCK);
		}
	};
}
