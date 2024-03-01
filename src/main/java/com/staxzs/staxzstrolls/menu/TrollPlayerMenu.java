package com.staxzs.staxzstrolls.menu;

import com.staxzs.staxzstrolls.troll.Troll;
import com.staxzs.staxzstrolls.util.Interval;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.MenuPagged;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.annotation.Position;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.Arrays;
import java.util.List;

public class TrollPlayerMenu extends MenuPagged<Troll> {

	private final Player target;

	// Buttons
	@Position(4)
	private final Button targetInfo;

	public TrollPlayerMenu(Menu parentMenu, Player viewer, @NotNull Player target) {

		// Initialise menu
		super(parentMenu, Interval.of(18, 44).toList(), Troll.getRegisteredTrolls());
		this.setSize(54);
		this.setViewer(viewer);
		this.target = target;
		this.setTitle("&8Trolling &l" + target.getName());

		this.setSlotNumbersVisible();

		// Initialise buttons
		this.targetInfo = Button.makeDummy(ItemCreator.of(CompMaterial.PLAYER_HEAD)
				.name("&8Target Info")
				.skullOwner(target.getName()));
	}

	@Override
	public ItemStack getItemAt(int slot) {
		// Divider
		List<Integer> dividerIndexes = Arrays.asList(9, 10, 11, 12, 13, 14, 15, 16, 17);
		if (dividerIndexes.contains(slot))
			return ItemCreator.of(CompMaterial.BLACK_STAINED_GLASS_PANE).name(" ").make();

		return super.getItemAt(slot);
	}

	@Override
	protected String[] getInfo() {
		return new String[]{
				"Select a troll to use on",
				"the player " + this.target.getName() + "."
		};
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
