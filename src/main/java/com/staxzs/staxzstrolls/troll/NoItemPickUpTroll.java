package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public final class NoItemPickUpTroll extends ToggleableTroll {

	private final Set<UUID> noItemPickupPlayers = new HashSet<>();

	public NoItemPickUpTroll() {
		super("NO_ITEM_PICKUP", Permissions.Troll.NO_ITEM_PICKUP, Settings.TrollSection.IconsSection.NO_ITEM_PICKUP);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();
		boolean added = this.noItemPickupPlayers.add(targetUUID);

		if (!added)
			this.noItemPickupPlayers.remove(targetUUID);

		return null;
	}


	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		this.noItemPickupPlayers.remove(event.getPlayer().getUniqueId());
	}

	@Override
	public void onEntityPickupItem(EntityPickupItemEvent event) {
		Entity entity = event.getEntity();

		if (!(entity instanceof Player))
			return;
		Player player = (Player) entity;

		if (this.isToggled(player))
			event.setCancelled(true);
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.noItemPickupPlayers.contains(forPlayer.getUniqueId());
	}
}
