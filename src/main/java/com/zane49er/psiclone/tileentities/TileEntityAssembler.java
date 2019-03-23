package com.zane49er.psiclone.tileentities;

import com.zane49er.psiclone.recipes.AssemblerBurnRecipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityAssembler extends TileEntity implements ITickable {

	int tick;
	public ItemStackHandler handler = new ItemStackHandler(5);
	private String customName;
	public int cookTime;
	private ItemStack smelting = ItemStack.EMPTY;

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		return super.hasCapability(capability, facing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) this.handler;
		return super.getCapability(capability, facing);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("Inventory", this.handler.serializeNBT());
		compound.setInteger("CookTime", cookTime);
		compound.setString("Name", getDisplayName().toString());
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
		this.cookTime = compound.getInteger("CookTime");
		if (compound.hasKey("Name")) this.customName = compound.getString("Name");
	}

	@Override
	public void update() {
		tick++;
		if (tick > 20) tick = 0;

		ItemStack[] inputs = new ItemStack[] { handler.getStackInSlot(0), handler.getStackInSlot(1), handler.getStackInSlot(2), handler.getStackInSlot(3) };

		if (cookTime > 0) {
			cookTime++;
			//BlockAssembler.setState(true, world, pos);
			if (cookTime == 100) {
				if (handler.getStackInSlot(4).getCount() > 0) {
					handler.getStackInSlot(4).grow(1);
				} else {
					handler.insertItem(4, smelting, false);
				}
				smelting = ItemStack.EMPTY;
				cookTime = 0;
				return;
			}
		} else {
			if (!inputs[0].isEmpty() && !inputs[1].isEmpty() && !inputs[2].isEmpty() && !inputs[3].isEmpty()) {
				ItemStack output = AssemblerBurnRecipes.getInstance().getPsiBurnResult(inputs[0], inputs[1], inputs[2], inputs[3]);
				if (!output.isEmpty()) {
					smelting = output;
					cookTime++;
					inputs[0].shrink(1);
					inputs[1].shrink(1);
					inputs[2].shrink(1);
					inputs[3].shrink(1);
					handler.setStackInSlot(0, inputs[0]);
					handler.setStackInSlot(1, inputs[1]);
					handler.setStackInSlot(2, inputs[2]);
					handler.setStackInSlot(3, inputs[3]);
				}
			}
		}
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentTranslation("container.assembler");
	}

	public boolean isUsableByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
	}

	public int getField(int id) {
		switch (id) {
		case 0:
			return this.cookTime;
		default:
			return 0;
		}
	}

	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.cookTime = value;
		}
	}

}
