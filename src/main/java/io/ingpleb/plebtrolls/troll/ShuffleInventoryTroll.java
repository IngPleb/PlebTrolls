package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.model.Tuple;

public final class ShuffleInventoryTroll extends Troll {

	public ShuffleInventoryTroll() {
		super("SHUFFLE_INVENTORY", Permissions.Troll.SHUFFLE_INVENTORY, Settings.TrollSection.IconsSection.SHUFFLE_INVENTORY);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Inventory inventory = target.getInventory();
		ItemStack[] originalContents = inventory.getContents();
		ItemStack[] newContents = new ItemStack[originalContents.length];

		for (ItemStack item : originalContents) {
			if (item != null) {
				int newIndex = (int) (Math.random() * newContents.length);
				while (newContents[newIndex] != null) {
					newIndex = (newIndex + 1) % newContents.length;
				}
				newContents[newIndex] = item;
			}
		}

		inventory.setContents(newContents);

		return null;
	}
}
