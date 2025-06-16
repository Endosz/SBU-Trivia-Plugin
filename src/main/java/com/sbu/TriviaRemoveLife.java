package com.sbu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class TriviaRemoveLife implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.isOp()){
            if(strings.length==0){
                commandSender.sendMessage(ChatColor.RED+"Unspecified player!");
                return true;
            }
            int scoreAmount;
            if(strings.length==2){
                String regex = "^[0-9]*$";
                if(!strings[1].matches(regex)){
                    commandSender.sendMessage(ChatColor.RED+"Specified value isn't a number!");
                    return true;
                }
                scoreAmount = Integer.parseInt(strings[1]);
            }else{
                scoreAmount = 1;
            }
            Player player = Bukkit.getPlayer(strings[0]);
            if(player!=null){
                Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
                Objective objectiveLives = scoreboard.getObjective("Lives");
                if(objectiveLives!=null){
                    objectiveLives.getScore(player.getName()).setScore(objectiveLives.getScore(player.getName()).getScore()-scoreAmount);
                    commandSender.sendMessage("Successfully removed score from "+ChatColor.AQUA+player.getName()+ChatColor.RESET+".");
                }else{
                    commandSender.sendMessage(ChatColor.RED+"Trivia isn't initialized!");
                }
            }else{
                commandSender.sendMessage(ChatColor.RED+"Couldn't find player!");
            }
            return true;
        }
        commandSender.sendMessage(ChatColor.RED +"You don't have permission to run this command!");
        return true;
    }
}
