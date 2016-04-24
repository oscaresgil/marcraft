package com.spaceapps.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SABlocks {
	//ores
	public static Block copperOre;
	public static Block nickelOre;
	
	//gems
	public static Block topasOre;
	
	//ore blocks
	public static Block copperBlock;
	
	public static void initBlocks(){
		
		//ores
		GameRegistry.registerBlock(copperOre=new SABlock("copperOre",Material.rock,3,15),"copperOre");
		GameRegistry.registerBlock(nickelOre=new SABlock("nickelOre",Material.rock,3,15),"nickelOre");
		
		//gems
		GameRegistry.registerBlock(topasOre=new SABlock("topasOre",Material.rock,3,15),"topasOre");
		
		//ore blocks
		GameRegistry.registerBlock(copperBlock=new SABlock("copperBlock",Material.iron,5,10),"copperBlock");
	}
}
