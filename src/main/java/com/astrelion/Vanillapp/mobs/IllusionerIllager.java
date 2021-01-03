package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Illusioner;

import java.util.Map;

public class IllusionerIllager extends AMob
{
    public static final String NAME = "illusioner";

    protected SpawnController spawnController;

    public IllusionerIllager(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.EVOKER, 0.1f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        Illusioner illusioner = (Illusioner) location.getWorld().spawnEntity(location, EntityType.ILLUSIONER);

        this.nameMob(illusioner, NAME);

        return illusioner;
    }
}
