package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Rabbit;

import java.util.Map;

public class RabbitToast extends AMob
{
    public static final String NAME = "rabbit_toast";

    protected SpawnController spawnController;

    public RabbitToast(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.RABBIT, 0.1f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        Rabbit toast = (Rabbit) location.getWorld().spawnEntity(location, EntityType.RABBIT);

        this.nameMob(toast, "Toast");

        return toast;
    }
}
