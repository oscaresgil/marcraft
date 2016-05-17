package com.spaceapps.mod.items.tools;

import com.spaceapps.mod.SAGlobal;

import net.minecraft.item.ItemPickaxe;

public class SACopperPickaxe extends ItemPickaxe{
	public SACopperPickaxe(String unlocalizedName,ToolMaterial material){
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(SAGlobal.saCreativeTab);
	}
}
