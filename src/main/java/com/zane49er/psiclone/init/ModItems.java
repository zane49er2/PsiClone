package com.zane49er.psiclone.init;

import java.util.List;

import com.zane49er.psiclone.items.ItemBase;

import java.util.ArrayList;

import net.minecraft.item.Item;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();

	//crafting
	public static final Item PSITANIUM_SHARD = new ItemBase("psi_shard");
	//public static final Item PSITANIUM_INGOT = new ItemBase("psitanium_ingot");
	//public static final Item INFUSED_INGOT = new ItemBase("infused_ingot");

	//tier 0
	public static final Item BASIC_CHASSIS = new ItemBase("basic_chassis");
	//public static final Item GLASS_LENS = new ItemBase("glass_lens");
	
	//tier 1
	public static final Item IRON_CHASSIS = new ItemBase("iron_chassis");
	public static final Item GOLD_CHASSIS = new ItemBase("gold_chassis");
	public static final Item REVOLVING_CHASSIS = new ItemBase("revolving_chassis");
	/*public static final Item TINY_CLIP = new ItemBase("tiny_clip");
	public static final Item REDSTONE_BATTERY = new ItemBase("redstone_battery");
	public static final Item QUARTZ_LENS = new ItemBase("quartz_lens");
	public static final Item DIAMOND_CORE = new ItemBase("quartz_lens");
	public static final Item BASIC_CASING = new ItemBase("basic_casing");

	//tier 2
	public static final Item PSI_CHASSIS = new ItemBase("psitanium_chassis");
	public static final Item PSI_CORE = new ItemBase("psitanium_core");
	public static final Item PSI_LENS= new ItemBase("psitanium_lens");*/

}
