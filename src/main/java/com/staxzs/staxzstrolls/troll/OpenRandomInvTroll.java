package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
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
			case 0 -> target.openWorkbench(null, true);
			case 1 -> target.openEnchanting(null, true);
			case 2 -> target.openInventory(target.getEnderChest());
			case 3 -> target.openInventory(target.getInventory());
		}

		return null;
	}

}
