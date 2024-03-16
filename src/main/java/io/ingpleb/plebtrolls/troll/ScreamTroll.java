package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompSound;

import java.util.Objects;

public final class ScreamTroll extends Troll {

	public ScreamTroll() {
		super("SCREAM", Permissions.Troll.SCREAM, Settings.TrollSection.IconsSection.SCREAM);
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		CompSound compSound = CompSound.fromName(Settings.TrollSection.SCREAM_SOUND);

		Objects.requireNonNull(compSound, "Sound " + Settings.TrollSection.SCREAM_SOUND + " not found");

		compSound.play(target, Settings.TrollSection.SCREAM_VOLUME, 0);
		return null;
	}
}
