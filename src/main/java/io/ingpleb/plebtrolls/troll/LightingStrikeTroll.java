package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;

public final class LightingStrikeTroll extends Troll {

	public LightingStrikeTroll() {
		super("LIGHTNING_STRIKE", Lang.of("Trolls.Lightning_Strike.Display_Name"),
				Lang.of("Trolls.Lightning_Strike.Description"),
				Permissions.Troll.LIGHTNING_STRIKE,
				CompMaterial.fromString(Settings.TrollSection.IconsSection.LIGHTNING_STRIKE));
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		target.getWorld().strikeLightning(target.getLocation());
		return null;
	}
}
