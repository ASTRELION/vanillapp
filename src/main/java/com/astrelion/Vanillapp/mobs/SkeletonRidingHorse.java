package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;

public class SkeletonRidingHorse extends AMob
{
    public static final String NAME = "skeleton_horse";

    protected SpawnController spawnController;

    public SkeletonRidingHorse(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.SKELETON, 0.1f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        SkeletonHorse skeletonHorse = (SkeletonHorse) location.getWorld().spawnEntity(location, EntityType.SKELETON_HORSE);
        Skeleton skeleton = (Skeleton) location.getWorld().spawnEntity(location, EntityType.SKELETON);

        skeletonHorse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
        skeleton.getEquipment().setItemInMainHand(new ItemStack(Material.BOW));
        skeleton.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));

        skeletonHorse.setTamed(true);
        skeletonHorse.addPassenger(skeleton);

        this.nameMob(skeleton, NAME);

        return skeleton;
    }
}
