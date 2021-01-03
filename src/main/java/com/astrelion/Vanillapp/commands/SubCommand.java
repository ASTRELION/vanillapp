package com.astrelion.Vanillapp.commands;

import com.astrelion.Vanillapp.controllers.CommandController;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class SubCommand
{
    protected CommandController hmcCommand;
    protected CommandSender sender;

    public SubCommand(CommandController hmcCommand)
    {
        this.hmcCommand = hmcCommand;
    }

    public CommandSender getCommandSender()
    {
        return sender;
    }

    public CommandController getCommand()
    {
        return hmcCommand;
    }

    public abstract boolean onCommand(CommandSender sender, Command command, String[] args);
}
