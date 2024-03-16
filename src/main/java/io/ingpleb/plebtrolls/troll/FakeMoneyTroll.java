package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.settings.Lang;

public final class FakeMoneyTroll extends Troll {

	public FakeMoneyTroll() {
		super("FAKE_MONEY", Permissions.Troll.FAKE_MONEY, Settings.TrollSection.IconsSection.FAKE_MONEY);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Common.tellNoPrefix(target, Lang.of("Trolls.Fake_Money.Message"));

		return null;
	}
}
