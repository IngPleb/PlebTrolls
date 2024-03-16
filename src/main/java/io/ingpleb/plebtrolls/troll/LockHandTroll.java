package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public final class LockHandTroll extends ToggleableTroll {
	private final Set<UUID> lockHandPlayers = new HashSet<>();

	public LockHandTroll() {
		super("LOCK_HAND", Permissions.Troll.LOCK_HAND, Settings.TrollSection.IconsSection.LOCK_HAND);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();

		if (this.isToggled(target)) {
			this.lockHandPlayers.remove(targetUUID);
		} else {
			this.lockHandPlayers.add(targetUUID);
		}

		return null;
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		UUID playerUUID = event.getPlayer().getUniqueId();
		this.lockHandPlayers.remove(playerUUID);
	}

	@Override
	public void onPlayerItemHeld(PlayerItemHeldEvent event) {
		Player player = event.getPlayer();

		if (this.isToggled(player)) {
			event.setCancelled(true);
		}
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.lockHandPlayers.contains(forPlayer.getUniqueId());
	}
}