package com.astrelion.Vanillapp.commands;

import com.astrelion.Vanillapp.controllers.CommandController;
import com.astrelion.Vanillapp.mobs.AMob;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

public class SpawnCommand extends SubCommand
{
    private Map<String, AMob> mobs;

    public SpawnCommand(CommandController commandController)
    {
        super(commandController);
        mobs = commandController.getVanillapp().getSpawnController().getMobs();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String[] args)
    {
        this.sender = sender;

        Player player = (Player) sender;
        int amount = Integer.parseInt(args.length >= 2 ? args[1] : "1");
        Block block = player.getTargetBlock(100);
        Location location = block != null ? block.getLocation() : player.getLocation();
        location.add(0, 1, 0); // up one block so they don't spawn inside a block

        AMob mob = mobs.get(args[0].toLowerCase());

        if (mob != null)
        {
            mob.spawnMany(location, amount);
            getCommand().getVanillapp().getLogger().warning(mob.getName());
            return true;
        }

        return false;
    }
}
