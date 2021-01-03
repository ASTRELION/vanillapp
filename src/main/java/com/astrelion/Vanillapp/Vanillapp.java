package com.astrelion.Vanillapp;

import com.astrelion.Vanillapp.controllers.CommandController;
import com.astrelion.Vanillapp.controllers.EventController;
import com.astrelion.Vanillapp.controllers.ScoreboardController;
import com.astrelion.Vanillapp.controllers.SpawnController;
import com.astrelion.Vanillapp.util.Util;
import org.bukkit.Chunk;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class Vanillapp extends JavaPlugin
{
    protected SpawnController spawnController;
    protected CommandController commandController;
    protected EventController eventController;
    protected ScoreboardController scoreboardController;

    private static final String BASE_COMMAND = "vpp";

    @Override
    public void onEnable()
    {
        commandController = new CommandController(this);
        spawnController = new SpawnController(this);
        eventController = new EventController(this);
        scoreboardController = new ScoreboardController(this);
        commandController.register();
        spawnController.register();
        eventController.register();
        scoreboardController.register();

        this.getCommand(BASE_COMMAND).setExecutor(commandController);

        for (World world : getServer().getWorlds())
        {
            getLogger().info("Setting world '" + world.getName() + "' difficulty to HARD...");
            world.setDifficulty(Difficulty.HARD);
            for (Chunk chunk : world.getLoadedChunks())
            {
                // 100 hours of IRL time
                chunk.setInhabitedTime(Util.TICKS_PER_HOUR * 100L);
            }
        }

        getLogger().info("Vanilla++ successfully enabled.");
    }

    @Override
    public void onDisable()
    {
        getLogger().info("Vanilla++ successfully disabled.");
    }

    public SpawnController getSpawnController()
    {
        return this.spawnController;
    }

    public CommandController getCommandController()
    {
        return this.commandController;
    }

    public EventController getEventController()
    {
        return this.eventController;
    }

    public ScoreboardController getScoreboardController()
    {
        return this.scoreboardController;
    }
}
