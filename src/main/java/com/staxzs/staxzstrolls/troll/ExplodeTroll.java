package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;

public final class ExplodeTroll extends Troll {

	public ExplodeTroll() {
		super("EXPLODE_PLAYER", Lang.of("Trolls.Explode_Player.Display_Name"),
				Lang.of("Trolls.Explode_Player.Description"),
				Permissions.Troll.EXPLODE_PLAYER,
				CompMaterial.fromString(Settings.TrollSection.IconsSection.EXPLODE_PLAYER));
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		target.getWorld().createExplosion(target.getLocation(), (float) Settings.TrollSection.EXPLODE_POWER);
		return null;
	}
}
