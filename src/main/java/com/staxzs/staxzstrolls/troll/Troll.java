package com.staxzs.staxzstrolls.troll;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Messenger;
import org.mineacademy.fo.PlayerUtil;
import org.mineacademy.fo.collection.StrictSet;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.model.Tuple;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;

import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode(of = "name")
public abstract class Troll {

	private static final StrictSet<Troll> REGISTERED_TROLLS = new StrictSet<>();

	final String name;
	final String displayName;
	final String description;
	final String permission;
	final CompMaterial icon;

	protected Troll(String name, String permission, CompMaterial icon) {
		this(name, getDisplayNameFromName(name), getDescriptionFromName(name), permission, icon);
	}

	protected Troll(String name, String displayName, String description, String permission, CompMaterial icon) {
		this.name = name;
		this.displayName = displayName;
		this.description = description;
		this.permission = permission;
		this.icon = icon;
	}

	public static Set<Troll> getRegisteredTrolls() {
		return REGISTERED_TROLLS.getSource();
	}

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
	}

	public static void deregisterAllTrolls() {
		for (Troll troll : REGISTERED_TROLLS)
			troll.onDeregister();

		REGISTERED_TROLLS.clear();
	}

	public static Troll fromName(String name) {
		for (Troll troll : REGISTERED_TROLLS)
			if (troll.getName().equalsIgnoreCase(name))
				return troll;

		return null;
	}

	public static Set<String> getTrollNames() {
		Set<String> names = new HashSet<>();

		for (Troll troll : REGISTERED_TROLLS)
			names.add(troll.getName());

		return names;
	}

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

	public final void executeTroll(CommandSender sender, Player target) {

		// Check permission
		if (!PlayerUtil.hasPerm(sender, this.permission)) {
			Messenger.error(sender, Lang.of("No_Permission").replace("{permission}", this.permission));
			return;
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

	protected abstract Tuple<Boolean, String> performTroll(CommandSender sender, Player target);

	public void onDeregister() {
		// Override if needed
	}

	protected String getExecuteMessage(Player target) {
		return Lang.of("Trolls.Execute_Message")
				.replace("{troll_name}", this.displayName)
				.replace("{target_name}", target.getName());
	}

	public ItemStack getItemStack(Player target) {
		ItemCreator creator = ItemCreator.of(this.getIcon())
				.name(this.getDisplayName())
				.lore("", this.getDescription());

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
}
