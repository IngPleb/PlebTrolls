package com.staxzs.staxzstrolls.command;

import com.staxzs.staxzstrolls.menu.PlayerListMenu;
import com.staxzs.staxzstrolls.menu.TrollPlayerMenu;
import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import com.staxzs.staxzstrolls.troll.Troll;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.collection.StrictList;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * The TrollCommand class extends the SimpleCommand class and represents the command that triggers the troll functionality in the game.
 * This command can be used to display a list of online players to the command sender, or to execute a specific troll on a target player.
 * <p>
 * This class is final and cannot be subclassed.
 * <p>
 * The @AutoRegister annotation indicates that this command is automatically registered when the plugin is enabled.
 * The @SuppressWarnings("unused") annotation is used to suppress warnings about unused methods or variables in this class.
 */
@AutoRegister
@SuppressWarnings("unused")
public final class TrollCommand extends SimpleCommand {
	public TrollCommand() {
		super(new StrictList<>(Settings.TrollSection.COMMAND_ALIASES));
		this.setDescription(Lang.of("Commands.Troll_Description"));
		this.setUsage(Lang.of("Commands.Troll_Usage"));
		this.setPermission(Permissions.Command.TROLL);
		this.setMinArguments(0);
	}

	@Override
	protected void onCommand() {
		if (this.args.length == 0) {
			this.checkConsole();

			new PlayerListMenu().displayTo(this.getPlayer());
			return;
		}

		Player target = this.findPlayer(this.args[0]);
		String trollName = this.args.length > 1 ? this.args[1] : null;

		if (!this.isPlayer())
			this.checkNotNull(trollName, Lang.of("Commands.Troll_Console_No_Player"));

		if (trollName == null) {
			Player menuViewer = (Player) this.sender;

			new TrollPlayerMenu(null, target, menuViewer).displayTo(menuViewer);
		} else {
			Troll troll = Troll.fromName(trollName);
			this.checkBoolean(troll != null, Lang.of("Commands.Troll_Not_Found").replace("{troll}", trollName));

			assert troll != null;
			troll.executeTroll(this.sender, target);
		}
	}

	@Override
	protected List<String> tabComplete() {
		switch (this.args.length) {
			case 1:
				return Common.getPlayerNames();
			case 2:
				Set<String> trollNames = (Settings.TrollSection.FILTER_BY_PERMISSION ?
						Troll.getRegisteredTrollsByPlayer((Player) this.sender) : Troll.getRegisteredTrolls())
						.stream()
						.map(Troll::getName)
						.collect(toSet());

				return this.completeLastWord(trollNames);
			default:
				return NO_COMPLETE;
		}
	}
}
