package io.ingpleb.plebtrolls;

import io.ingpleb.plebtrolls.troll.Troll;
import io.ingpleb.plebtrolls.util.FreezePlayerUtil;
import org.mineacademy.fo.plugin.SimplePlugin;

/**
 * The main class of the plugin.
 */
public final class PlebTrolls extends SimplePlugin {

	/**
	 * Return the instance of this plugin, which simply refers to a static
	 * field already created for you in SimplePlugin but casts it to your
	 * specific plugin instance for your convenience.
	 *
	 * @return PlebTrolls instance
	 */
	@SuppressWarnings("unused")
	public static PlebTrolls getInstance() {
		return (PlebTrolls) SimplePlugin.getInstance();
	}

	/**
	 * Automatically perform login ONCE when the plugin starts.
	 */
	@Override
	protected void onPluginStart() {
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
}
