package com.zane49er.psiclone.items;

import com.zane49er.psiclone.Main;
import com.zane49er.psiclone.init.ModItems;
import com.zane49er.psiclone.util.IHasModel;
import com.zane49er.psiclone.util.handlers.TabHandler;

import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TabHandler.tabResources);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRender(this, 0, "inventory");
	}
	
}
