package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.PlayerCache;
import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public final class DisableGravityTroll extends ToggleableTroll {

	private final Set<UUID> disabledGravityPlayers = new HashSet<>();

	public DisableGravityTroll() {
		super("DISABLE_GRAVITY", Permissions.Troll.DISABLE_GRAVITY, Settings.TrollSection.IconsSection.DISABLE_GRAVITY);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();
		boolean added = this.disabledGravityPlayers.add(targetUUID);

		if (!added) {
			this.disabledGravityPlayers.remove(targetUUID);
			target.setGravity(true);
		} else
			target.setGravity(false);

		return null;
	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		PlayerCache cache = PlayerCache.from(player);

		if (cache.isEnableGravityOnJoin()) {
			player.setGravity(true);
			player.setFlying(false);
			cache.setEnableGravityOnJoin(false);
		}
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		PlayerCache cache = PlayerCache.from(player);

		if (this.isToggled(player)) {
			cache.setEnableGravityOnJoin(true);
			this.disabledGravityPlayers.remove(player.getUniqueId());
		}
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.disabledGravityPlayers.contains(forPlayer.getUniqueId());
	}
}
