package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.CompSound;
import org.mineacademy.fo.settings.Lang;

public final class CreeperHissTroll extends Troll {

	public CreeperHissTroll() {
		super("CREEPER_HISS", Lang.of("Trolls.Creeper_Hiss.Display_Name"), Lang.of("Trolls.Creeper_Hiss.Description"), Permissions.Troll.CREEPER_HISS, CompMaterial.CREEPER_HEAD);
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		CompSound.CREEPER_HISS.play(target);
		return null;
	}
}
