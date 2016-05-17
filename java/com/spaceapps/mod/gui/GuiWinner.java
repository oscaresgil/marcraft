package com.spaceapps.mod.gui;

import net.minecraft.client.gui.GuiScreen;

public class GuiWinner extends GuiScreen{

	@Override
	public void initGui() {
		super.initGui();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.fontRendererObj.drawString("You found the Mars Rover", mouseX, mouseY, -1, false);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void drawBackground(int tint) {
		this.drawDefaultBackground();
		super.drawBackground(tint);
	}
	

}
