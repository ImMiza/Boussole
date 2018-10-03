package me.mizaki.boussole.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClickCompassEvent implements Listener
{

	private Inventory mainInventory;
	private List<ItemStack> itemsGui = new ArrayList<ItemStack>();
	
	@EventHandler
	public void onMakeInventoryClick(PlayerInteractEvent event) 
	{
		final Player player = event.getPlayer();
		
		if(player.getInventory().getItemInMainHand() != null || player.getInventory().getItemInOffHand() != null)
		{
			if(player.getInventory().getItemInMainHand().getType() == Material.COMPASS || player.getInventory().getItemInOffHand().getType() == Material.COMPASS)
			{
				if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
				{
					this.mainInventory = Bukkit.createInventory(player, InventoryType.CHEST, "Boussole de " + player.getName());
					this.mainInventory = fillInventory(this.mainInventory);
					player.openInventory(this.mainInventory);
				}
			}
		}
		
	}
	
	private Inventory fillInventory(Inventory inventory)
	{
		Inventory inv = inventory;
		ItemMeta meta;
		
		ItemStack lit = new ItemStack(Material.RED_BED), 
				enderPearl = new ItemStack(Material.ENDER_PEARL),
					tete = new ItemStack(Material.SKELETON_SKULL),
						spawn = new ItemStack(Material.BLUE_BED),
							origin = new ItemStack(Material.APPLE),
								direction = new ItemStack(Material.ACACIA_BOAT);
					
		meta = lit.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + ".Lit");
		lit.setItemMeta(meta);
		
		
		meta = enderPearl.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + ".Position enregistrée");
		enderPearl.setItemMeta(meta);
		
		
		meta = tete.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + ".Suivre un joueur");
		tete.setItemMeta(meta);
		
		
		meta = spawn.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + ".Spawn par défaut");
		spawn.setItemMeta(meta);
		
		meta = origin.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + ".Pointez le 0 !");
		origin.setItemMeta(meta);
		
		meta = direction.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + ".Pointez vers un pole");
		direction.setItemMeta(meta);
		
		if(itemsGui.isEmpty())
		{
			itemsGui.add(lit);
			itemsGui.add(enderPearl);
			itemsGui.add(tete);
			itemsGui.add(spawn);
			itemsGui.add(origin);
			itemsGui.add(direction);
		}
		
		inv.setItem(0, lit);
		inv.setItem(1, enderPearl);
		inv.setItem(2, tete);
		inv.setItem(3, spawn);
		inv.setItem(4, origin);
		inv.setItem(5, direction);
		
		return inv;
	}
	
	@EventHandler
	public void itemClick(InventoryClickEvent event)
	{
		
	}
}
