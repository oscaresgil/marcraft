package com.spaceapps.mod.items.tools;

import com.spaceapps.mod.SAGlobal;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;

public class SACopperSword extends ItemSword{
	public SACopperSword(String unlocalizedName,ToolMaterial material){
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(SAGlobal.saCreativeTab);
	}
}
