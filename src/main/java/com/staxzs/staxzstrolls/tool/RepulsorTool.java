package com.staxzs.staxzstrolls.tool;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.menu.tool.Tool;
import org.mineacademy.fo.settings.Lang;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RepulsorTool extends Tool {

	@Getter
	private static final RepulsorTool instance = new RepulsorTool();

	@Override
	public ItemStack getItem() {
		return ItemCreator.of(Settings.ToolSection.RepulsorTool.MATERIAL)
				.name(Settings.ToolSection.RepulsorTool.NAME)
				.lore(Settings.ToolSection.RepulsorTool.LORE)
				.make();
	}

	@Override
	protected void onBlockClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		String permission = Permissions.Tools.REPULSOR;
		if (!player.hasPermission(permission)) {
			player.sendMessage(Lang.of("No_Permission").replace("{permission}", permission));
			return;
		}

		// Define the radius and force
		double radius = Settings.ToolSection.RepulsorTool.RADIUS;
		double force = Settings.ToolSection.RepulsorTool.FORCE;

		// Get the player's location
		Location playerLocation = player.getLocation();

		// Get all entities within the radius
		List<Entity> nearbyEntities = player.getNearbyEntities(radius, radius, radius);

		// Throw entities away
		for (Entity entity : nearbyEntities) {
			Vector direction = entity.getLocation().subtract(playerLocation).toVector().normalize().multiply(force);
			entity.setVelocity(direction);
		}

		// Get all blocks within the radius and throw them away
		for (int x = (int) -radius; x <= radius; x++) {
			for (int y = (int) -radius; y <= radius; y++) {
				for (int z = (int) -radius; z <= radius; z++) {
					Location blockLocation = playerLocation.clone().add(x, y, z);
					if (blockLocation.getBlock().getType() != Material.AIR) {
						BlockData blockData = blockLocation.getBlock().getBlockData();
						blockLocation.getBlock().setType(Material.AIR);

						World playerWorld = playerLocation.getWorld();

						Objects.requireNonNull(playerWorld, "Player world is null");

						FallingBlock fallingBlock = playerWorld.spawnFallingBlock(blockLocation, blockData);
						Vector direction = blockLocation.subtract(playerLocation).toVector().normalize().multiply(force);
						fallingBlock.setVelocity(direction);
					}
				}
			}
		}

		if (Settings.ToolSection.RepulsorTool.PLAY_SOUND)
			Settings.ToolSection.RepulsorTool.SOUND.play(player);
	}

	@Override
	protected boolean ignoreCancelled() {
		return false;
	}
}
