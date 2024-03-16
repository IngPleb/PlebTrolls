package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import io.ingpleb.plebtrolls.util.FreezePlayerUtil;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public final class FreezeTroll extends ToggleableTroll {

	private final Set<UUID> frozenPlayers = new HashSet<>();

	public FreezeTroll() {
		super("FREEZE_PLAYER", Permissions.Troll.FREEZE_PLAYER, Settings.TrollSection.IconsSection.FREEZE_PLAYER);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();

		if (this.isToggled(target)) {
			this.frozenPlayers.remove(targetUUID);
			FreezePlayerUtil.getINSTANCE().freezePlayerInPlace(targetUUID, false);
		} else {
			this.frozenPlayers.add(targetUUID);
			FreezePlayerUtil.getINSTANCE().freezePlayerInPlace(targetUUID, true);
		}

		return null;
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		this.frozenPlayers.remove(player.getUniqueId());
		FreezePlayerUtil.getINSTANCE().freezePlayerInPlace(player.getUniqueId(), false);
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.frozenPlayers.contains(forPlayer.getUniqueId());
	}
}
