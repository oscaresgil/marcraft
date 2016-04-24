package com.spaceapps.mod.render;

import com.spaceapps.mod.SAGlobal;
import com.spaceapps.mod.blocks.SABlocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class SABlockRender {
	public static void registerBlockRender(){
		//ores
		regBlock(SABlocks.copperOre);
		regBlock(SABlocks.nickelOre);
		
		//gems
		regBlock(SABlocks.topasOre);
		
		//ore blocks
		regBlock(SABlocks.copperBlock);
	}
	
	public static void regBlock(Block block){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block),0, new ModelResourceLocation(SAGlobal.MOD_ID+":"+block.getUnlocalizedName().substring(5),"inventory"));
	}
}
