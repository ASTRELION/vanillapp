package com.astrelion.Vanillapp.controllers;

import com.astrelion.Vanillapp.Vanillapp;
import com.astrelion.Vanillapp.mobs.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Map;

public class SpawnController extends ARegisterable implements Listener
{
    protected Vanillapp vanillapp;
    protected Map<String, AMob> mobs = new HashMap<>();

    public SpawnController(Vanillapp vanillapp)
    {
        this.vanillapp = vanillapp;
    }

    public Vanillapp getVanillapp()
    {
        return this.vanillapp;
    }

    public Map<String, AMob> getMobs()
    {
        return mobs;
    }

    @EventHandler
    public void onEntitySpawnEvent(EntitySpawnEvent event)
    {
//        Random random = new Random();
//
//        for (AMob mob : getMobs().values())
//        {
//            Entity entity = event.getEntity();
//
//            if (entity.getCustomName() != null &&
//                ChatColor.stripColor(entity.getCustomName()).equalsIgnoreCase(Util.toTitleCase(mob.getName())))
//            {
//                break;
//            }
//            else if (mob.mobReplaced() != null)
//            {
//                for (EntityType replacement : mob.mobReplaced().keySet())
//                {
//                    if (event.getEntityType() == replacement && Util.observeEvent(mob.mobReplaced().get(replacement)))
//                    {
//                        event.getEntity().remove();
//                        mob.spawnOne(event.getLocation());
//                        break;
//                    }
//                }
//            }
//        }
    }

    public void register()
    {
        if (!registered)
        {
            registered = true;

            mobs.put(Bandit.NAME, new Bandit(this));
            mobs.put(BroodMother.NAME, new BroodMother(this));
            mobs.put(ChargedCreeper.NAME, new ChargedCreeper(this));
            mobs.put(Ghost.NAME, new Ghost(this));
            mobs.put(GiantMagmaCube.NAME, new GiantMagmaCube(this));
            mobs.put(GiantSlime.NAME, new GiantSlime(this));
            mobs.put(GiantZombie.NAME, new GiantZombie(this));
            mobs.put(Hellhound.NAME, new Hellhound(this));
            mobs.put(IllusionerIllager.NAME, new IllusionerIllager(this));
            mobs.put(KillerBunny.NAME, new KillerBunny(this));
            mobs.put(Lich.NAME, new Lich(this));
            mobs.put(Magmaman.NAME, new Magmaman(this));
            mobs.put(MinecartSpawner.NAME, new MinecartSpawner(this));
            mobs.put(RabbitToast.NAME, new RabbitToast(this));
            mobs.put(RainbowSheep.NAME, new RainbowSheep(this));
            mobs.put(SkeletonMelee.NAME, new SkeletonMelee(this));
            mobs.put(SkeletonRidingHorse.NAME, new SkeletonRidingHorse(this));
            mobs.put(Slimeman.NAME, new Slimeman(this));
            mobs.put(TestMob.NAME, new TestMob(this));
            mobs.put(VindicatorJohnny.NAME, new VindicatorJohnny(this));
            mobs.put((new Wraith(this)).getName(), new Wraith(this));
            mobs.put(ZombieRidingHorse.NAME, new ZombieRidingHorse(this));
        }
    }
}
