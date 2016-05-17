package com.spaceapps.mod.event;

import com.spaceapps.mod.gui.GuiWinner;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class EventsHandler implements IGuiHandler {

    public static final int MOD_WINNER_ENTITY_GUI = 0;


    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == MOD_WINNER_ENTITY_GUI){
            return new GuiWinner();
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == MOD_WINNER_ENTITY_GUI){
            return new GuiWinner();
        }
        return null;
    }
}