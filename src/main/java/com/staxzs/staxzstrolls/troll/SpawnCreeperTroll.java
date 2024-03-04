package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.mineacademy.fo.model.Tuple;

public final class SpawnCreeperTroll extends Troll {

	public SpawnCreeperTroll() {
		super("SPAWN_CREEPER", Permissions.Troll.SPAWN_CREEPER, Settings.TrollSection.IconsSection.SPAWN_CREEPER);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {

		// Get the player's location and direction
		Location targetLocation = target.getLocation();
		Vector direction = targetLocation.getDirection();

		// Calculate the location behind the player
		Location behindLocation = targetLocation.subtract(direction);

		// Spawn a creeper at the calculated location
		target.getWorld().spawnEntity(behindLocation, EntityType.CREEPER);

		return null;
	}
}
