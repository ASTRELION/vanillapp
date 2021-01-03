package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;

import java.util.Map;

public class GiantZombie extends AMob
{
    public static final String NAME = "giant";

    protected SpawnController spawnController;

    public GiantZombie(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.ZOMBIE, 0.0f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        Giant giant = (Giant) location.getWorld().spawnEntity(location, EntityType.GIANT);

        return giant;
    }
}
