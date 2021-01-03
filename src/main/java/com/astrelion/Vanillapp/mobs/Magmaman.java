package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.MagmaCube;

import java.util.Map;

public class Magmaman extends AMob
{
    public static final String NAME = "magmaman";

    protected SpawnController spawnController;

    public Magmaman(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.MAGMA_CUBE, 0.1f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        MagmaCube magma1 = (MagmaCube) location.getWorld().spawnEntity(location, EntityType.MAGMA_CUBE);
        MagmaCube magma2 = (MagmaCube) location.getWorld().spawnEntity(location, EntityType.MAGMA_CUBE);
        MagmaCube magma3 = (MagmaCube) location.getWorld().spawnEntity(location, EntityType.MAGMA_CUBE);

        magma1.setSize(3);
        magma2.setSize(2);
        magma3.setSize(1);

        magma1.addPassenger(magma2);
        magma2.addPassenger(magma3);

        nameMob(magma3, NAME);

        return magma1;
    }
}
