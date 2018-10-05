package me.mizaki.boussole.ressources;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Gui {

	private Inventory inventory;
	private Player player;
	private InventoryType type;
	private String title;
	
	private List<ItemStack> items;
	
	/*
	 * Cette Class existe pour gerer l'interface graphique et de ses items
	 */
	
	public Gui(Player player, InventoryType type, String title) {
		
		this.player = player;
		this.type = type;
		this.title = title;
		this.inventory = Bukkit.createInventory(this.player, this.type, this.title);
		this.items = new ArrayList<ItemStack>();
		
	}
	
	public Gui(Player player, InventoryType type) {
		
		this.player = player;
		this.type = type;
		this.inventory = Bukkit.createInventory(this.player, this.type);
		this.title = this.inventory.getTitle();
		this.items = new ArrayList<ItemStack>();
		
	}
	
	public void setItem(ItemStack itemStack, int n) {
		this.items.add((Item) itemStack);
		this.inventory.setItem(n, itemStack);
	}
	
	public void removeItem(Item item) {
		this.inventory.remove(item);
		
		for(ItemStack i : this.items) {
			if(i.equals(item))
				this.items.remove(i);
		}
	}
	
	public void reload() {
		this.inventory.clear();
		for(ItemStack i : this.items)
			this.inventory.addItem(i);
	}
	
	public void openInventory() {
		this.player.openInventory(this.inventory);
	}
	
	public void closeInventory() {
		this.player.closeInventory();
	}
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public InventoryType getType() {
		return type;
	}

	public void setType(InventoryType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ItemStack> getItems() {
		return items;
	}

	public void setItems(List<ItemStack> items) {
		this.items = items;
	}
}
