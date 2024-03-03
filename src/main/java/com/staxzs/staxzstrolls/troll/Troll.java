package com.staxzs.staxzstrolls.troll;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Messenger;
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
	CompMaterial icon;

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
	}

	public static void deregisterAllTrolls() {
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
		Tuple<Boolean, String> finalResult;
		Tuple<Boolean, String> actionResult = this.performTroll(sender, target);

		if (actionResult != null)
			finalResult = actionResult;
		else
			finalResult = new Tuple<>(true, this.getExecuteMessage(target));


		boolean success = finalResult.getKey();
		String message = finalResult.getValue();

		if (success)
			Messenger.success(sender, message);
		else
			Messenger.error(sender, message);
	}

	protected abstract Tuple<Boolean, String> performTroll(CommandSender sender, Player target);

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

	public void onInventoryClick(InventoryClickEvent event) {
		// Override if needed
	}

	public void onPlayerRespawn(PlayerRespawnEvent event) {
		// Override if needed
	}
}
