package com.MibacTechnologies.Minecraft.DestroyTheMonument.Listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerKickEvent;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTM;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerDeathEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.ArenaPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Utils.BooleanUtils;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 28 Jan 2015 (18:10:57)
 */
public class PlayerEvents implements Listener {
	@EventHandler ( ignoreCancelled = true )
	public void leave ( final PlayerKickEvent e ) {
		DTM.l.info( "\"" + e.getReason( ) + "\"REASON!!!!!!!!!!!!!" );
	}

	@EventHandler
	public void death ( final PlayerDeathEvent e ) {
		DTMPlayer p1 = DTM.PM.getDTMPlayer( e.getEntity( ) );
		DTMPlayer p2 = DTM.PM.getDTMPlayer( e.getEntity( ).getKiller( ) );

		if ( !( p1 != null && p2 != null ) )
			return;

		if ( !p1.isPlaying( ) || !p2.isPlaying( ) )
			return;

		if ( !p1.ap.arena.equals( p2.ap.arena ) )
			return;

		p1.deaths++;
		p2.kills++;

		p1.ap.deaths++;
		p2.ap.kills++;

		DTM.pm.callEvent( new ArenaPlayerDeathEvent( p2, p2, p1.ap.arena ) );
	}

	@EventHandler
	public void attack ( final EntityDamageByEntityEvent e ) {
		Entity e1 = e.getEntity( );
		Entity e2 = e.getDamager( );

		if ( !( e1 instanceof Player ) || !( e2 instanceof Player ) )
			return;

		Player p1 = (Player) e1;
		Player p2 = (Player) e2;

		DTMPlayer victim = DTM.PM.getDTMPlayer( p1 );
		DTMPlayer damager = DTM.PM.getDTMPlayer( p2 );

		if ( victim == null || damager == null )
			return;

		int c = BooleanUtils.countBools( victim.isPlaying( ),
				damager.isPlaying( ) );

		if ( c == 0 )
			return;

		if ( c == 1 ) {
			e.setCancelled( true );
			return;
		}

		ArenaPlayer at1 = victim.ap;
		ArenaPlayer at2 = damager.ap;

		if ( at1.arena != at2.arena ) {
			e.setCancelled( true );
			return;
		}

		if ( at1.team == at2.team ) {
			e.setCancelled( true );
			return;
		}
	}

	@EventHandler
	public void blockBreak ( final BlockBreakEvent e ) {
	}
}
