package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.util.Vector;
import org.mineacademy.fo.model.Tuple;

import java.util.Objects;

public final class HoundAttackTroll extends Troll {

	public HoundAttackTroll() {
		super("HOUND_ATTACK", Permissions.Troll.HOUND_ATTACK, Settings.TrollSection.IconsSection.HOUND_ATTACK);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Location targetLocation = target.getLocation();
		Vector targetDirection = targetLocation.getDirection();

		Location spawnLocation = targetLocation.subtract(targetDirection.multiply(1));
		Objects.requireNonNull(spawnLocation.getWorld(), "World cannot be null");

		for (int i = 0; i < Settings.TrollSection.HOUND_ATTACK_AMOUNT; i++) {
			Wolf wolf = (Wolf) spawnLocation.getWorld().spawnEntity(spawnLocation, EntityType.WOLF);

			wolf.setTarget(target);
		}

		return null;
	}

}
