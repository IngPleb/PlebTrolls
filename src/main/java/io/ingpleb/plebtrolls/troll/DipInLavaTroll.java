package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;

public final class DipInLavaTroll extends Troll {


	public DipInLavaTroll() {
		super("DIP_IN_LAVA", Lang.of("Trolls.Dip_In_Lava.Display_Name"),
				Lang.of("Trolls.Dip_In_Lava.Description"),
				Permissions.Troll.DIP_IN_LAVA,
				Settings.TrollSection.IconsSection.DIP_IN_LAVA);
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Location targetLocation = target.getLocation();

		Location lavaLocation = targetLocation.clone().subtract(0, 1, 0);
		lavaLocation.getBlock().setType(CompMaterial.LAVA.getMaterial());

		target.teleport(lavaLocation);

		return null;
	}
}
