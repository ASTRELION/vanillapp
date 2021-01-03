package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Hellhound extends AMob
{
    public static final String NAME = "hellhound";

    protected SpawnController spawnController;

    public Hellhound(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.WOLF, 0.0f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        Wolf hellhound = (Wolf) location.getWorld().spawnEntity(location, EntityType.WOLF);

        List<PotionEffect> effects = new ArrayList<>(Arrays.asList(
            new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1),
            new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1)
        ));
        hellhound.addPotionEffects(effects);

        hellhound.setBreed(false);
        hellhound.setCollarColor(DyeColor.BLACK);
        hellhound.setAngry(true);
        hellhound.setFireTicks(Integer.MAX_VALUE);

        this.nameMob(hellhound, NAME);

        return hellhound;
    }
}
