package com.staxzs.staxzstrolls.listener;

import com.staxzs.staxzstrolls.troll.Troll;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.mineacademy.fo.annotation.AutoRegister;

@AutoRegister
public final class InventoryListener implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void onInventoryClick(InventoryClickEvent event) {
		for (Troll troll : Troll.getRegisteredTrolls())
			troll.onInventoryClick(event);
	}
}
