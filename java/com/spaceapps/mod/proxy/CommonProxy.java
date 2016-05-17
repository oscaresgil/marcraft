package com.spaceapps.mod.proxy;

import com.spaceapps.mod.blocks.SABlocks;
import com.spaceapps.mod.crafting.SARecipes;
import com.spaceapps.mod.crafting.SASmelting;
import com.spaceapps.mod.items.SAItems;
import com.spaceapps.mod.world.SAWorldGen;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent preEvent){
		SABlocks.initBlocks();
		SAItems.initItems();
		
		SARecipes.initRecipes();
		SASmelting.initSmelting();
	}
	
	
	public void init(FMLInitializationEvent event){
		GameRegistry.registerWorldGenerator(new SAWorldGen(), 0);
		System.out.println("registrado");
	}

	
	public void postInit(FMLPostInitializationEvent postEvent){
		
	}
}
