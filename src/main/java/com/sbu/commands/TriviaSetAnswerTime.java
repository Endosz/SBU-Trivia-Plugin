package com.sbu.commands;

import com.sbu.SBUTrivia;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class TriviaSetAnswerTime implements CommandExecutor {
    private Plugin plugin;

    public TriviaSetAnswerTime(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.isOp()){
            if(strings.length>0){
                String regex = "^[0-9]*$";
                if(!strings[0].matches(regex)){
                    commandSender.sendMessage(ChatColor.RED+"Specified value isn't a number!");
                    return true;
                }
                int answerTime = Integer.valueOf(strings[0]);
                if(answerTime<=0){
                    commandSender.sendMessage(ChatColor.RED+"Specified value can't be negative!");
                    return true;
                }
                ((SBUTrivia) plugin).setQuestionAnswerTime(answerTime);
            }else{
                commandSender.sendMessage(ChatColor.RED+"Unspecified time!");
            }
        }
        return true;
    }
}
