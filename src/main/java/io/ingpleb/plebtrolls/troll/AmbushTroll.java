package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;

public final class AmbushTroll extends Troll {

	public AmbushTroll() {
		super("AMBUSH_PLAYER", Lang.of("Trolls.Ambush_Player.Display_Name"),
				Lang.of("Trolls.Ambush_Player.Description"),
				Permissions.Troll.AMBUSH_PLAYER,
				CompMaterial.fromString(Settings.TrollSection.IconsSection.AMBUSH_PLAYER));
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		World targetWorld = target.getWorld();
		Location targetLocation = target.getLocation();

		EntityType entityType = Settings.TrollSection.AMBUSH_ENTITY_TYPE;
		Integer entityAmount = Settings.TrollSection.AMBUSH_ENTITY_AMOUNT;

		for (int i = 0; i < entityAmount; i++) {
			targetWorld.spawnEntity(targetLocation, entityType);
		}

		return null;
	}
}
