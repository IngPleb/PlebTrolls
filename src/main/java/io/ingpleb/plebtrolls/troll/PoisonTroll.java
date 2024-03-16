package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
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
