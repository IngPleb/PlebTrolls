package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.mineacademy.fo.model.Tuple;

import java.util.Objects;

public final class FireballTroll extends Troll {

	public FireballTroll() {
		super("FIREBALL", Permissions.Troll.FIREBALL, Settings.TrollSection.IconsSection.FIREBALL);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Location targetLocation = target.getLocation();
		Vector targetDirection = targetLocation.getDirection();

		// Subtract 3 blocks from the player's location in the direction they are facing
		Location spawnLocation = targetLocation.subtract(targetDirection.multiply(6));

		// Spawn the fireball at the new location
		Objects.requireNonNull(spawnLocation.getWorld()).spawn(spawnLocation, org.bukkit.entity.Fireball.class);


		return null;
	}
}
