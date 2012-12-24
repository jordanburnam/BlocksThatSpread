package com.github.jordanburnam.bukkit.plugin.BlocksThatSpread;
import org.bukkit.Location;
import org.bukkit.block.*;
import org.bukkit.entity.Player;
import org.bukkit.util.NumberConversions;
import org.bukkit.util.BlockIterator.*;

public class BlockWatcher {
	
	private static rjbDataBaseWrapper staticFact = new rjbDataBaseWrapper();
	private rjbDataBaseWrapper Fact = new rjbDataBaseWrapper();
	
	public static void addBlockthatChanged(Block b, Location loc, BlockState blockstate, String entityName) throws Exception
	{
		try
		{
			int oldBlock = blockstate.getTypeId();
			int newBlock = b.getTypeId();
			int x = NumberConversions.round(loc.getX());
			int y = NumberConversions.round(loc.getY());
			int z = NumberConversions.round(loc.getZ());
			staticFact.DeleteParameters();
			staticFact.AddParameter(entityName);
			staticFact.AddParameter(oldBlock);
			staticFact.AddParameter(newBlock);
			staticFact.AddParameter(x);
			staticFact.AddParameter(y);
			staticFact.AddParameter(z);
			staticFact.executeStoredProcedureWithNoResults("rjb_mc_addBlockUpdated");
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}

	
	
}
