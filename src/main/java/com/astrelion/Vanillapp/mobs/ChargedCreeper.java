package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.Map;

public class ChargedCreeper extends AMob
{
    public static final String NAME = "charged_creeper";

    protected SpawnController spawnController;

    public ChargedCreeper(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.CREEPER, 0.1f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        Creeper chargedCreeper = (Creeper) location.getWorld().spawnEntity(location, EntityType.CREEPER);

        chargedCreeper.setPowered(true);

        this.nameMob(chargedCreeper, NAME);

        return chargedCreeper;
    }
}
