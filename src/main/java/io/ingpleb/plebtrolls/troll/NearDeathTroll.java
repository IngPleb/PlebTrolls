package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class NearDeathTroll extends Troll {

	public NearDeathTroll() {
		super("NEAR_DEATH", Permissions.Troll.NEAR_DEATH, Settings.TrollSection.IconsSection.NEAR_DEATH);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		target.setHealth(1D);

		return null;
	}
}
