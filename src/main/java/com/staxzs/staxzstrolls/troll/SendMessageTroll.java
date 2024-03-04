package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.mineacademy.fo.conversation.SimpleConversation;
import org.mineacademy.fo.model.Tuple;

public final class SendMessageTroll extends Troll {

	public SendMessageTroll() {
		super("SEND_MESSAGE", Permissions.Troll.SEND_MESSAGE, Settings.TrollSection.IconsSection.SEND_MESSAGE);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {

		new SimpleConversation() {
			@Override
			protected Prompt getFirstPrompt() {
				return new StringPrompt() {

					@NotNull
					@Override
					public String getPromptText(@NotNull ConversationContext context) {
						return "Enter the message you want to send as the player:";
					}

					@Override
					public Prompt acceptInput(ConversationContext context, String input) {
						target.chat(input);
						return END_OF_CONVERSATION;
					}
				};
			}
		}.start((Player) sender);

		return new Tuple<>(true, null);
	}
}
