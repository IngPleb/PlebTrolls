package com.staxzs.staxzstrolls.tool;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.menu.tool.Tool;
import org.mineacademy.fo.settings.Lang;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExplodeTool extends Tool {

	@Getter
	private static final ExplodeTool instance = new ExplodeTool();

	@Override
	public ItemStack getItem() {
		return ItemCreator.of(Settings.ToolSection.ExplodeTool.MATERIAL)
				.name(Settings.ToolSection.ExplodeTool.NAME)
				.lore(Settings.ToolSection.ExplodeTool.LORE)
				.make();
	}

	@Override
	protected void onBlockClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();

		String permission = Permissions.Tools.EXPLODE;

		if (!player.hasPermission(permission)) {
			player.sendMessage(Lang.of("No_Permission").replace("{permission}", permission));
			return;
		}

		Block clickedBlock = event.getClickedBlock();
		if (clickedBlock == null || clickedBlock.getType().isAir())
			return;

		Location clickedLocation = clickedBlock.getLocation();

		clickedBlock.getWorld().createExplosion(clickedLocation, Settings.ToolSection.ExplodeTool.POWER);
	}
}
