package com.staxzs.staxzstrolls.settings;

import org.bukkit.entity.EntityType;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;
import org.mineacademy.fo.settings.SimpleSettings;
import org.mineacademy.fo.settings.YamlStaticConfig;

import java.util.Arrays;
import java.util.List;

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
		return Arrays.asList(
				"Example.Uncommented_Section");
	}

	public static class TrollSection {
		public static String PATH_PREFIX = "Trolls";

		public static Integer IGNITE_DURATION;

		public static Integer EXPLODE_POWER;

		public static String SCREAM_SOUND;
		public static Integer SCREAM_VOLUME;

		public static EntityType AMBUSH_ENTITY_TYPE;

		public static Integer AMBUSH_ENTITY_AMOUNT;

		public static CompMaterial FILL_INVENTORY_ITEM_TYPE;

		public static Integer FILL_INVENTORY_ITEM_AMOUNT;

		public static String SPAM_CHAT_MESSAGE;

		public static Integer BLINDNESS_DURATION;

		public static Integer RANDOM_TELEPORT_RADIUS;

		public static String FAKE_BAN_MESSAGE;

		public static Integer ANVIL_RAIN_HEIGHT;

		private static void init() {
			setPathPrefix(PATH_PREFIX);

			IGNITE_DURATION = getInteger("Ignite_Duration");

			EXPLODE_POWER = getInteger("Explosion_Power");

			SCREAM_SOUND = getString("Scream_Sound");
			SCREAM_VOLUME = getInteger("Scream_Volume");

			AMBUSH_ENTITY_TYPE = get("Ambush_Entity_Type", EntityType.class);
			AMBUSH_ENTITY_AMOUNT = getInteger("Ambush_Entity_Amount");

			FILL_INVENTORY_ITEM_TYPE = get("Fill_Inventory.Material", CompMaterial.class);
			FILL_INVENTORY_ITEM_AMOUNT = getInteger("Fill_Inventory.Amount");

			SPAM_CHAT_MESSAGE = getString("Spam_Chat_Message");

			BLINDNESS_DURATION = getInteger("Blindness_Duration");

			RANDOM_TELEPORT_RADIUS = getInteger("Random_Teleport_Radius");

			FAKE_BAN_MESSAGE = getString("Fake_Ban_Message");

			ANVIL_RAIN_HEIGHT = getInteger("Anvil_Rain_Height");
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

			public static String SCREAM;

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

			private static void init() {
				setPathPrefix(PATH_PREFIX);

				LAUNCH_PLAYER = getString("Launch_Player");
				CREEPER_HISS = getString("Creeper_Hiss");
				LIGHTNING_STRIKE = getString("Lightning_Strike");
				IGNITE_PLAYER = getString("Ignite_Player");
				EXPLODE_PLAYER = getString("Explode_Player");
				SCREAM = getString("Scream");
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
			}
		}
	}
}
