package me.mizaki.boussole.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.mizaki.boussole.ressources.Item;

public class SecureInventoryEvent implements Listener
{

	/*
	 * Cette Class permet de proteger les items en interdisant l'utilisateur de bouger les items de l'inventaire
	 */
	
	@EventHandler
	public void onInventory(InventoryClickEvent event)
	{
		if(event.getCurrentItem() instanceof Item)
		{
			event.setCancelled(true);
		}
	}
}
