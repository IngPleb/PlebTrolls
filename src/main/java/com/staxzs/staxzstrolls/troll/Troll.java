package com.staxzs.staxzstrolls.troll;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Messenger;
import org.mineacademy.fo.model.Tuple;

import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode
public abstract class Troll {

	private static final Set<Troll> REGISTERED_TROLLS = new HashSet<>();

	final String name;
	final String displayName;
	final String description;
	final String permission;

	protected Troll(String name, String displayName, String description, String permission) {
		this.name = name;
		this.displayName = displayName;
		this.description = description;
		this.permission = permission;
	}

	public final void executeTroll(CommandSender sender, Player target) {
		String finalMessage = "&7Executed troll " + this.displayName + " &7on &f" + target.getName() + "&7!";
		Tuple<Boolean, String> finalResult = new Tuple<>(true, finalMessage);

		Tuple<Boolean, String> actionResult = this.performTroll(sender, target);
		finalResult = actionResult != null ? actionResult : finalResult;

		boolean success = finalResult.getKey();
		String message = finalResult.getValue();

		if (success)
			Messenger.success(sender, message);
		else
			Messenger.error(sender, message);
	}

	public abstract Tuple<Boolean, String> performTroll(CommandSender sender, Player target);

	//////////////////////////////
	// Static
	//////////////////////////////


	public static Set<Troll> getRegisteredTrolls() {
		return REGISTERED_TROLLS;
	}

	public static void registerTroll(Troll troll) {
		REGISTERED_TROLLS.add(troll);
	}

	public static void initailizeTrolls() {
		registerTroll(new CreeperHissTroll());
		registerTroll(new LaunchTroll());
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

}