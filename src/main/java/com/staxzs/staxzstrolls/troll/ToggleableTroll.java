package com.staxzs.staxzstrolls.troll;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;

public abstract class ToggleableTroll extends Troll {
	protected ToggleableTroll(String name, String permission, CompMaterial icon) {
		super(name, permission, icon);
	}

	protected ToggleableTroll(String name, String displayName, String description, String permission, CompMaterial icon) {
		super(name, displayName, description, permission, icon);
	}

	public abstract boolean isToggled(Player forPlayer);

	@Override
	protected String getExecuteMessage(Player target) {
		final String langPathPrefix = "Trolls.Toggle_Troll.";
		final String stateString = this.isToggled(target) ? Lang.of(langPathPrefix + "On_State") : Lang.of(langPathPrefix + "Off_State");

		return Lang.of(langPathPrefix + "Execute_Message")
				.replace("{state}", stateString)
				.replace("{target_name}", target.getName())
				.replace("{troll_name}", this.getDisplayName());
	}

	@Override
	public ItemStack getItemStack(Player target) {
		final String langPathPrefix = "Menu.Troll_Menu.Toggleable_Troll_";

		ItemCreator itemCreator = ItemCreator.of(this.getIcon(),
						this.getDisplayName() + " " +
								(this.isToggled(target) ? Lang.of(langPathPrefix + "Enabled") : Lang.of(langPathPrefix + "Disabled")),
						this.getDescription())
				.glow(this.isToggled(target));

		return itemCreator.make();
	}
}
