package io.ingpleb.plebtrolls.listener;

import io.ingpleb.plebtrolls.PlayerCache;
import io.ingpleb.plebtrolls.troll.Troll;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.mineacademy.fo.annotation.AutoRegister;

/**
 * A sample listener for events.
 */
@AutoRegister
public final class PlayerListener implements Listener {

	/**
	 * Listen for player join and loads his data
	 *
	 * @param event the event
	 */
	@EventHandler(priority = EventPriority.LOWEST)
	public void onJoin(PlayerJoinEvent event) {
		final Player player = event.getPlayer();

		PlayerCache.from(player); // Load player's cache

		for (Troll troll : Troll.getRegisteredTrolls())
			troll.onPlayerJoin(event);
	}

	/**
	 * Automatically unload player's cache on his exit to save memory.
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		final Player player = event.getPlayer();

		PlayerCache.from(player).removeFromMemory(); // Unload player's cache

		for (Troll troll : Troll.getRegisteredTrolls())
			troll.onPlayerQuit(event);
	}

	@EventHandler(ignoreCancelled = true)
	public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
		for (Troll troll : Troll.getRegisteredTrolls())
			troll.onAsyncPlayerChat(event);
	}

	@EventHandler(ignoreCancelled = true)
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		for (Troll troll : Troll.getRegisteredTrolls())
			troll.onPlayerRespawn(event);
	}

	@EventHandler(ignoreCancelled = true)
	public void onPlayerItemHeld(PlayerItemHeldEvent event) {
		for (Troll troll : Troll.getRegisteredTrolls())
			troll.onPlayerItemHeld(event);
	}
}
