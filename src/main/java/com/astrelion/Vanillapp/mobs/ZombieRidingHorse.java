package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class ZombieRidingHorse extends AMob
{
    public static final String NAME = "zombie_horse";

    protected SpawnController spawnController;

    public ZombieRidingHorse(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.ZOMBIE, 0.1f,
            EntityType.ZOMBIE_VILLAGER, 0.1f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        ZombieHorse zombieHorse = (ZombieHorse) location.getWorld().spawnEntity(location, EntityType.ZOMBIE_HORSE);
        Zombie zombie = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);

        zombieHorse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
        zombie.getEquipment().setItemInMainHand(new ItemStack(this.getWeapon()));

        zombieHorse.setTamed(true);
        zombieHorse.addPassenger(zombie);

        zombie.setShouldBurnInDay(false);

        this.nameMob(zombie, NAME);

        return zombie;
    }

    @Override
    public Material[] getWeapons()
    {
        return new Material[] {
                Material.STONE_SWORD,
                Material.STONE_AXE
        };
    }
}
