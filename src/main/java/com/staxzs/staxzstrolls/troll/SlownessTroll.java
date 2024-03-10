package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public final class SlownessTroll extends ToggleableTroll {
	private final Set<UUID> slowedPlayer = new HashSet<>();

	public SlownessTroll() {
		super("SLOWNESS", Permissions.Troll.SLOWNESS, Settings.TrollSection.IconsSection.SLOWNESS);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();

		if (this.isToggled(target)) {
			this.slowedPlayer.remove(targetUUID);
			target.removePotionEffect(PotionEffectType.SLOW);
		} else {
			this.slowedPlayer.add(targetUUID);
			target.addPotionEffect(PotionEffectType.SLOW.createEffect(1000000, Settings.TrollSection.SLOWNESS_AMPLIFIER));
		}

		return null;
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		boolean result = this.slowedPlayer.remove(player.getUniqueId());
		if (result)
			player.removePotionEffect(PotionEffectType.SLOW);
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.slowedPlayer.contains(forPlayer.getUniqueId());
	}
}