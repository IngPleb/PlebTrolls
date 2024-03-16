package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;

public final class SwapTroll extends Troll {

	public SwapTroll() {
		super("SWAP", Permissions.Troll.SWAP, Settings.TrollSection.IconsSection.SWAP);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		if (!(sender instanceof Player))
			return new Tuple<>(false, "Only players can use this troll.");
		Player senderPlayer = (Player) sender;

		Location senderLocation = senderPlayer.getLocation();
		Location targetLocation = target.getLocation();

		senderPlayer.teleport(targetLocation);
		target.teleport(senderLocation);

		return null;
	}
}
