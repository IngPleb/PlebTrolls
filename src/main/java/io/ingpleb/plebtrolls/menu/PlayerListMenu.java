package io.ingpleb.plebtrolls.menu;

import io.ingpleb.plebtrolls.util.PlayerUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.MenuPagged;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.StartPosition;
import org.mineacademy.fo.menu.button.annotation.Position;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.Remain;
import org.mineacademy.fo.settings.Lang;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The PlayerListMenu class extends the MenuPagged class and represents a paginated menu of online players in the game.
 * This menu displays a list of online players, and each player is represented by an item in the menu.
 * Clicking on a player's item in the menu opens the TrollPlayerMenu for the clicked player.
 * <p>
 * This class also includes a button that opens the tools menu.
 */
public class PlayerListMenu extends MenuPagged<Player> {

	@Position(start = StartPosition.BOTTOM_CENTER)
	@SuppressWarnings("unused")
	private final Button toolsMenuButton;

	public PlayerListMenu() {
		super(getListOfPlayers());
		this.setSize(4 * 9);
		this.setTitle(Lang.of("Menu.Player_List_Menu.Title"));

		this.toolsMenuButton = ToolMenu.getButton(this);
	}

	private static List<Player> getListOfPlayers() {
		Collection<? extends Player> players = Remain.getOnlinePlayers();

		return players.stream().map(player -> (Player) player).collect(Collectors.toList());
	}

	@Override
	protected ItemStack convertToItemStack(Player player) {
		ItemCreator creator = ItemCreator.of(CompMaterial.PLAYER_HEAD)
				.skullOwner(player.getName())
				.name(Lang.of("Menu.Player_List_Menu.Player_Name").replace("{player_name}", player.getName()))
				.lore(PlayerUtil.getTargetInfo(player));

		return creator.make();
	}

	@Override
	protected void onPageClick(Player player, Player target, ClickType click) {
		new TrollPlayerMenu(this, target, player).displayTo(player);
	}

	@Override
	protected String[] getInfo() {
		return Lang.ofArray("Menu.Player_List_Menu.Info");
	}
}
