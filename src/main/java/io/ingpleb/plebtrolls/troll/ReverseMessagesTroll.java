package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public final class ReverseMessagesTroll extends ToggleableTroll {

	private final Set<UUID> reverseMessagePlayers = new HashSet<>();

	public ReverseMessagesTroll() {
		super("REVERSE_MESSAGES", Permissions.Troll.REVERSE_MESSAGES, Settings.TrollSection.IconsSection.REVERSE_MESSAGES);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();
		boolean added = this.reverseMessagePlayers.add(targetUUID);

		if (!added)
			this.reverseMessagePlayers.remove(targetUUID);

		return null;
	}

	@Override
	public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
		if (this.isToggled(event.getPlayer()))
			event.setMessage(new StringBuilder(event.getMessage()).reverse().toString());
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		this.reverseMessagePlayers.remove(player.getUniqueId());
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.reverseMessagePlayers.contains(forPlayer.getUniqueId());
	}
}
