package com.MibacTechnologies.Minecraft.DestroyTheMonument;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.ArenaManager;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Listeners.ArenaEvents;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Listeners.PlayerEvents;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Utils.BooleanUtils;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 28 Jan 2015 (17:54:46)
 */
public class DTM extends JavaPlugin {
	public FileConfiguration config;
	public PluginManager pm;
	public Logger l;
	public ArenaManager AM;
	public ItemManager IM;
	public PlayerManager PM;
	public ScoreboardManager SM;
	//public WorldGuardPlugin wg;
	//public WorldEditPlugin we;
	private static DTM dtm;

	//private BooleanUtils bu;

	@Override
	public void onEnable ( ) {
		new BooleanUtils( );
		config = getConfig( );
		//wg = getWorldGuard( );
		//we = getWorldEdit( );
		pm = getServer( ).getPluginManager( );
		AM = new ArenaManager( );
		IM = new ItemManager( );
		PM = new PlayerManager( );
		SM = Bukkit.getScoreboardManager( );
		l = getLogger( );
		dtm = this;

		pm.registerEvents( new PlayerEvents( ), this );
		pm.registerEvents( new ArenaEvents( ), this );
	}

	@Override
	public void onDisable ( ) {
		// Prevents using I/O while running - better performance.
		for ( String key : config.getKeys( true ) )
			getConfig( ).set( key, config.get( key ) );

		saveConfig( );
	}

	public FileConfiguration getCfg ( ) {
		return config;
	}

	public static DTM instance ( ) {
		return dtm;
	}

	/*
	 * private WorldEditPlugin getWorldEdit ( ) { Plugin plugin =
	 * getServer( ).getPluginManager( ).getPlugin( "WorldGuard" ); //
	 * WorldGuard may not be loaded if ( plugin == null || !( plugin
	 * instanceof WorldEditPlugin ) ) return null; return
	 * (WorldEditPlugin) plugin; }
	 */

	/*
	 * private WorldGuardPlugin getWorldGuard ( ) { Plugin plugin =
	 * getServer( ).getPluginManager( ).getPlugin( "WorldGuard" ); //
	 * WorldGuard may not be loaded if ( plugin == null || !( plugin
	 * instanceof WorldGuardPlugin ) ) return null; return
	 * (WorldGuardPlugin) plugin; }
	 */
}
