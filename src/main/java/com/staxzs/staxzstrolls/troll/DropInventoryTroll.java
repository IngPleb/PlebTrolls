package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.model.Tuple;

public final class DropInventoryTroll extends Troll {

	@Getter
	private static final DropInventoryTroll INSTANCE = new DropInventoryTroll();

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
