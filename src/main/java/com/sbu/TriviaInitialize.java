package com.sbu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TriviaInitialize implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.isOp()){
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
            Team team = scoreboard.getTeam("answering") != null ? scoreboard.getTeam("answering") : scoreboard.registerNewTeam("answering");
            team.setColor(ChatColor.AQUA);
            Team teamTriviaPlayers = scoreboard.getTeam("TriviaPlayers") != null ? scoreboard.getTeam("TriviaPlayers") : scoreboard.registerNewTeam("TriviaPlayers");
            teamTriviaPlayers.setColor(ChatColor.DARK_PURPLE);
            scoreboard.registerNewObjective("Lives","dummy","❤");
            scoreboard.getObjective("Lives").setDisplaySlot(DisplaySlot.PLAYER_LIST);
            for(Player player : Bukkit.getOnlinePlayers()){
                if(!player.isOp())  scoreboard.getObjective("Lives").getScore(player.getName()).setScore(3);
            }
            commandSender.sendMessage("Trivia initialized!");
        }
        return true;
    }
}
