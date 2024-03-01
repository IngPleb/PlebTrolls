package com.staxzs.staxzstrolls;

import com.staxzs.staxzstrolls.settings.Settings;
import com.staxzs.staxzstrolls.troll.Troll;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

/**
 * The main class of the plugin.
 */
public final class StaxzsTrolls extends SimplePlugin {

	/**
	 * Automatically perform login ONCE when the plugin starts.
	 */
	@Override
	protected void onPluginStart() {
		if (!Settings.SILENT_START)
			this.consoleGreeting();
	}

	/**
	 * Automatically perform login when the plugin starts and each time it is reloaded.
	 */
	@Override
	protected void onReloadablesStart() {

		// You can check for necessary plugins and disable loading if they are missing
		//Valid.checkBoolean(HookManager.isVaultLoaded(), "You need to install Vault so that we can work with packets, offline player data, prefixes and groups.");

		// Uncomment to load variables
		// Variable.loadVariables();

		Troll.initailizeTrolls();
	}

	@Override
	protected void onPluginPreReload() {

		// Close your database here if you use one
		//YourDatabase.getInstance().close();
	}

	private void consoleGreeting() {

		String staxzsLogo = """
				\u200E \u200E /$$$$$$\u200E \u200E \u200E /$$\u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E\s
				\u200E /$$__\u200E \u200E $$\u200E |\u200E $$\u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E\s
				|\u200E $$\u200E \u200E \\__//$$$$$$\u200E \u200E \u200E \u200E /$$$$$$\u200E \u200E /$$\u200E \u200E \u200E /$$\u200E /$$$$$$$$\u200E \u200E /$$$$$$$
				|\u200E \u200E $$$$$$|_\u200E \u200E $$_/\u200E \u200E \u200E |____\u200E \u200E $$|\u200E \u200E $$\u200E /$$/|____\u200E /$$/\u200E /$$_____/
				\u200E \\____\u200E \u200E $$\u200E |\u200E $$\u200E \u200E \u200E \u200E \u200E \u200E /$$$$$$$\u200E \\\u200E \u200E $$$$/\u200E \u200E \u200E \u200E /$$$$/\u200E |\u200E \u200E $$$$$$\u200E\s
				\u200E /$$\u200E \u200E \\\u200E $$\u200E |\u200E $$\u200E /$$\u200E /$$__\u200E \u200E $$\u200E \u200E >$$\u200E \u200E $$\u200E \u200E \u200E /$$__/\u200E \u200E \u200E \\____\u200E \u200E $$
				|\u200E \u200E $$$$$$/\u200E |\u200E \u200E $$$$/|\u200E \u200E $$$$$$$\u200E /$$/\\\u200E \u200E $$\u200E /$$$$$$$$\u200E /$$$$$$$/
				\u200E \\______/\u200E \u200E \u200E \\___/\u200E \u200E \u200E \\_______/|__/\u200E \u200E \\__/|________/|_______/\u200E\s""";

		String productName = """
				\u200E /$$$$$$$$\u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E /$$\u200E /$$\u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E\s
				|__\u200E \u200E $$__/\u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E |\u200E $$|\u200E $$\u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E \u200E\s
				\u200E \u200E \u200E |\u200E $$\u200E \u200E /$$$$$$\u200E \u200E \u200E /$$$$$$\u200E |\u200E $$|\u200E $$\u200E \u200E /$$$$$$$
				\u200E \u200E \u200E |\u200E $$\u200E /$$__\u200E \u200E $$\u200E /$$__\u200E \u200E $$|\u200E $$|\u200E $$\u200E /$$_____/
				\u200E \u200E \u200E |\u200E $$|\u200E $$\u200E \u200E \\__/|\u200E $$\u200E \u200E \\\u200E $$|\u200E $$|\u200E $$|\u200E \u200E $$$$$$\u200E\s
				\u200E \u200E \u200E |\u200E $$|\u200E $$\u200E \u200E \u200E \u200E \u200E \u200E |\u200E $$\u200E \u200E |\u200E $$|\u200E $$|\u200E $$\u200E \\____\u200E \u200E $$
				\u200E \u200E \u200E |\u200E $$|\u200E $$\u200E \u200E \u200E \u200E \u200E \u200E |\u200E \u200E $$$$$$/|\u200E $$|\u200E $$\u200E /$$$$$$$/
				\u200E \u200E \u200E |__/|__/\u200E \u200E \u200E \u200E \u200E \u200E \u200E \\______/\u200E |__/|__/|_______/\u200E\s""";

		String divider = "\u200E\n" + Common.consoleLineSmooth() + "\n \u200E";

		// Divider
		Common.logNoPrefix(divider);

		// Name of the plugin
		Common.logNoPrefix(staxzsLogo);
		Common.logNoPrefix(productName);

		// Space
		Common.logNoPrefix(" ");

		// Version
		Common.logNoPrefix("StaxzsTrolls v" + Settings.VERSION + " by Staxzs (IngPleb)");
		Common.logNoPrefix("If you encounter any issues, please contact us!"); //TODO add contact info

		// Space
		Common.logNoPrefix(" ");

		// PS
		Common.logNoPrefix("Enjoy Trolling!");

		// Divider
		Common.logNoPrefix(divider);
	}

	/* ------------------------------------------------------------------------------- */
	/* Static */
	/* ------------------------------------------------------------------------------- */

	/**
	 * Return the instance of this plugin, which simply refers to a static
	 * field already created for you in SimplePlugin but casts it to your
	 * specific plugin instance for your convenience.
	 *
	 * @return StaxzsTrolls instance
	 */
	@SuppressWarnings("unused")
	public static StaxzsTrolls getInstance() {
		return (StaxzsTrolls) SimplePlugin.getInstance();
	}
}