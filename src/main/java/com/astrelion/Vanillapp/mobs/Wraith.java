package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Wraith extends AMob
{
    protected SpawnController spawnController;

    public Wraith(SpawnController spawnController)
    {
        this.spawnController = spawnController;
        name = "wraith";
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.ZOMBIE, 0.1f,
            EntityType.SKELETON, 0.1f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);

        LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
        chestMeta.setColor(Color.fromRGB(50, 50, 50));
        chest.setItemMeta(chestMeta);

        Zombie wraith = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);

        wraith.getEquipment().setHelmet(new ItemStack(Material.WITHER_SKELETON_SKULL, 1));
        wraith.getEquipment().setHelmetDropChance(0f);
        wraith.getEquipment().setChestplate(chest);
        wraith.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_HOE, 1));

        List<PotionEffect> effects = new ArrayList<>(Arrays.asList(
                new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1),
                new PotionEffect(PotionEffectType.SLOW_FALLING, Integer.MAX_VALUE, 1),
                new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1),
                new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2),
                new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1),
                new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 1)
        ));
        wraith.addPotionEffects(effects);

        BukkitScheduler scheduler = spawnController.getVanillapp().getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(spawnController.getVanillapp(), () -> effectThing(wraith), 0L, 20L);

        wraith.setCanPickupItems(false);
        wraith.setShouldBurnInDay(false);

        this.nameMob(wraith, getName());

        return wraith;
    }

    public Listener effectThing(Entity entity)
    {
        //entity.playEffect(EntityEffect.FIREWORK_EXPLODE);
        //entity.getLocation().getWorld().playEffect(entity.getLocation(), Effect.DRAGON_BREATH, 1);

        return null;
    }
}
