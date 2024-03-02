package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class SlingshotTroll extends Troll {

	@Getter
	private static final SlingshotTroll INSTANCE = new SlingshotTroll();

	public SlingshotTroll() {
		super("SLINGSHOT_PLAYER", Permissions.Troll.SLINGSHOT_PLAYER, Settings.TrollSection.IconsSection.SLINGSHOT_PLAYER);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		target.setVelocity(target.getLocation().getDirection().multiply(7).setY(1.25D));

		return null;
	}
}
