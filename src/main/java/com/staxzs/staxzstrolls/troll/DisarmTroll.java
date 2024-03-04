package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.model.Tuple;

public final class DisarmTroll extends Troll {

	public DisarmTroll() {
		super("DISARM", Permissions.Troll.DISARM, Settings.TrollSection.IconsSection.DISARM);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		ItemStack itemInHand = target.getInventory().getItemInMainHand();

		if (itemInHand.getType() == Material.AIR)
			return new Tuple<>(false, "The player is not holding anything.");

		target.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
		Item item = target.getWorld().dropItem(target.getLocation(), itemInHand);

		item.setPickupDelay(60);
		item.setVelocity(target.getLocation().getDirection().multiply(0.5));

		return null;
	}
}
