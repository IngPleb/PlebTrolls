package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;

public final class FillInventoryTroll extends Troll {

	@Getter
	private static final FillInventoryTroll INSTANCE = new FillInventoryTroll();

	public FillInventoryTroll() {
		super("FILL_INVENTORY", Lang.of("Trolls.Fill_Inventory.Display_Name"),
				Lang.of("Trolls.Fill_Inventory.Description"),
				Permissions.Troll.FILL_INVENTORY,
				CompMaterial.fromString(Settings.TrollSection.IconsSection.FILL_INVENTORY));
	}


	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		CompMaterial material = Settings.TrollSection.FILL_INVENTORY_ITEM_TYPE;
		int amount = Settings.TrollSection.FILL_INVENTORY_ITEM_AMOUNT;

		PlayerInventory inventory = target.getInventory();
		// fill the empty slots in the main inventory only
		// 36 is the main inventory size
		for (int i = 0; i < 36; i++) {
			if (inventory.getItem(i) == null || inventory.getItem(i).getType() == CompMaterial.AIR.getMaterial()) {
				inventory.setItem(i, material.toItem(amount));
			}
		}

		return null;
	}
}
