package com.staxzs.staxzstrolls.menu;

import com.staxzs.staxzstrolls.model.Permissions;
import com.staxzs.staxzstrolls.settings.Settings;
import com.staxzs.staxzstrolls.tool.ExplodeTool;
import com.staxzs.staxzstrolls.tool.RepulsorTool;
import com.staxzs.staxzstrolls.tool.SmiteTool;
import org.mineacademy.fo.Messenger;
import org.mineacademy.fo.PlayerUtil;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.MenuTools;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.settings.Lang;

public final class ToolMenu extends MenuTools {

	public ToolMenu(Menu parent) {
		super(parent);
		this.setTitle(Lang.of("Menu.Tool_Menu.Title"));
		this.setSize(9 * 2);
	}

	public static Button getButton(Menu parentMenu) {
		ItemCreator itemCreator = ItemCreator.of(Settings.ToolSection.TOOL_MENU_MATERIAL)
				.name(Lang.of("Menu.Tool_Menu.Button_Title"))
				.lore(Lang.ofArray("Menu.Tool_Menu.Button_Lore"));

		return Button.makeSimple(itemCreator, player -> {
			if (!PlayerUtil.hasPerm(player, Permissions.Tools.TOOLS_MENU)) {
				Messenger.error(player, Lang.of("No_Permission").replace("{permission}", Permissions.Tools.TOOLS_MENU));
				return;
			}

			new ToolMenu(parentMenu).displayTo(player);
		});
	}

	@Override
	protected Object[] compileTools() {
		return new Object[]{
				SmiteTool.class,
				ExplodeTool.class,
				RepulsorTool.class
		};
	}

	@Override
	protected int getInfoButtonPosition() {
		return this.getSize() - 9;
	}

	@Override
	protected String[] getInfo() {
		return Lang.ofArray("Menu.Tool_Menu.Info");
	}
}
