package com.staxzs.staxzstrolls.menu;

import com.staxzs.staxzstrolls.troll.Troll;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.MenuPagged;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class TrollPlayerMenu extends MenuPagged<Troll> {

	private final Player target;

	public TrollPlayerMenu(Menu parentMenu, Player viewer, Player target) {
		super(9 * 4, parentMenu, Troll.getRegisteredTrolls());

		this.setViewer(viewer);
		this.target = target;
		this.setTitle("&8Trolling &l" + target.getName());
	}

	@Override
	protected ItemStack convertToItemStack(Troll item) {
		ItemCreator creator = ItemCreator.of(CompMaterial.GOLDEN_AXE)
				.name(item.getDisplayName());

		return creator.make();
	}

	@Override
	protected void onPageClick(Player player, Troll item, ClickType click) {
		item.executeTroll(player, this.target);
	}
}
