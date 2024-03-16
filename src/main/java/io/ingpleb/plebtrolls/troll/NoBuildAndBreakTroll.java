package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public final class NoBuildAndBreakTroll extends ToggleableTroll {

	private final Set<UUID> noBuildBreakPlayers = new HashSet<>();

	public NoBuildAndBreakTroll() {
		super("NO_BUILD_AND_BREAK", Permissions.Troll.NO_BUILD_AND_BREAK, Settings.TrollSection.IconsSection.NO_BUILD_AND_BREAK);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();
		boolean added = this.noBuildBreakPlayers.add(targetUUID);

		if (!added)
			this.noBuildBreakPlayers.remove(targetUUID);

		return null;
	}

	@Override
	public void onBlockBreak(BlockBreakEvent event) {
		if (this.noBuildBreakPlayers.contains(event.getPlayer().getUniqueId()))
			event.setCancelled(true);
	}

	@Override
	public void onBlockPlace(BlockPlaceEvent event) {
		if (this.noBuildBreakPlayers.contains(event.getPlayer().getUniqueId()))
			event.setCancelled(true);
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		this.noBuildBreakPlayers.remove(event.getPlayer().getUniqueId());
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.noBuildBreakPlayers.contains(forPlayer.getUniqueId());
	}
}
