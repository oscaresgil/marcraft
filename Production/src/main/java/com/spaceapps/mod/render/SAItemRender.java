package com.spaceapps.mod.render;

import com.spaceapps.mod.SAGlobal;
import com.spaceapps.mod.items.SAItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class SAItemRender {
	public static void registerItemRender(){
		
		//tools
		regItem(SAItems.copperPickaxe);
		regItem(SAItems.copperAxe);
		regItem(SAItems.copperSpade);
		regItem(SAItems.copperHoe);
		regItem(SAItems.copperSword);
		
		//armor
		regItem(SAItems.copperHelmet);
		regItem(SAItems.copperChestplate);
		regItem(SAItems.copperLeggings);
		regItem(SAItems.copperBoots);
		
		//ingots
		regItem(SAItems.copperIngot);
		regItem(SAItems.nickelIngot);
		
		//gems
		regItem(SAItems.topasStone);
	}
	public static void regItem(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0, new ModelResourceLocation(SAGlobal.MOD_ID+":"+item.getUnlocalizedName().substring(5),"inventory"));
	}
}
