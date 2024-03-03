package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class FakeCrashTroll extends Troll {

	public FakeCrashTroll() {
		super("FAKE_CRASH", Permissions.Troll.FAKE_CRASH, Settings.TrollSection.IconsSection.FAKE_CRASH);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		target.kickPlayer("Internal Exception: java.io.IOException: An existing connection was forcibly closed by the remote host");

		return null;
	}
}
