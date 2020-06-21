package com.gmail.fingrambbg.applesremastered;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ApplesRemastered extends JavaPlugin implements Runnable {
	public static Plugin plugin;
	World world;
	ArrayList<Location> points;
	ArrayList<ItemStack> apples;
	Location spawnPoint;
	Random randomNumb;
	int math;
	long timer;
	ItemStack summoned;
	Location locationized;

	private enum Phases {
		ENABLE, DISABLE
	}

	Phases phase;

	@Override
	public void onEnable() {
		math  = 0;
		timer = 0;
		world  = Bukkit.getWorld("World");
		points  = new ArrayList<Location>();
		apples  = new ArrayList<ItemStack>();
		phase = Phases.ENABLE;
		plugin = this;
		randomNumb = new Random();
		spawnPoint = new Location(world, 1, 1, 1);
		getLogger().info("Apples enabled, Config loaded");
		initialize();
	}

	@Override
	public void onDisable() {
		phase = Phases.DISABLE;
		points.clear();
		apples.clear();
		
		getLogger().info("Apples disabled");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("apples")) {
			if (args[0].equalsIgnoreCase("enable")) {
				if (!phase.equals(Phases.ENABLE)) {
					sender.sendMessage("Apples are enabled!");
					phase = Phases.ENABLE;
					run();
				} else {
					sender.sendMessage("Apples are already enabled!");
				}
				return true;
			}
			if (args[0].equalsIgnoreCase("disable")) {
				if (!phase.equals(Phases.DISABLE)) {
					sender.sendMessage("Apples are disabled!");
					phase = Phases.DISABLE;
					run();
				} else {
					sender.sendMessage("Apples are already disabled!");
				}

				return true;
			}
			if (args[0].equalsIgnoreCase("give")) {
				Player p = (Player) sender;
				for (int i = 0; i < apples.size(); i++) {
					p.getInventory().addItem(apples.get(i));
				}
				return true;
			}
			if (args[0].equalsIgnoreCase("reload")) {
				initialize();
				return true;
			}
			
			if (args[0].equalsIgnoreCase("timer")) {
				long temp = math- ((Bukkit.getWorld("World").getTime() - timer) / 20);
				temp = temp / 20;
				sender.sendMessage("Next apple spawns in:" + temp + " seconds.");
				return true;
			}
			
			if (args[0].equalsIgnoreCase("sample")) {
				int math = 0;
				int common = 0;
				int rare = 0;
				int legend = 0;
				for (int i = 0; i < 100; i++) {
					math = randomNumb.nextInt(100);
					if (math < 74) {
						common++;
					} else if (math < 94) {
						rare++;
					} else {
						legend++;
					}
				}
				sender.sendMessage("Common: " + common + ", Rare: " + rare + ", Legendary: " + legend);
				return true;
			}
			
			if (args[0].equalsIgnoreCase("help")) {
				sender.sendMessage("/apples enable - enables apples");
				sender.sendMessage("/apples disable - disables apples");
				sender.sendMessage("/apples give - gives apple of each rank");
				sender.sendMessage("/apples reload - restarts the plugin, helpful for bugs");
				sender.sendMessage("/apples timer - gives the time until the next apple");
				sender.sendMessage("/apples sample - creates a random generation of the next 100 apples");
			}
			return true;
		}
		
		return true;
	}

	private void initialize() {
		// East going counter clockwise
		points.clear();
		apples.clear();
		points.add(spawnPoint = new Location(world, -74, 88, -290));
		points.add(spawnPoint = new Location(world, -67, 88, -287));
		points.add(spawnPoint = new Location(world, -64, 88, -284));
		points.add(spawnPoint = new Location(world, -60, 88, -279));
		points.add(spawnPoint = new Location(world, -58, 88, -274));
		points.add(spawnPoint = new Location(world, -58, 88, -266));
		points.add(spawnPoint = new Location(world, -61, 88, -259));
		points.add(spawnPoint = new Location(world, -64, 88, -256));
		points.add(spawnPoint = new Location(world, -69, 88, -252));
		points.add(spawnPoint = new Location(world, -74, 88, -250));
		points.add(spawnPoint = new Location(world, -82, 88, -250));
		points.add(spawnPoint = new Location(world, -89, 88, -253));
		points.add(spawnPoint = new Location(world, -92, 88, -256));
		points.add(spawnPoint = new Location(world, -96, 88, -261));
		points.add(spawnPoint = new Location(world, -98, 88, -266));
		points.add(spawnPoint = new Location(world, -98, 88, -274));
		points.add(spawnPoint = new Location(world, -95, 88, -281));
		points.add(spawnPoint = new Location(world, -92, 88, -284));
		points.add(spawnPoint = new Location(world, -87, 88, -288));
		points.add(spawnPoint = new Location(world, -82, 88, -290));
		points.add(spawnPoint = new Location(world, -65, 88, -278));
		points.add(spawnPoint = new Location(world, -70, 88, -257));
		points.add(spawnPoint = new Location(world, -75, 88, -255));
		points.add(spawnPoint = new Location(world, -81, 88, -255));
		points.add(spawnPoint = new Location(world, -86, 88, -257));
		points.add(spawnPoint = new Location(world, -91, 88, -262));
		points.add(spawnPoint = new Location(world, -93, 88, -267));
		points.add(spawnPoint = new Location(world, -93, 88, -273));
		points.add(spawnPoint = new Location(world, -91, 88, -278));
		points.add(spawnPoint = new Location(world, -86, 88, -283));
		points.add(spawnPoint = new Location(world, -81, 88, -285));
		points.add(spawnPoint = new Location(world, -75, 88, -285));
		points.add(spawnPoint = new Location(world, -70, 88, -283));
		points.add(spawnPoint = new Location(world, -63, 88, -273));
		points.add(spawnPoint = new Location(world, -65, 88, -262));
		points.add(spawnPoint = new Location(world, -78, 88, -260));
		points.add(spawnPoint = new Location(world, -85, 88, -263));
		points.add(spawnPoint = new Location(world, -88, 88, -270));
		points.add(spawnPoint = new Location(world, -85, 88, -277));
		points.add(spawnPoint = new Location(world, -78, 88, -280));
		points.add(spawnPoint = new Location(world, -71, 88, -277));
		points.add(spawnPoint = new Location(world, -68, 88, -270));
		points.add(spawnPoint = new Location(world, -71, 88, -263));

		ItemStack item = new ItemStack(Material.APPLE);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(ChatColor.AQUA + "Common " + ChatColor.RED + ChatColor.BOLD + "Grand Oak Apple");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("" + ChatColor.GOLD + ChatColor.UNDERLINE + "An Apple That Has Fallen From The Spawn Tree");
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		apples.add(item);

		item = new ItemStack(Material.GOLDEN_APPLE);
		itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(ChatColor.GOLD + "Rare " + ChatColor.RED + ChatColor.BOLD + "Grand Oak Apple");
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		apples.add(item);

		item = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
		itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(ChatColor.YELLOW + "Legendary " + ChatColor.RED + ChatColor.BOLD + "Grand Oak Apple");
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		apples.add(item);
		summoned = item;
		plugin.getServer().getScheduler().runTaskLater(plugin, this, 20);
	}

	public void run() {
		if(phase.equals(Phases.ENABLE)){
			summon();
		}
		else{
			return;
		}
	}

	private void summon() {
		summoned = apples.get(2);
		math = randomNumb.nextInt(100);
		if (math < 74) {
			summoned = apples.get(0);
			//Bukkit.getServer().broadcastMessage("" + ChatColor.GREEN + ChatColor.BOLD + "An " + ChatColor.AQUA + ChatColor.BOLD + "Apple " + ChatColor.GREEN + ChatColor.BOLD + "has fallen from the spawn tree!");
		} else if (math < 94) {
			summoned = apples.get(1);
			//Bukkit.getServer().broadcastMessage("" + ChatColor.GREEN + ChatColor.BOLD + "An " + ChatColor.GOLD	+ ChatColor.BOLD + "Apple " + ChatColor.GREEN + ChatColor.BOLD + "has fallen from the spawn tree!");
		} else {
			summoned = apples.get(2);
			//Bukkit.getServer().broadcastMessage("" + ChatColor.GREEN + ChatColor.BOLD + "An " + ChatColor.YELLOW + ChatColor.BOLD + "Apple " + ChatColor.GREEN + ChatColor.BOLD + "has fallen from the spawn tree!");
		}
		Bukkit.getServer().broadcastMessage("" + ChatColor.GREEN + ChatColor.BOLD + "An apple has fallen from the spawn tree!");
		
		math = randomNumb.nextInt(points.size());
		locationized = points.get(math);
		world.dropItemNaturally(locationized, summoned);

		math = 20 * (randomNumb.nextInt(1800) + (1800));
		timer = Bukkit.getServer().getWorld("World").getTime();
		plugin.getServer().getScheduler().runTaskLater(plugin, this, (long) math);
	}
}
