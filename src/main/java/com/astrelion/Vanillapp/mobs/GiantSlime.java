package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Slime;

import java.util.Map;

public class GiantSlime extends AMob
{
    public static final String NAME = "giant_slime";
    public static final int SLIME_SIZE = 20;

    protected SpawnController spawnController;

    public GiantSlime(SpawnController spawnController)
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
        Slime giantSlime = (Slime) location.getWorld().spawnEntity(location, EntityType.SLIME);
        giantSlime.setSize(SLIME_SIZE);

        this.nameMob(giantSlime, NAME);

        return giantSlime;
    }
}
