package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import com.staxzs.staxzstrolls.util.FreezePlayerUtil;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Getter
public final class PotatoTroll extends ToggleableTroll {
	private final Map<UUID, Item> potatoPlayerLocation = new HashMap<>();

	public PotatoTroll() {
		super("POTATO", Permissions.Troll.POTATO, Settings.TrollSection.IconsSection.POTATO);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();

		if (this.isToggled(target)) {
			this.removePotatoEffect(target, targetUUID);
		} else {
			this.applyPotatoEffect(target, targetUUID);
		}

		return null;
	}

	private void applyPotatoEffect(Player target, UUID targetUUID) {
		Location targetLocation = target.getLocation();
		Item droppedPotato = Objects.requireNonNull(targetLocation.getWorld()).dropItem(targetLocation, ItemCreator.of(CompMaterial.POTATO).make());
		droppedPotato.setPickupDelay(Integer.MAX_VALUE);
		this.potatoPlayerLocation.put(targetUUID, droppedPotato);
		FreezePlayerUtil.getINSTANCE().freezePlayerInPlace(targetUUID, true);
		target.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, false, false));
	}

	private void removePotatoEffect(Player target, UUID targetUUID) {
		Item droppedPotato = this.potatoPlayerLocation.get(targetUUID);
		if (droppedPotato != null) {
			droppedPotato.remove();
			this.potatoPlayerLocation.remove(targetUUID);
			FreezePlayerUtil.getINSTANCE().freezePlayerInPlace(targetUUID, false);
			target.removePotionEffect(PotionEffectType.INVISIBILITY);
		}
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		UUID playerUUID = event.getPlayer().getUniqueId();
		this.removePotatoEffect(event.getPlayer(), playerUUID);
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.potatoPlayerLocation.containsKey(forPlayer.getUniqueId());
	}
}