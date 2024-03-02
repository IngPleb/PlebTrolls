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
	@PermissionGroup("Execute main plugin command.")
	public static final class Command {

		@Permission("Open the troll menu for a player or troll them directly.")
		public static final String TROLL = "staxzstrolls.command.troll";

		@Permission("Reload the plugin.")
		public static final String RELOAD = "staxzstrolls.command.reload";

		@Permission("Permission management.")
		public static final String PERMS = "staxzstrolls.command.perms";

		@Permission("Debug the plugin.")
		public static final String DEBUG = "staxzstrolls.command.debug";
	}

	@PermissionGroup("Troll permissions")
	public static final class Troll {
		@Permission("Launch the player into the air")
		public static final String LAUNCH = "staxzstrolls.troll.launch";

		@Permission("Creeper hiss at the player")
		public static final String CREEPER_HISS = "staxzstrolls.troll.creeperhiss";

		@Permission("Strike the player with lightning")
		public static final String LIGHTNING_STRIKE = "staxzstrolls.troll.lightning_strike";

		@Permission("Ignite the player")
		public static final String IGNITE_PLAYER = "staxzstrolls.troll.ignite_player";

		@Permission("Explode the player")
		public static final String EXPLODE_PLAYER = "staxzstrolls.troll.explode_player";

		@Permission("Scream at the player")
		public static final String SCREAM_PLAYER = "staxzstrolls.troll.scream_player";

		@Permission("Ambush the player")
		public static final String AMBUSH_PLAYER = "staxzstrolls.troll.ambush_player";

		@Permission("Fill the player's inventory")
		public static final String FILL_INVENTORY = "staxzstrolls.troll.fill_inventory";

		@Permission("Dip the player in lava")
		public static final String DIP_IN_LAVA = "staxzstrolls.troll.dip_in_lava";

		@Permission("Clear the player's inventory")
		public static final String CLEAR_INVENTORY = "staxzstrolls.troll.clear_inventory";

	}
}
