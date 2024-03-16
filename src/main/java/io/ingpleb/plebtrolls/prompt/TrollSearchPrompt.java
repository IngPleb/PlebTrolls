package io.ingpleb.plebtrolls.prompt;

import io.ingpleb.plebtrolls.menu.SearchTrollMenu;
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

/**
 * The TrollSearchPrompt class extends the SimplePrompt class and represents a prompt for searching trolls in the game.
 * This class is used to handle the conversation with the player when they are searching for a troll.
 * <p>
 * The @Getter annotation from the Lombok library is used to automatically generate getter methods for all non-static fields.
 * <p>
 * This class includes a return menu, a target player, and a search input string.
 * The return menu is the menu that will be displayed to the player after the conversation ends.
 * The target player is the player who will be affected by the troll.
 * The search input string is the string that the player inputs to search for a troll.
 */
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
