package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.region.Region;

public final class AnvilRainTroll extends Troll {

	public AnvilRainTroll() {
		super("ANVIL_RAIN", Permissions.Troll.ANVIL_RAIN, Settings.TrollSection.IconsSection.ANVIL_RAIN);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		int height = Settings.TrollSection.ANVIL_RAIN_HEIGHT;

		Location anvilRainLocation = target.getLocation().clone().add(0, height, 0);
		Location firstCorner = anvilRainLocation.clone().add(-7, 0, -7);
		Location secondCorner = anvilRainLocation.clone().add(7, 0, 7);
		Region anvilRainRegion = new Region(firstCorner, secondCorner);

		anvilRainRegion.getBlocks().forEach(block -> block.setType(Material.ANVIL));

		return null;
	}
}
