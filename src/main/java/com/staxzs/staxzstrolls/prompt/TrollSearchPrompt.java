package com.staxzs.staxzstrolls.prompt;

import com.staxzs.staxzstrolls.menu.SearchTrollMenu;
import lombok.Getter;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mineacademy.fo.conversation.SimpleConversation;
import org.mineacademy.fo.conversation.SimplePrompt;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.settings.Lang;

@Getter
public class TrollSearchPrompt extends SimplePrompt {

	private final Menu returnMenu;
	private final Player target;
	private String searchInput;

	public TrollSearchPrompt(Menu returnMenu, Player target) {
		this.returnMenu = returnMenu;
		this.target = target;
	}

	@Override
	protected String getPrompt(ConversationContext context) {
		return Lang.of("Conversation.Troll_Search_Prompt");
	}

	@Nullable
	@Override
	protected Prompt acceptValidatedInput(@NotNull ConversationContext context, @NotNull String searchInput) {
		this.searchInput = searchInput;

		return END_OF_CONVERSATION;
	}

	@Override
	public void onConversationEnd(SimpleConversation conversation, ConversationAbandonedEvent event) {
		if (event.gracefulExit()) {
			Menu searchMenu = new SearchTrollMenu(this.returnMenu, this.target, this.searchInput);
			searchMenu.displayTo(this.getPlayer(event.getContext()));
		}
	}
}
