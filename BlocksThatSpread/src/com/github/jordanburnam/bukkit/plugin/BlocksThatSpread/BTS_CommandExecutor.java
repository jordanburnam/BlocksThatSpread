package com.github.jordanburnam.bukkit.plugin.BlocksThatSpread;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BTS_CommandExecutor implements CommandExecutor {
	
	private BlocksThatSpread plugin;
	
	public BTS_CommandExecutor(BlocksThatSpread bts)
	{
		this.plugin = bts;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) 
	{
		if (sender instanceof Player) {
	           Player player = (Player) sender;
	           // do something
	        } else {
	           sender.sendMessage("You must be a player!");
	           return false;
	        }
	        // do something
	        return false;
	}

}
