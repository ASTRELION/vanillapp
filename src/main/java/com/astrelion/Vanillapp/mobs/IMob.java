package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.util.Util;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.Map;
import java.util.Random;

public interface IMob
{
    /**
     * Get the set of entities that this entity can replace when spawning
     * @return a map of the replaced entity to the chance of replacement
     */
    public Map<EntityType, Float> mobReplaced();

    /**
     * Spawn `amount` of this mob
     * @param location
     * @param amount
     */
    public default void spawnMany(Location location, int amount)
    {
        for (int i = 0; i < amount; i++)
        {
            spawnOne(location);
        }
    }

    /**
     * Spawn a single mob of this type
     * @param location
     * @return Entity
     */
    public Entity spawnOne(Location location);

    public default Material[] getWeapons()
    {
        return new Material[0];
    }

    /**
     * Randomly gets a weapon from valid weapons and returns it
     * @return a random weapon from `getWeapons()`
     */
    public default Material getWeapon()
    {
        Random random = new Random();
        Material[] weapons = getWeapons();
        return weapons[random.nextInt(weapons.length)];
    }

    /**
     * Name this mob from `name` to Title Case
     * @param entity
     * @param name
     */
    public default void nameMob(Entity entity, String name)
    {
        entity.setCustomName(Util.toTitleCase(name));
        entity.setCustomNameVisible(true);
    }

    public default void nameMob(Entity entity, String name, ChatColor color)
    {
        nameMob(entity, name);
        entity.setCustomName(color + entity.getCustomName());
    }

    public static boolean isIMob(Entity entity)
    {
        return false;
    }
}
