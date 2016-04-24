package com.spaceapps.mod.items.tools;

import com.spaceapps.mod.SAGlobal;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;

public class SACopperHoe extends ItemHoe{
	public SACopperHoe(String unlocalizedName,ToolMaterial material){
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(SAGlobal.saCreativeTab);
	}
}
