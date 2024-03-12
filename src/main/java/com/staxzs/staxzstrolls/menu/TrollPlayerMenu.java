package com.staxzs.staxzstrolls.menu;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.prompt.TrollSearchPrompt;
import com.staxzs.staxzstrolls.settings.Settings;
import com.staxzs.staxzstrolls.troll.Troll;
import com.staxzs.staxzstrolls.util.Interval;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.mineacademy.fo.Messenger;
import org.mineacademy.fo.PlayerUtil;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.MenuPagged;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.StartPosition;
import org.mineacademy.fo.menu.button.annotation.Position;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;

import java.util.Arrays;
import java.util.List;

public final class TrollPlayerMenu extends MenuPagged<Troll> {

	private final Player target;

	// Buttons
	@Position(2)
	@SuppressWarnings("unused")
	private final Button bringPlayerToYouButton;
	@Position(4)
	@SuppressWarnings("unused")
	private final Button targetInfoButton;
	@Position(6)
	@SuppressWarnings("unused")
	private final Button teleportToPlayerButton;

	@Position(46)
	@SuppressWarnings("unused")
	private final Button searchTrollButton;

	@Position(start = StartPosition.BOTTOM_CENTER)
	@SuppressWarnings("unused")
	private final Button toolsMenuButton;


	public TrollPlayerMenu(Menu parentMenu, @NotNull Player target, @NotNull Player viewer) {

		// Initialise menu
		super(parentMenu, Interval.of(18, 44).toList()
				, Settings.TrollSection.FILTER_BY_PERMISSION ?
						Troll.getRegisteredTrollsByPlayer(viewer) : Troll.getRegisteredTrolls());
		this.setSize(54);
		this.target = target;
		this.setTitle(Lang.of("Menu.Troll_Menu.Title").replace("{target_name}", target.getName()));

		// Initialise buttons
		this.targetInfoButton = Button.makeDummy(ItemCreator.of(CompMaterial.PLAYER_HEAD)
				.name(Lang.of("Menu.Troll_Menu.Target_Info_Title").replace("{target_name}", target.getName()))
				.lore(com.staxzs.staxzstrolls.util.PlayerUtil.getTargetInfo(target))
				.skullOwner(target.getName()));

		this.teleportToPlayerButton = Button.makeSimple(
				ItemCreator.of(CompMaterial.ENDER_PEARL,
						Lang.of("Menu.Troll_Menu.Teleport_To_Player"),
						Lang.ofList("Menu.Troll_Menu.Teleport_To_Player_Lore")),
				player -> {

					if (!PlayerUtil.hasPerm(player, Permissions.TELEPORT)) {
						Messenger.error(player, Lang.of("No_Permission").replace("{permission}", Permissions.TELEPORT));
						return;
					}
					player.teleport(target);

					Messenger.success(player, Lang.of("Menu.Troll_Menu.Teleport_To_Player_Success")
							.replace("{target_name}", target.getName()));
				});

		this.bringPlayerToYouButton = Button.makeSimple(
				ItemCreator.of(CompMaterial.ENDER_EYE,
						Lang.of("Menu.Troll_Menu.Bring_Player_To_You"),
						Lang.ofList("Menu.Troll_Menu.Bring_Player_To_You_Lore")),
				player -> {
					if (!PlayerUtil.hasPerm(player, Permissions.BRING)) {
						Messenger.error(player, Lang.of("No_Permission").replace("{permission}", Permissions.BRING));
						return;
					}
					target.teleport(player);

					Messenger.success(player, Lang.of("Menu.Troll_Menu.Bring_Player_To_You_Success")
							.replace("{target_name}", target.getName()));
				});

		final String trollSearchButtonPrefix = "Menu.Troll_Menu.Search_Troll_Button.";

		this.searchTrollButton = Button.makeSimple(ItemCreator.of(CompMaterial.COMPASS)
						.name(Lang.of(trollSearchButtonPrefix + "Title"))
						.lore(Lang.of(trollSearchButtonPrefix + "Lore")),
				player -> {
					player.closeInventory();

					new TrollSearchPrompt(this, target).show(player);
				}
		);

		this.toolsMenuButton = ToolMenu.getButton(this);

	}

	////////////////////////
	// Instance Methods
	////////////////////////

	@Override
	public ItemStack getItemAt(int slot) {
		// Divider
		List<Integer> dividerIndexes = Arrays.asList(9, 10, 11, 12, 13, 14, 15, 16, 17);
		if (dividerIndexes.contains(slot))
			return ItemCreator.of(CompMaterial.BLACK_STAINED_GLASS_PANE).name(" ").make();

		return super.getItemAt(slot);
	}

	@Override
	protected ItemStack convertToItemStack(Troll troll) {
		return troll.getItemStack(this.target);
	}

	@Override
	protected void onPageClick(Player player, Troll item, ClickType click) {
		item.executeTroll(player, this.target);
	}

	@Override
	protected String[] getInfo() {
		return Lang.ofArray("Menu.Troll_Menu.Info");
	}
}
