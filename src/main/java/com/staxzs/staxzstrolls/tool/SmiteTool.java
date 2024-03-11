package com.staxzs.staxzstrolls.tool;

import com.staxzs.staxzstrolls.settings.Settings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.menu.tool.Tool;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SmiteTool extends Tool {

	@Getter
	private static final SmiteTool instance = new SmiteTool();

	@Override
	public ItemStack getItem() {
		return ItemCreator.of(Settings.ToolSection.SmiteTool.MATERIAL)
				.name(Settings.ToolSection.SmiteTool.NAME)
				.lore(Settings.ToolSection.SmiteTool.LORE)
				.make();
	}

	@Override
	protected void onBlockClick(PlayerInteractEvent event) {
		event.getClickedBlock().getWorld().strikeLightning(event.getClickedBlock().getLocation());
	}
}
