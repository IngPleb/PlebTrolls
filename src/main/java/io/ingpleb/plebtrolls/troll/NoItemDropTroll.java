package io.ingpleb.plebtrolls.troll;

import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public final class NoItemDropTroll extends ToggleableTroll {

	private static final Set<UUID> PLAYERS_WITH_NO_DROPS = new HashSet<>();

	public NoItemDropTroll() {
		super("NO_ITEM_DROP", Permissions.Troll.NO_ITEM_DROP, Settings.TrollSection.IconsSection.NO_ITEM_DROP);
	}

	@Override
	public Tuple<Boolean, String> performTroll(CommandSender sender, Player target) {
		UUID targetUUID = target.getUniqueId();
		boolean added = PLAYERS_WITH_NO_DROPS.add(targetUUID);

		if (!added)
			PLAYERS_WITH_NO_DROPS.remove(targetUUID);

		return null;
	}

	@Override
	public void onBlockBreak(BlockBreakEvent event) {
		if (PLAYERS_WITH_NO_DROPS.contains(event.getPlayer().getUniqueId()))
			event.setDropItems(false);
	}

	@Override
	public boolean isToggled(Player forPlayer) {
		return PLAYERS_WITH_NO_DROPS.contains(forPlayer.getUniqueId());
	}
}
