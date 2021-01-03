package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Slime;

import java.util.Map;

public class Slimeman extends AMob
{
    public static final String NAME = "slimeman";

    protected SpawnController spawnController;

    public Slimeman(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.SLIME, 0.1f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        Slime slime1 = (Slime) location.getWorld().spawnEntity(location, EntityType.SLIME);
        Slime slime2 = (Slime) location.getWorld().spawnEntity(location, EntityType.SLIME);
        Slime slime3 = (Slime) location.getWorld().spawnEntity(location, EntityType.SLIME);

        slime1.setSize(3);
        slime2.setSize(2);
        slime3.setSize(1);

        slime1.addPassenger(slime2);
        slime2.addPassenger(slime3);

        nameMob(slime3, NAME);

        return slime1;
    }
}
