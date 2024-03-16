package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class OpenRandomInvTroll extends Troll {

	public OpenRandomInvTroll() {
		super("OPEN_RANDOM_INVENTORY", Permissions.Troll.OPEN_RANDOM_INVENTORY, Settings.TrollSection.IconsSection.OPEN_RANDOM_INVENTORY);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		int random = (int) (Math.random() * 4);

		switch (random) {
			case 0:
				target.openWorkbench(null, true);
				break;
			case 1:
				target.openEnchanting(null, true);
				break;
			case 2:
				target.openInventory(target.getEnderChest());
				break;
			case 3:
				target.openInventory(target.getInventory());
				break;
		}

		return null;
	}

}
