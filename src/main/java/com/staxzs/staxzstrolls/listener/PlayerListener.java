package com.staxzs.staxzstrolls.listener;

import com.staxzs.staxzstrolls.PlayerCache;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mineacademy.fo.annotation.AutoRegister;

/**
 * A sample listener for events.
 */
@AutoRegister
public final class PlayerListener implements Listener {

	/**
	 * Listen for player join and loads his data
	 *
	 * @param event
	 */
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		final Player player = event.getPlayer();

		PlayerCache.from(player); // Load player's cache
	}

	/**
	 * Automatically unload player's cache on his exit to save memory.
	 *
	 * @param event
	 */
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		final Player player = event.getPlayer();

		PlayerCache.from(player).removeFromMemory(); // Unload player's cache
	}
}
