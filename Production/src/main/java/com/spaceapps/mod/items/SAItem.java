package com.spaceapps.mod.items;

import com.spaceapps.mod.SAGlobal;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SAItem extends Item{
	public SAItem (String name){
		super();
		
		this.setUnlocalizedName(name);
		this.setCreativeTab(SAGlobal.saCreativeTab);
	}
}
