package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.settings.Lang;

public final class DisarmTroll extends Troll {

	public DisarmTroll() {
		super("DISARM", Permissions.Troll.DISARM, Settings.TrollSection.IconsSection.DISARM);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		ItemStack itemInHand = target.getInventory().getItemInMainHand();

		if (itemInHand.getType() == Material.AIR)
			return new Tuple<>(false, Lang.of("Trolls.Disarm.Empty_Hand"));

		target.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
		Item item = target.getWorld().dropItem(target.getLocation(), itemInHand);

		item.setPickupDelay(60);
		item.setVelocity(target.getLocation().getDirection().multiply(0.5));

		return null;
	}
}
