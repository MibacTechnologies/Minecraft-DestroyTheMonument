package com.MibacTechnologies.Minecraft.DestroyTheMonument.Listeners;

import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTM;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Block.ArenaBlockBreakEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerDamageByEntityEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerDamageByPlayerEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerDeathEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerFallOutOfMapEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerNaturalRespawnEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerRespawnEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerShootBowEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerUnknownDamageEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.ArenaPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Utils.BooleanUtils;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 28 Jan 2015 (18:10:57)
 */
public class PlayerEvents implements Listener {

	//TODO: ArenaLeaveEventCause - doesn't work on this build of bukkit (when doing so, change PlayerQuitEvent on PlayerKickEvent)
	@EventHandler ( ignoreCancelled = true )
	public void leave ( final PlayerQuitEvent e ) {
		DTM.instance( )
				.getLogger( )
				.info( "TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
	}

	@EventHandler
	public void naturalResp ( final PlayerRespawnEvent e ) {
		DTMPlayer player = DTM.PM.getDTMPlayer( e.getPlayer( ) );

		if ( player == null || !player.isPlaying( ) )
			return;

		e.setRespawnLocation( player.ap.arena.getSpawn( player.p ) );

		DTM.pm.callEvent( new ArenaPlayerNaturalRespawnEvent( player ) );
	}

	@EventHandler
	public void death ( final PlayerDeathEvent e ) {
		if ( !valid( e.getEntity( ), e.getEntity( ).getKiller( ) ) )
			return;

		DTMPlayer p1 = DTM.PM.getDTMPlayer( e.getEntity( ) );
		DTMPlayer p2 = DTM.PM.getDTMPlayer( e.getEntity( ).getKiller( ) );

		p1.deaths++;
		p2.kills++;

		p1.ap.deaths++;
		p2.ap.kills++;

		DTM.pm.callEvent( new ArenaPlayerDeathEvent( p1, p2 ) );

		Damageable d = p1.p;
		d.setHealth( d.getMaxHealth( ) );

		DTM.pm.callEvent( new ArenaPlayerRespawnEvent( p1 ) );
	}

	@EventHandler
	public void Void ( final EntityDamageByEntityEvent e ) {
		if ( !( e.getEntity( ) instanceof Player ) )
			return;

		if ( e.getCause( ) != DamageCause.VOID )
			return;

		DTMPlayer p = DTM.PM.getDTMPlayer( (Player) e.getEntity( ) );

		if ( p == null || !p.isPlaying( ) )
			return;

		DTM.pm.callEvent( new ArenaPlayerFallOutOfMapEvent( p ) );
	}

	@EventHandler
	public void pve ( final EntityDamageByEntityEvent e ) {
		//FIXME CONTROL FLOW

		//ArenaPlayerDamageByEntityEvent ae = new ArenaPlayerDamageByEntityEvent(
		//		player, e.getDamager( ), e.getDamage( ) );

		//DTM.pm.callEvent( ae );

		//e.setDamage( ae.getDamage( ) );
		//e.setCancelled( ae.isCancelled( ) );
	}

	@EventHandler
	public void edbeevent ( final EntityDamageByEntityEvent e ) {
		Entity e1 = e.getEntity( );

		if ( !( e1 instanceof Player ) )
			return;

		DTMPlayer victim = DTM.PM.getDTMPlayer( (Player) e1 );

		if ( victim == null )
			return;

		if ( e.getCause( ) == DamageCause.ENTITY_ATTACK ) {

			Entity e2 = e.getDamager( );

			if ( !( e2 instanceof Player ) ) {
				ArenaPlayerDamageByEntityEvent ae = new ArenaPlayerDamageByEntityEvent(
						victim, e2, e.getDamage( ) );

				DTM.pm.callEvent( ae );

				e.setDamage( ae.getDamage( ) );
				e.setCancelled( ae.isCancelled( ) );
				return;
			}

			Player p2 = (Player) e2;

			DTMPlayer damager = DTM.PM.getDTMPlayer( p2 );

			if ( damager == null )
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

			if ( at1.arena != at2.arena || at1.team == at2.team ) {
				e.setCancelled( true );
				return;
			}

			ArenaPlayerDamageByPlayerEvent ae = new ArenaPlayerDamageByPlayerEvent(
					victim, damager, e.getDamage( ) );

			e.setDamage( ae.getDamage( ) );
			e.setCancelled( ae.isCancelled( ) );
		} else if ( e.getCause( ) == DamageCause.VOID ) {
			if ( !victim.isPlaying( ) )
				return;

			DTM.pm.callEvent( new ArenaPlayerFallOutOfMapEvent( victim ) );
		} else {
			if ( !victim.isPlaying( ) )
				return;

			ArenaPlayerUnknownDamageEvent ae = new ArenaPlayerUnknownDamageEvent(
					victim, e.getDamage( ), e.getCause( ), e.isCancelled( ) );

			DTM.pm.callEvent( ae );

			e.setDamage( ae.getDamage( ) );
			e.setCancelled( ae.isCancelled( ) );
		}
	}

	@EventHandler
	public void blockBreak ( final BlockBreakEvent e ) {
		Arena a = DTM.AM.isInBounds( e.getBlock( ).getLocation( ) );

		if ( a == null )
			return;

		ArenaBlockBreakEvent ae = new ArenaBlockBreakEvent(
				DTM.PM.getDTMPlayer( e.getPlayer( ) ), e.getBlock( )
						.getLocation( ) );

		DTM.pm.callEvent( ae );

		e.setCancelled( ae.isCancelled( ) );
	}

	@EventHandler
	public void shoot ( final EntityShootBowEvent e ) {
		if ( !( e.getEntity( ) instanceof Player ) )
			return;

		Player p = (Player) e.getEntity( );
		DTMPlayer dp = DTM.PM.getDTMPlayer( p );

		if ( dp == null || !dp.isPlaying( ) )
			return;

		//Dunno how, just preventing possible errors
		if ( e.getBow( ) == null )
			return;

		ArenaPlayerShootBowEvent ae = new ArenaPlayerShootBowEvent( dp,
				e.getBow( ), e.getProjectile( ), e.isCancelled( ) );

		DTM.pm.callEvent( ae );

		e.setProjectile( ae.getProjectile( ) );
		e.setCancelled( ae.isCancelled( ) );
	}

	private boolean valid ( final Entity _p1, final Entity _p2 ) {
		if ( !( _p1 instanceof Player ) || !( _p2 instanceof Player ) )
			return false;

		DTMPlayer p1 = DTM.PM.getDTMPlayer( (Player) _p1 );
		DTMPlayer p2 = DTM.PM.getDTMPlayer( (Player) _p2 );

		if ( !( p1 != null && p2 != null ) )
			return false;

		if ( !p1.isPlaying( ) || !p2.isPlaying( ) )
			return false;

		if ( !p1.ap.arena.equals( p2.ap.arena ) )
			return false;

		return true;
	}
}
