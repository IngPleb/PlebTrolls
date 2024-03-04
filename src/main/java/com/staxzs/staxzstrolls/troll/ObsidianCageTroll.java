package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.region.Region;

public final class ObsidianCageTroll extends Troll {

	public ObsidianCageTroll() {
		super("OBSIDIAN_CAGE", Permissions.Troll.OBSIDIAN_CAGE, Settings.TrollSection.IconsSection.OBSIDIAN_CAGE);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		Location obsidianCageOrigin = target.getLocation().clone().subtract(0, 1, 0);

		this.buildCage(obsidianCageOrigin);

		return null;
	}

	private void buildCage(Location location) {
		Location topCorner = location.clone().add(1, 3, 1);
		Location bottomCorner = location.clone().subtract(2, 0, 2);
		Region wholeBox = new Region(topCorner, bottomCorner);
		wholeBox.getBoundingBox().forEach(location1 -> location1.getBlock().setType(org.bukkit.Material.OBSIDIAN));

		Location downTopCorner = topCorner.clone().subtract(0, 3, 0);
		Region floor = new Region(downTopCorner, bottomCorner);
		floor.getBlocks().forEach(block -> block.setType(org.bukkit.Material.OBSIDIAN));

		Location upBottomCorner = bottomCorner.clone().add(0, 4, 0);
		Region ceiling = new Region(upBottomCorner, topCorner.add(0, 1, 0));
		ceiling.getBlocks().forEach(block -> block.setType(org.bukkit.Material.OBSIDIAN));
	}
}
