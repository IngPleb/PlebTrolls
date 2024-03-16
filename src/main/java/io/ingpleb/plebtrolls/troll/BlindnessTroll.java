package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class BlindnessTroll extends ToggleableTroll {

	private final Set<UUID> blindedPlayers = new HashSet<>();

	public BlindnessTroll() {
		super("BLINDNESS", Permissions.Troll.BLINDNESS, Settings.TrollSection.IconsSection.BLINDNESS);
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		boolean added = this.blindedPlayers.add(target.getUniqueId());

		if (added) {
			target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1));
		} else {
			this.blindedPlayers.remove(target.getUniqueId());
			target.removePotionEffect(PotionEffectType.BLINDNESS);
		}

		return null;
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		player.removePotionEffect(PotionEffectType.BLINDNESS);

		this.blindedPlayers.remove(player.getUniqueId());
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.blindedPlayers.contains(forPlayer.getUniqueId());
	}
}
