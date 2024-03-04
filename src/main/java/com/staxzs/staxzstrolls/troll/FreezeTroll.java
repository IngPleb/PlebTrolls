package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.StaxzsTrolls;
import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.Bukkit;
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
public final class FreezeTroll extends ToggleableTroll {

	private final Map<UUID, Location> frozenPlayerLocations = new HashMap<>();

	private BukkitRunnable freezeTask;

	public FreezeTroll() {
		super("FREEZE_PLAYER", Permissions.Troll.FREEZE_PLAYER, Settings.TrollSection.IconsSection.FREEZE_PLAYER);
		this.startFreezeTask();
	}

	private void startFreezeTask() {
		this.freezeTask = new BukkitRunnable() {
			@Override
			public void run() {
				for (Map.Entry<UUID, Location> entry : FreezeTroll.this.frozenPlayerLocations.entrySet()) {
					Player player = Bukkit.getPlayer(entry.getKey());

					if (player != null)
						player.teleport(entry.getValue());
				}
			}
		};

		this.freezeTask.runTaskTimer(StaxzsTrolls.getInstance(), 0, 1);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();
		Location location = target.getLocation();

		if (this.frozenPlayerLocations.containsKey(targetUUID)) {
			target.teleport(this.frozenPlayerLocations.get(targetUUID));
			this.frozenPlayerLocations.remove(targetUUID);
		} else {
			this.frozenPlayerLocations.put(targetUUID, location);
		}

		return null;
	}

	@Override
	public void onDeregister() {
		this.freezeTask.cancel();
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		this.frozenPlayerLocations.remove(event.getPlayer().getUniqueId());
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.frozenPlayerLocations.containsKey(forPlayer.getUniqueId());
	}
}
