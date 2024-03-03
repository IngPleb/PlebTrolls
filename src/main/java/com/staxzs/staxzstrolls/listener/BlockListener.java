package com.staxzs.staxzstrolls.listener;

import com.staxzs.staxzstrolls.troll.Troll;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.mineacademy.fo.annotation.AutoRegister;

@AutoRegister
public final class BlockListener implements Listener {
	@EventHandler(ignoreCancelled = true)
	public void onBlockBreak(BlockBreakEvent event) {
		for (Troll troll : Troll.getRegisteredTrolls())
			troll.onBlockBreak(event);
	}

	@EventHandler(ignoreCancelled = true)
	public void onBlockPlace(BlockPlaceEvent event) {
		for (Troll troll : Troll.getRegisteredTrolls())
			troll.onBlockPlace(event);
	}
}
