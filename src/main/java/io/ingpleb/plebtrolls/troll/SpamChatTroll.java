package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.PlebTrolls;
import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.Tuple;

public final class SpamChatTroll extends Troll {

	public SpamChatTroll() {
		super("SPAM_CHAT", Permissions.Troll.SPAM_CHAT, Settings.TrollSection.IconsSection.SPAM_CHAT);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {

		new BukkitRunnable() {
			private int count = 0;

			@Override
			public void run() {
				for (int i = 0; i < 200; i++) {
					Common.tellNoPrefix(target, Settings.TrollSection.SPAM_CHAT_MESSAGE);
				}

				if (this.count++ == 3) {
					this.cancel();
				}
			}
		}.runTaskTimer(PlebTrolls.getInstance(), 0, 20);

		return null;
	}
}
