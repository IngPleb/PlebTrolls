package io.ingpleb.plebtrolls.command;

import io.ingpleb.plebtrolls.menu.ToolMenu;
import io.ingpleb.plebtrolls.model.Permissions;
import io.ingpleb.plebtrolls.settings.Settings;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.collection.StrictList;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

/**
 * The TrollToolsCommand class extends the SimpleCommand class and represents the command that triggers the troll tools functionality in the game.
 * This command can be used to display a list of troll tools to the command sender.
 * <p>
 * This class is final and cannot be subclassed.
 * <p>
 * The @AutoRegister annotation indicates that this command is automatically registered when the plugin is enabled.
 * The @SuppressWarnings("unused") annotation is used to suppress warnings about unused methods or variables in this class.
 */
@AutoRegister
@SuppressWarnings("unused")
public final class TrollToolsCommand extends SimpleCommand {
	public TrollToolsCommand() {
		super(new StrictList<>(Settings.ToolSection.COMMAND_ALIASES));
		this.setMinArguments(0);
		this.setPermission(Permissions.Tools.TOOLS_MENU);
		this.setDescription(Lang.of("Commands.Tools_Description"));
	}

	@Override
	protected void onCommand() {
		this.checkConsole();

		new ToolMenu(null).displayTo(this.getPlayer());
	}
}
