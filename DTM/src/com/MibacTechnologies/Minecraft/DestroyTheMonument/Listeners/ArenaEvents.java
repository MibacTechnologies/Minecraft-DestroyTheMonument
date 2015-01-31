package com.MibacTechnologies.Minecraft.DestroyTheMonument.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.ArenaCreateEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.ArenaBlockBreakEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerDeathEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerJoinEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerLeaveEvent;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 30 Jan 2015 (16:45:33)
 */
public class ArenaEvents implements Listener {
	// -------------------[[ Player  ]]-------------------
	@EventHandler ( priority = EventPriority.MONITOR )
	public void leave ( final ArenaPlayerLeaveEvent e ) {
	}

	@EventHandler ( priority = EventPriority.MONITOR )
	public void join ( final ArenaPlayerJoinEvent e ) {
	}

	@EventHandler ( priority = EventPriority.MONITOR )
	public void kill ( final ArenaPlayerDeathEvent e ) {
	}

	// -------------------[[  Block  ]]-------------------
	@EventHandler ( priority = EventPriority.MONITOR )
	public void blockBreak ( final ArenaBlockBreakEvent e ) { //Not triggered for now - arena bounds not defined
	}

	// -------------------[[  Arena  ]]-------------------
	@EventHandler ( priority = EventPriority.MONITOR )
	public void arenaCreate ( final ArenaCreateEvent e ) {
	}
}
