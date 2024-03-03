package com.staxzs.staxzstrolls.menu;

import com.staxzs.staxzstrolls.troll.Troll;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.MenuPagged;
import org.mineacademy.fo.settings.Lang;

import java.util.Set;
import java.util.stream.Collectors;

public final class SearchTrollMenu extends MenuPagged<Troll> {

	private final Player target;

	public SearchTrollMenu(Menu parentMenu, Player target, String searchInput) {
		super(parentMenu, getTrollsBySearchInput(searchInput));

		this.target = target;

		this.setTitle(Lang.of("Menu.Troll_Search_Menu.Title").replace("{search_input}", searchInput));
		this.setSize(3 * 9);
	}

	private static Set<Troll> getTrollsBySearchInput(String searchInput) {
		Set<Troll> trolls = Troll.getRegisteredTrolls();

		return trolls.stream().filter(troll -> troll.getName().toLowerCase().contains(searchInput.toLowerCase())).collect(Collectors.toSet());
	}

	@Override
	protected ItemStack convertToItemStack(Troll troll) {
		return troll.getItemStack(this.target);
	}

	@Override
	protected void onPageClick(Player player, Troll troll, ClickType click) {
		troll.executeTroll(player, this.target);
	}

	@Override
	protected String[] getInfo() {
		return Lang.ofArray("Menu.Troll_Search_Menu.Info");
	}
}
