package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.MagmaCube;

import java.util.Map;

public class GiantMagmaCube extends AMob
{
    public static final String NAME = "giant_magma_cube";
    public static final int MAGMA_CUBE_SIZE = 20;

    protected SpawnController spawnController;

    public GiantMagmaCube(SpawnController spawnController)
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
        MagmaCube giantMagmaCube = (MagmaCube) location.getWorld().spawnEntity(location, EntityType.MAGMA_CUBE);
        giantMagmaCube.setSize(MAGMA_CUBE_SIZE);

        this.nameMob(giantMagmaCube, NAME);

        return giantMagmaCube;
    }
}
