package com.staxzs.staxzstrolls.listener;

import com.staxzs.staxzstrolls.troll.Troll;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.mineacademy.fo.annotation.AutoRegister;

@AutoRegister
public final class EntityListener implements Listener {
	@EventHandler(ignoreCancelled = true)
	public void onEntityPickupItem(EntityPickupItemEvent event) {
		for (Troll troll : Troll.getRegisteredTrolls())
			troll.onEntityPickupItem(event);
	}
}
