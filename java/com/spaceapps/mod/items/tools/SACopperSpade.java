package com.spaceapps.mod.items.tools;

import com.spaceapps.mod.SAGlobal;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;

public class SACopperSpade extends ItemSpade{
	public SACopperSpade(String unlocalizedName,ToolMaterial material){
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(SAGlobal.saCreativeTab);
	}
}
