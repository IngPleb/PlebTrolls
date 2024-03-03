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

		@Permission("Spam the player's chat")
		public static final String SPAM_CHAT = "staxzstrolls.troll.spam_chat";

		@Permission("Turn the player")
		public static final String TURN_PLAYER = "staxzstrolls.troll.turn_player";

		@Permission("Drop the player's inventory")
		public static final String DROP_INVENTORY = "staxzstrolls.troll.drop_inventory";

		@Permission("Fake OP the player")
		public static final String FAKE_OP = "staxzstrolls.troll.fake_op";

		@Permission("Fake crash the player")
		public static final String FAKE_CRASH = "staxzstrolls.troll.fake_crash";

		@Permission("Kill the player")
		public static final String KILL_PLAYER = "staxzstrolls.troll.kill_player";

		@Permission("Slingshot the player")
		public static final String SLINGSHOT_PLAYER = "staxzstrolls.troll.slingshot_player";

		@Permission("Abyss the player")
		public static final String ABYSS = "staxzstrolls.troll.abyss_player";

		@Permission("Blind the player")
		public static final String BLINDNESS = "staxzstrolls.troll.blindness";

		@Permission("Randomly teleport the player")
		public static final String RANDOM_TELEPORT = "staxzstrolls.troll.random_teleport";

		@Permission("Lag behind the player")
		public static final String LAG_BEHIND = "staxzstrolls.troll.lag_behind";

		@Permission("Pumpkin the player")
		public static final String PUMPKIN = "staxzstrolls.troll.pumpkin";

		@Permission("Don't drop items when mining blocks.")
		public static final String NO_ITEM_DROP = "staxzstrolls.troll.random_item_drop";

		@Permission("Open a random inventory for the player")
		public static final String OPEN_RANDOM_INVENTORY = "staxzstrolls.troll.open_random_inventory";

		@Permission("Fake ban the player")
		public static final String FAKE_BAN = "staxzstrolls.troll.fake_ban";

		@Permission("Cobweb the player")
		public static final String COBWEB = "staxzstrolls.troll.cobweb";

	}
}
