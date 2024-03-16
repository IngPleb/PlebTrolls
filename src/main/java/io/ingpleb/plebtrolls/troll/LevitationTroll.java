package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public final class LevitationTroll extends ToggleableTroll {
	private final Set<UUID> levitatingPlayer = new HashSet<>();

	public LevitationTroll() {
		super("LEVITATION", Permissions.Troll.LEVITATION, Settings.TrollSection.IconsSection.LEVITATION);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();

		if (this.isToggled(target)) {
			this.levitatingPlayer.remove(targetUUID);
			target.removePotionEffect(PotionEffectType.LEVITATION);
		} else {
			this.levitatingPlayer.add(targetUUID);
			target.addPotionEffect(PotionEffectType.LEVITATION.createEffect(1000000, Settings.TrollSection.LEVITATION_AMPLIFIER));
		}

		return null;
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		boolean result = this.levitatingPlayer.remove(player.getUniqueId());
		if (result)
			player.removePotionEffect(PotionEffectType.LEVITATION);
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.levitatingPlayer.contains(forPlayer.getUniqueId());
	}
}