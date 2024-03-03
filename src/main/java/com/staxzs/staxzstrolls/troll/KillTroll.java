package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class KillTroll extends Troll {

	public KillTroll() {
		super("KILL_PLAYER", Permissions.Troll.KILL_PLAYER, Settings.TrollSection.IconsSection.KILL_PLAYER);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		target.setHealth(0D);

		return null;
	}
}
