package com.sbu.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TriviaEnd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.isOp()){
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
            Team team = scoreboard.getTeam("answering");
            if(team!=null){
                team.unregister();
            }
            Objective lives = scoreboard.getObjective("Lives");
            if(lives!=null) lives.unregister();
            commandSender.sendMessage("Trivia terminated!");
        }
        return true;
    }
}
