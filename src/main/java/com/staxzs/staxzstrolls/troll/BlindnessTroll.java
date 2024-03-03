package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class BlindnessTroll extends Troll {

	public BlindnessTroll() {
		super("BLINDNESS", Permissions.Troll.BLINDNESS, Settings.TrollSection.IconsSection.BLINDNESS);
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		int duration = Settings.TrollSection.BLINDNESS_DURATION;
		target.addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.BLINDNESS, duration, 5));

		return null;
	}
}
