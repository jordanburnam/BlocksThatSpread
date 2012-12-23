package com.github.jordanburnam.bukkit.plugin.BlocksThatSpread;
import org.bukkit.block.Block;
import org.bukkit.event.*;
import org.bukkit.event.block.BlockPlaceEvent;
public class BTS_EventListener implements Listener 
{
	@EventHandler
	public void blockPlaced(BlockPlaceEvent event)
	{
	   Block b = event.getBlock();
	   
	}
}
