package com.staxzs.staxzstrolls.troll;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.Messenger;
import org.mineacademy.fo.PlayerUtil;
import org.mineacademy.fo.collection.StrictSet;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompItemFlag;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a Troll in the game.
 * It contains methods to register, deregister, and execute trolls.
 * It also contains event handlers for various game events.
 */
@Getter
@EqualsAndHashCode(of = "name")
public abstract class Troll {

	private static final StrictSet<Troll> REGISTERED_TROLLS = new StrictSet<>();

	final String name;
	final String displayName;
	final String description;
	final String permission;
	final CompMaterial icon;

	/**
	 * Constructor for creating a Troll with a name, permission, and icon.
	 */
	protected Troll(String name, String permission, CompMaterial icon) {
		this(name, getDisplayNameFromName(name), getDescriptionFromName(name), permission, icon);
	}

	/**
	 * Constructor for creating a Troll with a name, display name, description, permission, and icon.
	 */
	protected Troll(String name, String displayName, String description, String permission, CompMaterial icon) {
		this.name = name;
		this.displayName = displayName;
		this.description = description;
		this.permission = permission;
		this.icon = icon;
	}

	/**
	 * Returns a set of all registered trolls.
	 */
	public static Set<Troll> getRegisteredTrolls() {
		return REGISTERED_TROLLS.getSource();
	}

	/**
	 * Returns a set of all registered trolls that a player has permission for.
	 */
	public static Set<Troll> getRegisteredTrollsByPlayer(Player player) {
		Set<Troll> trolls = new HashSet<>();
		for (Troll troll : REGISTERED_TROLLS) {
			if (PlayerUtil.hasPerm(player, troll.getPermission())) {
				trolls.add(troll);
			}
		}
		return trolls;
	}

	//////////////////////////////
	// Static
	//////////////////////////////

	public static void registerTroll(Troll troll) {
		REGISTERED_TROLLS.add(troll);
	}

	public static void registerAllTrolls() {
		registerTroll(new CreeperHissTroll());
		registerTroll(new LaunchTroll());
		registerTroll(new LightingStrikeTroll());
		registerTroll(new IgniteTroll());
		registerTroll(new ExplodeTroll());
		registerTroll(new ScreamTroll());
		registerTroll(new AmbushTroll());
		registerTroll(new FillInventoryTroll());
		registerTroll(new DipInLavaTroll());
		registerTroll(new ClearInventoryTroll());
		registerTroll(new SpamChatTroll());
		registerTroll(new TurnTroll());
		registerTroll(new DropInventoryTroll());
		registerTroll(new FakeOPTroll());
		registerTroll(new FakeCrashTroll());
		registerTroll(new KillTroll());
		registerTroll(new SlingshotTroll());
		registerTroll(new AbyssTroll());
		registerTroll(new BlindnessTroll());
		registerTroll(new RandomTeleportTroll());
		registerTroll(new LagBehindTroll());
		registerTroll(new PumpkinTroll());
		registerTroll(new NoItemDropTroll());
		registerTroll(new OpenRandomInvTroll());
		registerTroll(new FakeBanTroll());
		registerTroll(new CobwebTroll());
		registerTroll(new NoBuildAndBreakTroll());
		registerTroll(new FreezeTroll());
		registerTroll(new TeleportToSunTroll());
		registerTroll(new ObsidianCageTroll());
		registerTroll(new SwapTroll());
		registerTroll(new NoChestTroll());
		registerTroll(new AnvilRainTroll());
		registerTroll(new ShuffleInventoryTroll());
		registerTroll(new SpawnCreeperTroll());
		registerTroll(new NoItemPickUpTroll());
		registerTroll(new DisableGravityTroll());
		registerTroll(new DisarmTroll());
		registerTroll(new ReverseMessagesTroll());
		registerTroll(new SendMessageTroll());
		registerTroll(new PotatoTroll());
		registerTroll(new SlownessTroll());
		registerTroll(new LevitationTroll());
		registerTroll(new ClearArmourTroll());
		registerTroll(new NearDeathTroll());
		registerTroll(new PoisonTroll());
		registerTroll(new DipInWaterTroll());
		registerTroll(new AloneTroll());
		registerTroll(new FireballTroll());
		registerTroll(new StampedeTroll());
		registerTroll(new SuffocateTroll());
		registerTroll(new HoundAttackTroll());
		registerTroll(new LockHandTroll());
		registerTroll(new TeleportAllTroll());
		registerTroll(new FakeMoneyTroll());
		registerTroll(new RingOfFireTroll());
		registerTroll(new TNTTrapTroll());
		registerTroll(new ExplodeBlockTroll());
		registerTroll(new GibberishMessagesTroll());
		registerTroll(new ReplaceMessagesTroll());
		registerTroll(new GuardianTroll());
	}

	public static void deregisterAllTrolls() {
		for (Troll troll : REGISTERED_TROLLS)
			troll.onDeregister();

		REGISTERED_TROLLS.clear();
	}

	/**
	 * This method is used to get a Troll object from its name.
	 * It iterates over all registered trolls and returns the one with the matching name.
	 * If no troll with the given name is found, it returns null.
	 *
	 * @param name The name of the troll to be retrieved.
	 * @return The Troll object with the given name, or null if no such troll is found.
	 */
	public static Troll fromName(String name) {
		for (Troll troll : REGISTERED_TROLLS)
			if (troll.getName().equalsIgnoreCase(name))
				return troll;

		return null;
	}

