package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class TeleportToSunTroll extends Troll {

	public TeleportToSunTroll() {
		super("TELEPORT_TO_SUN", Permissions.Troll.TELEPORT_TO_SUN, Settings.TrollSection.IconsSection.TELEPORT_TO_SUN);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		int maxBuildHeight = target.getWorld().getMaxHeight();

		Location highestBlock = target.getLocation().clone();
		highestBlock.setY(maxBuildHeight - 1);
		highestBlock.getBlock().setType(Material.GLASS);

		target.teleport(highestBlock.add(0, 1, 0));

		return null;
	}
}
