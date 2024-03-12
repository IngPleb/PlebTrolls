package com.staxzs.staxzstrolls.tool;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.RayTraceResult;
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

		// Define the maximum distance for the raycast
		int maxDistance = 100;

		// Create a ray from the player's eye location in the direction they are looking
		RayTraceResult rayTrace = player.getWorld().rayTraceBlocks(player.getEyeLocation(), player.getEyeLocation().getDirection(), maxDistance);

		// If the raycast hit a block, explode it
		if (rayTrace != null && rayTrace.getHitBlock() != null) {
			Block hitBlock = rayTrace.getHitBlock();
			hitBlock.getWorld().createExplosion(hitBlock.getLocation(), Settings.ToolSection.ExplodeTool.POWER);
		}
	}

	@Override
	protected boolean ignoreCancelled() {
		return false;
	}
}
