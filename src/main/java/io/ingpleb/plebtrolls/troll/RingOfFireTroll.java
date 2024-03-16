package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class RingOfFireTroll extends Troll {

	public RingOfFireTroll() {
		super("RING_OF_FIRE", Permissions.Troll.RING_OF_FIRE, Settings.TrollSection.IconsSection.RING_OF_FIRE);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Location center = target.getLocation();

		for (int i = 0; i < 360; i += 5) { // Adjust the step for more/less blocks
			double angle = i * Math.PI / 180;
			int x = (int) (center.getX() + 3 * Math.cos(angle));
			int z = (int) (center.getZ() + 3 * Math.sin(angle));
			Location loc = new Location(center.getWorld(), x, center.getY(), z);
			Block block = loc.getBlock();
			block.setType(Material.FIRE);
		}

		return null;
	}
}
