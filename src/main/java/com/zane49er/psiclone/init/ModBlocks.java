package com.zane49er.psiclone.init;

import java.util.ArrayList;
import java.util.List;

import com.zane49er.psiclone.blocks.BlockAssembler;
import com.zane49er.psiclone.blocks.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
		
		public static final List<Block> BLOCKS = new ArrayList<Block>();

		public static final Block PSI_BLOCK = new BlockBase("psitanium_block",Material.ROCK);
		public static final Block ASSEMBLER = new BlockAssembler("assembler");

}
