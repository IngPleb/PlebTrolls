package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.mineacademy.fo.PlayerUtil;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public final class PumpkinTroll extends ToggleableTroll {

	private static final Set<UUID> playersWithPumpkin = new HashSet<>();

	private static final Material pumpkinMaterial = Material.CARVED_PUMPKIN;

	private static final int HELMET_SLOT = 39;

	public PumpkinTroll() {
		super("PUMPKIN", Permissions.Troll.PUMPKIN, Settings.TrollSection.IconsSection.PUMPKIN);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();
		boolean added = playersWithPumpkin.add(targetUUID); // Simplify logic if possible

		if (added) {
			this.putPumpkinOnHead(target);
		} else {
			playersWithPumpkin.remove(targetUUID);
			this.removePumpkinFromHead(target);
		}

		return null;
	}

	private void putHelmetIntoInventory(Player player) {
		PlayerInventory playerInventory = player.getInventory();
		ItemStack helmet = playerInventory.getHelmet();

		PlayerUtil.addItems(playerInventory, helmet);
		playerInventory.setHelmet(null);
	}

	private void putPumpkinOnHead(Player player) {
		PlayerInventory playerInventory = player.getInventory();
		ItemStack pumpkin = new ItemStack(pumpkinMaterial);

		this.putHelmetIntoInventory(player);
		playerInventory.setHelmet(pumpkin);
	}

	private void removePumpkinFromHead(Player player) {
		PlayerInventory playerInventory = player.getInventory();
		ItemStack helmet = playerInventory.getHelmet();

		if (helmet != null && helmet.getType() == pumpkinMaterial) {
			playerInventory.setHelmet(null);
		}
	}

	@Override
	public void onInventoryClick(InventoryClickEvent event) {
		if (!(event.getWhoClicked() instanceof Player player))
			return;

		if (event.getSlot() != HELMET_SLOT)
			return;

		if (event.getInventory() instanceof PlayerInventory)
			return;

		if (this.isToggled(player))
			event.setResult(Event.Result.DENY);
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();

		if (this.isToggled(player))
			this.putPumpkinOnHead(player);
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return playersWithPumpkin.contains(forPlayer.getUniqueId());
	}
}
