package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class ExplodeBlockTroll extends Troll {

	private final Set<UUID> playersExplodingBlocks = new HashSet<>();

	public ExplodeBlockTroll() {
		super("EXPLODE_BLOCK", Permissions.Troll.EXPLODE_BLOCK, Settings.TrollSection.IconsSection.EXPLODE_BLOCK);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		this.playersExplodingBlocks.add(target.getUniqueId());
		return null;
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		this.playersExplodingBlocks.remove(event.getPlayer().getUniqueId());
	}

	@Override
	public void onBlockBreak(BlockBreakEvent event) {
		UUID playerUUID = event.getPlayer().getUniqueId();

		if (this.playersExplodingBlocks.contains(playerUUID)) {
			event.setCancelled(true);
			event.getBlock().getWorld().createExplosion(event.getBlock().getLocation(), 4);
			this.playersExplodingBlocks.remove(playerUUID);
		}
	}
}
