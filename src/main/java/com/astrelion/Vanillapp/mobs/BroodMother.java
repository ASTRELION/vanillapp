package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import com.astrelion.Vanillapp.util.Util;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BroodMother extends AMob implements Listener
{
    public static final String NAME = "brood_mother";

    protected SpawnController spawnController;

    public BroodMother(SpawnController spawnController)
    {
        this.spawnController = spawnController;
    }

    @Override
    public Map<EntityType, Float> mobReplaced()
    {
        return Map.of(
            EntityType.SPIDER, 0.1f
        );
    }

    @Override
    public Entity spawnOne(Location location)
    {
        Spider broodMother = (Spider) location.getWorld().spawnEntity(location, EntityType.SPIDER);

        List<PotionEffect> effects = new ArrayList<>(Arrays.asList(
                new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1),
                new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 2)
        ));
        broodMother.addPotionEffects(effects);

        this.nameMob(broodMother, NAME, ChatColor.RED);

        return broodMother;
    }

    @EventHandler
    void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event)
    {
        if (event.getEntity().getCustomName() != null &&
            ChatColor.stripColor(event.getEntity().getCustomName()).trim().equalsIgnoreCase(Util.toTitleCase(NAME)))
        {
            if (event.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK)
            {
                Location location = event.getEntity().getLocation();

                CaveSpider broodling = (CaveSpider) location.getWorld().spawnEntity(location, EntityType.CAVE_SPIDER);
                broodling.setTarget((LivingEntity) event.getDamager());

                List<PotionEffect> effects = new ArrayList<>(Arrays.asList(
                        new PotionEffect(PotionEffectType.SLOW, 40, 1)
                ));
                broodling.addPotionEffects(effects);

                nameMob(broodling, "Broodling", ChatColor.GRAY);
            }
        }
    }
}
