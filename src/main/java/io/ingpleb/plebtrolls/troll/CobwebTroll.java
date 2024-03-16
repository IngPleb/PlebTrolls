package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.region.Region;

public final class CobwebTroll extends Troll {

	public CobwebTroll() {
		super("COBWEB", Permissions.Troll.COBWEB, Settings.TrollSection.IconsSection.COBWEB);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Location targetLocation = target.getLocation();
		Region region = new Region(targetLocation.clone().add(-1, -1, -1), targetLocation.clone().add(1, 1, 1));
		region.getBlocks().forEach(block -> {
			if (block.getType() == Material.AIR)
				block.setType(Material.COBWEB);
		});

		return null;
	}
}
