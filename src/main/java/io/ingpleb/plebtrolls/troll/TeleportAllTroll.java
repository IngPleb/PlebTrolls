package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.Remain;

public final class TeleportAllTroll extends Troll {

	public TeleportAllTroll() {
		super("TELEPORT_ALL", Permissions.Troll.TELEPORT_ALL, Settings.TrollSection.IconsSection.TELEPORT_ALL);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		for (Player player : Remain.getOnlinePlayers()) {
			player.teleport(target);
		}

		return null;
	}
}
