package com.spaceapps.mod.event;

import java.util.ArrayList;

import com.spaceapps.mod.Main;
import com.spaceapps.mod.SAGlobal;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import scala.util.Random;

public class Events {

    //http://bedrockminer.jimdo.com/modding-tutorials/advanced-modding/event-handler/
    //http://jabelarminecraft.blogspot.com/p/minecraft-forge-172-event-handling.html
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onPlayerInteractEvent(PlayerInteractEvent e){
        PlayerInteractEvent.Action action = e.action;
        if (action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK){
        	BlockPos actualPos = e.pos;
        	
        	BlockPos[] position = new BlockPos[]{
        			new BlockPos(SAGlobal.X, SAGlobal.Y, SAGlobal.Z), 
        			new BlockPos(SAGlobal.X + 4, SAGlobal.Y, SAGlobal.Z),
        			new BlockPos(SAGlobal.X + 4, SAGlobal.Y, SAGlobal.Z + 3),
        			new BlockPos(SAGlobal.X, SAGlobal.Y, SAGlobal.Z + 3)};
        	
        	for (BlockPos pos : position){
        		if (actualPos.getX() == pos.getX() && actualPos.getY() == pos.getY() && actualPos.getZ() == pos.getZ()){
        			e.entityPlayer.openGui(Main.instance, EventsHandler.MOD_WINNER_ENTITY_GUI, e.world, e.entityPlayer.chunkCoordX, e.entity.chunkCoordY, e.entity.chunkCoordZ);
        			break;
        		}
        	}
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onPlayerSpawnEvent(PlayerEvent e){
    	Random r = new Random();
    	SAGlobal.X = e.player.getPosition().getX() + 10;//r.nextInt(150);
        SAGlobal.Z = e.player.getPosition().getZ() + 10;//r.nextInt(150);
        SAGlobal.Y = getBlockPosition(e.player.worldObj, SAGlobal.X, SAGlobal.Z);
        System.out.println("POSITION BLOCK (" + SAGlobal.X + ", "+SAGlobal.Y + "," + SAGlobal.Z + ")");
    }
    
    public static int getBlockPosition(World world, int x, int z){
    	for (int i=1; i <= 255; i++){
    		BlockPos actualPosition = new BlockPos(x,i,z);
    		Block actualBlock = world.getBlockState(actualPosition).getBlock();
    		if (actualBlock.isAir(world, actualPosition)){
    			return i;
        	}
    	}
    	return 0;
    }
}
