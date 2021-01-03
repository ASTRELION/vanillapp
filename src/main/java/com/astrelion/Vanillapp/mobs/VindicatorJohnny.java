package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Vindicator;

import java.util.Map;

public class VindicatorJohnny extends AMob
{
    public static final String NAME = "johnny";

    protected SpawnController spawnController;

    public VindicatorJohnny(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.VINDICATOR, 0.01f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        Vindicator johnny = (Vindicator) location.getWorld().spawnEntity(location, EntityType.VINDICATOR);

        this.nameMob(johnny, NAME);

        return johnny;
    }
}
