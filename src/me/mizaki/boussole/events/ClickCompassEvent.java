package me.mizaki.boussole.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;

import me.mizaki.boussole.main.CompassMain;
import me.mizaki.boussole.ressources.Gui;
import me.mizaki.boussole.ressources.Item;
import me.mizaki.boussole.ressources.ItemType;

public class ClickCompassEvent implements Listener
{

	private Gui mainInventory;
	private Gui poleInventory;
	
	/*
	 * Cette Fonction gere l'ouverture de l'inventaire par l'intermediaire d'un boussole
	 */
	
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
					this.mainInventory = new Gui(player, InventoryType.CHEST, "Boussole de " + player.getName());
					this.mainInventory = fillInventory(this.mainInventory);
					this.mainInventory.openInventory();
				}
			}
		}
		
	}
	
	private Gui fillInventory(Gui inventory)
	{
		Gui inv = inventory;
		Item lit = new Item(Material.RED_BED, "Lit"),
				enderPearl = new Item(Material.ENDER_PEARL, "Position enregistrée"),
					tete = new Item(Material.SKELETON_SKULL, "Suivre un joueur"),
						spawn = new Item(Material.BLUE_BED, "Spawn par défaut"),
							origin = new Item(Material.APPLE, "Pointez le 0 !"),
								direction = new Item(Material.ACACIA_BOAT, "Pointez vers un pole");
		
		inv.setItem(lit.getItem(), 0);
		inv.setItem(enderPearl.getItem(), 1);
		inv.setItem(tete.getItem(), 2);
		inv.setItem(spawn.getItem(), 3);
		inv.setItem(origin.getItem(), 4);
		inv.setItem(direction.getItem(), 5);
		
		return inv;
	}
	
	
	
	@EventHandler
	public void itemClick(InventoryClickEvent event)
	{
		if(event.getCurrentItem() instanceof Item)
		{
			actionClick((Item) event.getCurrentItem(), (Player) event.getWhoClicked());
		}
	}
	
	private void actionClick(Item item, Player player)
	{
		if(item.getItemType() == ItemType.MENU)
		{
			switch (item.getName())
			{
				case "Lit":
						if(player.getBedSpawnLocation() != null)
						{
							CompassMain.sendMessage(player, "Direction le lit !");
							player.setCompassTarget(player.getBedSpawnLocation());
						}
						else
							CompassMain.sendMessage(player, "Vous n'avez pas de lit !");
					break;
					
				case "Position enregistrée":
						
					break;
					
				case "Suivre un joueur":
					
					break;
					
				case "Spawn par défaut":
	
					break;
					
				case "Pointez le 0 !":
						CompassMain.sendMessage(player, "Direction l'origine du monde !");
						player.setCompassTarget(new Location(player.getWorld(), 0.0, 0.0, 0.0));
					break;
					
				case "Pointez vers un pole":
						pole(player);
					break;
				default:
					break;
			}
		}
		else
		{
			
		}
	}

	private void pole(Player player)
	{
		Item nord = new Item(Material.GRASS, "NORD"),
				sud = new Item(Material.GRASS, "SUD"),
					est = new Item(Material.GRASS, "EST"),
						ouest = new Item(Material.GRASS, "OUEST");
		
		this.poleInventory = new Gui(player, InventoryType.HOPPER, "Choix des pôles");
		this.poleInventory.setItem(nord, 0);
		this.poleInventory.setItem(sud, 1);
		this.poleInventory.setItem(est, 2);
		this.poleInventory.setItem(ouest, 3);
		
		this.poleInventory.openInventory();
	}
}
