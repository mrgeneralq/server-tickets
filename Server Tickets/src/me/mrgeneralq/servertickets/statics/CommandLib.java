package me.mrgeneralq.servertickets.statics;

import java.util.HashMap;

import me.mrgeneralq.servertickets.model.CommandAlias;

abstract class CommandLib {
		
	
	@SuppressWarnings("unused")
	private static HashMap<String, CommandAlias> commandList = new HashMap<String,CommandAlias>();
	
	
	public static void registerCommand(String command, String alias, String permission) {
		
		
		
		
	}

}
