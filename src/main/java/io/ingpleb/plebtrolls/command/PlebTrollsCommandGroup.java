package io.ingpleb.plebtrolls.command;

import io.ingpleb.plebtrolls.model.Permissions;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bukkit.ChatColor;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.command.DebugCommand;
import org.mineacademy.fo.command.PermsCommand;
import org.mineacademy.fo.command.ReloadCommand;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.settings.Lang;

@AutoRegister
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@SuppressWarnings("unused")
public final class PlebTrollsCommandGroup extends SimpleCommandGroup {

	@Override
	protected String getHeaderPrefix() {
		return "" + ChatColor.GREEN + ChatColor.BOLD;
	}

	@Override
	protected String getCredits() {
		return Lang.of("Commands.Label_Credits")
				.replace("{link}", "github.com/ingpleb");
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
