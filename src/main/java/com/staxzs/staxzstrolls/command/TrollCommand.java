package com.staxzs.staxzstrolls.command;

import com.staxzs.staxzstrolls.model.Permissions;
import org.bukkit.entity.Player;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.collection.StrictList;
import org.mineacademy.fo.command.SimpleCommand;

@AutoRegister
@SuppressWarnings("unused")
public final class TrollCommand extends SimpleCommand {
	public TrollCommand() {
		super(new StrictList<>("troll", "trl", "tl")); // TODO: Add ability to add more aliases
		this.setDescription("Open the troll menu for a player or troll them directly");
		this.setUsage("<player> [troll]");
		this.setPermission(Permissions.Command.TROLL);
		this.setMinArguments(1);
	}

	@Override
	protected void onCommand() {
		Player target = this.findPlayer(this.args[0]);
		String troll = this.args.length > 1 ? this.args[1] : null;

		if (!this.isPlayer())
			this.checkNotNull(troll, "You must specify a troll to use on the player");

		if (troll == null) {

		} else {
			this.tellError("Not implemented yet.");
		}
	}
}
