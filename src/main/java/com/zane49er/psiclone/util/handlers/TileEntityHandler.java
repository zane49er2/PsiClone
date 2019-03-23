package com.zane49er.psiclone.util.handlers;

import com.zane49er.psiclone.tileentities.TileEntityAssembler;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityAssembler.class, "assembler");
	}
	
}
