package com.astrelion.Vanillapp.controllers;

import com.astrelion.Vanillapp.Vanillapp;
import com.astrelion.Vanillapp.mobs.AMob;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.plugin.PluginManager;

public class EventController extends ARegisterable
{
    protected Vanillapp vanillapp;
    protected PluginManager pluginManager;

    public EventController(Vanillapp vanillapp)
    {
        this.vanillapp = vanillapp;
        this.pluginManager = this.vanillapp.getServer().getPluginManager();
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event)
    {
        getVanillapp().getScoreboardController().updatePlayerScoreboard(event.getPlayer());
    }

    @EventHandler
    public void onPluginEnableEvent(PluginEnableEvent event)
    {
        // reload scoreboards for active users (mainly for reloads)
        for (Player player : getVanillapp().getServer().getOnlinePlayers())
        {
            getVanillapp().getScoreboardController().updatePlayerScoreboard(player);
        }
    }

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event)
    {
        if (event.getEntityType() == EntityType.PLAYER)
        {
            getVanillapp().getScoreboardController().updatePlayerHealth((Player) event.getEntity());
        }
    }

    @EventHandler
    public void onEntityRegainHealthEvent(EntityRegainHealthEvent event)
    {
        if (event.getEntityType() == EntityType.PLAYER)
        {
            getVanillapp().getScoreboardController().updatePlayerHealth((Player) event.getEntity());
        }
    }

    public Vanillapp getVanillapp()
    {
        return this.vanillapp;
    }

    public void register()
    {
        if (!registered)
        {
            registered = true;

            // register events for any mob that relies on them
            for (AMob mob : getVanillapp().getSpawnController().getMobs().values())
            {
                if (mob instanceof Listener)
                {
                    pluginManager.registerEvents((Listener) mob, getVanillapp());
                }
            }

            pluginManager.registerEvents(getVanillapp().getSpawnController(), getVanillapp());
            pluginManager.registerEvents(this, getVanillapp());
        }
    }
}
