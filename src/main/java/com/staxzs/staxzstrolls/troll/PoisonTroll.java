package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.mineacademy.fo.model.Tuple;

public final class PoisonTroll extends Troll {

	public PoisonTroll() {
		super("POISON", Permissions.Troll.POISON, Settings.TrollSection.IconsSection.POISON);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		PotionEffect poison = new PotionEffect(PotionEffectType.POISON, Settings.TrollSection.POISON_DURATION, Settings.TrollSection.POISON_AMPLIFIER);

		target.addPotionEffect(poison);

		return null;
	}
}
