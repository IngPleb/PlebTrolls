package com.staxzs.staxzstrolls.settings;

import org.bukkit.entity.EntityType;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.CompSound;
import org.mineacademy.fo.settings.Lang;
import org.mineacademy.fo.settings.SimpleSettings;
import org.mineacademy.fo.settings.YamlStaticConfig;

import java.util.List;
import java.util.Set;

/**
 * A sample settings class, utilizing {@link YamlStaticConfig} with prebuilt settings.yml handler
 * with a bunch of preconfigured keys, see resources/settings.yml
 * <p>
 * Foundation detects if you have "settings.yml" placed in your jar (in src/main/resources in source)
 * and will load this class automatically. The same goes for the {@link Lang} class which is
 * automatically loaded when we detect the presence of at least one localization/messages_X.yml
 * file in your jar.
 */
@SuppressWarnings("unused")
public final class Settings extends SimpleSettings {

	public static Boolean SILENT_START;

	/*
	 * Automatically called method when we load settings.yml to load values in this class
	 *
	 * See above for usage.
	 */
	private static void init() {
		setPathPrefix(null);

		SILENT_START = getBoolean("Silent_Start");
	}

	/**
	 * @see org.mineacademy.fo.settings.SimpleSettings#getConfigVersion()
	 */
	@Override
	protected int getConfigVersion() {
		return 1;
	}

	/**
	 * Place the sections where user can create new "key: value" pairs
	 * here so that they are not removed while adding comments.
	 * <p>
	 * Example use in ChatControl: user can add new channels in "Channels.List"
	 * section so we place "Channels.List" here.
	 *
	 * @return the ignored sections
	 */
	@Override
	protected List<String> getUncommentedSections() {
		return List.of(
				"Example.Uncommented_Section");
	}

	public static class TrollSection {
		public static String PATH_PREFIX = "Trolls";

		public static Set<String> COMMAND_ALIASES;

		public static Boolean IGNORE_IMMUNITY;

		public static Boolean LOG_TROLLS;

		public static Boolean FILTER_BY_PERMISSION;

		public static Integer IGNITE_DURATION;

		public static Integer EXPLODE_POWER;

		public static String SCREAM_SOUND;
		public static Integer SCREAM_VOLUME;

		public static EntityType AMBUSH_ENTITY_TYPE;

		public static Integer AMBUSH_ENTITY_AMOUNT;

		public static CompMaterial FILL_INVENTORY_ITEM_TYPE;

		public static Integer FILL_INVENTORY_ITEM_AMOUNT;

		public static String SPAM_CHAT_MESSAGE;

		public static Integer RANDOM_TELEPORT_RADIUS;

		public static String FAKE_BAN_MESSAGE;

		public static Integer ANVIL_RAIN_HEIGHT;

		public static Integer SLOWNESS_AMPLIFIER;

		public static Integer LEVITATION_AMPLIFIER;

		public static Integer POISON_DURATION;

		public static Integer POISON_AMPLIFIER;

		public static Integer STAMPEDE_AMOUNT;

		public static Integer HOUND_ATTACK_AMOUNT;

		public static String[] REPLACE_MESSAGES;

