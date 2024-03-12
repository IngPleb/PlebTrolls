package com.staxzs.staxzstrolls.tool;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
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
public final class SpawnCreeperTool extends Tool {

	@Getter
	private static final SpawnCreeperTool instance = new SpawnCreeperTool();

	@Override
	public ItemStack getItem() {
		return ItemCreator.of(Settings.ToolSection.SpawnCreeperTool.MATERIAL)
				.name(Settings.ToolSection.SpawnCreeperTool.NAME)
				.lore(Settings.ToolSection.SpawnCreeperTool.LORE)
				.make();
	}

	@Override
	protected void onBlockClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();

		String permission = Permissions.Tools.SPAWN_CREEPER;
		if (!PlayerUtil.hasPerm(player, permission)) {
			Messenger.error(player, Lang.of("No_Permission").replace("{permission}", permission));
			return;
		}

		Block clickedBlock = event.getClickedBlock();
		if (clickedBlock != null && clickedBlock.getType() != Material.AIR) {
			// If the clicked block is not air, spawn a creeper there
			clickedBlock.getWorld().spawnEntity(clickedBlock.getLocation().add(0, 1, 0), EntityType.CREEPER);
		} else {
			// If the clicked block is air, perform a raycast
			RayTraceResult rayTraceResult = player.getWorld().rayTraceBlocks(player.getEyeLocation(), player.getEyeLocation().getDirection(), 100);
			if (rayTraceResult != null && rayTraceResult.getHitBlock() != null) {
				// If the raycast hit a block, spawn a creeper there
				rayTraceResult.getHitBlock().getWorld().spawnEntity(rayTraceResult.getHitBlock().getLocation().add(0, 1, 0), EntityType.CREEPER);
			}
		}
	}

	@Override
	protected boolean ignoreCancelled() {
		return false;
	}
}
