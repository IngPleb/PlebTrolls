package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class ClearArmourTroll extends Troll {

	public ClearArmourTroll() {
		super("CLEAR_ARMOUR", Permissions.Troll.CLEAR_ARMOUR, Settings.TrollSection.IconsSection.CLEAR_ARMOUR);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		target.getInventory().setArmorContents(null);
		return null;
	}
}
