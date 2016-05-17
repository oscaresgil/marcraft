package com.spaceapps.mod;

import com.spaceapps.mod.proxy.CommonProxy;
import com.spaceapps.mod.world.SAWorldGen;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid=SAGlobal.MOD_ID,name=SAGlobal.MOD_NAME,version=SAGlobal.VERSION)
public class Main{
	@Instance(SAGlobal.MOD_ID)
	public static Main instance;
	
	@SidedProxy(clientSide=SAGlobal.SA_Client_Proxy, serverSide=SAGlobal.SA_Common_Proxy)
	public static CommonProxy proxy;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent){
		this.proxy.preInit(preEvent);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		this.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent postEvent){
		this.proxy.postInit(postEvent);
	}
}
