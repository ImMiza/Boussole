package me.mizaki.boussole.ressources;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item extends ItemStack{

	private ItemStack item;
	private String name;
	private ItemType type;
	
	public Item(Material material, String name, ItemType type) {
		this.item = new ItemStack(material);
		this.name = name;
		this.type = type;
		
		ItemMeta meta = this.item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + this.name);
		this.item.setItemMeta(meta);
		
	}
	
	public Item(Material material, String name) {
		this.item = new ItemStack(material);
		this.name = name;
		this.type = ItemType.MENU;
		
		ItemMeta meta = this.item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + this.name);
		this.item.setItemMeta(meta);
		
	}
	
	public Item(Material material) {
		this.item = new ItemStack(material);
		this.name = this.item.getItemMeta().getDisplayName();
		this.type = ItemType.MENU;
		
		ItemMeta meta = this.item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + this.name);
		this.item.setItemMeta(meta);
		
	}

	public ItemStack getItem() {
		return item;
	}

	public void setItem(ItemStack item) {
		this.item = item;
	}
	
	public void setItem(Material item) {
		this.item = new ItemStack(item);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemType getItemType()
	{
		return this.type;
	}

	public void setItemType(ItemType type)
	{
		this.type = type;
	}

}
