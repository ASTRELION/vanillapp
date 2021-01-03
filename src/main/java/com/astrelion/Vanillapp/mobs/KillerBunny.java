package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Rabbit;

import java.util.Map;

public class KillerBunny extends AMob
{
    public static final String NAME = "killer_bunny";

    protected SpawnController spawnController;

    public KillerBunny(SpawnController spawnController)
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
        Rabbit killerBunny = (Rabbit) location.getWorld().spawnEntity(location, EntityType.RABBIT);

        killerBunny.setRabbitType(Rabbit.Type.THE_KILLER_BUNNY);

        this.nameMob(killerBunny, NAME);

        return killerBunny;
    }
}
