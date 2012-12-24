package com.github.jordanburnam.bukkit.plugin.BlocksThatSpread;


import org.bukkit.Location;
import org.bukkit.block.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

public class BTS_EventListener implements Listener 
{
	@EventHandler
	public void blockPlaced(BlockPlaceEvent event)
	{
		try 
		{
			BlockState blockstate = event.getBlockReplacedState();
			Block b = event.getBlock();
			Location bloc = b.getLocation();
			BlockWatcher.addBlockthatChanged(b, bloc, blockstate, event.getPlayer().getPlayerListName());
		} 
		catch (Exception e) 
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	 
	}
}