		private static void init() {
			setPathPrefix(PATH_PREFIX);

			COMMAND_ALIASES = getSet("Command_Aliases", String.class);

			IGNORE_IMMUNITY = getBoolean("Ignore_Immunity");

			LOG_TROLLS = getBoolean("Log_Trolls");

			FILTER_BY_PERMISSION = getBoolean("Filter_By_Permission");

			IGNITE_DURATION = getInteger("Ignite_Duration");

			EXPLODE_POWER = getInteger("Explosion_Power");

			SCREAM_SOUND = getString("Scream_Sound");
			SCREAM_VOLUME = getInteger("Scream_Volume");

			AMBUSH_ENTITY_TYPE = get("Ambush_Entity_Type", EntityType.class);
			AMBUSH_ENTITY_AMOUNT = getInteger("Ambush_Entity_Amount");

			FILL_INVENTORY_ITEM_TYPE = get("Fill_Inventory.Material", CompMaterial.class);
			FILL_INVENTORY_ITEM_AMOUNT = getInteger("Fill_Inventory.Amount");

			SPAM_CHAT_MESSAGE = getString("Spam_Chat_Message");

			RANDOM_TELEPORT_RADIUS = getInteger("Random_Teleport_Radius");

			FAKE_BAN_MESSAGE = getString("Fake_Ban_Message");

			ANVIL_RAIN_HEIGHT = getInteger("Anvil_Rain_Height");

			SLOWNESS_AMPLIFIER = getInteger("Slowness_Amplifier");

			LEVITATION_AMPLIFIER = getInteger("Levitation_Amplifier");

			POISON_DURATION = getInteger("Poison_Duration");

			POISON_AMPLIFIER = getInteger("Poison_Amplifier");

			STAMPEDE_AMOUNT = getInteger("Stampede_Amount");

			HOUND_ATTACK_AMOUNT = getInteger("Hound_Attack_Amount");

			REPLACE_MESSAGES = get("Replace_Messages", String[].class);
		}


		/**
		 * Section for troll icons
		 */
		public static class IconsSection {
			public static String PATH_PREFIX = TrollSection.PATH_PREFIX + ".Icons";

			public static String LAUNCH_PLAYER;
			public static String CREEPER_HISS;
			public static String LIGHTNING_STRIKE;

			public static String IGNITE_PLAYER;

			public static String EXPLODE_PLAYER;

			public static CompMaterial SCREAM;

			public static String AMBUSH_PLAYER;

			public static String FILL_INVENTORY;

			public static CompMaterial DIP_IN_LAVA;

			public static CompMaterial CLEAR_INVENTORY;

			public static CompMaterial SPAM_CHAT;

			public static CompMaterial TURN_PLAYER;

			public static CompMaterial DROP_INVENTORY;

			public static CompMaterial FAKE_OP;

			public static CompMaterial FAKE_CRASH;

			public static CompMaterial KILL_PLAYER;

			public static CompMaterial SLINGSHOT_PLAYER;

			public static CompMaterial ABYSS;

			public static CompMaterial BLINDNESS;

			public static CompMaterial RANDOM_TELEPORT;

			public static CompMaterial LAG_BEHIND;

			public static CompMaterial PUMPKIN;

			public static CompMaterial NO_ITEM_DROP;

			public static CompMaterial OPEN_RANDOM_INVENTORY;

			public static CompMaterial FAKE_BAN;

			public static CompMaterial COBWEB;

			public static CompMaterial NO_BUILD_AND_BREAK;

			public static CompMaterial FREEZE_PLAYER;

			public static CompMaterial TELEPORT_TO_SUN;

			public static CompMaterial OBSIDIAN_CAGE;

			public static CompMaterial SWAP;

			public static CompMaterial NO_CHEST;

			public static CompMaterial ANVIL_RAIN;

			public static CompMaterial SHUFFLE_INVENTORY;

			public static CompMaterial SPAWN_CREEPER;

			public static CompMaterial NO_ITEM_PICKUP;

			public static CompMaterial DISABLE_GRAVITY;

			public static CompMaterial DISARM;

			public static CompMaterial REVERSE_MESSAGES;

			public static CompMaterial SEND_MESSAGE;

			public static CompMaterial POTATO;

			public static CompMaterial SLOWNESS;

			public static CompMaterial LEVITATION;

			public static CompMaterial CLEAR_ARMOUR;

			public static CompMaterial NEAR_DEATH;

			public static CompMaterial POISON;

			public static CompMaterial DIP_IN_WATER;

			public static CompMaterial ALONE;

			public static CompMaterial FIREBALL;

