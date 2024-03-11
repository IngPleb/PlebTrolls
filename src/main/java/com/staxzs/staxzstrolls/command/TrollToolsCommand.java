package com.staxzs.staxzstrolls.command;

import com.staxzs.staxzstrolls.menu.ToolMenu;
import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.collection.StrictList;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

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
