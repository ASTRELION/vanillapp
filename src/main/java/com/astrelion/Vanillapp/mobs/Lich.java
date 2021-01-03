package com.astrelion.Vanillapp.mobs;

import com.astrelion.Vanillapp.controllers.SpawnController;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Lich extends AMob
{
    public static final String NAME = "lich";

    protected SpawnController spawnController;

    public Lich(SpawnController spawnController)
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
        Skeleton lich = (Skeleton) location.getWorld().spawnEntity(location, EntityType.SKELETON);

        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) helmet.getItemMeta();
        meta.setColor(Color.fromRGB(50, 50, 50));
        helmet.setItemMeta(meta);
        lich.getEquipment().setHelmet(helmet);

        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        chestplate.setItemMeta(meta);
        lich.getEquipment().setChestplate(chestplate);

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        leggings.setItemMeta(meta);
        lich.getEquipment().setLeggings(leggings);

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        boots.setItemMeta(meta);
        lich.getEquipment().setBoots(boots);

        ItemStack mainWeapon = new ItemStack(Material.BLAZE_ROD);
        mainWeapon.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
        lich.getEquipment().setItemInMainHand(mainWeapon);

        ItemStack offhandWeapon = new ItemStack(Material.SOUL_LANTERN);
        offhandWeapon.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 1);
        lich.getEquipment().setItemInOffHand(offhandWeapon);

        List<PotionEffect> effects = new ArrayList<>(Arrays.asList(
                new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1),
                new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 1),
                new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 2),
                new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 3)
        ));
        lich.addPotionEffects(effects);

        this.nameMob(lich, NAME);

        return lich;
    }
}
