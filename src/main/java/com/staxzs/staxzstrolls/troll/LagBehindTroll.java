package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.StaxzsTrolls;
import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.mineacademy.fo.model.Tuple;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public final class LagBehindTroll extends ToggleableTroll {

	private static final Map<UUID, BukkitRunnable> lagBehindTasks = new HashMap<>();

	public LagBehindTroll() {
		super("LAG_BEHIND", Permissions.Troll.LAG_BEHIND, Settings.TrollSection.IconsSection.LAG_BEHIND);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();

		if (lagBehindTasks.containsKey(targetUUID)) {
			lagBehindTasks.get(targetUUID).cancel();
			lagBehindTasks.remove(targetUUID);
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
			lagBehindTasks.put(targetUUID, task);
		}

		return null;
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return lagBehindTasks.containsKey(forPlayer.getUniqueId());
	}
}
