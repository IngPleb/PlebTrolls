package com.staxzs.staxzstrolls.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.MenuPagged;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.Remain;
import org.mineacademy.fo.settings.Lang;

import java.util.Collection;
import java.util.List;

public class PlayerListMenu extends MenuPagged<Player> {

	public PlayerListMenu() {
		super(getListOfPlayers());
		this.setSize(4 * 9);
		this.setTitle(Lang.of("Menu.Player_List_Menu.Title"));
	}

	private static List<Player> getListOfPlayers() {
		Collection<? extends Player> players = Remain.getOnlinePlayers();

		return players.stream().map(player -> (Player) player).toList();
	}

	@Override
	protected ItemStack convertToItemStack(Player player) {
		ItemCreator creator = ItemCreator.of(CompMaterial.PLAYER_HEAD)
				.skullOwner(player.getName())
				.name(Lang.of("Menu.Player_List_Menu.Player_Name").replace("{player_name}", player.getName()));
		// TODO: add lore

		return creator.make();
	}

	@Override
	protected void onPageClick(Player player, Player target, ClickType click) {
		new TrollPlayerMenu(this, target).displayTo(player);
	}

	@Override
	protected String[] getInfo() {
		return Lang.ofArray("Menu.Player_List_Menu.Info");
	}
}