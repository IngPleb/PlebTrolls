package com.staxzs.staxzstrolls;

import com.staxzs.staxzstrolls.settings.Settings;
import com.staxzs.staxzstrolls.troll.Troll;
import com.staxzs.staxzstrolls.util.FreezePlayerUtil;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

/**
 * The main class of the plugin.
 */
public final class StaxzsTrolls extends SimplePlugin {

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
		Troll.registerAllTrolls();
		FreezePlayerUtil.getINSTANCE().start();
	}

	@Override
	protected void onPluginPreReload() {
		Troll.deregisterAllTrolls();
		FreezePlayerUtil.getINSTANCE().stop();
	}

	/* ------------------------------------------------------------------------------- */
	/* Static */
	/* ------------------------------------------------------------------------------- */

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
		Common.logNoPrefix(divider + "\n"
				+ staxzsLogo + "\n"
				+ productName + "\n"
				+ " " + "\n"
				+ "StaxzsTrolls v" + Settings.VERSION + " by Staxzs (IngPleb)" + "\n"
				+ "If you encounter any issues, use our GitHub Issues!" + "\n"
				+ " " + "\n"
				+ "Enjoy Trolling!" + "\n"
				+ divider);
	}
}
