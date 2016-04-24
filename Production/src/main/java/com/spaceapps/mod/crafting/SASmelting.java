package com.spaceapps.mod.crafting;

import com.spaceapps.mod.blocks.SABlocks;
import com.spaceapps.mod.items.SAItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SASmelting {
	
	public static void initSmelting(){
		GameRegistry.addSmelting(SABlocks.copperOre, new ItemStack(SAItems.copperIngot), 0);
	}
}
