package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class TestMob extends AMob
{
    public static final String NAME = "test";

    protected SpawnController spawnController;

    public TestMob(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return null;
    }

    @Override
    public Entity spawnOne(Location location)
    {
        //Fluid water = Fluid.WATER;
        Material water = Material.WATER;
        ArmorStand skeleton = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        skeleton.getEquipment().setHelmet(new ItemStack(Material.LAVA));
        skeleton.getEquipment().setChestplate(new ItemStack(Material.WATER));
        skeleton.getEquipment().setLeggings(new ItemStack(Material.WATER));
        skeleton.getEquipment().setBoots(new ItemStack(Material.WATER));
        //location.getWorld().spawnFallingBlock(location, water);

        return skeleton;
    }
}
