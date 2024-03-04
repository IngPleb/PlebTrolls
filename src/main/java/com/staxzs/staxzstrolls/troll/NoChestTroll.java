package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public final class NoChestTroll extends ToggleableTroll {

	private final Set<UUID> noChestPlayers = new HashSet<>();

	public NoChestTroll() {
		super("NO_CHEST", Permissions.Troll.NO_CHEST, Settings.TrollSection.IconsSection.NO_CHEST);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();
		boolean added = this.noChestPlayers.add(targetUUID);

		if (!added)
			this.noChestPlayers.remove(targetUUID);

		return null;
	}

	@Override
	public void onInventoryOpen(InventoryOpenEvent event) {
		Inventory inventory = event.getInventory();
		Player player = (Player) event.getPlayer();

		if (this.isSomeChest(inventory, player)) {
			UUID playerUUID = player.getUniqueId();

			if (this.noChestPlayers.contains(playerUUID))
				event.setCancelled(true);
		}
	}

	private boolean isSomeChest(Inventory inventory, Player player) {
		InventoryHolder holder = inventory.getHolder();
		boolean isChest = holder instanceof Chest;
		boolean isDoubleChest = holder instanceof DoubleChest;
		boolean isEnderChest = inventory.equals(player.getEnderChest());

		return isChest || isDoubleChest || isEnderChest;
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		this.noChestPlayers.remove(event.getPlayer().getUniqueId());
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.noChestPlayers.contains(forPlayer.getUniqueId());
	}
}