			public static CompMaterial STAMPEDE;

			public static CompMaterial SUFFOCATE;

			public static CompMaterial HOUND_ATTACK;

			public static CompMaterial LOCK_HAND;

			public static CompMaterial TELEPORT_ALL;

			public static CompMaterial FAKE_MONEY;

			public static CompMaterial RING_OF_FIRE;

			public static CompMaterial TNT_TRAP;

			public static CompMaterial EXPLODE_BLOCK;

			public static CompMaterial GIBBERISH_MESSAGES;

			public static CompMaterial REPLACE_MESSAGES;

			public static CompMaterial GUARDIAN;

			private static void init() {
				setPathPrefix(PATH_PREFIX);

				LAUNCH_PLAYER = getString("Launch_Player");
				CREEPER_HISS = getString("Creeper_Hiss");
				LIGHTNING_STRIKE = getString("Lightning_Strike");
				IGNITE_PLAYER = getString("Ignite_Player");
				EXPLODE_PLAYER = getString("Explode_Player");
				SCREAM = get("Scream", CompMaterial.class);
				AMBUSH_PLAYER = getString("Ambush_Player");
				FILL_INVENTORY = getString("Fill_Inventory");
				DIP_IN_LAVA = get("Dip_In_Lava", CompMaterial.class);
				CLEAR_INVENTORY = get("Clear_Inventory", CompMaterial.class);
				SPAM_CHAT = get("Spam_Chat", CompMaterial.class);
				TURN_PLAYER = get("Turn_Player", CompMaterial.class);
				DROP_INVENTORY = get("Drop_Inventory", CompMaterial.class);
				FAKE_OP = get("Fake_Op", CompMaterial.class);
				FAKE_CRASH = get("Fake_Crash", CompMaterial.class);
				KILL_PLAYER = get("Kill_Player", CompMaterial.class);
				SLINGSHOT_PLAYER = get("Slingshot_Player", CompMaterial.class);
				ABYSS = get("Abyss", CompMaterial.class);
				BLINDNESS = get("Blindness", CompMaterial.class);
				RANDOM_TELEPORT = get("Random_Teleport", CompMaterial.class);
				LAG_BEHIND = get("Lag_Behind", CompMaterial.class);
				PUMPKIN = get("Pumpkin", CompMaterial.class);
				NO_ITEM_DROP = get("No_Item_Drop", CompMaterial.class);
				OPEN_RANDOM_INVENTORY = get("Open_Random_Inventory", CompMaterial.class);
				FAKE_BAN = get("Fake_Ban", CompMaterial.class);
				COBWEB = get("Cobweb", CompMaterial.class);
				NO_BUILD_AND_BREAK = get("No_Build_And_Break", CompMaterial.class);
				FREEZE_PLAYER = get("Freeze_Player", CompMaterial.class);
				TELEPORT_TO_SUN = get("Teleport_To_Sun", CompMaterial.class);
				OBSIDIAN_CAGE = get("Obsidian_Cage", CompMaterial.class);
				SWAP = get("Swap", CompMaterial.class);
				NO_CHEST = get("No_Chest", CompMaterial.class);
				ANVIL_RAIN = get("Anvil_Rain", CompMaterial.class);
				SHUFFLE_INVENTORY = get("Shuffle_Inventory", CompMaterial.class);
				SPAWN_CREEPER = get("Spawn_Creeper", CompMaterial.class);
				NO_ITEM_PICKUP = get("No_Item_Pickup", CompMaterial.class);
				DISABLE_GRAVITY = get("Disable_Gravity", CompMaterial.class);
				DISARM = get("Disarm", CompMaterial.class);
				REVERSE_MESSAGES = get("Reverse_Messages", CompMaterial.class);
				SEND_MESSAGE = get("Send_Message", CompMaterial.class);
				POTATO = get("Potato", CompMaterial.class);
				SLOWNESS = get("Slowness", CompMaterial.class);
				LEVITATION = get("Levitation", CompMaterial.class);
				CLEAR_ARMOUR = get("Clear_Armour", CompMaterial.class);
				NEAR_DEATH = get("Near_Death", CompMaterial.class);
				POISON = get("Poison", CompMaterial.class);
				DIP_IN_WATER = get("Dip_In_Water", CompMaterial.class);
				ALONE = get("Alone", CompMaterial.class);
				FIREBALL = get("Fireball", CompMaterial.class);
				STAMPEDE = get("Stampede", CompMaterial.class);
				SUFFOCATE = get("Suffocate", CompMaterial.class);
				HOUND_ATTACK = get("Hound_Attack", CompMaterial.class);
				LOCK_HAND = get("Lock_Hand", CompMaterial.class);
				TELEPORT_ALL = get("Teleport_All", CompMaterial.class);
				FAKE_MONEY = get("Fake_Money", CompMaterial.class);
				RING_OF_FIRE = get("Ring_Of_Fire", CompMaterial.class);
				TNT_TRAP = get("Tnt_Trap", CompMaterial.class);
				EXPLODE_BLOCK = get("Explode_Block", CompMaterial.class);
				GIBBERISH_MESSAGES = get("Gibberish_Messages", CompMaterial.class);
				REPLACE_MESSAGES = get("Replace_Messages", CompMaterial.class);
				GUARDIAN = get("Guardian", CompMaterial.class);
			}
		}
	}

