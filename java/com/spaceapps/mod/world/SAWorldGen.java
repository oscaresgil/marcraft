package com.spaceapps.mod.world;

import java.awt.Color;
import java.util.Random;

import com.spaceapps.mod.SAGlobal;
import com.spaceapps.mod.blocks.SABlocks;
import com.spaceapps.mod.networking.BackgroundTask;
import com.spaceapps.mod.networking.ServerRequester;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class SAWorldGen implements IWorldGenerator {

	// Coordenates where the center chunk starts in the matrix of heights
	/*
	 * x: <>
	 * z: ^v
	 */
	private int chunkCenterX, chunkCenterZ;
	private int[][] worldMatrix;
	private int orgChunkX, orgChunkZ;
	private int chunkSize = 16;
	private static boolean constructed=false;
	
	public void initializeWorldAttr(int [][] worldMatrix){
		this.worldMatrix = worldMatrix;
		int absoluteCenterX, absoluteCenterZ;
		absoluteCenterZ = worldMatrix.length / 2;
		
		// Asumes same size for all rows
		if (worldMatrix.length > 0) {
			absoluteCenterX = worldMatrix[0].length / 2;
			
		}
		else {
			absoluteCenterX = 0;
		}
		
		// Based on absulte center get where the chunk starts 
		// Chunk size = 16
		chunkCenterZ = absoluteCenterZ - (absoluteCenterZ % chunkSize);
		chunkCenterX = absoluteCenterX - (absoluteCenterX % chunkSize);
	}
	
	private void setRover(World world, int x, int y, int z){
		world.setBlockState(new BlockPos(x, y, z), Blocks.coal_block.getDefaultState());
		world.setBlockState(new BlockPos(x + 4, y, z), Blocks.coal_block.getDefaultState());
		world.setBlockState(new BlockPos(x + 4, y, z + 3), Blocks.coal_block.getDefaultState());
		world.setBlockState(new BlockPos(x, y, z + 3), Blocks.coal_block.getDefaultState());
		
		world.setBlockState(new BlockPos(x, y + 1, z + 1), Blocks.iron_block.getDefaultState());
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 1), Blocks.iron_block.getDefaultState());
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 1), Blocks.iron_block.getDefaultState());
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 1), Blocks.iron_block.getDefaultState());
		
		world.setBlockState(new BlockPos(x, y + 1, z + 2), Blocks.iron_block.getDefaultState());
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 2), Blocks.iron_block.getDefaultState());
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 2), Blocks.iron_block.getDefaultState());
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 2), Blocks.iron_block.getDefaultState());
		
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 1), Blocks.stone.getDefaultState());
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 2), Blocks.stone.getDefaultState());
		world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.stained_glass.getDefaultState().withProperty(PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class), EnumDyeColor.YELLOW));
		world.setBlockState(new BlockPos(x, y + 2, z + 2), Blocks.stained_glass.getDefaultState().withProperty(PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class), EnumDyeColor.YELLOW));

		world.setBlockState(new BlockPos(x + 4, y + 2, z + 1), Blocks.stained_glass.getDefaultState().withProperty(PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class), EnumDyeColor.RED));
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 2), Blocks.stained_glass.getDefaultState().withProperty(PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class), EnumDyeColor.RED));
		
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 1), Blocks.iron_block.getDefaultState());
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 1), Blocks.iron_block.getDefaultState());
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 1), Blocks.iron_block.getDefaultState());
		
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 2), Blocks.iron_block.getDefaultState());
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 2), Blocks.iron_block.getDefaultState());
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 2), Blocks.iron_block.getDefaultState());
		
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 1), Blocks.iron_block.getDefaultState());
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 2), Blocks.iron_block.getDefaultState());
	}
	
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
    	// The first generation will set center of the world
    	if(SAGlobal.worldMatrix==null){
    		SAGlobal.worldMatrix=SAGlobal.getWorldMatrix();
    		ServerRequester serverRequester = new ServerRequester();
    		serverRequester.init();
    		//Thread thread = new BackgroundTask();
    		//thread.start();
    	}
    	initializeWorldAttr(SAGlobal.worldMatrix);
    	BlockPos spawnPoint = world.getSpawnPoint();
    	Chunk spawnChunk = world.getChunkFromChunkCoords(spawnPoint.getX(), spawnPoint.getZ());
    	int realX = chunkX * 16;
    	int realZ = chunkZ * 16;
    	
    	int startIndexX = chunkCenterX + (realX - spawnChunk.xPosition);
    	int startIndexZ = chunkCenterZ + (realZ - spawnChunk.zPosition);
    	if(!constructed){
    		int indexZ, indexX, blockHeight;
    		blockHeight = 0;
    		for (int i = 0; i < chunkSize; i++){
    			indexZ = startIndexZ + i;
    			for (int j = 0; j < chunkSize; j++){
    				indexX = startIndexX + j;
    				if (indexZ < worldMatrix.length && indexZ > 0){
    					if (indexX < worldMatrix[indexZ].length && indexX > 0){
    						blockHeight = worldMatrix[indexZ][indexX];
    					}
    				}
    				
    				for (int p = 1; p < blockHeight; p++){
    					BlockPos pos = new BlockPos(realX + j, p, realZ + i);
    					world.setBlockState(pos, SABlocks.marsBlock.getDefaultState(), 4);
    				}
    				if (random.nextDouble() > 0.995){
    					if (blockHeight < 255){
        					world.setBlockState(new BlockPos(realX + j, blockHeight, realZ + i), Blocks.stone_slab2.getDefaultState(), 4);
        				}
    				}
    				
    				
    	    		
    	    		//System.out.println(pos.toString());
    	    		//System.out.println("x:  " + (chunkX *  16) + j + ", z: " + (chunkZ * 16) + i);
    				
    			}
    		}
    		
    		//System.out.println("x: " + chunkX * 16+ ", z: " + chunkZ * 16);
    	}
    	else{
    		constructed=true;
    	}
    	
    	//world.setBlockState(new BlockPos(SAGlobal.X, SAGlobal.Y, SAGlobal.Z), Blocks.coal_block.getDefaultState());
    	setRover(world, SAGlobal.X, SAGlobal.Y, SAGlobal.Z);
    	
    }
}