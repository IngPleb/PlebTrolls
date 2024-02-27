package com.staxzs.staxzstrolls.model;

import org.mineacademy.fo.command.PermsCommand;
import org.mineacademy.fo.command.annotation.Permission;
import org.mineacademy.fo.command.annotation.PermissionGroup;

/**
 * A sample permissions class. This is the preferred way of keeping all permissions
 * of your plugin in one place.
 * <p>
 * You will also be able to use the {@link PermsCommand} to list them automatically
 * if you choose to this class.
 */
public final class Permissions {

	/**
	 * A sample permission group for your convenience. The {@link PermissionGroup}
	 * is used in the {@link PermsCommand} for your convenience automatically.
	 */
	@PermissionGroup("Execute main plugin command for /{label}.")
	public static final class Command {

		@Permission("Reload the plugin")
		public static final String RELOAD = "staxzstrolls.command.reload";

		@Permission("Permission management")
		public static final String PERMS = "staxzstrolls.command.perms";

		@Permission("Debug the plugin")
		public static final String DEBUG = "staxzstrolls.command.debug";

	}
}
