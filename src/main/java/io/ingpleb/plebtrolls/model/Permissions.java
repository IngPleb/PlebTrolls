package io.ingpleb.plebtrolls.model;

import org.mineacademy.fo.command.PermsCommand;
import org.mineacademy.fo.command.annotation.Permission;
import org.mineacademy.fo.command.annotation.PermissionGroup;

/**
 * A permissions class.
 * <p>
 * You will also be able to use the {@link PermsCommand} to list them automatically
 * if you choose to this class.
 */
public final class Permissions {

	@Permission("Immunity from being trolled.")
	public static final String IMMUNITY = "plebtrolls.immunity";

	@Permission("Teleport to player using the menu.")
	public static final String TELEPORT = "plebtrolls.teleport";

	@Permission("Bring the player to you.")
	public static final String BRING = "plebtrolls.bring";

	/**
	 * A sample permission group for your convenience. The {@link PermissionGroup}
	 * is used in the {@link PermsCommand} for your convenience automatically.
	 */
	@PermissionGroup("Execute main plugin command.")
	public static final class Command {

		@Permission("Open the troll menu for a player or troll them directly.")
		public static final String TROLL = "plebtrolls.command.troll";

		@Permission("Reload the plugin.")
		public static final String RELOAD = "plebtrolls.command.reload";

		@Permission("Permission management.")
		public static final String PERMS = "plebtrolls.command.perms";

		@Permission("Debug the plugin.")
		public static final String DEBUG = "plebtrolls.command.debug";
	}

	@PermissionGroup("Use tools.")
	public static final class Tools {

		@Permission("Open the tools menu.")
		public static final String TOOLS_MENU = "plebtrolls.tools.menu";

		@Permission("Use the smite tool.")
		public static final String SMITE = "plebtrolls.tools.smite";

		@Permission("Use the explode tool.")
		public static final String EXPLODE = "plebtrolls.tools.explode";

		@Permission("Use the repulsor tool.")
		public static final String REPULSOR = "plebtrolls.tools.repulsor";

		@Permission("Use the spawn creeper tool.")
		public static final String SPAWN_CREEPER = "plebtrolls.tools.spawn_creeper";
	}

	@PermissionGroup("Troll permissions")
	public static final class Troll {
		@Permission("Launch the player into the air")
		public static final String LAUNCH = "plebtrolls.troll.launch";

		@Permission("Creeper hiss at the player")
		public static final String CREEPER_HISS = "plebtrolls.troll.creeperhiss";

		@Permission("Strike the player with lightning")
		public static final String LIGHTNING_STRIKE = "plebtrolls.troll.lightning_strike";

		@Permission("Ignite the player")
		public static final String IGNITE_PLAYER = "plebtrolls.troll.ignite_player";

		@Permission("Explode the player")
		public static final String EXPLODE_PLAYER = "plebtrolls.troll.explode_player";

		@Permission("Play a loud scream noise to the player")
		public static final String SCREAM = "plebtrolls.troll.scream";

		@Permission("Ambush the player")
		public static final String AMBUSH_PLAYER = "plebtrolls.troll.ambush_player";

		@Permission("Fill the player's inventory")
		public static final String FILL_INVENTORY = "plebtrolls.troll.fill_inventory";

		@Permission("Dip the player in lava")
		public static final String DIP_IN_LAVA = "plebtrolls.troll.dip_in_lava";

		@Permission("Clear the player's inventory")
		public static final String CLEAR_INVENTORY = "plebtrolls.troll.clear_inventory";

		@Permission("Spam the player's chat")
		public static final String SPAM_CHAT = "plebtrolls.troll.spam_chat";

		@Permission("Turn the player")
		public static final String TURN_PLAYER = "plebtrolls.troll.turn_player";

		@Permission("Drop the player's inventory")
		public static final String DROP_INVENTORY = "plebtrolls.troll.drop_inventory";

		@Permission("Fake OP the player")
		public static final String FAKE_OP = "plebtrolls.troll.fake_op";

		@Permission("Fake crash the player")
		public static final String FAKE_CRASH = "plebtrolls.troll.fake_crash";

		@Permission("Kill the player")
		public static final String KILL_PLAYER = "plebtrolls.troll.kill_player";

		@Permission("Slingshot the player")
		public static final String SLINGSHOT_PLAYER = "plebtrolls.troll.slingshot_player";

		@Permission("Abyss the player")
		public static final String ABYSS = "plebtrolls.troll.abyss_player";

		@Permission("Blind the player")
		public static final String BLINDNESS = "plebtrolls.troll.blindness";

		@Permission("Randomly teleport the player")
		public static final String RANDOM_TELEPORT = "plebtrolls.troll.random_teleport";

		@Permission("Lag behind the player")
		public static final String LAG_BEHIND = "plebtrolls.troll.lag_behind";

		@Permission("Pumpkin the player")
		public static final String PUMPKIN = "plebtrolls.troll.pumpkin";

