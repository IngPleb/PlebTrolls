package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class ClearInventoryTroll extends Troll {


	public ClearInventoryTroll() {
		super("CLEAR_INVENTORY", Permissions.Troll.CLEAR_INVENTORY, Settings.TrollSection.IconsSection.CLEAR_INVENTORY);
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		target.getInventory().clear();

		return null;
	}
}