	/**
	 * This method is used to format a given name into a specific key format.
	 * The name is split into words, each word is capitalized, and then the words are joined back together with underscores.
	 *
	 * @param name The name to be formatted.
	 * @return The formatted key string.
	 */
	private static String getKeyFromName(String name) {
		// Split the string into words
		String[] words = name.split("_");

		// Capitalize each word
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
		}

		// Join the words back together with underscores
		return String.join("_", words);
	}

	private static String getDisplayNameFromName(String name) {
		String key = getKeyFromName(name);

		String path = "Trolls." + key + ".Display_Name";

		return Lang.of(path);
	}

	private static String getDescriptionFromName(String name) {
		String key = getKeyFromName(name);

		String path = "Trolls." + key + ".Description";

		return Lang.of(path);
	}

	//////////////////////////////
	// Instance methods
	//////////////////////////////

	/**
	 * This method is used to execute a troll on a target player.
	 * It first checks if the sender has the required permission to execute the troll.
	 * If the sender does not have the required permission, an error message is sent to the sender and the method returns.
	 * If the target player has immunity, an error message is sent to the sender and the method returns.
	 * If the troll is successfully executed, a success message is sent to the sender.
	 * If it is not successfully executed, an error message is sent to the sender.
	 *
	 * @param sender The CommandSender who is trying to execute the troll.
	 * @param target The Player who is the target of the troll.
	 */
	public final void executeTroll(CommandSender sender, Player target) {

		// Check permission
		if (!PlayerUtil.hasPerm(sender, this.permission)) {
			Messenger.error(sender, Lang.of("No_Permission").replace("{permission}", this.permission));
			return;
		}

		// Check immunity
		if (!Settings.TrollSection.IGNORE_IMMUNITY && PlayerUtil.hasPerm(target, Permissions.IMMUNITY)) {
			Messenger.error(sender, Lang.of("Immune")
					.replace("{target_name}", target.getName()));
			return;
		}

		// Log the troll
		if (Settings.TrollSection.LOG_TROLLS) {
			Common.log(Lang.of("Trolls.Log_Message")
					.replace("{troll_name}", this.displayName)
					.replace("{sender_name}", sender.getName())
					.replace("{target_name}", target.getName()));
		}

		Tuple<Boolean, String> finalResult;
		Tuple<Boolean, String> actionResult = this.performTroll(sender, target);

		if (actionResult != null)
			finalResult = actionResult;
		else
			finalResult = new Tuple<>(true, this.getExecuteMessage(target));


		boolean success = finalResult.getKey();
		String message = finalResult.getValue();

		if (message == null)
			return;

		if (success)
			Messenger.success(sender, message);
		else
			Messenger.error(sender, message);
	}

	/**
	 * This is an abstract method that must be implemented by any class that extends the Troll class.
	 * It is used to perform the specific actions of a troll on a target player.
	 * The method returns a Tuple where the Boolean indicates the success of the troll execution and the String provides a message about the execution.
	 * The specific implementation of this method will depend on the type of troll being executed.
	 *
	 * @param sender The CommandSender who is trying to execute the troll.
	 * @param target The Player who is the target of the troll.
	 * @return A Tuple where the Boolean indicates the success of the troll execution and the String provides a message about the execution.
	 */
	protected abstract Tuple<Boolean, String> performTroll(CommandSender sender, Player target);

	public void onDeregister() {
		// Override if needed
	}

	/**
	 * This method is used to generate a message for the execution of a troll.
	 * It uses the display name of the troll and the name of the target player to create the message.
	 * The message is retrieved from a language file and placeholders in the message are replaced with the troll's display name and the target player's name.
	 *
	 * @param target The Player who is the target of the troll.
	 * @return A String containing the message for the execution of the troll.
	 */
	protected String getExecuteMessage(Player target) {
		return Lang.of("Trolls.Execute_Message")
				.replace("{troll_name}", this.displayName)
				.replace("{target_name}", target.getName());
	}

	/**
	 * This method is used to create an ItemStack representing the troll.
	 * The ItemStack is created with the icon of the troll, the display name of the troll, and the description of the troll.
	 * The ItemStack also has the HIDE_ATTRIBUTES flag set, which means that any attributes of the item (such as attack damage or speed) will not be displayed.
	 *
	 * @param target The Player who is the target of the troll.
	 * @return An ItemStack representing the troll.
	 */
	public ItemStack getItemStack(Player target) {
		ItemCreator creator = ItemCreator.of(this.getIcon())
				.name(this.getDisplayName())
				.lore("", this.getDescription())
				.flags(CompItemFlag.HIDE_ATTRIBUTES);

		return creator.make();
	}

	//////////////////////////////
	// Events
	//////////////////////////////
	public void onPlayerJoin(PlayerJoinEvent event) {
		// Override if needed
	}

	public void onPlayerQuit(PlayerQuitEvent event) {
		// Override if needed
	}

	public void onInventoryClick(InventoryClickEvent event) {
		// Override if needed
	}

	public void onInventoryOpen(InventoryOpenEvent event) {
		// Override if needed
	}

	public void onPlayerRespawn(PlayerRespawnEvent event) {
		// Override if needed
	}

	public void onBlockPlace(BlockPlaceEvent event) {
		// Override if needed
	}

	public void onBlockBreak(BlockBreakEvent event) {
		// Override if needed
	}

	public void onEntityPickupItem(EntityPickupItemEvent event) {
		// Override if needed
	}

	public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
		// Override if needed
	}

	public void onPlayerItemHeld(PlayerItemHeldEvent event) {
		// Override if needed
	}
}
