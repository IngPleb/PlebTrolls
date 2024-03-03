package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.CompSound;
import org.mineacademy.fo.settings.Lang;

public final class ScreamTroll extends Troll {

	public ScreamTroll() {
		super("SREAM_PLAYER", Lang.of("Trolls.Scream.Display_Name"),
				Lang.of("Trolls.Scream.Description"),
				Permissions.Troll.SCREAM_PLAYER,
				CompMaterial.fromString(Settings.TrollSection.IconsSection.SCREAM));
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		CompSound.fromName(Settings.TrollSection.SCREAM_SOUND).play(target, Settings.TrollSection.SCREAM_VOLUME, 0);
		return null;
	}
}
