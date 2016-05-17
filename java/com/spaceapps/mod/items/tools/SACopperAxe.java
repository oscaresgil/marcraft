package com.spaceapps.mod.items.tools;

import com.spaceapps.mod.SAGlobal;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;

public class SACopperAxe extends ItemAxe{
	public SACopperAxe(String unlocalizedName,ToolMaterial material){
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(SAGlobal.saCreativeTab);
	}
}
