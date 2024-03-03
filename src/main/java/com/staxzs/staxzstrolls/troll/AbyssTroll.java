package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class AbyssTroll extends Troll {

	public AbyssTroll() {
		super("ABYSS", Permissions.Troll.ABYSS, Settings.TrollSection.IconsSection.ABYSS);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Location location = target.getLocation();
		location.setY(-1000);
		target.teleport(location);

		return null;
	}
}
