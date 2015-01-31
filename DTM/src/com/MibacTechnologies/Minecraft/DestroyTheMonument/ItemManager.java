package com.MibacTechnologies.Minecraft.DestroyTheMonument;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 29 Jan 2015 (15:11:30)
 */
public class ItemManager {
	private HashMap< Integer, ItemStack > items;

	public ItemManager( ) {
		items.put( 0, new ItemStack( Material.STONE_SWORD, 1 ) );
	}

	public HashMap< Integer, ItemStack > getItems ( ) {
		return items;
	}
}
