package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.model.Tuple;

public final class DropInventoryTroll extends Troll {

	public DropInventoryTroll() {
		super("DROP_INVENTORY", Permissions.Troll.DROP_INVENTORY, Settings.TrollSection.IconsSection.DROP_INVENTORY);
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		ItemStack[] items = target.getInventory().getContents();
		target.getInventory().clear();

		for (ItemStack item : items) {
			if (item != null) {
				target.getWorld().dropItemNaturally(target.getLocation(), item);
			}
		}

		return null;
	}
}
