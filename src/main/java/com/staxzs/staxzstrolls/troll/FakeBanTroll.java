package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.Tuple;

public final class FakeBanTroll extends Troll {

	public FakeBanTroll() {
		super("FAKE_BAN", Permissions.Troll.FAKE_BAN, Settings.TrollSection.IconsSection.FAKE_BAN);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		target.kickPlayer(Common.colorize(Settings.TrollSection.FAKE_BAN_MESSAGE));

		return null;
	}
}
