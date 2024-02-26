package com.staxzs.staxzstrolls.api;

import com.staxzs.staxzstrolls.PlayerCache;
import com.staxzs.staxzstrolls.StaxzsTrolls;
import org.bukkit.entity.Player;

/**
 * A sample API class you can build on to use for your plugin.
 */
public final class SampleAPI {

	/**
	 * Return the main instance of this plugin
	 *
	 * @return
	 */
	public static StaxzsTrolls getAPI() {
		return StaxzsTrolls.getInstance();
	}

	/**
	 * Get the player cache. Creates the cache if it does not exist.
	 * <p>
	 * Please use with caution since we do create this cache on PlayerJoinEvent
	 * when the player joins automatically.
	 *
	 * @param player
	 * @return
	 */
	public static PlayerCache getPlayerCache(Player player) {
		return PlayerCache.from(player);
	}
}
