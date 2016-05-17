package com.spaceapps.mod.blocks;

import java.util.Random;

import com.spaceapps.mod.SAGlobal;
import com.spaceapps.mod.items.SAItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class SABlock extends Block{
	public SABlock(String unlocalizedName, Material material, float hardness, float resistance){
		super(material);
		this.setCreativeTab(SAGlobal.saCreativeTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		
		return this == SABlocks.topasOre ? SAItems.topasStone: Item.getItemFromBlock(this);
	}
}