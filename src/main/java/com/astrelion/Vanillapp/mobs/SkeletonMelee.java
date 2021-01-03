package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class SkeletonMelee extends AMob
{
    public static final String NAME = "melee_skeleton";

    protected SpawnController spawnController;

    public SkeletonMelee(SpawnController spawnController)
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
        Skeleton skeleton = (Skeleton) location.getWorld().spawnEntity(location, EntityType.SKELETON);
        skeleton.getEquipment().setItemInMainHand(new ItemStack(getWeapon()));

        return skeleton;
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
