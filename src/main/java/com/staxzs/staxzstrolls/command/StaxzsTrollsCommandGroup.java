package com.staxzs.staxzstrolls.command;

import com.staxzs.staxzstrolls.model.Permissions;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bukkit.ChatColor;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.command.DebugCommand;
import org.mineacademy.fo.command.PermsCommand;
import org.mineacademy.fo.command.ReloadCommand;
import org.mineacademy.fo.command.SimpleCommandGroup;

@AutoRegister
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public final class StaxzsTrollsCommandGroup extends SimpleCommandGroup {

	@Override
	protected String getHeaderPrefix() {
		return "" + ChatColor.GREEN + ChatColor.BOLD;
	}

	@Override
	protected String getCredits() {
		return ChatColor.GRAY + "Visit " + ChatColor.WHITE + "www.staxzs.com" + ChatColor.GRAY + " for more information."; // TODO: Change to real website
	}

	@Override
	protected ChatColor getTheme() {
		return ChatColor.GREEN;
	}

	@Override
	protected void registerSubcommands() {
		this.registerSubcommand(new PermsCommand(Permissions.class, Permissions.Command.PERMS));
		this.registerSubcommand(new DebugCommand(Permissions.Command.DEBUG));
		this.registerSubcommand(new ReloadCommand(Permissions.Command.RELOAD));
	}
}
