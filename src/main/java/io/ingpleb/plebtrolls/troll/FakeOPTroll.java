package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.Tuple;

public final class FakeOPTroll extends Troll {

	public FakeOPTroll() {
		super("FAKE_OP", Permissions.Troll.FAKE_OP, Settings.TrollSection.IconsSection.FAKE_OP);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Common.tellNoPrefix(target, "&fMade " + target.getName() + " &fa server operator");

		return null;
	}
}
