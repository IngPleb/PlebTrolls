package com.staxzs.staxzstrolls.util;

import org.bukkit.entity.Player;
import org.mineacademy.fo.remain.Remain;
import org.mineacademy.fo.settings.Lang;

import java.util.List;

public final class PlayerUtil {
	public static List<String> getTargetInfo(Player target) {
		return Lang.ofList("Menu.Target_Info")
				.stream()
				.map(line -> line
						.replace("{target_ping}", org.mineacademy.fo.PlayerUtil.getPing(target) + "")
						.replace("{target_health}", Remain.getHealth(target) + "")
						.replace("{target_food}", target.getFoodLevel() + "")
						.replace("{target_gamemode}", target.getGameMode().name())
						.replace("{target_world}", target.getWorld().getName()))
				.toList();
	}
}
