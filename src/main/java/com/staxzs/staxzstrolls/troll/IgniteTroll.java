package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;

public final class IgniteTroll extends Troll {

	public IgniteTroll() {
		super("IGNITE_PLAYER", Lang.of("Trolls.Ignite_Player.Display_Name"),
				Lang.of("Trolls.Ignite_Player.Description"),
				Permissions.Troll.IGNITE_PLAYER,
				CompMaterial.fromString(Settings.TrollSection.IconsSection.IGNITE_PLAYER));
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		target.setFireTicks(Settings.TrollSection.IGNITE_DURATION);
		return null;
	}
}
