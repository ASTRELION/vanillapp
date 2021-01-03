package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Ghost extends AMob implements Listener
{
    public static final String NAME = "ghost";

    protected SpawnController spawnController;

    public Ghost(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return null;
    }

    @Override
    public Entity spawnOne(Location location)
    {
        Vindicator ghost = (Vindicator) location.getWorld().spawnEntity(location, EntityType.VINDICATOR);

        List<PotionEffect> effects = new ArrayList<>(Arrays.asList(
                new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1),
                new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1),
                new PotionEffect(PotionEffectType.SLOW_FALLING, Integer.MAX_VALUE, 1),
                new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 1),
                new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1)
        ));
        ghost.addPotionEffects(effects);

        ghost.setCanPickupItems(false);
        ghost.setGlowing(true);

        ghost.getEquipment().clear();

        this.nameMob(ghost, NAME);

        return ghost;
    }

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event)
    {
        Player player = event.getEntity().getPlayer();

        if (player.getGameMode() == GameMode.SURVIVAL)
        {
            Entity ghost = spawnOne(player.getLocation());
            this.nameMob(ghost, player.getName() + "'s Ghost");
        }
    }
}
