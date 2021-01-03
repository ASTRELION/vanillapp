package com.astrelion.Vanillapp.controllers;

import com.astrelion.Vanillapp.Vanillapp;
import com.astrelion.Vanillapp.util.Util;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreboardController extends ARegisterable
{
    private Vanillapp vanillapp;
    private ScoreboardManager scoreboardManager;

    public static String OBJECTIVE = "vanillapp";
    public static String HEALTH = "health";
    public static String WATER = "water";
    public static String FOOD = "food";
    public static String TEMPERATURE = "temperature";
    public static String TOXICITY = "toxicity";
    public static String RADIATION = "radiation";

    public ScoreboardController(Vanillapp vanillapp)
    {
        this.vanillapp = vanillapp;
        this.scoreboardManager = vanillapp.getServer().getScoreboardManager();
    }

    public Vanillapp getVanillapp()
    {
        return this.vanillapp;
    }

    public Scoreboard createPlayerScoreboard()
    {
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective(OBJECTIVE, "dummy", "-= Vanilla++ =-");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setRenderType(RenderType.HEARTS);

        Team healthTeam = registerTeam(scoreboard, objective, HEALTH, 20, ChatColor.WHITE);
        Team waterTeam = registerTeam(scoreboard, objective, WATER,  20, ChatColor.AQUA);
        Team foodTeam = registerTeam(scoreboard, objective, FOOD, 20, ChatColor.GOLD);
        Team temperatureTeam = registerTeam(scoreboard, objective, TEMPERATURE, 10, ChatColor.RED);
        Team toxicityTeam = registerTeam(scoreboard, objective, TOXICITY, 0, ChatColor.GREEN);
        Team radiationTeam = registerTeam(scoreboard, objective, RADIATION, 0, ChatColor.YELLOW);

        healthTeam.setPrefix("HPrefix ");
        healthTeam.setSuffix(" HSuffix");

        return scoreboard;
    }

    private Team registerTeam(Scoreboard scoreboard, Objective objective, String name, int defaultScore, ChatColor color)
    {
        Team newTeam = scoreboard.registerNewTeam(name);
        newTeam.setDisplayName(color + Util.toTitleCase(name));
        newTeam.setColor(color);
        newTeam.setAllowFriendlyFire(true);
        newTeam.setCanSeeFriendlyInvisibles(false);
        objective.getScore(name).setScore(defaultScore);
        return newTeam;
    }

    public void updatePlayerScoreboard(Player player)
    {
        player.setScoreboard(createPlayerScoreboard());
    }

    public void updatePlayerHealth(Player player)
    {
        Scoreboard scoreboard = player.getScoreboard();
        scoreboard.getObjective(OBJECTIVE).getScore(HEALTH).setScore((int) player.getHealth());
    }

    @Override
    public void register()
    {
        if (!registered)
        {
            registered = true;
        }
    }
}
