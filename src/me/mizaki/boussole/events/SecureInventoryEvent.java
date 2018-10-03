package me.mizaki.boussole.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SecureInventoryEvent implements Listener
{

	@EventHandler
	public void onInventory(InventoryClickEvent event)
	{
		if(event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.AQUA + "."))
		{
			event.setCancelled(true);
		}
	}
}
