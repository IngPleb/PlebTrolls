package io.ingpleb.plebtrolls.util;

import org.bukkit.entity.Player;
import org.mineacademy.fo.remain.Remain;
import org.mineacademy.fo.settings.Lang;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The PlayerUtil class provides utility methods related to Player entities in a game.
 * This class is final and cannot be subclassed.
 */
public final class PlayerUtil {

	/**
	 * Retrieves information about a target player and formats it into a list of strings.
	 * The information includes the player's ping, health, food level, game mode, and world name.
	 *
	 * @param target The target player whose information is to be retrieved.
	 * @return A list of strings containing the formatted information about the target player.
	 */
	public static List<String> getTargetInfo(Player target) {
		return Lang.ofList("Menu.Target_Info")
				.stream()
				.map(line -> line
						.replace("{target_ping}", org.mineacademy.fo.PlayerUtil.getPing(target) + "")
						.replace("{target_health}", Remain.getHealth(target) + "")
						.replace("{target_food}", target.getFoodLevel() + "")
						.replace("{target_gamemode}", target.getGameMode().name())
						.replace("{target_world}", target.getWorld().getName()))
				.collect(Collectors.toList());
	}
}
