package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;

public final class LaunchTroll extends Troll {

	public LaunchTroll() {
		super("LAUNCH_PLAYER", Lang.of("Trolls.Launch_Player.Display_Name"),
				Lang.of("Trolls.Launch_Player.Description"),
				Permissions.Troll.LAUNCH,
				CompMaterial.fromString(Settings.TrollSection.IconsSection.LAUNCH_PLAYER));
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		target.setVelocity(target.getVelocity().setY(2));
		return null;
	}
}
