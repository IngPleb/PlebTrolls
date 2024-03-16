package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompMaterial;

public final class DipInWaterTroll extends Troll {


	public DipInWaterTroll() {
		super("DIP_IN_WATER", Permissions.Troll.DIP_IN_WATER, Settings.TrollSection.IconsSection.DIP_IN_WATER);
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Location targetLocation = target.getLocation();

		Location lavaLocation = targetLocation.clone().subtract(0, 1, 0);
		lavaLocation.getBlock().setType(CompMaterial.WATER.getMaterial());

		target.teleport(lavaLocation);

		return null;
	}
}