	public static class ToolSection {
		public static String PATH_PREFIX = "Tool";

		public static String[] COMMAND_ALIASES;

		public static CompMaterial TOOL_MENU_MATERIAL;

		private static void init() {
			setPathPrefix(PATH_PREFIX);

			COMMAND_ALIASES = get("Command_Aliases", String[].class);
			TOOL_MENU_MATERIAL = get("Tool_Menu_Material", CompMaterial.class);
		}

		public static class SmiteTool {

			public static CompMaterial MATERIAL;

			public static String NAME;

			public static String[] LORE;

			private static void init() {
				setPathPrefix(ToolSection.PATH_PREFIX + ".Smite_Tool");

				MATERIAL = get("Material", CompMaterial.class);
				NAME = getString("Name");
				LORE = get("Lore", String[].class);
			}
		}

		public static class ExplodeTool {

			public static CompMaterial MATERIAL;

			public static String NAME;

			public static String[] LORE;

			public static Integer POWER;

			private static void init() {
				setPathPrefix(ToolSection.PATH_PREFIX + ".Explode_Tool");

				MATERIAL = get("Material", CompMaterial.class);
				NAME = getString("Name");
				LORE = get("Lore", String[].class);
				POWER = getInteger("Power");
			}
		}

		public static class RepulsorTool {

			public static CompMaterial MATERIAL;
			public static String NAME;
			public static String[] LORE;
			public static Integer RADIUS;
			public static Integer FORCE;
			public static Boolean PLAY_SOUND;
			public static CompSound SOUND;

			private static void init() {
				setPathPrefix(ToolSection.PATH_PREFIX + ".Repulsor_Tool");

				MATERIAL = get("Material", CompMaterial.class);
				NAME = getString("Name");
				LORE = get("Lore", String[].class);
				RADIUS = getInteger("Radius");
				FORCE = getInteger("Force");
				PLAY_SOUND = getBoolean("Play_Sound");
				SOUND = get("Sound", CompSound.class);
			}
		}

		public static class SpawnCreeperTool {

			public static CompMaterial MATERIAL;
			public static String NAME;
			public static String[] LORE;

			private static void init() {
				setPathPrefix(ToolSection.PATH_PREFIX + ".Spawn_Creeper_Tool");

				MATERIAL = get("Material", CompMaterial.class);
				NAME = getString("Name");
				LORE = get("Lore", String[].class);
			}
		}
	}
}
