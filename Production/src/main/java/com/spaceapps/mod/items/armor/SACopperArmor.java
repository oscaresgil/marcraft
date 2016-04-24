package com.spaceapps.mod.items.armor;

import com.spaceapps.mod.SAGlobal;
import com.spaceapps.mod.items.SAItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class SACopperArmor extends ItemArmor{
	public SACopperArmor(String unlocalizedName,ArmorMaterial material,int renderIndex, int armorType){
		super(material,renderIndex,armorType);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(SAGlobal.saCreativeTab);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack){
		if(itemStack.getItem()==SAItems.copperHelmet){
			this.effectPlayer(player, Potion.nightVision, 0);
		}
		if(itemStack.getItem()==SAItems.copperChestplate){
			this.effectPlayer(player, Potion.absorption, 1);
		}
		if(itemStack.getItem()==SAItems.copperLeggings){
			this.effectPlayer(player, Potion.moveSpeed, 1);
		}
		if(itemStack.getItem()==SAItems.copperBoots){
			this.effectPlayer(player, Potion.jump, 2);
		}
		
		if(this.isWearingFullSet(player, SAItems.copperHelmet, SAItems.copperChestplate, SAItems.copperLeggings, SAItems.copperBoots)){
			this.effectPlayer(player, Potion.regeneration, 1);
		}
	}
	
	private boolean isWearingFullSet(EntityPlayer player,Item helmet, Item chestpiece, Item leggings, Item boots){
		return player.inventory.armorItemInSlot(3)!=null&&player.inventory.armorItemInSlot(3).getItem()==helmet
				&&player.inventory.armorItemInSlot(2)!=null&&player.inventory.armorItemInSlot(2).getItem()==chestpiece
				&&player.inventory.armorItemInSlot(1)!=null&&player.inventory.armorItemInSlot(1).getItem()==leggings
				&&player.inventory.armorItemInSlot(0)!=null&&player.inventory.armorItemInSlot(0).getItem()==boots;
	}
	
	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier){
		if(player.getActivePotionEffect(potion)==null ||player.getActivePotionEffect(potion).getDuration()<=1){
			player.addPotionEffect(new PotionEffect(potion.id,159,amplifier,true,true));
		}
	}
}
