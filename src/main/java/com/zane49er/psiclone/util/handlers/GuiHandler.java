package com.zane49er.psiclone.util.handlers;

import com.zane49er.psiclone.guis.GuiAssembler;
import com.zane49er.psiclone.tileentities.ContainerAssembler;
import com.zane49er.psiclone.tileentities.TileEntityAssembler;
import com.zane49er.psiclone.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_ASSEMBLER) return new ContainerAssembler(player.inventory, (TileEntityAssembler)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_ASSEMBLER) return new GuiAssembler(player.inventory, (TileEntityAssembler)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
}
