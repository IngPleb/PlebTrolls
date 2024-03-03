package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

import java.util.Objects;

public final class RandomTeleportTroll extends Troll {

	@Getter
	private static final RandomTeleportTroll INSTANCE = new RandomTeleportTroll();

	public RandomTeleportTroll() {
		super("RANDOM_TELEPORT", Permissions.Troll.RANDOM_TELEPORT, Settings.TrollSection.IconsSection.RANDOM_TELEPORT);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		int radius = Settings.TrollSection.RANDOM_TELEPORT_RADIUS;

		Location randomlocation = this.getRandomLocation(target.getLocation(), radius);

		target.teleport(randomlocation);

		return null;
	}

	private Location getRandomLocation(@NonNull Location location, int radius) {
		double x0 = location.getX();
		double z0 = location.getZ();

		double x = x0 + (Math.random() - 0.5) * radius;
		double z = z0 + (Math.random() - 0.5) * radius;

		Location randomLocation = new Location(location.getWorld(), x, Objects.requireNonNull(location.getWorld()).getHighestBlockYAt((int) x, (int) z), z);
		// bring the player up from the ground
		randomLocation.add(0, 1, 0);
		randomLocation.setPitch(location.getPitch());
		randomLocation.setYaw(location.getYaw());

		return randomLocation;
	}
}
