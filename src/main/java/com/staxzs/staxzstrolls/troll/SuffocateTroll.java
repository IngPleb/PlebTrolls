package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.region.Region;

public final class SuffocateTroll extends Troll {

	public SuffocateTroll() {
		super("SUFFOCATE", Permissions.Troll.SUFFOCATE, Settings.TrollSection.IconsSection.SUFFOCATE);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		this.centerPlayer(target);

		Location rightUpCorner = target.getLocation().clone().add(1, 2, 1);
		Location leftDownCorner = target.getLocation().clone().add(-1, -1, -1);
		Region region = new Region(rightUpCorner, leftDownCorner);
		region.getBlocks().forEach(block -> block.setType(Material.OBSIDIAN));

		return null;
	}

	private void centerPlayer(Player player) {
		Location location = player.getLocation();
		location.setX(Math.floor(location.getX()) + 0.5);
		location.setZ(Math.floor(location.getZ()) + 0.5);
		player.teleport(location);
	}
}
