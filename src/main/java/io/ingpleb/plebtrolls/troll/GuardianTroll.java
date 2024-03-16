package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompParticle;

public final class GuardianTroll extends Troll {

	public GuardianTroll() {
		super("GUARDIAN", Permissions.Troll.GUARDIAN, Settings.TrollSection.IconsSection.GUARDIAN);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		CompParticle.MOB_APPEARANCE.spawn(target, target.getLocation());

		return null;
	}
}
