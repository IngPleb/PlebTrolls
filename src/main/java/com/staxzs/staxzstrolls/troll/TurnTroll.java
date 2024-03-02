package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class TurnTroll extends Troll {

	@Getter
	private static final TurnTroll INSTANCE = new TurnTroll();

	public TurnTroll() {
		super("TURN_PLAYER", Permissions.Troll.TURN_PLAYER, Settings.TrollSection.IconsSection.TURN_PLAYER);
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Location targetLocation = target.getLocation();
		targetLocation.setYaw(targetLocation.getYaw() + 180);
		target.teleport(targetLocation);

		return null;
	}
}
