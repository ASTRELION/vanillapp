package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;

import java.util.Map;

public class RainbowSheep extends AMob
{
    public static final String NAME = "rainbow_sheep";

    protected SpawnController spawnController;

    public RainbowSheep(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.SHEEP, 0.0f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        Sheep rainbowSheep = (Sheep) location.getWorld().spawnEntity(location, EntityType.SHEEP);

        this.nameMob(rainbowSheep, "jeb_");

        return rainbowSheep;
    }

    @Override
    public void nameMob(Entity entity, String string)
    {
        entity.setCustomName(string);
        entity.setCustomNameVisible(true);
    }
}
