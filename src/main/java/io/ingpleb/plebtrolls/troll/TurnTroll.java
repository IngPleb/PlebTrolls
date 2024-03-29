package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class TurnTroll extends Troll {

	public TurnTroll() {
		super("TURN_PLAYER", Permissions.Troll.TURN_PLAYER, Settings.TrollSection.IconsSection.TURN_PLAYER);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Location targetLocation = target.getLocation();
		targetLocation.setYaw(targetLocation.getYaw() + 180);
		target.teleport(targetLocation);

		return null;
	}
}
