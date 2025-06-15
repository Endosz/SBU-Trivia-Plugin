package com.sbu;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class TriviaAnswer implements CommandExecutor {
    private long lastUsed = 0L;
    private long answerTime = 10*1000;
    private Player playerAnswering = null;
    private Plugin plugin;

    public TriviaAnswer(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof ConsoleCommandSender) {

            String playerName = strings[0];

            for(Player player : commandSender.getServer().getWorld("world").getPlayers()){
                if(player.getDisplayName().equals(playerName)){
                    playerAnswering=player;
                    break;
                }
            }
            if(playerAnswering==null){
                return false;
            }
            long now = System.currentTimeMillis();
            if (now - lastUsed < answerTime) {
                long secondsLeft = (answerTime - (now - lastUsed)) / 1000;
                playerAnswering.sendMessage("§cThis command is on cooldown for " + secondsLeft + " more seconds.");
                return true;
            }
            lastUsed=now;
            for (int i = 0; i < 10; i++) {
                final int indicator = i;
                new BukkitRunnable(){
                    @Override
                    public void run(){
                        long secondsLeft = ((answerTime/1000) - (indicator));
                        for(Player player : commandSender.getServer().getWorld("world").getPlayers()){
                            player.sendTitle(ChatColor.DARK_AQUA+"Answering: "+ ChatColor.AQUA+playerAnswering.getDisplayName(),"Time left: "+secondsLeft,5, 20, 5);
                        }
                    }
                }.runTaskLater(plugin,20*indicator);
            }
            return true;
        }
        return true;
    }
}
