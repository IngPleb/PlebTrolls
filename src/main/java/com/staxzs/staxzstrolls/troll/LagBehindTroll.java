package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.StaxzsTrolls;
import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.mineacademy.fo.model.Tuple;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public final class LagBehindTroll extends ToggleableTroll {

	private final Map<UUID, BukkitRunnable> lagBehindTasks = new HashMap<>();

	public LagBehindTroll() {
		super("LAG_BEHIND", Permissions.Troll.LAG_BEHIND, Settings.TrollSection.IconsSection.LAG_BEHIND);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();

		if (this.lagBehindTasks.containsKey(targetUUID)) {
			this.lagBehindTasks.get(targetUUID).cancel();
			this.lagBehindTasks.remove(targetUUID);
		} else {
			BukkitRunnable task = new BukkitRunnable() {

				private int counter = 0;
				private Location lastLocation;

				@Override
				public void run() {
					this.counter++;

					if (this.counter < 2)
						return;

					if (this.lastLocation == null) {
						this.lastLocation = target.getLocation().clone();
						return;
					}

					target.teleport(this.lastLocation);
					this.lastLocation = null;
					this.counter = 0;
				}
			};

			task.runTaskTimer(StaxzsTrolls.getInstance(), 0, 15);
			this.lagBehindTasks.put(targetUUID, task);
		}

		return null;
	}

	@Override
	public void onDeregister() {
		for (BukkitRunnable task : this.lagBehindTasks.values())
			task.cancel();

		this.lagBehindTasks.clear();
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		UUID playerUUID = event.getPlayer().getUniqueId();

		if (this.lagBehindTasks.containsKey(playerUUID)) {
			this.lagBehindTasks.get(playerUUID).cancel();
			this.lagBehindTasks.remove(playerUUID);
		}

	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.lagBehindTasks.containsKey(forPlayer.getUniqueId());
	}
}
