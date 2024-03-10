package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.mineacademy.fo.model.Tuple;

public final class TNTTrapTroll extends Troll {

	public TNTTrapTroll() {
		super("TNT_TRAP", Permissions.Troll.TNT_TRAP, Settings.TrollSection.IconsSection.TNT_TRAP);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Location targetLocation = target.getLocation();

		// Get the block behind the player
		Vector direction = targetLocation.getDirection().normalize();
		direction.multiply(-1); // Reverse the direction

		Location behindLocation = targetLocation.add(direction);
		Location pressurePlateLocation = behindLocation.clone(); // One block below the player
		Location tntLocation = pressurePlateLocation.clone().add(0, -1, 0); // One block below the pressure plate

		pressurePlateLocation.getBlock().setType(org.bukkit.Material.STONE_PRESSURE_PLATE);
		tntLocation.getBlock().setType(org.bukkit.Material.TNT);

		return null;
	}
}
