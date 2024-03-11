package com.staxzs.staxzstrolls.tool;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.RayTraceResult;
import org.mineacademy.fo.Messenger;
import org.mineacademy.fo.PlayerUtil;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.menu.tool.Tool;
import org.mineacademy.fo.settings.Lang;

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
		Player player = event.getPlayer();
		Block clickedBlock = event.getClickedBlock();

		String permission = Permissions.Tools.SMITE;
		if (!PlayerUtil.hasPerm(player, permission)) {
			Messenger.error(player, Lang.of("No_Permission").replace("{permission}", permission));
			return;
		}

		if (clickedBlock != null && clickedBlock.getType() != Material.AIR) {
			// If the clicked block is not air, spawn lightning there
			clickedBlock.getWorld().strikeLightning(clickedBlock.getLocation());
		} else {
			// If the clicked block is air, perform a raycast
			RayTraceResult rayTraceResult = player.getWorld().rayTraceBlocks(player.getEyeLocation(), player.getEyeLocation().getDirection(), 100);
			if (rayTraceResult != null && rayTraceResult.getHitBlock() != null) {
				// If the raycast hit a block, spawn lightning there
				rayTraceResult.getHitBlock().getWorld().strikeLightning(rayTraceResult.getHitBlock().getLocation());
			}
		}
	}

	@Override
	protected boolean ignoreCancelled() {
		return false;
	}
}
