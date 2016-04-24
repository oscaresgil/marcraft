package com.spaceapps.mod.crafting;

import com.spaceapps.mod.blocks.SABlock;
import com.spaceapps.mod.blocks.SABlocks;
import com.spaceapps.mod.items.SAItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SARecipes {
	
	public static void initRecipes(){
		
		GameRegistry.addRecipe(new ItemStack(SABlocks.copperBlock),
				new Object[]{
						"###",
						"###",
						"###",
						'#',SAItems.copperIngot
				});
		GameRegistry.addShapelessRecipe(new ItemStack(SAItems.copperIngot,9),
				new Object[]{
						SABlocks.copperBlock
				});
	}
}
