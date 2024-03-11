package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
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
public final class GibberishMessagesTroll extends ToggleableTroll {

	private final Set<UUID> gibberishMessagePlayers = new HashSet<>();

	public GibberishMessagesTroll() {
		super("GIBBERISH_MESSAGES", Permissions.Troll.GIBBERISH, Settings.TrollSection.IconsSection.GIBBERISH_MESSAGES);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();
		boolean added = this.gibberishMessagePlayers.add(targetUUID);

		if (!added)
			this.gibberishMessagePlayers.remove(targetUUID);

		return null;
	}

	@Override
	public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
		if (!this.isToggled(event.getPlayer()))
			return;

		String message = event.getMessage();
		StringBuilder newMessage = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c)) {
					newMessage.append(Character.toUpperCase((char) (Math.random() * 26 + 'a')));
				} else {
					newMessage.append(Character.toLowerCase((char) (Math.random() * 26 + 'A')));
				}
			} else {
				newMessage.append(c);
			}
		}
		event.setMessage(newMessage.toString());
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		this.gibberishMessagePlayers.remove(player.getUniqueId());
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.gibberishMessagePlayers.contains(forPlayer.getUniqueId());
	}
}
