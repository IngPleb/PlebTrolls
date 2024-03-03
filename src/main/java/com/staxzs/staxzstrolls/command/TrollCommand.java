package com.staxzs.staxzstrolls.command;

import com.staxzs.staxzstrolls.menu.PlayerListMenu;
import com.staxzs.staxzstrolls.menu.TrollPlayerMenu;
import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.troll.Troll;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.collection.StrictList;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.List;

@AutoRegister
@SuppressWarnings("unused")
public final class TrollCommand extends SimpleCommand {
	public TrollCommand() {
		super(new StrictList<>("troll", "trl", "tl")); // TODO: Add ability to add more aliases
		this.setDescription("Open the troll menu for a player or troll them directly");
		this.setUsage("[player] [troll]");
		this.setPermission(Permissions.Command.TROLL);
		this.setMinArguments(0);
	}

	@Override
	protected void onCommand() {
		if (this.args.length == 0) {
			this.checkConsole();
			//TODO: add this.checkPerm(Permissions.Command.TROLL_MENU);

			new PlayerListMenu().displayTo(this.getPlayer());
			return;
		}

		Player target = this.findPlayer(this.args[0]);
		String trollName = this.args.length > 1 ? this.args[1] : null;

		if (!this.isPlayer())
			this.checkNotNull(trollName, "You must specify a troll to use on the player");

		if (trollName == null) {
			Player menuViewer = (Player) this.sender;

			new TrollPlayerMenu(null, target).displayTo(menuViewer);
		} else {
			Troll troll = Troll.fromName(trollName);
			this.checkBoolean(troll != null, "Troll " + trollName + " not found");

			assert troll != null;
			troll.executeTroll(this.sender, target);
		}
	}

	@Override
	protected List<String> tabComplete() {
		return switch (this.args.length) {
			case 1 -> Common.getPlayerNames();
			case 2 -> this.completeLastWord(Troll.getTrollNames());
			default -> NO_COMPLETE;
		};
	}
}
