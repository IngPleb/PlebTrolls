package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
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

	private static final Material pumpkinMaterial = Material.CARVED_PUMPKIN;
	private static final int HELMET_SLOT = 39;
	private final Set<UUID> playersWithPumpkin = new HashSet<>();

	public PumpkinTroll() {
		super("PUMPKIN", Permissions.Troll.PUMPKIN, Settings.TrollSection.IconsSection.PUMPKIN);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();
		boolean added = this.playersWithPumpkin.add(targetUUID); // Simplify logic if possible

		if (added) {
			this.putPumpkinOnHead(target);
		} else {
			this.playersWithPumpkin.remove(targetUUID);
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
	public void onDeregister() {
		for (UUID playerUUID : this.playersWithPumpkin) {
			Player player = Bukkit.getPlayer(playerUUID);

			if (player != null)
				this.removePumpkinFromHead(player);
		}
	}

	@Override
	public void onInventoryClick(InventoryClickEvent event) {
		if (!(event.getWhoClicked() instanceof Player))
			return;

		Player player = (Player) event.getWhoClicked();

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
	public void onPlayerQuit(PlayerQuitEvent event) {
		this.playersWithPumpkin.remove(event.getPlayer().getUniqueId());
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.playersWithPumpkin.contains(forPlayer.getUniqueId());
	}
}
