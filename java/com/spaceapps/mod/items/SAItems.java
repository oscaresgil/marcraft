package com.spaceapps.mod.items;

import com.spaceapps.mod.SAGlobal;
import com.spaceapps.mod.items.armor.SACopperArmor;
import com.spaceapps.mod.items.tools.SACopperAxe;
import com.spaceapps.mod.items.tools.SACopperHoe;
import com.spaceapps.mod.items.tools.SACopperPickaxe;
import com.spaceapps.mod.items.tools.SACopperSpade;
import com.spaceapps.mod.items.tools.SACopperSword;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SAItems {
	//Tools Material
	public static ToolMaterial COPPERTOOLS = EnumHelper.addToolMaterial("COPPERTOOLS",3,800,8.0f,4.0f,10);
	
	//Armor Material
	public static ArmorMaterial COPPERARMOR = EnumHelper.addArmorMaterial("COPPERARMOR", SAGlobal.MOD_ID+":"+"copper",20,new int[]{2,3,5,1},30);
	
	
	//tools
	public static Item copperPickaxe;
	public static Item copperAxe;
	public static Item copperSpade;
	public static Item copperHoe;
	public static Item copperSword;
	
	//armor
	public static Item copperHelmet;
	public static Item copperChestplate;
	public static Item copperLeggings;
	public static Item copperBoots;
	
	//ingots
	public static Item copperIngot;
	public static Item nickelIngot;
	
	//gems
	public static Item topasStone;
	public static void initItems(){
		//Tools
		GameRegistry.registerItem(copperPickaxe = new SACopperPickaxe("copperPickaxe",COPPERTOOLS),"copperPickaxe");
		GameRegistry.registerItem(copperAxe = new SACopperAxe("copperAxe",COPPERTOOLS),"copperAxe");
		GameRegistry.registerItem(copperSpade = new SACopperSpade("copperSpade",COPPERTOOLS),"copperSpade");
		GameRegistry.registerItem(copperHoe = new SACopperHoe("copperHoe",COPPERTOOLS),"copperHoe");
		GameRegistry.registerItem(copperSword = new SACopperSword("copperSword",COPPERTOOLS),"copperSword");
		
		//armor
		GameRegistry.registerItem(copperHelmet = new SACopperArmor("copperHelmet",COPPERARMOR,1,0),"copperHelmet");
		GameRegistry.registerItem(copperChestplate = new SACopperArmor("copperChestplate",COPPERARMOR,1,1),"copperChestplate");
		GameRegistry.registerItem(copperLeggings = new SACopperArmor("copperLeggings",COPPERARMOR,2,2),"copperLeggings");
		GameRegistry.registerItem(copperBoots = new SACopperArmor("copperBoots",COPPERARMOR,1,3),"copperBoots");
		
		//ingots
		GameRegistry.registerItem(copperIngot = new SAItem("copperIngot"),"copperIngot");
		GameRegistry.registerItem(nickelIngot = new SAItem("nickelIngot"),"nickelIngot");
		
		//gems
		GameRegistry.registerItem(topasStone = new SAItem("topasStone"),"topasStone");
	}
}
