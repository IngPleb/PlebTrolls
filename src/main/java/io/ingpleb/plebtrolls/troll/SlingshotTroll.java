package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class SlingshotTroll extends Troll {

	public SlingshotTroll() {
		super("SLINGSHOT_PLAYER", Permissions.Troll.SLINGSHOT_PLAYER, Settings.TrollSection.IconsSection.SLINGSHOT_PLAYER);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		target.setVelocity(target.getLocation().getDirection().multiply(7).setY(1.25D));

		return null;
	}
}
