package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
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
