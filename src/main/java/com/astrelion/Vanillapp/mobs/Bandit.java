package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;
import java.util.Random;

public class Bandit extends AMob
{
    public static final String NAME = "bandit";

    protected SpawnController spawnController;

    public Bandit(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.VILLAGER, 0.1f,
            EntityType.ZOMBIE_VILLAGER, 0.1f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        Random random = new Random();
        Monster entity = null;

        switch (random.nextInt(3))
        {
            case 0:
                entity = spawnMeleeRidingBandit(location);
                break;

            case 1:
                entity = spawnRangedRidingBandit(location);
                break;

            case 2:
                entity = spawnMeleeBandit(location);
                break;

            default:
                break;
        }

        this.nameMob(entity, NAME);

        return entity;
    }

    public Zombie spawnMeleeRidingBandit(Location location)
    {
        Zombie meleeRidingBandit = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);
        Horse horse = (Horse) location.getWorld().spawnEntity(location, EntityType.HORSE);

        meleeRidingBandit.getEquipment().setHelmet(new ItemStack(Material.PLAYER_HEAD), true);
        meleeRidingBandit.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE), true);
        meleeRidingBandit.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS), true);
        meleeRidingBandit.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS), true);
        meleeRidingBandit.getEquipment().setItemInMainHand(new ItemStack(this.getWeapon()), true);

        horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
        horse.getInventory().setArmor(new ItemStack(Material.LEATHER_HORSE_ARMOR));
        horse.setTamed(true);
        horse.addPassenger(meleeRidingBandit);

        meleeRidingBandit.setShouldBurnInDay(false);

        return meleeRidingBandit;
    }

    public Skeleton spawnRangedRidingBandit(Location location)
    {
        Skeleton rangedRidingBandit = (Skeleton) location.getWorld().spawnEntity(location, EntityType.SKELETON);
        Horse horse = (Horse) location.getWorld().spawnEntity(location, EntityType.HORSE);

        rangedRidingBandit.getEquipment().setHelmet(new ItemStack(Material.PLAYER_HEAD), true);
        rangedRidingBandit.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE), true);
        rangedRidingBandit.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS), true);
        rangedRidingBandit.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS), true);
        rangedRidingBandit.getEquipment().setItemInMainHand(new ItemStack(Material.BOW), true);

        horse.getInventory().setArmor(new ItemStack(Material.LEATHER_HORSE_ARMOR));
        horse.setTamed(true);
        horse.addPassenger(rangedRidingBandit);

        rangedRidingBandit.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));

        return rangedRidingBandit;
    }

    public Zombie spawnMeleeBandit(Location location)
    {
        Zombie meleeBandit = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);

        meleeBandit.getEquipment().setHelmet(new ItemStack(Material.PLAYER_HEAD), true);
        meleeBandit.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE), true);
        meleeBandit.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS), true);
        meleeBandit.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS), true);

        Material weapon = this.getWeapon();

        meleeBandit.getEquipment().setItemInMainHand(new ItemStack(weapon));

        if (weapon.equals(Material.IRON_AXE))
        {
            meleeBandit.getEquipment().setItemInOffHand(new ItemStack(weapon));
        }

        meleeBandit.setShouldBurnInDay(false);

        return meleeBandit;
    }

    @Override
    public Material[] getWeapons()
    {
        return new Material[] {
            Material.IRON_SWORD,
            Material.IRON_AXE
        };
    }
}
