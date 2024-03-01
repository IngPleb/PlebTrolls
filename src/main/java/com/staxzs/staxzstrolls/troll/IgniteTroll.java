package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;

public final class IgniteTroll extends Troll {

	@Getter
	private static final IgniteTroll INSTANCE = new IgniteTroll();

	public IgniteTroll() {
		super("LAUNCH_PLAYER", Lang.of("Trolls.Ignite.Display_Name"),
				Lang.of("Trolls.Ignite.Description"),
				Permissions.Troll.IGNITE,
				CompMaterial.fromString(Settings.TrollSection.IconsSection.IGNITE_PLAYER));
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		target.setFireTicks(Settings.TrollSection.IGNITE_DURATION);
		return null;
	}
}
