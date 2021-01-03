package com.astrelion.Vanillapp.controllers;

import com.astrelion.Vanillapp.Vanillapp;
import com.astrelion.Vanillapp.commands.SpawnCommand;
import com.astrelion.Vanillapp.commands.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class CommandController extends ARegisterable implements CommandExecutor
{
    protected JavaPlugin plugin;
    protected Vanillapp vanillapp;
    protected Map<String, SubCommand> commands = new HashMap<>();

    public CommandController(Vanillapp vanillapp)
    {
        this.plugin = vanillapp;
        this.vanillapp = vanillapp;
    }

    public Vanillapp getVanillapp()
    {
        return this.vanillapp;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
    {
        if (commandSender instanceof Player)
        {
            SubCommand subCommand = commands.get(args[0].toLowerCase());

            if (subCommand != null)
            {
                String[] newArgs = new String[args.length - 1];
                System.arraycopy(args, 1, newArgs, 0, args.length - 1);
                return subCommand.onCommand(commandSender, command, newArgs);
            }
            else
            {
                commandSender.sendMessage("- Vanilla++ Help -");
            }
        }

        return false;
    }

    public void register()
    {
        if (!registered)
        {
            registered = true;

            commands.put("spawn", new SpawnCommand(this));
        }
    }
}
