package com.staxzs.staxzstrolls.util;

import com.staxzs.staxzstrolls.StaxzsTrolls;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FreezePlayerUtil {

	@Getter
	private static final FreezePlayerUtil INSTANCE = new FreezePlayerUtil();

	public final Map<UUID, Location> frozenPlayers = new HashMap<>();
	private BukkitRunnable freezeTask;

	public void freezePlayerInPlace(UUID playerUUID, boolean freeze) {
		if (freeze) {
			Player player = Bukkit.getPlayer(playerUUID);
			Objects.requireNonNull(player, "Player with UUID " + playerUUID + " not found.");
			this.frozenPlayers.put(playerUUID, player.getLocation());
		} else {
			this.frozenPlayers.remove(playerUUID);
		}
	}

	public void start() {
		this.freezeTask = new BukkitRunnable() {
			@Override
			public void run() {
				for (Map.Entry<UUID, Location> entry : FreezePlayerUtil.this.frozenPlayers.entrySet()) {
					Player player = Bukkit.getPlayer(entry.getKey());
					if (player != null)
						player.teleport(entry.getValue());
				}
			}
		};
		this.freezeTask.runTaskTimer(StaxzsTrolls.getInstance(), 0, 2);
	}

	public void stop() {
		this.freezeTask.cancel();
		this.frozenPlayers.clear();
		this.freezeTask = null;
	}
}
