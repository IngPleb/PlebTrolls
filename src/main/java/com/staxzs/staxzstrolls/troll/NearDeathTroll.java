package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class NearDeathTroll extends Troll {

	public NearDeathTroll() {
		super("NEAR_DEATH", Permissions.Troll.NEAR_DEATH, Settings.TrollSection.IconsSection.NEAR_DEATH);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		target.setHealth(1D);
		
		return null;
	}
}
