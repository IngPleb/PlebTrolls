package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class StampedeTroll extends Troll {

	public StampedeTroll() {
		super("STAMPEDE", Permissions.Troll.STAMPEDE, Settings.TrollSection.IconsSection.STAMPEDE);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Location targetLocation = target.getLocation();

		for (int i = 0; i < Settings.TrollSection.STAMPEDE_AMOUNT; i++) {
			target.getWorld().spawnEntity(targetLocation, EntityType.COW);
		}

		return null;
	}
}
