package com.spaceapps.mod.proxy;


import com.spaceapps.mod.Main;
import com.spaceapps.mod.event.Events;
import com.spaceapps.mod.event.EventsHandler;
import com.spaceapps.mod.render.SABlockRender;
import com.spaceapps.mod.render.SAItemRender;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy{
	public void preInit(FMLPreInitializationEvent preEvent){
		super.preInit(preEvent);
	}
	
	
	public void init(FMLInitializationEvent event){
		super.init(event);
		SABlockRender.registerBlockRender();
		SAItemRender.registerItemRender();
		MinecraftForge.EVENT_BUS.register(new Events());
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new EventsHandler());
	}

	
	public void postInit(FMLPostInitializationEvent postEvent){
		super.postInit(postEvent);
	}
}
