package com.zane49er.psiclone.blocks;

import com.zane49er.psiclone.Main;
import com.zane49er.psiclone.init.ModBlocks;
import com.zane49er.psiclone.init.ModItems;
import com.zane49er.psiclone.util.IHasModel;
import com.zane49er.psiclone.util.handlers.TabHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel{

		public BlockBase(String name, Material material) {
			super(material);
			setUnlocalizedName(name);
			setRegistryName(name);
			setCreativeTab(TabHandler.tabResources);
			
			ModBlocks.BLOCKS.add(this);
			ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		}
		
		@Override
		public void registerModels() {
			Main.proxy.registerItemRender(Item.getItemFromBlock(this), 0, "inventory");
		}
		
	
}
