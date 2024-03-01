package com.staxzs.staxzstrolls.settings;

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

		private static void init() {
			setPathPrefix(PATH_PREFIX);
		}

		public static class IconsSection {
			public static String PATH_PREFIX = TrollSection.PATH_PREFIX + ".Icons";

			public static String LAUNCH_PLAYER;
			public static String CREEPER_HISS;
			public static String LIGHTNING_STRIKE;

			private static void init() {
				setPathPrefix(PATH_PREFIX);

				LAUNCH_PLAYER = getString("Launch_Player");
				CREEPER_HISS = getString("Creeper_Hiss");
				LIGHTNING_STRIKE = getString("Lightning_Strike");
			}
		}
	}
}
