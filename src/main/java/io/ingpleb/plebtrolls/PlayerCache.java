package io.ingpleb.plebtrolls;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.mineacademy.fo.constants.FoConstants;
import org.mineacademy.fo.remain.Remain;
import org.mineacademy.fo.settings.YamlConfig;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * A sample player cache storing permanent player information
 * to data.db or MySQL database for players.
 */
@Getter
public final class PlayerCache extends YamlConfig {

	/**
	 * The player cache map caching data for players online.
	 */
	private static final Map<UUID, PlayerCache> cacheMap = new HashMap<>();

	/**
	 * This instance's player's unique id
	 */
	private final UUID uniqueId;

	/**
	 * This instance's player's name
	 */
	private final String playerName;

	//
	// Store any custom savable data here
	//
	@Setter
	private boolean enableGravityOnJoin;

	/*
	 * Creates a new player cache (see the bottom)
	 */
	private PlayerCache(String name, UUID uniqueId) {
		this.playerName = name;
		this.uniqueId = uniqueId;

		this.setPathPrefix("Players." + uniqueId.toString());
		this.loadConfiguration(NO_DEFAULT, FoConstants.File.DATA);
	}

	/**
	 * Return or create new player cache for the given player
	 */
	public static PlayerCache from(Player player) {
		synchronized (cacheMap) {
			final UUID uniqueId = player.getUniqueId();
			final String playerName = player.getName();

			PlayerCache cache = cacheMap.get(uniqueId);

			if (cache == null) {
				cache = new PlayerCache(playerName, uniqueId);

				cacheMap.put(uniqueId, cache);
			}

			return cache;
		}
	}

	/**
	 * Clear the entire cache map
	 */
	public static void clearCaches() {
		synchronized (cacheMap) {
			cacheMap.clear();
		}
	}

	/* ------------------------------------------------------------------------------- */
	/* Data-related methods */
	/* ------------------------------------------------------------------------------- */

	//
	// Implement your own data getter/setters here according to this example:
	//

	//public boolean hasChatColor() {
	//	return this.chatColor != null;
	//}

	//public void setChatColor(@Nullable CompChatColor chatColor) {
	//	this.chatColor = chatColor;
	//
	//	save();
	//}

	/* ------------------------------------------------------------------------------- */
	/* Misc methods */
	/* ------------------------------------------------------------------------------- */

	/**
	 * Automatically called when loading data from disk.
	 *
	 * @see org.mineacademy.fo.settings.YamlConfig#onLoadFinish()
	 */
	@Override
	protected void onLoad() {
		//
		// Load any custom fields here, example:
		// this.chatColor = get("Chat_Color", CompChatColor.class);
		//

		this.enableGravityOnJoin = this.getBoolean("Enable_Gravity_On_Join", false);
	}

	/**
	 * Called automatically when the file is about to be saved, set your field values here
	 */
	@Override
	public void onSave() {

		//
		// Save any custom fields here, example:
		// this.set("Chat_Color", this.chatColor);
		//

		this.set("Enable_Gravity_On_Join", this.enableGravityOnJoin);
	}

	/**
	 * Return player from cache if online or null otherwise
	 *
	 * @return
	 */
	@Nullable
	public Player toPlayer() {
		final Player player = Remain.getPlayerByUUID(this.uniqueId);

		return player != null && player.isOnline() ? player : null;
	}

	/**
	 * Remove this cached data from memory if it exists
	 */
	public void removeFromMemory() {
		synchronized (cacheMap) {
			cacheMap.remove(this.uniqueId);
		}
	}

	/**
	 * Compare if two caches are equal on the basis of {@link UUID} since it is unique.
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof PlayerCache && ((PlayerCache) obj).getUniqueId().equals(this.uniqueId);
	}

	/* ------------------------------------------------------------------------------- */
	/* Static access */
	/* ------------------------------------------------------------------------------- */

	/**
	 * Generate unique hash code from {@link UUID}.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.uniqueId);
	}

	@Override
	public String toString() {
		return "PlayerCache{" + this.playerName + ", " + this.uniqueId + "}";
	}
}
