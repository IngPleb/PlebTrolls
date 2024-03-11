package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mineacademy.fo.RandomUtil;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public final class ReplaceMessagesTroll extends ToggleableTroll {

	private final Set<UUID> replaceMessagePlayers = new HashSet<>();

	public ReplaceMessagesTroll() {
		super("REPLACE_MESSAGES", Permissions.Troll.REPLACE_MESSAGE, Settings.TrollSection.IconsSection.REPLACE_MESSAGES);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();
		boolean added = this.replaceMessagePlayers.add(targetUUID);

		if (!added)
			this.replaceMessagePlayers.remove(targetUUID);

		return null;
	}

	@Override
	public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
		if (!this.isToggled(event.getPlayer()))
			return;

		String replacedMessage = RandomUtil.nextItem(Settings.TrollSection.REPLACE_MESSAGES);
		event.setMessage(replacedMessage);
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		this.replaceMessagePlayers.remove(player.getUniqueId());
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return this.replaceMessagePlayers.contains(forPlayer.getUniqueId());
	}
}
