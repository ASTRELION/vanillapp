package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.SpawnerMinecart;

import java.util.Map;

public class MinecartSpawner extends AMob
{
    public static final String NAME = "spawner_minecart";

    protected SpawnController spawnController;

    public MinecartSpawner(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.MINECART, 0.1f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        SpawnerMinecart minecartSpawner = (SpawnerMinecart) location.getWorld().spawnEntity(location, EntityType.MINECART_MOB_SPAWNER);

        this.nameMob(minecartSpawner, NAME);

        return minecartSpawner;
    }
}
