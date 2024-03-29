package io.ingpleb.plebtrolls.menu;

import io.ingpleb.plebtrolls.settings.Settings;
import io.ingpleb.plebtrolls.troll.Troll;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.PlayerUtil;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.MenuPagged;
import org.mineacademy.fo.settings.Lang;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class extends the MenuPagged class and represents a menu for searching trolls in the application.
 * It contains a target player and methods for creating the menu, getting trolls by search input, converting a troll to an ItemStack, handling page clicks, and getting information for the info button.
 * The class is final, which means it cannot be subclassed.
 */
public final class SearchTrollMenu extends MenuPagged<Troll> {

	private final Player target;

	public SearchTrollMenu(Menu parentMenu, Player target, String searchInput) {
		super(parentMenu, getTrollsBySearchInput(searchInput, target));

		this.target = target;

		this.setTitle(Lang.of("Menu.Troll_Search_Menu.Title").replace("{search_input}", searchInput));
		this.setSize(3 * 9);
	}

	private static Set<Troll> getTrollsBySearchInput(String searchInput, Player player) {
		Set<Troll> trolls = Troll.getRegisteredTrolls();

		// Filter by search input
		trolls = trolls.stream()
				.filter(troll -> troll.getName().toLowerCase().contains(searchInput.toLowerCase())).collect(Collectors.toSet());

		if (Settings.TrollSection.FILTER_BY_PERMISSION)
			trolls = trolls.stream()
					.filter(troll -> {
						String permission = troll.getPermission();
						return PlayerUtil.hasPerm(player, permission);
					}).collect(Collectors.toSet());

		return trolls;
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
