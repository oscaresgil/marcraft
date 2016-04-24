package com.spaceapps.mod.world;

import java.util.Random;

import com.spaceapps.mod.SAGlobal;
import com.spaceapps.mod.blocks.SABlocks;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
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
	private int chunkSize = 15;
	
	
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
	
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
    	//((Object) world).setBlock(chunkX*16 + random.nextInt(16), 100, chunkZ*16 + random.nextInt(16), 5);
    	// The first generation will set center of the world
    	int realCoordinateX=chunkX*16;
    	int realCoordinateZ=chunkZ*16;
    	world.setBlockState(new BlockPos(realCoordinateX, 1, realCoordinateZ), SABlocks.copperBlock.getDefaultState());
    	
    	
    }
}