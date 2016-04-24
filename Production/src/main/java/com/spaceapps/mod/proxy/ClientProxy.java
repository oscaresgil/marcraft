package com.spaceapps.mod.proxy;


import com.spaceapps.mod.render.SABlockRender;
import com.spaceapps.mod.render.SAItemRender;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	public void preInit(FMLPreInitializationEvent preEvent){
		super.preInit(preEvent);
	}
	
	
	public void init(FMLInitializationEvent event){
		super.init(event);
		SABlockRender.registerBlockRender();
		SAItemRender.registerItemRender();
	}

	
	public void postInit(FMLPostInitializationEvent postEvent){
		super.postInit(postEvent);
	}
}
