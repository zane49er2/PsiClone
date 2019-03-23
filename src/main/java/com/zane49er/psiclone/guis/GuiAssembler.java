package com.zane49er.psiclone.guis;

import com.zane49er.psiclone.tileentities.ContainerAssembler;
import com.zane49er.psiclone.tileentities.TileEntityAssembler;
import com.zane49er.psiclone.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiAssembler extends GuiContainer {

	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/assembler.png");
	private final InventoryPlayer player;
	private final TileEntityAssembler tileentity;

	private int xSize = 176;
	private int ySize = 188;

	public GuiAssembler(InventoryPlayer player, TileEntityAssembler tileentity) {
		super(new ContainerAssembler(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1f, 1f, 1f, 1f);
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		//this.drawTexturedModalRect(0, 0, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String tileName = this.tileentity.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(tileName, this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2, 6, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 122, this.ySize - 96 + 2, 4210752);
	}

	//getburnleftscaled
	//getcookprogressscaled

}
