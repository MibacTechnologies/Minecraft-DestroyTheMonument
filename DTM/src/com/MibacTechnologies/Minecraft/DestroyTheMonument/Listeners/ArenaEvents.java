package com.MibacTechnologies.Minecraft.DestroyTheMonument.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.ArenaBlockBreakEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Player.ArenaPlayerJoinEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Player.ArenaPlayerLeaveEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 30 Jan 2015 (16:45:33)
 */
public class ArenaEvents implements Listener {

	@EventHandler ( priority = EventPriority.MONITOR )
	public void leave ( final ArenaPlayerLeaveEvent e ) {
		//TODO
		Arena a = e.getArena( );
		DTMPlayer p = e.getDTMPlayer( );

		a.removePlayer( p );
	}

	@EventHandler ( priority = EventPriority.MONITOR )
	public void join ( final ArenaPlayerJoinEvent e ) {
		//TODO
	}

	@EventHandler ( priority = EventPriority.MONITOR )
	public void blockBreak ( final ArenaBlockBreakEvent e ) {
		//TODO
	}
}
