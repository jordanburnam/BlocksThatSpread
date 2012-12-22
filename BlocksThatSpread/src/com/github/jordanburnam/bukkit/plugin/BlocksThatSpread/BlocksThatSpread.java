package com.github.jordanburnam.bukkit.plugin.BlocksThatSpread;

import org.bukkit.plugin.java.JavaPlugin;

public class BlocksThatSpread extends JavaPlugin {
	
	@Override
    public void onEnable(){
		getLogger().info("onEnable has been invoked!");
		getCommand("basic").setExecutor(new BTS_CommandExecutor(this));
    }
 
    @Override
    public void onDisable() {
    	getLogger().info("onDisable has been invoked!");
    }

}
