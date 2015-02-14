package com.MibacTechnologies.Minecraft.DestroyTheMonument.Listeners;

import java.util.HashMap;

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
import org.bukkit.inventory.ItemStack;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTM;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Block.ArenaBlockBreakEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerDamageByEntityEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerDamageByPlayerEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerDeathEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerFallOutOfMapEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerNaturalRespawnEvent;
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
		DTMPlayer player = DTM.instance( ).PM.getDTMPlayer( e.getPlayer( ) );

		if ( player == null || !player.isPlaying( ) )
			return;

		e.setRespawnLocation( player.ap.getSpawn( ) );

		HashMap< Integer, ItemStack > items = DTM.instance( ).IM.getItems( );

		for ( Integer i = Integer.valueOf( 0 ); i < items.size( ); i++ )
			player.p.getInventory( ).setItem( i, items.get( i ) );

		DTM.instance( ).pm.callEvent( new ArenaPlayerNaturalRespawnEvent(
				player ) );
	}

	@EventHandler
	public void death ( final PlayerDeathEvent e ) {
		if ( !valid( e.getEntity( ), e.getEntity( ).getKiller( ) ) )
			return;

		final DTMPlayer p1 = DTM.instance( ).PM.getDTMPlayer( e.getEntity( ) );
		DTMPlayer p2 = DTM.instance( ).PM.getDTMPlayer( e.getEntity( )
				.getKiller( ) );

		p1.deaths++;
		p2.kills++;

		p1.ap.deaths++;
		p2.ap.kills++;

		DTM.instance( ).pm.callEvent( new ArenaPlayerDeathEvent( p1, p2 ) );
		/*
		 * Damageable d = p1.p; d.setHealth( d.getMaxHealth( ) );
		 * DTM.pm.callEvent( new ArenaPlayerRespawnEvent( p1 ) );
		 */
		/*
		 * new BukkitRunnable( ) {
		 * @Override public void run ( ) { try { Object nmsPlayer =
		 * p1.p.getClass( ).getMethod( "getHandle" ) .invoke( p1.p );
		 * Object packet = Class .forName( "net.minecraft.server." +
		 * Bukkit.getServer( ).getClass( ) .getPackage( ).getName( )
		 * .replace( ".", "," ) .split( "," )[ 3 ] +
		 * ".Packet205ClientCommand" ) .newInstance( );
		 * packet.getClass( ).getField( "a" ).set( packet, 1 ); Object
		 * con = nmsPlayer.getClass( ) .getField( "playerConnection"
		 * ).get( nmsPlayer ); con.getClass( ).getMethod( "a",
		 * packet.getClass( ) ) .invoke( con, packet ); } catch (
		 * Throwable e ) { e.printStackTrace( ); } } }.runTaskLater(
		 * DTM.instance( ), 2L ); DTM.instance( ).pm.callEvent( new
		 * ArenaPlayerRespawnEvent( p1 ) );
		 */}

	@EventHandler
	public void voidDmg ( final EntityDamageByEntityEvent e ) {
		if ( !( e.getEntity( ) instanceof Player ) )
			return;

		if ( e.getCause( ) != DamageCause.VOID )
			return;

		DTMPlayer p = DTM.instance( ).PM.getDTMPlayer( (Player) e.getEntity( ) );

		if ( p == null || !p.isPlaying( ) )
			return;

		DTM.instance( ).pm.callEvent( new ArenaPlayerFallOutOfMapEvent( p ) );
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

		DTMPlayer victim = DTM.instance( ).PM.getDTMPlayer( (Player) e1 );

		if ( victim == null )
			return;

		if ( e.getCause( ) == DamageCause.ENTITY_ATTACK ) {

			Entity e2 = e.getDamager( );

			if ( !( e2 instanceof Player ) ) {
				ArenaPlayerDamageByEntityEvent ae = new ArenaPlayerDamageByEntityEvent(
						victim, e2, e.getDamage( ) );

				DTM.instance( ).pm.callEvent( ae );

				e.setDamage( ae.getDamage( ) );
				e.setCancelled( ae.isCancelled( ) );
				return;
			}

			Player p2 = (Player) e2;

			DTMPlayer damager = DTM.instance( ).PM.getDTMPlayer( p2 );

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

			DTM.instance( ).pm.callEvent( new ArenaPlayerFallOutOfMapEvent(
					victim ) );
		} else {
			if ( !victim.isPlaying( ) )
				return;

			ArenaPlayerUnknownDamageEvent ae = new ArenaPlayerUnknownDamageEvent(
					victim, e.getDamage( ), e.getCause( ), e.isCancelled( ) );

			DTM.instance( ).pm.callEvent( ae );

			e.setDamage( ae.getDamage( ) );
			e.setCancelled( ae.isCancelled( ) );
		}
	}

	@EventHandler
	public void blockBreak ( final BlockBreakEvent e ) {
		Arena a = DTM.instance( ).AM.isInBounds( e.getBlock( ).getLocation( ) );

		if ( a == null )
			return;

		ArenaBlockBreakEvent ae = new ArenaBlockBreakEvent(
				DTM.instance( ).PM.getDTMPlayer( e.getPlayer( ) ), e.getBlock( )
						.getLocation( ) );

		DTM.instance( ).pm.callEvent( ae );

		e.setCancelled( ae.isCancelled( ) );
	}

	@EventHandler
	public void shoot ( final EntityShootBowEvent e ) {
		if ( !( e.getEntity( ) instanceof Player ) )
			return;

		Player p = (Player) e.getEntity( );
		DTMPlayer dp = DTM.instance( ).PM.getDTMPlayer( p );

		if ( dp == null || !dp.isPlaying( ) )
			return;

		//Dunno how, just preventing possible errors
		if ( e.getBow( ) == null )
			return;

		ArenaPlayerShootBowEvent ae = new ArenaPlayerShootBowEvent( dp,
				e.getBow( ), e.getProjectile( ), e.isCancelled( ) );

		DTM.instance( ).pm.callEvent( ae );

		e.setProjectile( ae.getProjectile( ) );
		e.setCancelled( ae.isCancelled( ) );
	}

	private boolean valid ( final Entity _p1, final Entity _p2 ) {
		if ( !( _p1 instanceof Player ) || !( _p2 instanceof Player ) )
			return false;

		DTMPlayer p1 = DTM.instance( ).PM.getDTMPlayer( (Player) _p1 );
		DTMPlayer p2 = DTM.instance( ).PM.getDTMPlayer( (Player) _p2 );

		if ( !( p1 != null && p2 != null ) )
			return false;

		if ( !p1.isPlaying( ) || !p2.isPlaying( ) )
			return false;

		if ( !p1.ap.arena.equals( p2.ap.arena ) )
			return false;

		return true;
	}
}
