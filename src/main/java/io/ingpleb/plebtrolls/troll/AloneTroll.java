package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.PlebTrolls;
import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.Remain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public final class AloneTroll extends ToggleableTroll {

	private final Set<UUID> alonePlayers = new HashSet<>();

	public AloneTroll() {
		super("ALONE", Permissions.Troll.ALONE, Settings.TrollSection.IconsSection.ALONE);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();
		boolean added = this.alonePlayers.add(targetUUID);

		if (added) {
			this.makePlayerAlone(target, true);
		} else {
			this.alonePlayers.remove(targetUUID);
			this.makePlayerAlone(target, false);
		}

		return null;
	}

	private void makePlayerAlone(Player target, boolean alone) {
		UUID targetUUID = target.getUniqueId();

		for (Player player : Remain.getOnlinePlayers()) {
			if (!player.getUniqueId().equals(targetUUID)) {
				if (alone)
					player.hidePlayer(PlebTrolls.getInstance(), target);
				else
					player.showPlayer(PlebTrolls.getInstance(), target);
			}
		}
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		this.makePlayerAlone(player, false);
		this.alonePlayers.remove(player.getUniqueId());
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.alonePlayers.contains(forPlayer.getUniqueId());
	}
}
