package me.mrgeneralq.servertickets.utils;

import org.bukkit.ChatColor;

public class ColorUtils {
	
	private ColorUtils() {}
	
	public static String toColor(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

}
