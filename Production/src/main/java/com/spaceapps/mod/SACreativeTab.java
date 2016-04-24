package com.spaceapps.mod;

import com.spaceapps.mod.items.SAItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SACreativeTab extends CreativeTabs{
	public SACreativeTab(String string){
		super(string);
	}
	
	public Item getTabIconItem(){
		return SAItems.copperIngot; 
	}
}