package me.mrgeneralq.servertickets;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.mrgeneralq.servertickets.commands.SosCommand;
import me.mrgeneralq.servertickets.commands.TicketCommand;
import me.mrgeneralq.servertickets.eventlisteners.OnChat;
import me.mrgeneralq.servertickets.eventlisteners.OnPlayerLeave;
import me.mrgeneralq.servertickets.eventlisteners.OnTicketClaim;
import me.mrgeneralq.servertickets.eventlisteners.OnTicketClose;
import me.mrgeneralq.servertickets.eventlisteners.OnTicketCreate;
import me.mrgeneralq.servertickets.eventlisteners.OnTicketReprocess;
import me.mrgeneralq.servertickets.eventlisteners.OnTicketTeleport;
import me.mrgeneralq.servertickets.eventlisteners.OnTicketTogglePrivate;
import me.mrgeneralq.servertickets.statics.Bootstrapper;




public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
			
		Bootstrapper.getBootstrapper().run();
		Bukkit.getPluginCommand("sos").setExecutor(new SosCommand(Bootstrapper.getBootstrapper().getTicketService()));
		Bukkit.getPluginCommand("ticket").setExecutor(new TicketCommand(Bootstrapper.getBootstrapper().getTicketService()));
		
		
		
		// ticket events
		
		Bukkit.getServer().getPluginManager().registerEvents(new OnTicketCreate(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new OnTicketClaim(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new OnTicketTeleport(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new OnTicketClose(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new OnTicketTogglePrivate(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new OnTicketReprocess(), this);
		
		
		
		// bukkit events
		
		Bukkit.getServer().getPluginManager().registerEvents(new OnPlayerLeave(Bootstrapper.getBootstrapper().getTicketService()), this);
		Bukkit.getServer().getPluginManager().registerEvents(new OnChat(Bootstrapper.getBootstrapper().getTicketService()), this);
		
		getLogger().info("Server tickets enabled!");
	}
	
	
	public void onDisable() {
		
	}
	
	
}
