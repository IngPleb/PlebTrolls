package com.staxzs.staxzstrolls.menu;

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
import org.mineacademy.fo.menu.button.annotation.Position;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.Remain;
import org.mineacademy.fo.settings.Lang;

import java.util.Arrays;
import java.util.List;

public class TrollPlayerMenu extends MenuPagged<Troll> {

	private final Player target;

	// Buttons
	@Position(6)
	private final Button teleportToPlayer;

	@Position(4)
	private final Button targetInfo;

	@Position(2)
	private final Button teleportPlayerToYou;

	public TrollPlayerMenu(Menu parentMenu, Player viewer, @NotNull Player target) {

		// Initialise menu
		super(parentMenu, Interval.of(18, 44).toList(), Troll.getRegisteredTrolls());
		this.setSize(54);
		this.setViewer(viewer);
		this.target = target;
		this.setTitle(Lang.of("Menu.Troll_Menu.Title").replace("{target_name}", target.getName()));

		this.setSlotNumbersVisible(); // TODO: remove

		// Initialise buttons
		List<String> lore = Lang.ofList("Menu.Troll_Menu.Target_Info_Lore")
				.stream()
				.map(line -> {

					String newLine;
					// name
					newLine = line.replace("{target_name}", target.getName());
					// ping
					newLine = newLine.replace("{target_ping}", PlayerUtil.getPing(target) + "");
					// health
					newLine = newLine.replace("{target_health}", Remain.getHealth(target) + "");
					// food
					newLine = newLine.replace("{target_food}", target.getFoodLevel() + "");
					// gamemode
					newLine = newLine.replace("{target_gamemode}", target.getGameMode().name());
					// World name
					newLine = newLine.replace("{target_world}", target.getWorld().getName());

					return newLine;
				})
				.toList();

		this.targetInfo = Button.makeDummy(ItemCreator.of(CompMaterial.PLAYER_HEAD)
				.name(Lang.of("Menu.Troll_Menu.Target_Info_Title").replace("{target_name}", target.getName()))
				.lore(lore)
				.skullOwner(target.getName()));

		this.teleportToPlayer = Button.makeSimple(
				ItemCreator.of(CompMaterial.ENDER_PEARL,
						Lang.of("Menu.Troll_Menu.Teleport_To_Player"),
						Lang.ofList("Menu.Troll_Menu.Teleport_To_Player_Lore")),
				player -> {

					player.teleport(target);

					Messenger.success(player, Lang.of("Menu.Troll_Menu.Teleport_To_Player_Success")
							.replace("{target_name}", target.getName()));
				});

		this.teleportPlayerToYou = Button.makeSimple(
				ItemCreator.of(CompMaterial.ENDER_EYE,
						Lang.of("Menu.Troll_Menu.Teleport_Player_To_You"),
						Lang.ofList("Menu.Troll_Menu.Teleport_Player_To_You_Lore")),
				player -> {

					target.teleport(player);

					Messenger.success(player, Lang.of("Menu.Troll_Menu.Teleport_Player_To_You_Success")
							.replace("{target_name}", target.getName()));
				});

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
		ItemCreator creator = ItemCreator.of(troll.getIcon())
				.name(troll.getDisplayName())
				.lore("", troll.getDescription());


		return creator.make();
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
