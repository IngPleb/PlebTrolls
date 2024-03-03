package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;

public final class LightingStrikeTroll extends Troll {

	@Getter
	private static final LightingStrikeTroll INSTANCE = new LightingStrikeTroll();

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