		@Permission("Don't drop items when mining blocks.")
		public static final String NO_ITEM_DROP = "plebtrolls.troll.random_item_drop";

		@Permission("Open a random inventory for the player")
		public static final String OPEN_RANDOM_INVENTORY = "plebtrolls.troll.open_random_inventory";

		@Permission("Fake ban the player")
		public static final String FAKE_BAN = "plebtrolls.troll.fake_ban";

		@Permission("Cobweb the player")
		public static final String COBWEB = "plebtrolls.troll.cobweb";

		@Permission("No build and break")
		public static final String NO_BUILD_AND_BREAK = "plebtrolls.troll.no_build_and_break";

		@Permission("Freeze the player")
		public static final String FREEZE_PLAYER = "plebtrolls.troll.freeze_player";

		@Permission("Teleport the player to the sun")
		public static final String TELEPORT_TO_SUN = "plebtrolls.troll.teleport_to_sun";

		@Permission("Obsidian cage the player")
		public static final String OBSIDIAN_CAGE = "plebtrolls.troll.obsidian_cage";

		@Permission("Swap with the player")
		public static final String SWAP = "plebtrolls.troll.swap_player";

		@Permission("Disable the player from opening chests")
		public static final String NO_CHEST = "plebtrolls.troll.no_chest";

		@Permission("Fall anvils on the player")
		public static final String ANVIL_RAIN = "plebtrolls.troll.anvil_fall";

		@Permission("Shuffle the player's inventory")
		public static final String SHUFFLE_INVENTORY = "plebtrolls.troll.shuffle_inventory";

		@Permission("Spawn a creeper")
		public static final String SPAWN_CREEPER = "plebtrolls.troll.spawn_creeper";

		@Permission("Make the player unable to pick up items")
		public static final String NO_ITEM_PICKUP = "plebtrolls.troll.no_item_pickup";

		@Permission("Disable gravity for the player")
		public static final String DISABLE_GRAVITY = "plebtrolls.troll.disable_gravity";

		@Permission("Disarm the player")
		public static final String DISARM = "plebtrolls.troll.disarm";

		@Permission("Reverse the player's messages")
		public static final String REVERSE_MESSAGES = "plebtrolls.troll.reverse_messages";

		@Permission("Send a message as the player")
		public static final String SEND_MESSAGE = "plebtrolls.troll.send_message";

		@Permission("Turn the player into a potato")
		public static final String POTATO = "plebtrolls.troll.potato";

		@Permission("Toggle slowness on the player")
		public static final String SLOWNESS = "plebtrolls.troll.slowness";

		@Permission("Make the player levitate")
		public static final String LEVITATION = "plebtrolls.troll.levitation";

		@Permission("Clear the player's armour")
		public static final String CLEAR_ARMOUR = "plebtrolls.troll.clear_armour";

		@Permission("Put your victim down to 1/2 heart")
		public static final String NEAR_DEATH = "plebtrolls.troll.near_death";

		@Permission("Poison the player")
		public static final String POISON = "plebtrolls.troll.poison";

		@Permission("Dip the player in water")
		public static final String DIP_IN_WATER = "plebtrolls.troll.dip_in_water";

		@Permission("Make the player alone")
		public static final String ALONE = "plebtrolls.troll.alone";

		@Permission("Shot a fireball at the player")
		public static final String FIREBALL = "plebtrolls.troll.fireball";

		@Permission("Stampede the player")
		public static final String STAMPEDE = "plebtrolls.troll.stampede";

		@Permission("Suffocate the player")
		public static final String SUFFOCATE = "plebtrolls.troll.suffocate";

		@Permission("Hound attack the player")
		public static final String HOUND_ATTACK = "plebtrolls.troll.hound_attack";

		@Permission("Lock player's hand")
		public static final String LOCK_HAND = "plebtrolls.troll.lock_hand";

		@Permission("Teleport all players to the target.")
		public static final String TELEPORT_ALL = "plebtrolls.troll.teleport_all";

		@Permission("Send fake money messages to the player.")
		public static final String FAKE_MONEY = "plebtrolls.troll.fake_money";

		@Permission("Create a ring of fire around the player.")
		public static final String RING_OF_FIRE = "plebtrolls.troll.ring_of_fire";

		@Permission("Create a simple TNT trap beneath the player.")
		public static final String TNT_TRAP = "plebtrolls.troll.tnt_trap";

		@Permission("Next block mined will explode.")
		public static final String EXPLODE_BLOCK = "plebtrolls.troll.explode_block";

		@Permission("Gibberish the player's messages.")
		public static final String GIBBERISH = "plebtrolls.troll.gibberish";

		@Permission("Replace player's messages with a custom message.")
		public static final String REPLACE_MESSAGE = "plebtrolls.troll.replace_message";

		@Permission("Give the player a guardian jumpscare.")
		public static final String GUARDIAN = "plebtrolls.troll.guardian";
	}
}
